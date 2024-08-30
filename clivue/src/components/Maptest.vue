<template>
  <div>
      <div>
        <el-input id='tipinput' type="text" v-model="to" size="medium" style="width: 80%"></el-input>
        <el-button style="margin-left: 5px" type="primary" size="medium" @click="getSearchVal(to)">搜索</el-button>
        <el-button @click="aaa" type="primary" size="medium">获取您的位置</el-button>
        <el-button type="primary" size="medium" @click="ride">骑行导航</el-button>
        <el-button type="primary" size="medium" @click="walk">步行导航</el-button>
        <el-button type="primary" size="medium" @click="drive">驾车导航</el-button>
        <el-button style="margin-left: 145px" type="primary" size="medium" @click="togglePanelFn">收起路线</el-button>
      </div>
    <div class="mapContainer">
      <div id="container"></div>
      <div class="panelWrap" ref="panelWrap">
        <div class="panelOpen" v-show="initOpen" @click="togglePanelFn" ref="panelOpen">

        </div>
        <div id="panel" v-show="togglePanel"></div>
      </div>

    </div>

  </div>
</template>

<script>
import AMapLoader from '@amap/amap-jsapi-loader'
export default {
  data() {
    return {
      map: null,
      your:"",//查询地点
      to:"",
      lnglat: [],
      currentAddress:"",
      toAddress:"",
      type:'',
      dialogVisible:false,
      initOpen: false,//初始化展开按钮
      togglePanel: false,//初始化展开按钮
      placeSearch: null,
      mapModule: null // AMap
    }
  },
  mounted() {
    window._AMapSecurityConfig = {
      securityJsCode: 'b88b9fab575ac142fa26daa5cfbc0d9d' // 申请key对应的秘钥 -> 注意了，如果不搭配密钥使用，搜索将没有结果
    }
    // 初始化地图
    this.initAMap()
    if(this.$route.query.name){
      this.getSearchVal(this.$route.query.name)
    }
  },
  methods: {
    // 初始化地图函数
    initAMap() {
      const _this = this
      AMapLoader.load({
        key: '1804f07cb4958d0cd049b77a103ae478', // 申请好的Web端开发者Key，首次调用 load 时必填
        version: '2.0', // 指定要加载的 JSAPI 的版本，缺省时默认为 1.4.15
        plugins: []
      })
          .then((AMap) => {
            // 保存AMap实例
            _this.mapModule = AMap
            const map = new AMap.Map('container', {
              // 设置地图容器id
              viewMode: '2D', // 默认2d地图模式
              zoom: 12, // 初始化地图级别
              zooms: [5, 30],
              // 可以设置初始化当前位置
              center: [116.397428, 39.90923],
              resizeEnable: true
            })
            // 添加控件
            AMap.plugin(
                [
                  'AMap.ElasticMarker',
                  'AMap.Scale',
                  'AMap.ToolBar',
                  'AMap.HawkEye',
                  'AMap.MapType',
                  'AMap.Geolocation',
                  'AMap.AutoComplete',
                  'AMap.PlaceSearch'
                ],
                () => {
                  map.addControl(new AMap.ElasticMarker())
                  map.addControl(new AMap.Scale())
                  map.addControl(new AMap.ToolBar())
                  map.addControl(new AMap.HawkEye())
                  // map.addControl(new AMap.MapType())
                  map.addControl(new AMap.Geolocation())
                }
            )
            _this.map = map
            // 搜索功能
            _this.toSearch()
          })
          .catch((e) => {
            console.log(e)
          })
    },
    toSearch() {
      const _this = this
      // 实例化AutoComplete
      const autoOptions = {
        // input 为绑定输入提示功能的input的DOM ID,注意这个id要个搜索输入框的id一致
        input: 'tipinput'
      }
      const autoComplete = new _this.mapModule.AutoComplete(autoOptions)
      // autoComplete.on('select', _this.select)// 注册监听，当选中某条记录时会触发
      const placeSearch = new _this.mapModule.PlaceSearch({
        map: _this.map
      })
      placeSearch.search(_this.to)
    },
    // select(e) {
    //   const _this = this
    //   // 无需再手动执行search方法，autoComplete会根据传入input对应的DOM动态触发search
    //   // { map: _this.map } ==> 这个对象是能配置的 --> 根据官方文档配置即可，需要什么配置什么
    //   const placeSearch = new _this.mapModule.PlaceSearch({
    //     map: _this.map
    //   })
    //   placeSearch.setCity(e.poi.adcode)
    //   placeSearch.search(e.poi.name) // 关键字查询查询
    // },
    getSearchVal(to) {
      if(to===""){
        return
      }
      const _this = this
      var marker = new AMap.Marker();
      AMap.plugin('AMap.Geocoder', function () {
        const geocoder = new AMap.Geocoder({
          // city: "010", //城市设为北京，默认：“全国”
        });
        const address = to;
        geocoder.getLocation(address, function (status, result) {
          if (status === 'complete' && result.geocodes.length) {
            const lnglat = result.geocodes[0].location
            console.log('经纬度：', lnglat)
            _this.lnglat = lnglat
            _this.toAddress=lnglat
            marker.setPosition(lnglat)
            _this.map.add(marker);//map是一个页面全局变量
            _this.map.setFitView(marker);
          } else {
            console.log('根据地址查询位置失败');
          }
        });
      })
    },
    drawlLine(){
      const _this= this//存储this变量
      if(_this.currentAddress !=='' || _this.toAddress !== '') {
        try {
          //_this.ip是存储的用户地址[xx.xxxxxx,xx.xxxxxx], _this.lnglat是用户搜索出的地址[xx.xxxxxx,xx.xxxxxx]
          _this.type.search(_this.currentAddress, _this.toAddress, function (status, result) {
            console.log('status', status)
            console.log('result', result)
            // result即是对应的骑行路线数据信息
            if (status === 'complete') {
              // console.log('绘制骑行路线完成')
              _this.initOpen = true//路线展开和收起的样式
              _this.togglePanel = true
              _this.map.setCenter(_this.currentAddress)
            } else {
              console.log('路线数据查询失败')
            }
          });
        } catch (e) {
          console.log('路线报错:', e)
        }
      }
      else {
        this.$message.error("请获取当前位置信息或输入所去地点")
      }
    },
    ride(){
      const _this= this//存储this变量
      AMap.plugin('AMap.Riding', function () {
        _this.type = new AMap.Riding({
          map: _this.map,//AMap.Map对象, 展现结果的地图实例。当指定此参数后，搜索结果的标注、线路等均会自动添加到此地图上。可选参数
          panel: "panel", //结果列表的HTML容器id或容器元素，提供此参数后，结果列表将在此容器中进行展示。可选参数
          hideMarkers: false,
          autoFitView: true,//用于控制在路径规划结束后，是否自动调整地图视野使绘制的路线处于视口的可见范围
        });
        //根据起终点坐标规划骑行路线
        _this.drawlLine()
      })
    },
    walk(){
      const _this= this//存储this变量
      AMap.plugin('AMap.Walking', function () {
        _this.type = new AMap.Walking({
          map: _this.map,//AMap.Map对象, 展现结果的地图实例。当指定此参数后，搜索结果的标注、线路等均会自动添加到此地图上。可选参数
          panel: "panel", //结果列表的HTML容器id或容器元素，提供此参数后，结果列表将在此容器中进行展示。可选参数
          hideMarkers: false,
          autoFitView: true,//用于控制在路径规划结束后，是否自动调整地图视野使绘制的路线处于视口的可见范围
        });
        //根据起终点坐标规划骑行路线
        _this.drawlLine()
      })
    },
    drive(){
      const _this= this//存储this变量
      AMap.plugin('AMap.Driving', function () {
        _this.type = new AMap.Driving({
          map: _this.map,//AMap.Map对象, 展现结果的地图实例。当指定此参数后，搜索结果的标注、线路等均会自动添加到此地图上。可选参数
          panel: "panel", //结果列表的HTML容器id或容器元素，提供此参数后，结果列表将在此容器中进行展示。可选参数
          hideMarkers: false,
          autoFitView: true,//用于控制在路径规划结束后，是否自动调整地图视野使绘制的路线处于视口的可见范围
        });
        //根据起终点坐标规划骑行路线
        _this.drawlLine()
      })
    },
    //展开/收起路线列表
    togglePanelFn() {
      this.togglePanel = !this.togglePanel
    },
    aaa(){
        AMap.plugin('AMap.Geolocation', () => {
          const geolocation = new AMap.Geolocation({
            enableHighAccuracy: true,//是否使用高精度定位，默认:true
            timeout: 10000,          //超过10秒后停止定位，默认：无穷大
            maximumAge: 0,           //定位结果缓存0毫秒，默认：0
            zoomToAccuracy:true      //定位成功后调整地图视野范围使定位位置及精度范围视野内可见，默认：false
          });
          geolocation.getCurrentPosition((status, result) => {
            if (status === 'complete' && result.info === 'SUCCESS') {
              // 成功定位后，可以在这里更新地图中心点等操作
              this.map.setCenter(result.position);
              this.$message.success("定位成功")
              this.currentAddress=result.position
              console.log(this.currentAddress)
              const marker = new AMap.Marker({
                position: this.currentAddress,
              });
              this.map.add(marker)
            } else {
              this.$message.error("定位失败")
              console.error('定位失败', result);
            }
          });
        });
    }
  }
}
</script>
<style scoped>
.mapContainer {
  width: 100%;
  height: 50rem;
  position: relative;
}
#container {
  width: 100%;
  height: calc(100vh - 200px);
}
#panel {
  /*position: fixed;*/
  background-color: white;
  max-height: 90%;
  overflow-y: auto;
  top: 10px;
  right: 10px;
  width: 280px;
  height: 200px;
}
.panelWrap {
  /*width: 90%;*/
  height: 300px;
  position: absolute;
  top: 0;
  right: 0;
  display: flex;
  justify-content: right;
}
</style>
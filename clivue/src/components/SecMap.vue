<template>
  <div>
    <div ref="mapContainer" style="width: 100%; height: 400px;"></div>
    <button @click="center">高精度定位</button>
  </div>
</template>

<script>
import AMapLoader from '@amap/amap-jsapi-loader';

export default {
  name: 'HighPrecisionLocation',
  data() {
    return {
      map: null,
    };
  },
  mounted() {
    this.initMap();
  },
  methods: {
    initMap() {
      AMapLoader.load({
        key: '1804f07cb4958d0cd049b77a103ae478', // 替换成你的API Key
        version: '2.0', // 高德地图API的版本号，可以根据需要调整
        plugins: ['AMap.Geolocation'], // 确保加载Geolocation插件
      })
          .then((AMap) => {
            this.map = new AMap.Map(this.$refs.mapContainer, {
              zoom: 10,
              center: [116.39, 39.9], // 北京的经纬度作为初始中心点
            });
          })
          .catch((e) => {
            console.error('地图加载失败', e);
          });
    },
    getHighPrecisionLocation() {
      if (this.map) {
        AMap.plugin('AMap.Geolocation', () => {
          const geolocation = new AMap.Geolocation({
            enableHighAccuracy: true, // 是否使用高精度定位，默认:true
            timeout: 10000,          // 超过10秒后停止定位，默认：5s
            maximumAge: 0,           // 定位结果的缓存时间，默认：0
            convert: true,           // 坐标转换，将高德坐标转换为GPS坐标，默认:true
          });
          geolocation.getCurrentPosition((status, result) => {
            if (status === 'complete' && result.info === 'SUCCESS') {
              // 成功定位后，可以在这里更新地图中心点等操作
              this.map.setCenter(result.position);
              console.log('高精度定位结果:', result);
            } else {
              console.error('定位失败', result);
            }
          });
        });
      }
    },
    center(){
      this.map.setCenter([112.085284,30.398791])
      const marker = new AMap.Marker({
        position: [112.085284,30.398791],
        title: "当前位置",
      });
      this.map.add(marker)
    }
  },
};
</script>
<template>
  <div>
    <div style="text-align: center;font-family:'宋体';margin-top: 120px">
      景点展示
    </div>
    <div style="margin-top: 5px">
      <el-input size="medium" style="width: 80%" v-model="areaname"></el-input>
      <el-button size="medium" type="primary" style="margin-left: 5px" @click="search">搜索</el-button>
    </div>
    <div>
    <div class="div"  v-for="area in areas" :key="area.id">
      <img style="width: 100%; height: 150px" :src="area.image"  @click="cli(area.id)"/>
      <br>
      <a v-text="area.area" :key="nameIndex"></a>
    </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "aView",
  data() {
    return {
      areas: [{id: '', area: "", image: ""}],
      nameIndex: "",
      areaname:""
    }
  },
  mounted() {
    this.show()
  },
  methods: {
    show() {
      this.request.get("http://localhost:8080/client/area/show").then(res => {
        this.areas = res.data
      })
    },
    cli(id) {
      this.$router.push('/AreaView?id=' + id)
    },
    search(){
      this.request.get("http://localhost:8080/client/area/search",{
        params:{
          areaname:this.areaname
        }
      }).then(res=>{
        this.areas=res.data
      })
    }
  }
}
</script>

<style scoped>
.div{
  float: left;
  width: 47%;
  margin-left: 8px;
  margin-top: 20px;
  text-align: center;
  margin-bottom: 60px;
}
</style>
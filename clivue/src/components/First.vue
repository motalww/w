<template>
<div style="margin-bottom: 100px">
  <div style="width: 100%;height: 200px">
    <mt-swipe :auto="4000" >
      <mt-swipe-item v-for="item in items">
        <img :src="item" style="width: 100%">
      </mt-swipe-item>
    </mt-swipe>
  </div>

  <div >
    <router-link to="/aView">
        <div style=" background: #a0cfff;;margin-top: 10px ;height: 80px;float: left;border: 1px solid ;border-radius: 15px">
        <img  style="width: 80px;height: 80px;" slot="icon" src="../assets/056_风景区.png">
<!--          <br>-->
<!--          <a style=" margin-top: 5px;margin-left: 30px">景区</a>-->
        </div>
    </router-link>
    <router-link to="/hotel">
        <div class="linkimg">
        <img  style="width: 80px;height: 80px;" slot="icon" src="../assets/056_民宿.png"/>
        </div>
    </router-link>
    <router-link to="/restaurant">
        <div class="linkimg">
        <img  style="width: 80px;height: 80px;" slot="icon" src="../assets/056_椰子水.png"/>
        </div>
    </router-link>
<!--    <router-link to="/line">-->
<!--      <div class="linkimg">-->
<!--        <img  style="width: 80px;height: 80px;" slot="icon" src="../assets/056_跟团.png"/>-->
<!--      </div>-->
<!--    </router-link>-->
  </div>

  <div class="container">
<!--    <div style="text-align: center;font-family:'宋体'">-->
<!--      景点展示-->
<!--    </div>-->
<!--    <div class="div"  v-for="area in areas" :key="area.id">-->
<!--    <img style="width: 100%; height: 150px" :src="area.image"  @click="cli(area.id)"/>-->
<!--    <br>-->
<!--    <a v-text="area.area" :key="nameIndex"></a>-->
<!--    </div>-->
    <router-view>
    </router-view>

  </div>
</div>
</template>

<script>
export default {
  name: "Map",
  data(){
    return{
      items:[],
      index:"",
      areas:[{id:'',area:"",image:""}],
      tex:"",
    }
  },

  mounted() {
    this.showSwipe()
  },
  methods:{
    showSwipe(){
      this.request.get("http://localhost:8080/client/area/rand").then(res=>{
        this.items=res.data
      })
    },
   }
}
</script>

<style scoped>
.container{
  width: 100%;
  margin-top: 10px;
}
.div{
 float: left;
  width: 47%;
  margin-left: 8px;
  margin-top: 20px;
  text-align: center;
}
.imgbox{
  width: 90px;
  height: 90px;
}
.linkimg{
  float: left;
  background: #a0cfff;
  margin-left: 76px;
  width: 80px;
  height: 80px;
  border: 1px solid;
  margin-top: 10px;
  border-radius: 15px
}
</style>
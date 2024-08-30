<template>
  <div style="margin-top: 120px">
    <div style="text-align: center;font-family:'宋体'">
      酒店展示
    </div>
    <div style="margin-top: 5px">
      <el-input size="medium" style="width: 80%"></el-input>
      <el-button size="medium" type="primary" style="margin-left: 5px">搜索</el-button>
    </div>
    <div class="div"  v-for="hotel in hotels" :key="hotel.id">
      <img style="width: 100%; height: 150px" :src="hotel.image"  @click="cli(hotel.id)"/>
      <br>
      <a style="text-align: center" v-text="hotel.name" :key="nameIndex"></a>
    </div>
  </div>
</template>

<script>
export default {
  name: "Hotel",
  data(){
    return{
      hotels:[{id:'',name:"",image:""}],
      nameIndex:""
    }
  },
  mounted() {
    this.show()
  },
  methods:{
    show(){
      this.request.get("http://localhost:8080/client/hotel/show").then(res=>{
        this.hotels=res.data
      })
    },
    cli(id){
      this.$router.push('/HotelView?id='+id)
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
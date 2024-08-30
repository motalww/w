<template>
  <div style="margin-top: 120px">
    <div style="text-align: center;font-family:'宋体'">
      美食展示
    </div>
    <div style="margin-top: 5px">
      <el-input size="medium" style="width: 80%"></el-input>
      <el-button size="medium" type="primary" style="margin-left: 5px">搜索</el-button>
    </div>
    <div class="div"  v-for="restaurant in restaurants" :key="restaurant.id">
      <img style="width: 100%; height: 150px" :src="restaurant.image"  @click="cli(restaurant.id)"/>
      <br>
      <a style="text-align: center" v-text="restaurant.name" :key="nameIndex"></a>
    </div>
  </div>
</template>

<script>
export default {
  name: "Restaurant",
  data() {
    return {
      restaurants: [{id: '', name: "", image: ""}],
      tex: "",
      nameIndex: ""
    }
  },
  mounted() {
    this.show()
  },
  methods: {
    show() {
      this.request.get("http://localhost:8080/client/restaurant/show").then(res => {
        this.restaurants = res.data
      })
    },
    cli(id) {
      this.$router.push('/RestaurantView?id=' + id)
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
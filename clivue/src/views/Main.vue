<template>
    <div >
      <div class="back">
        <span style="font-size: 30px" @click="toback()"><</span>
      </div>
      <div>
      <router-view/>
      </div>

          <div class="footer">
            <mt-tabbar v-model="selected">
            <mt-tab-item id="首页" >
            <img slot="icon" src="../assets/home.png" @click="home()" >
            首页
            </mt-tab-item>
            <mt-tab-item id="订单">
            <img slot="icon" src="../assets/c.png" @click="tomap()">
            地点
            </mt-tab-item>
            <mt-tab-item id="我的" >
            <img slot="icon" src="../assets/my.png" @click="my()">
            我的
            </mt-tab-item>
            </mt-tabbar>
          </div>

  </div>

</template>

<script>

export default {
  name: "Main",

  data(){
    return{
      selected:[],
      }
    },
  methods:{
    home(){
      this.$router.push('/first')
    },
    my(){
       this.$router.push('/my')
    },
    tomap(){
      this.$router.push('/maptest')
    },
    toback(){
      this.$router.back()
    }
  }
}
</script>

<style scoped>
.footer {
  position: fixed; /* 使div固定在视口的底部 */
  left: 0;
  bottom: 0;
  width: 100%; /* 使div横跨整个视口宽度 */
}
.back{
  /*display: flex;*/
  justify-content: center;
  height: 50px; /* 根据需要调整高度 */
  top: 0;
  left: 0;
  width: 100%;
  z-index: 1000; /* 确保它在页面内容之上 */
}
</style>
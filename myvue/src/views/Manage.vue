<template>
  <div style="height: 100%">
<!--    <router-link to="/manage"></router-link>-->
  <el-row>
    <el-container style="height: 100%; border: 0px solid #eee">
<!--      侧边栏-->
      <el-aside  width="200px" style="background-color: rgb(238, 241, 246);height: 100% " >
        <Aside/>
      </el-aside>

      <el-container>
<!--        顶部-->
        <el-header style="text-align: right; font-size: 12px">
          <Header/>
        </el-header>
<!--          表数据-->
        <el-main>
<!--          存放子路由-->
          <router-view></router-view>
        </el-main>

      </el-container>
    </el-container>
  </el-row>
  </div>
</template>
<style>
.el-header {
  background-color: #B3C0D1;
  color: #333;
  line-height: 60px;
}
.el-aside {
  color: #333;
}
</style>

<script>
import Aside from "@/components/Aside.vue";
import Header from "@/components/Header.vue";
export default {
  name:"manage",
  components: {Header, Aside},
  data() {
    return {

    }
  },

  comments:{
    Aside,
    Header
  },

}
</script>
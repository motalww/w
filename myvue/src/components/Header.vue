<template>
  <div>
  <el-header style="text-align: right; font-size: 12px">
    <span style="font-size: 15px">admin</span>
    <el-dropdown>
      <i class="el-icon-setting" style="margin-left: 5px"></i>
      <el-dropdown-menu slot="dropdown">
        <div @click="exit()">
          <el-dropdown-item >退出></el-dropdown-item>
        </div>
      </el-dropdown-menu>
    </el-dropdown>
  </el-header>
  </div>
</template>

<script>
export default {
  name: "Header",
  methods:{
    exit(){
      this.$router.push("/login")
      localStorage.removeItem('admin')
    }
  }
}
</script>

<style scoped>

</style>
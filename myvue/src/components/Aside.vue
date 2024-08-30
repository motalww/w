<template>
  <el-menu :default-openeds="['1', '3']" style="height: 100%;overflow-x: hidden "
           background-color="rgb(48,65,86)"
           text-color="#fff"
           router>

<!--           加上后通过index:""进行跳转子项-->
    <el-submenu index="1">
      <template slot="title"><i class="el-icon-message"></i>管理</template>
      <el-menu-item index="/user"><i class="el-icon-user"></i>用户管理</el-menu-item>
      <el-menu-item index="/area"><i class="el-icon-discover"></i>地点管理</el-menu-item>
      <el-menu-item index="/hotel"><i class="el-icon-discover"></i>酒店管理</el-menu-item>
      <el-menu-item index="restaurant"><i class="el-icon-discover"></i>餐厅管理</el-menu-item>
<!--      <el-menu-item index="/line"><i class="el-icon-discover"></i>路线生成</el-menu-item>-->
      <el-menu-item index="/comment"><i class="el-icon-discover"></i>评论</el-menu-item>
    </el-submenu>

    <el-submenu index="2">
      <template slot="title"><i class="el-icon-menu"></i>其它</template>
      <el-menu-item-group>
        <template slot="title">分组一</template>
        <el-menu-item index="2-1">选项1</el-menu-item>
        <el-menu-item index="2-2">选项2</el-menu-item>
      </el-menu-item-group>
    </el-submenu>
  </el-menu>
</template>

<script>
export default {
  name: "Aside"
}
</script>

<style scoped>

</style>
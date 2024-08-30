<template>
  <div style="margin-top: 120px">
    <div style="text-align: center;font-family:'宋体'">
      路线展示
    </div>
    <div style="margin-top: 5px">
      <el-input size="medium" style="width: 80%"></el-input>
      <el-button size="medium" type="primary" style="margin-left: 5px">搜索</el-button>
    </div>
    <div class="div"  v-for="line in lines" :key="line.id">
      <img style="width: 100%; height: 150px" :src="line.image"  @click="cli(line.id)"/>
      <br>
      <a style="text-align: center" v-text="line.name" :key="nameIndex"></a>
    </div>
  </div>
</template>

<script>
export default {
  name: "aView",
  data() {
    return {
      items: [],
      index: "",
      areas: [{id: '', area: "", image: ""}],
      tex: "",
      nameIndex: ""
    }
  },
  mounted() {
    this.show()
  },
  methods: {
    show() {

    },
    cli(id) {
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
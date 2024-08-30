<template>
  <div class="personal-info">
    <h1 style="text-align: center">个人信息</h1>
    <div style="text-align: center">
      <img class="avatar" :src="user.avatar"/>
      <br>
      <el-upload
          action="http://localhost:8080/upload"
          :on-success="changeAvatar"
          :limit="1"
      >
        <el-button type="text" >更换头像</el-button>
        </el-upload>
    </div>
    <div>
      <mt-field label="昵称" placeholder="Input username" :value="user.nickname" v-model="user.nickname"></mt-field>
      <mt-field label="电话号码" placeholder="Input email"  v-model="user.phone"></mt-field>
      <mt-button type="primary" @click="ok()">确定</mt-button>
      <mt-button type="primary" @click="exit">退出</mt-button>
    </div>
  </div>
</template>

<script>
export default {
  name: "Info",
  data(){
    return{
      avatar:"",
      user:[],
      info:[]
    }
  },
  methods:{
    changeAvatar(res){
      this.$message.success("图片上传成功")
      this.user.avatar=res
    },
    ok(){
      this.request.post("http://localhost:8080/client/user/update",this.user).then(res=>{
        if(res.code===1){
          this.$message.success("修改成功")
          this.user=res.data
          this.user.token=this.info.token
          localStorage.setItem("user",JSON.stringify(this.user))
        }
      })
     },
    exit(){
      this.$router.push('/my')
      localStorage.removeItem('user')
    }
  },
  created() {
    this.info=JSON.parse(localStorage.getItem('user'))
    this.user=this.info
  }
}
</script>

<style scoped>
.avatar {
  margin-top: 20px;
  border-radius: 50%;
  border: 1px solid;
  width: 120px;
  height: 120px;
}
</style>
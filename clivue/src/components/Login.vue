<template>
  <div>
    <div>
      <div class="img">
        <img slot="icon" src="../assets/a.jpg" width="100%" height="200px" >
      </div>
    </div>
    <div style="margin-top: 60px; height: 200px">
      <mt-field label="用户名" placeholder="请输入用户名" v-model="user.username"></mt-field>
      <mt-field label="密码" placeholder="请输入密码" type="password" v-model="user.password"></mt-field>
      <mt-button class="button" type="primary" @click="login()">login</mt-button>
      <mt-button class="button" type="danger" @click="register()">register</mt-button>
      <mt-button class="button" type="danger" @click="back()">back</mt-button>
    </div>
  </div>
</template>

<script>
import {Toast} from "mint-ui";

export default {
  name: "Login",
  data(){
    return{
        user:{}
    }
  },
  methods:{
    login(){
      if(this.user.username===""||this.user.password===""){
        this.$message.warning("用户名或密码为空")
        return
      }
      this.request.post("http://localhost:8080/login/user",this.user).then(
          res=>{
            if(res.code===1){
              localStorage.setItem("user", JSON.stringify(res.data));
              this.$message.success("登录成功")
              this.$router.push('/my')
            }
            else {
              this.$message.error("登录失败")
            }
      })
    },
    register(){
      this.$router.push('/register')
    },
    back(){
      this.$router.back()
    }
  }
}
</script>

<style scoped>
.img{
  margin-top: 30px;
  width: 100%;
  height: 180px;
}
.button{
  width: 31%;
  margin-top: 20px;
  margin-left: 7px;
}
</style>
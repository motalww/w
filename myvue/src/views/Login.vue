<template >
  <div class="a">
      <div class="b" >
        <h1 style="margin-left: 42%">登录</h1>
        <el-input v-model="admin.username" size="medium" class="input"
                  prefix-icon="el-icon-user-solid" placeholder="请输入用户名"></el-input>
        <br>
        <el-input v-model="admin.password" size="medium" class="input" show-password
                  prefix-icon="el-icon-lock" placeholder="请输入密码"></el-input>
        <br>
        <div style="margin-left: 60px">
        <el-button size="medium" style="margin-top: 30px;margin-left: 150px" type="primary" @click="login()">登录</el-button>
        </div>
      </div>
  </div>
</template>

<script >

export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name:"login",
  data() {
    return {
     admin:{}
    }
  },
   methods: {
    login() {
      if(this.admin.username===""&&this.admin.password===""){
        this.$message.error("用户名或密码为空")
      }else {
        this.request.post(this.$baseUrl+"/login/admin",this.admin).then(
            res => {
              localStorage.setItem("admin", JSON.stringify(res.data));//存储信息到浏览器本地存储
              if(res.code===0){
                this.$message.error(res.msg)
              }
              if(res.code===1) {
                this.$message.success("登录成功")
                this.$router.push("/user")
              }
            }
        )
      }
    }
  }
}
</script>
<style >
.a{
  height: 100vh;
  background-image: linear-gradient(to bottom right,#3a8ee6,#00ffff);
  overflow: hidden;
}
.b{
  width: 500px;
  height: 400px;
  margin-top: 5%;
  margin-left: 500px;
  border: solid 2px white;
  background: #00ffff;
  border-radius: 4px;
}
.input{
  margin-left: 150px;
  margin-top: 40px;
  width: 200px;

}
</style>
<template>
  <div>
    <div>
    </div>
    <div style="margin-top: 50px">
      <mt-field label="用户名" placeholder="请输入用户名" v-model="user.username"></mt-field>
      <mt-field label="密码" placeholder="请输入密码" type="password" v-model="user.password"></mt-field>
      <mt-field label="昵称" placeholder="请输入昵称"  v-model="user.nickname"></mt-field>
      <mt-field label="手机号" placeholder="请输入手机号" type="tel" v-model="user.phone"></mt-field>
      <mt-button class="button" type="primary" @click="ok()">确定</mt-button>
      <mt-button class="button" type="danger" @click="clear()">清空</mt-button>
      <mt-button class="button" type="danger" @click="back()">返回</mt-button>
    </div>
  </div>

</template>

<script>
import {Toast} from "mint-ui";

export default {
  name: "register",
  data(){
    return{
      user:{}
    }
  },
  methods:{
    ok(){
       if(this.user.username===""||this.user.password===""||this.user.nickname===""){
         Toast("用户名为空")
       }
       else {
         this.request.post("http://localhost:8080/clien/register", this.user).then(res => {
           if (res) {
             Toast("注册成功")
             this.$router.push('/login')
           } else {
             Toast("注册失败")
           }
         })
       }
    },
    clear(){
    this.user={}
    },
    back(){
      this.$router.back()
    }
  }
}
</script>

<style scoped>
.button{
  width: 31%;
  margin-top: 20px;
  margin-left: 7px;
}
</style>
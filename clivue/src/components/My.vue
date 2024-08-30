<template>
  <div class="center-container">
    <h1 style="text-align: center">个人中心</h1>
    <div class="center-info" v-if="isLogin" @click="myInfo()">
      <img class="center-headImg"  :src="user.avatar" />
      <div class="center-text">
          <a>更改信息/退出登录  ></a>
          <p >用户名：{{user.username}}</p>
          <p > 昵称：{{user.nickname}}</p>
        </div>
    </div>
    <div class="center-info" v-else @click="toLogin">
      <img class="center-headImg" src="" />
      <div class="center-text">
        <h3 style="text-align: center;margin-top: 30px">去登陆/注册 ></h3>
      </div>

    </div>
    <div class="center-logout">

    </div>
  </div>

</template>
<script >
export default{
  data(){
    return{
      user: {},
      isLogin:false
    }
  },
  mounted() {
    this.loadUserInfo()
  },
  methods:{
      toLogin(){
        this.$router.push('/login')
      },
    loadUserInfo(){
      const userInfo=JSON.parse(localStorage.getItem('user'))
      if(userInfo){
        this.user=userInfo
        this.isLogin=true;
      }
    },
    myInfo(){
      this.$router.push('/info')
    }
  }
}
</script>
<style >
.center-container {
  width: 100%;
  height: 600px;
}

.center-info {
  display: flex;
}

.center-headImg {
  margin-top: 20px;
  margin-left: 20px;
  border-radius: 50%;
  border: 1px solid;
  width: 120px;
  height: 120px;
}

.center-text {
  margin: 20px;
}

.center-text p {
  line-height: 40px;
  text-align: left;
  font-size: 20px;
  font-family:"Microsoft YaHei";
}

.center-edit {
  margin: 20px;
}
</style>

<template>
  <div>
    <div class="areaname">
      <a style="text-align: center" v-text="data.name"></a>
    </div>

    <div>
      <img :src="data.image" style="width: 100%;height: 200px">
    </div>
    <div style="margin-top: 5px">
      <mt-cell  title="地址:"  style="height: 50px">
        <span v-html="data.address" style="margin-right: 40px"></span>
        <a><img src="https://pic51.photophoto.cn/20190429/1190120522151585_b.jpg" @click="position()" width="30px" height="30px">
          <br>
          <a style="font-size: small">导航</a>
        </a>
      </mt-cell>
      <mt-cell title="价格:">
        <span v-html="data.price" ></span>
      </mt-cell>
    </div>

    <div>
      <div>
        <div style="border-bottom: 1px solid orangered;padding: 10px 0px;font-size: 20px">评论</div>
        <div style="padding: 10px 0px">
          <el-input type="textarea" v-model="commentForm.content"></el-input>
        </div>
        <div style="padding: 10px 0px;text-align: right ">
          <el-button type="primary" size="small" @click="send()">评论</el-button>
        </div>
      </div >
      <!--  评论列表-->
      <div style="margin-bottom: 50px">

        <div v-for="item in comments" :key="item.id" style="border-bottom: 1px solid ;padding: 10px; display: flex">
          <div  style="border-bottom: 1px solid ;width: 100%;padding: 10px; display: flex">
            <!--    头像-->
            <div style="width: 100px">
              <el-image style="width: 70px;height: 70px; border-radius: 50%" :src="item.avatar"></el-image>
            </div>
            <!--    内容-->
            <div style="flex: 1;width: 100%;line-height: 25px" >
              <b>{{ item.nickname }}:</b>
              <span style="margin-left: 5px">{{ item.content }}</span>
              <div style=" text-align: right;margin-right:10px ;margin-top: 10px">
                <i class=" el-icon-time" >:{{item.time}}</i>
                <br>
                <el-button type="text" >回复</el-button>
                <el-button type="text" style="color: red" @click="del(item.id)" v-if="user.id===item.userId">删除</el-button>
              </div>
            </div>

          </div>
        </div>

      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "RestaurantView",
  data() {
    return {
      user:localStorage.getItem("user")? JSON.parse(localStorage.getItem("user")):{} ,
      data:[],
      commentForm:{},
      comments:[],
      restaurantId:this.$route.query.id
    }
  },
  created() {
    this.load(this.restaurantId)
    this.loadComment()
  },
  methods:{
    load(id){
      this.request.get("http://localhost:8080/client/restaurant/"+id).then(res=>{
        this.data=res.data
        if(this.data!=null){
          this.data.name=res.data[0].name
          this.data.image=res.data[0].image
          this.data.address=res.data[0].address
          this.data.price=res.data[0].price
        }
      })
    },
    loadComment(){
      this.request.get("/comment/restaurant/"+this.restaurantId).then(res=>{
        this.comments=res.data;
      })
    },
    send(){
      if(!this.user.id){
        this.$message.warning("请登录")
        return
      }
      this.commentForm.restaurantId=this.restaurantId
      this.commentForm.userId=JSON.parse(localStorage.getItem("user")).id
      this.request.post("/comment/send",this.commentForm).then(res=>{
        if(res.code===1){
          this.$message.success("评论成功")
          this.commentForm={} //初始化评论对象内容
          this.loadComment()
        }
        else {
          this.$message.error(res.msg)
        }
      })
    },
    position(){

    },
    del(id){
      this.request.delete("/comment/"+id).then(res=>{
        if(res.code===1){
          this.$message.success("删除成功")
          this.loadComment()
        }
      })
    }
  }
}
</script>
<style scoped>
.areaname{
  text-align: center;
  font-size: 30px;
}
</style>
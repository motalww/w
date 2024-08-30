<template>
  <div>
    <div style="margin-bottom: 30px">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item><a href="">活动管理</a></el-breadcrumb-item>
      </el-breadcrumb>
    </div>

    <el-table :data="tableData">
      <el-table-column prop="id" label="ID" width="100"></el-table-column>
      <el-table-column prop="content" label="内容" width="200"></el-table-column>
      <el-table-column prop="userId" label="用户ID" width="150"></el-table-column>
      <el-table-column prop="time" label="时间" width="100" ></el-table-column>
      <el-table-column prop="areaId" label="地点Id" width="200"></el-table-column>、
      <el-table-column prop="hotelId" label="酒店Id" width="200"></el-table-column>
      <el-table-column prop="restaurantId" label="餐馆Id" width="200"></el-table-column>
      <el-table-column prop="operate" label="操作">
        <template v-slot="scope">
          <el-button STYLE="margin-top: 5px" type="danger" @click="dele(scope.row.id)">删除<i class="el-icon-delete"></i></el-button>
        </template>
      </el-table-column>

    </el-table>

    <div class="block">
      <span class="demonstration"></span>
      <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="pageNum"
          :page-sizes="[1, 2, 10, 20]"
          :page-size="pagesize"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total">
      </el-pagination>
    </div>
  </div>
</template>
<script>

export default {
  name: "Comment",
  data(){
    return {
      tableData: [],
      total:0,
      pageNum:1,
      pagesize:5,
      dialogFormVisible:false,
      form:{},
    }
  },
  created() {
    this.load()
  },
  methods:{
    load(){
      this.request.get(this.$baseUrl+"/comment/all",{
        params:{
          pageNum:this.pageNum,
          pagesize:this.pagesize
        }
      }).then(
          res=>{
            console.log(res.data)
            this.tableData=res.data
            this.total=res.total
          }
      )
    },
    handleSizeChange(pagesize){
      console.log(pagesize),
      this.pagesize=pagesize
      this.load()
    },
    handleCurrentChange(pageNum){
      console.log(pageNum)
      this.pageNum=pageNum
      this.load()
    },

    dele(id){
      this.request.delete(this.$baseUrl+"/comment/"+id).then(res=>{
        if(res){
          this.$message.success("删除成功")
          this.load()
        }
        else {
          this.$message.error("删除成功")
        }
      })
    },
    handle_success(res){
      this.$message.success("图片上传成功")
      this.form.image=res
    }

  }
}
</script>

<style scoped>

</style>
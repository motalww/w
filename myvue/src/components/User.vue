<template>
<div>
  <div style="margin-bottom: 30px">
    <el-breadcrumb separator="/">
      <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item><a href="/myvue/public">活动管理</a></el-breadcrumb-item>
    </el-breadcrumb>
  </div>

<!--  <div>-->
<!--    <el-input  type="text" style="width: 200px" placeholder="请输入id" suffix-icon="el-icon-search"></el-input>-->
<!--    <el-button style="margin-left: 5px" type="primary">搜索</el-button>-->
<!--  </div>-->

  <div>
    <el-button STYLE="margin-top: 5px" type="primary" @click="add()">新增<i class="el-icon-circle-plus"></i></el-button>
  </div>

  <el-table :data="tableData">
    <el-table-column prop="id" label="ID" width="100">
    </el-table-column>
    <el-table-column prop="username" label="用户名" width="200">
    </el-table-column>
    <el-table-column prop="password" label="密码" width="200">
    </el-table-column>
    <el-table-column prop="avatar" label="头像" width="200">
      <template v-slot:="scope">
        <el-image :src="scope.row.avatar"  fit="cover" style="width: 150px;height: 130px" >
        </el-image>
      </template>
    </el-table-column>
    <el-table-column prop="phone" label="电话" >
    </el-table-column>
    <el-table-column prop="nickname" label="昵称" >
    </el-table-column>
    <el-table-column prop="operate" label="操作">
      <template v-slot="scope">
        <el-button STYLE="margin-top: 5px" type="success" @click="edit(scope.row)">修改<i class="el-icon-edit"></i></el-button>
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
        :page-sizes="[2, 5, 10, 20]"
        :page-size="pagesize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total">
    </el-pagination>
  </div>

  <el-dialog  title="用户信息" :visible.sync="dialogFormVisible" width="30%" >
      <el-form label-width="80px" size="small">

      <el-form-item label="用户名">
        <el-input v-model="form.username" ></el-input>
      </el-form-item>

      <el-form-item label="密码">
      <el-input v-model="form.password"></el-input>
      </el-form-item>
        <el-form-item label="头像">
          <el-image :src="form.avatar" style="width: 120px;height: 120px"></el-image>
        </el-form-item>

        <el-form-item label="昵称">
          <el-input v-model="form.nickname"></el-input>
        </el-form-item>

        <el-form-item label="电话">
          <el-input v-model="form.phone"></el-input>
        </el-form-item>
        <el-upload
            :action="$baseUrl+ '/upload' "
            :on-success="handle_success"
            :limit="1"
        >
          <el-button size="small" type="primary" style="margin-left: 80%">点击上传图片</el-button>
          <div slot="tip" style="text-align: center">只能上传jpg png文件，且不超500kb</div>
        </el-upload>

    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="dialogFormVisible = false">取 消</el-button>
      <el-button type="primary" @click="save()">确 定</el-button>
    </div>
  </el-dialog>

</div>
</template>

<script>

export default {
  name: "User",
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
      this.request.get(this.$baseUrl+"/admin/user/page",{
        params:{
          pageNum:this.pageNum,
          pagesize:this.pagesize
        }
      }).then(
          res=>{
            this.tableData=res.data
            this.total=res.total
          }
      )
    },
    handleSizeChange(pagesize){
          this.pagesize=pagesize
          this.load()
    },
    handleCurrentChange(pageNum){
      this.pageNum=pageNum
      this.load()
    },
    add(){
      this.dialogFormVisible=true
      this.form={}
    },
    save(){
      this.request.post(this.$baseUrl+"/admin/user/save",this.form).then(res=>{
              if(res){
               this.$message.success("保存成功")
               this.dialogFormVisible=false
                this.load()
                 }
              else {
              this.$message.error("保存失败")
             }
      })
    },
    edit(row){
      this.form=row
      this.dialogFormVisible=true
    },
    dele(id){
      this.request.delete(this.$baseUrl+"/admin/user/"+id).then(res=>{
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
      this.form.avatar=res
    }
  }

}
</script>

<style >

</style>
<template>
  <div>
    <div>
      <el-input type="text" style="width: 200px" placeholder="请输入" suffix-icon="el-icon-search"></el-input>
      <el-button style="margin-left: 5px" type="primary">搜索</el-button>
    </div>

    <div>
      <el-button STYLE="margin-top: 5px" type="primary" @click="add()">新增<i class="el-icon-circle-plus"></i></el-button>
    </div>

    <el-table :data="tableData">
      <el-table-column prop="id" label="ID" width="100"></el-table-column>
      <el-table-column prop="name" label="名称" width="100"></el-table-column>
      <el-table-column prop="type" label="类型" width="100"></el-table-column>
      <el-table-column prop="area" label="景点" width="100" ></el-table-column>
      <el-table-column prop="hotel" label="酒店" width="150" ></el-table-column>
      <el-table-column prop="restaurant" label="美食" width="200" ></el-table-column>
      <el-table-column prop="num" label="人数" width="200" ></el-table-column>
      <el-table-column prop="price" label="价格" width="200" ></el-table-column>
      <el-table-column prop="image" label="图片" width="200" >
        <template v-slot:="scope">
          <el-image :src="scope.row.image"  fit="cover" style="width: 150px;height: 130px" >
          </el-image>
        </template>
      </el-table-column>

      <el-table-column prop="operate" label="操作">
        <template v-slot="scope">
          <el-button STYLE="margin-top: 5px" type="primary">详情<i class="el-icon-edit"></i></el-button>
          <el-button STYLE="margin-top: 5px" type="success" @click="edit(scope.row)">修改<i class="el-icon-edit"></i></el-button>
          <el-button STYLE="margin-top: 5px" type="danger" @click="dele(scope.row.id)">删除<i class="el-icon-delete"></i></el-button>
        </template>
      </el-table-column>

    </el-table>

    <div class="block">
      <span class="demonstration"></span>
      <el-pagination
          @size-change=""
          @current-change=""
          :current-page="pageNum"
          :page-sizes="[1, 2, 10, 20]"
          :page-size="pagesize"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total">
      </el-pagination>
      <el-dialog  title="用户信息" :visible.sync="dialogFormVisible" width="30%" >
        <el-form label-width="80px" size="small">

          <el-form-item label="名称">
            <el-input v-model="form.name" ></el-input>
          </el-form-item>
          <el-form-item label="类型">
            <el-input v-model="form.type" ></el-input>
          </el-form-item>

          <el-form-item label="景点">
            <el-input v-model="form.area"></el-input>
          </el-form-item>
          <el-form-item label="酒店">
            <el-input v-model="form.hotel"></el-input>
          </el-form-item>
          <el-form-item label="美食">
            <el-input v-model="form.restaurant"></el-input>
          </el-form-item>
          <el-form-item label="人数">
            <el-input v-model="form.num"></el-input>
          </el-form-item>
          <el-form-item label="价格">
            <el-input v-model="form.price"></el-input>
          </el-form-item>
          <el-form-item label="图片">
            <el-input v-model="form.image"></el-input>
          </el-form-item>

          <el-upload
              :action="$baseUrl+ '/upload' "
              :on-success="handle_success"
              :limit="1"
          >
            <el-button size="small" type="primary" style="margin-left: 80%">点击上传图片</el-button>
            <div slot="tip">只能上传jpg png文件，且不超500kb</div>
          </el-upload>

        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogFormVisible = false">取 消</el-button>
          <el-button type="primary" @click="save()">确 定</el-button>
        </div>
      </el-dialog>
    </div>
  </div>
</template>

<script>
export default {
  name: "Line",
  data(){
    return{
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
      this.request.get(this.$baseUrl+"/admin/line/page",{
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
    add(){
      this.form={}
      this.dialogFormVisible=true
    },

    save(){
      this.request.post(this.$baseUrl+"/admin/hotel/save",this.form).then(res=>{
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
      this.request.delete(this.$baseUrl+"/admin/hotel/"+id).then(res=>{
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
      // console.log(res)
      this.$message.success("图片上传成功")
      this.form.image=res
    }
  }
}
</script>

<style scoped>

</style>
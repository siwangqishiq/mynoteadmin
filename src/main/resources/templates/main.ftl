<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <!-- 引入样式 -->
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
    <title>PMNote后台系统</title>

    <style>
   .el-header {
    background-color: #B3C0D1;
    color: #333;
    line-height: 60px;
  }

  .el-aside {
    color: #333;
  }
</style>
    <!-- import Vue before Element -->
    <script src="https://unpkg.com/vue/dist/vue.js"></script>
    <!-- import JavaScript -->
    <script src="https://unpkg.com/element-ui/lib/index.js"></script>
    <script src="https://cdn.staticfile.org/vue-resource/1.5.1/vue-resource.min.js"></script>
</head>

<body>
<div id="app">
    <el-container style="height: 1000px; border: 1px solid #eee">
        <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
            <el-menu :default-openeds="['1']">
                <el-submenu index="1">
                    <template slot="title"><i class="el-icon-menu"></i>App设置</template>
                    <el-menu-item-group>
                        <template slot="title">版本管理</template>
                        <el-menu-item index="2-1" >ios版本</el-menu-item>
                        <el-menu-item index="2-2">android版本</el-menu-item>
                    </el-menu-item-group>
                </el-submenu>
            </el-menu>
        </el-aside>

        <el-container>
            <el-header style="text-align: right; font-size: 12px">
                <el-dropdown>
                    <i class="el-icon-setting" style="margin-right: 15px"></i>
                    <el-dropdown-menu slot="dropdown">
                        <el-dropdown-item>帮助</el-dropdown-item>
                        <el-dropdown-item  @click.native="dialogVisible = true">退出</el-dropdown-item>
                    </el-dropdown-menu>
                </el-dropdown>
                <span>${username}</span>
            </el-header>

            <el-main>
                <el-table :data="tableData">
                    <el-table-column prop="date" label="日期" width="140">
                    </el-table-column>
                    <el-table-column prop="name" label="姓名" width="120">
                    </el-table-column>
                    <el-table-column prop="address" label="地址">
                    </el-table-column>
                </el-table>
            </el-main>
        </el-container>
    </el-container>


    <el-dialog title="提示" :visible.sync="dialogVisible" width="30%" :before-close="handleClose">
      <span>是否确认退出?</span>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="logout">确 定</el-button>
      </span>
    </el-dialog>

</div>
</body>

<script>
var appVue = new Vue({
    el:"#app",
    data:{
        dialogVisible:false
    },
    methods:{
        test : function(){
            alert('hahaha')
        },
        logout: function(){
             this.$http.post('/api/dologout',null,{emulateJSON:true})
                        .then(
                            function onSuccess(res){
                                if(res.body === null){
                                    return
                                }
                                if(res.body.code === 200){
                                    window.location = "/login.html";
                                    return
                                }
                            },

                            function onError(res){
                            }
                        )

            appVue.dialogVisible = false;
        }
    }
})
</script>
</html>
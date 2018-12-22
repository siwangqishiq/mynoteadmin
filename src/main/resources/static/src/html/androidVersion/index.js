
define([
    'text!./index.html',
    '{pro}base/util.js',
], function(_tpl, _u) {

    var Test = Vue.extend({
        template: _tpl,

        data: function() {
            return {
                versionList: [],
                dialogFormVisible:false,
                form : {},
            }
        },

        // 创建组建时，可以请求数据
        created: function() {
            this.getVersionList();
        },

        // 组件挂载
        mounted: function() {

        },

        methods: {
            getVersionList: function() {
                var _this = this;
                _u._$ajax({
                    url: '/api/versionList',
                    data: {
                        platform: 2
                    },
                    success: function(_json) {
                        if(_json.code === 200) {
                            _json.data.map(function(value , i){
                                value.updateTime = new Date(value.updateTime).toString()
                            });

                            _this.versionList = _json.data;
                        }
                    },
                    error: function() {
                        alert('erorr');
                    }
                })
            },

            submitNewVersion : function(){
                var _this = this;
                _u._$ajax({
                    url: '/api/addversion',
                    method: 'POST',
                    unStringify: true,
                    data:{
                        versionCode: this.form.versionCode,
                        versionName: this.form.versionName,
                        url: this.form.url,
                        descrption: this.form.desc,
                        type: 2
                    },
                    success: function(_json) {
                        if(_json.code != 200){
                            alert('添加失败');
                            return;
                        }

                        var data = _json.data
                        if(data > 0){
                            _this.getVersionList()
                        }
                                    //console.log(_json);
                    },
                    error : function(){
                        alert('添加失败');
                    }
                })

                this.dialogFormVisible = false
            },
        }

    })

    return Test
})
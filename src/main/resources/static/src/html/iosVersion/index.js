
define([
    'text!./index.html',
    '{pro}base/util.js',
], function(_tpl , _u) {

    var IosVersion = Vue.extend({
        template: _tpl,

        data: function(){
            return {
                versionList:[],
                dialogFormVisible:false,
                form : {},
            }
        },

        created:function(){
            this.getVersionList();
        },

        methods:{
            getVersionList: function() {
                var _this = this;
                _u._$ajax({
                    url: '/api/versionList',
                    data: {
                        platform: 1
                    },
                    success: function(_json) {
                        if(_json.code === 200) {
                            _json.data.map(function(value , i){
                                value.updateTime = new Date(value.updateTime).toString()
                            })
                            _this.versionList = _json.data
                        }
                    },
                    error: function() {
                        alert('ios erorr list')
                    }
                })
            },

            addNewIOSVersion: function() {
                var _this = this;
            },

            submitNewVersion : function(){
                _u._$ajax({
                    url: '/api/addversion',
                    method: 'POST',
                    unStringify: true,
                    data:{
                        versionCode: this.form.versionCode,
                        versionName: this.form.versionName,
                        url: this.form.url,
                        descrption: this.form.desc,
                        type: 1
                    },
                    success: function(_json) {
                        console.log(_json);
                    },
                    error : function(){
                        alert('添加失败');
                    }
                })

                this.dialogFormVisible = false
            },
        },
    })

    return IosVersion
})
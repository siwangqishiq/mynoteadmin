
define([
    'text!./index.html',
    '{pro}base/util.js',
], function(_tpl, _u) {

    var Test = Vue.extend({
        template: _tpl,

        data: function() {
            return {
                versionList: []
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
            }
        }

    })

    return Test
})

define([
    'text!./app.html'
], function(_tpl) {

    var App = Vue.extend({
        template: _tpl,

        data: function() {
            return {
                text: 'abcd'
            }
        }
    })

    return App
})
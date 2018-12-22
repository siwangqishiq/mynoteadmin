
define([
    '{module}app/app.js',
    './router.js'
], function(App, router) {

    new Vue({
        router: router,
        el: '#app',
        render: function(h) {
            return h(App)
        }
    })
})
define([
    '{module}androidVersion/index.js',
    '{module}iosVersion/index.js'
], function(AndroidVersion, iosVersion) {

    var routes = [{
        path: '/',
        component: AndroidVersion
    }, {
        path: '/androidVersion',
        component: AndroidVersion
    }, {
        path: '/iosVersion',
        component: iosVersion
    }]

    var router = new VueRouter({
        mode: 'hash',
        routes: routes
    })

    return router
})
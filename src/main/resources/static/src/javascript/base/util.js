
define([
    'base/util',
    'util/ajax/xdr'
], function(_u, _ajax) {

    var _p = {};

    _p._$ajax = function (opts) {
        if(!opts.url){
            return false;
        }

        var headers;

        headers = {
            'x-requested-with': 'XMLHttpRequest'
        }
        if (opts.headers) {
            for (var key in opts.headers) {
                headers[key] = opts.headers[key];
            }
        }
        _ajax._$request(opts.url,{
            type: 'json',
            method: opts.method || 'GET',
            data: opts.data || {},
            timeout: opts.timeout || 10000,
            headers: headers,
            onload:function(_data){
                opts.success && opts.success(_data);
            },
            onerror:function(_error){
                opts.fail && opts.fail.apply(this, arguments);
            },
            onbeforerequest: opts.beforeSend
        });
    }

    return _p;
});


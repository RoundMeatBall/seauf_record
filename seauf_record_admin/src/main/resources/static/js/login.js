layui.config({
    base: '/layuiadmin/',
    controller: '/user/'
}).extend({
    index: 'lib/index' //主入口模块
}).use(['index', 'user'], function () {
    var $ = layui.$
        , setter = layui.setter
        , admin = layui.admin
        , form = layui.form;

    form.render();

    //提交
    form.on('submit(LAY-user-login-submit)', function (obj) {

        //请求登入接口
        admin.req({
            url: "http://record.seauf.com:81/" + 'user/login'
            , data: obj.field
            , done: function (res) {

                //请求成功后，写入 access_token
                layui.data(setter.tableName, {
                    key: setter.request.tokenName
                    , value: res.data.access_token
                });

                //登入成功的提示与跳转
                layer.msg('登入成功', {
                    offset: '15px'
                    , icon: 1
                    , time: 1000
                }, function () {
                    location.href = '/'; //后台主页
                });
            }
        });

    });
});
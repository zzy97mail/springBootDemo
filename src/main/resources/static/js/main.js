$(function () {
    pageLoad();
    $("#page"+sessionStorage.getItem("page")).addClass("layui-this")
    $(".jump").click(function () {
        sessionStorage.setItem("page",$(this).attr("page"));
    });
    var name = JSON.parse(sessionStorage.getItem("usernameRel"));
    if (name.username == null) {
        loginOut();
    }else {
        var user = $("#userRelName");
        user.empty();
        user.append('<img src="http://t.cn/RCzsdCq" class="layui-nav-img">'+name.name);
    }
});


//页面加载时执行的函数
function pageLoad() {
    var page = sessionStorage.getItem("page");
    if (page == null){
        layui.use('layer', function () {
            layui.layer.confirm('还未登录', {
                btn: ['确定']
                , btn1:function(){
                    loginOut();
                },cancel:function f() {
                    loginOut();
                }
            });
        })
    }
    var content = $("#content");
    content.empty();
    var url = "";
    switch (page) {
        case "1" :
            url = "../small/index.html";
            break;
        case "2" :
            url = "../small/type.html";
            break;
        case "3":
            url = "../small/user.html";
            break;
        case "4":
            url = "../small/text.html";
            break;
    }
    var html_page = '<iframe style="height: 98%; width: 100%" src="' + url + '"></iframe>';
    content.append(html_page);
}


//退出登录
function loginOut() {
    document.location.href = "login-page.html";
}
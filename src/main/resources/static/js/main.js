$(function () {
    pageLoad();
    $(".jump").click(function () {
        sessionStorage.setItem("page",$(this).attr("page"));
    });
});


//页面加载时执行的函数
function pageLoad() {
    var page = sessionStorage.getItem("page");
    if (page == null){
        layui.use('layer', function () {
            layui.layer.confirm('还未登录', {
                btn: ['确定']
                , btn1:function(){
                    document.location.href = "login.html";
                },cancel:function f() {
                    document.location.href = "login.html";
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
    }
    var html_page = '<iframe style="height: 98%; width: 100%" src="' + url + '"></iframe>';
    content.append(html_page);
}


//退出登录
function loginOut() {
    document.location.href = "login.html";
}
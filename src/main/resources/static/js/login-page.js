$(function () {
    sessionStorage.clear();
    $('#password').bind('keyup', function(event) {
        if (event.keyCode == "13") {
            postForm();
        }
    });
})
layui.use('layer', function () {
})
function postForm(){
    var manager_id=document.getElementById("username").value;
    var manager_pwd=document.getElementById("password").value;
    if(manager_pwd == "" || manager_id==""){
        layui.layer.msg("请输入用户名或密码");
        return;
    }
    var index_load = layui.layer.load(1,{shade: [0.8, '#393D49']});
    $.ajax({
        url: "/LoginController/getIsLogin",
        contentType: "application/x-www-form-urlencoded",
        type:"post",
        data:{
            username:$("#username").val(),
            password:$("#password").val()
        },
        success: function(data){
            console.log(data);
            if (data.code == 0){

                    layui.layer.confirm('登录成功(3秒后自动关闭……)', {
                        btn: ['确定']
                        , btn1:function(){
                            jump(data.msg);
                        },end:function f() {
                            jump(data.msg);
                        },time:3000,shadeClose:true
                    }
                    );

            } else {
                layui.layer.msg("用户名或密码错误");
                layui.layer.closeAll('loading');
            }
        },
        error:function (e) {
            console.error(e);
        }
    });
}
// 帐号密码验证成功后的操作
function jump(name) {
    sessionStorage.setItem("page","1");
    var massage = {};
    massage.name = name;
    massage.username = $("#username").val();
    sessionStorage.setItem("usernameRel",JSON.stringify(massage));
    document.location.href = "main.html";
}
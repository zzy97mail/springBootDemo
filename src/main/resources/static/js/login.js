$(function () {
    sessionStorage.clear();
})
function postForm(){
    var manager_id=document.getElementById("username").value;
    var manager_pwd=document.getElementById("password").value;
    document.getElementById("msg").innerHTML="";
    if(manager_pwd == "" || manager_id==""){
        $("#msg").text("请输入用户名或密码");
        return;
    }
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
                layui.use('layer', function () {
                    layui.layer.confirm('登录成功', {
                        btn: ['确定']
                        , btn1:function(){
                            jump();
                        },cancel:function f() {
                            jump();
                        }
                    });
                })
            } else {
                $("#msg").text("用户名或密码错误");
            }
        },
        error:function (e) {
            console.error(e);
        }
    });
}
// 帐号密码验证成功后的操作
function jump() {
    sessionStorage.setItem("page","1");
    document.location.href = "main.html";
}
$(function () {
    sessionStorage.clear();
})
layui.use('layer', function () {
})
function postForm(){
    var manager_id=document.getElementById("username").value;
    var manager_pwd=document.getElementById("password").value;
    document.getElementById("msg").innerHTML="";
    if(manager_pwd == "" || manager_id==""){
        $("#msg").text("请输入用户名或密码");
        return;
    }
    layui.layer.load(1,{shade: [0.8, '#393D49']});
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

                    layui.layer.confirm('登录成功', {
                        btn: ['确定']
                        , btn1:function(){
                            jump(data.msg);
                        },end:function f() {
                            jump(data.msg);
                        },time:3000,shadeClose:true
                    }
                    );

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
function jump(name) {
    sessionStorage.setItem("page","1");
    sessionStorage.setItem("usernameRel",name);
    document.location.href = "main.html";
}
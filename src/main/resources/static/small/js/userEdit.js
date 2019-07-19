$(function () {
    if (getQueryString("page") == "1"){

    } else {
        $("#username").attr("disabled",true).val(getQueryString("user"));
        $("#name").val(sessionStorage.getItem("user_name"));
    }
})
/**
 * 获取url后面的参数
 *
 * @param name 参数名字
 * @returns {string|null}
 */
function getQueryString(name) {
    var reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)', 'i');
    var r = window.location.search.substr(1).match(reg);
    if (r != null) {
        return unescape(r[2]);
    }
    return null;
}
function back() {
    document.location.href = "user.html";
}
layui.use('layer', function () {
})
function add(){
    var username = $("#username").val();
    var name = $("#name").val();
    var password = $("#password").val();
    var rePassword = $("#rePassword").val();
    if (username === ""||name === ""||password===""||rePassword===""){
        layui.layer.msg("请把数据填写完整");
        return;
    }
    if (password !== rePassword){
        layui.layer.msg("两次密码不一致");
        return;
    }
    $.ajax({
        url: "/LoginController/upsertById",
        contentType: "application/x-www-form-urlencoded",
        type:"post",
        data:{
            managerId:$("#username").val(),
            managerName:$("#name").val(),
            managerPwd:$("#password").val()
        },
        success: function(data){
            if (data.code == 0){
                layui.use('layer', function () {
                    layui.layer.confirm('提交成功', {
                        btn: ['确定']
                        , btn1:function(){
                            back();
                        },cancel:function f() {
                            back();
                        }
                    });
                })
            }
        },
        error:function (e) {
            console.error(e);
        }
    });
}
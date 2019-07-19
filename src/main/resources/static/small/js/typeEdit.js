$(function () {
    var type_data = JSON.parse(sessionStorage.getItem("typeData"));
    $("#navName").val(type_data.navName);
    $("#navFeight").val(type_data.navFeight);
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
    document.location.href = "type.html";
}
layui.use('layer', function () {
})
function add(){
    var navFeight = $("#navFeight").val();
    var navName = $("#navName").val();
    if (navFeight === ""||navName === ""){
        layui.layer.msg("请把数据填写完整");
        return;
    }
    $.ajax({
        url: "/navController/upsertById",
        contentType: "application/x-www-form-urlencoded",
        type:"post",
        data:{
            navId:getQueryString("id"),
            navName:$("#navName").val(),
            navFeight:$("#navFeight").val()
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
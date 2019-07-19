$(function () {
    $.ajax({
        url: "/navController/getAllMsgNoPage",
        contentType: "application/x-www-form-urlencoded",
        type:"get",
        success: function(data){
            console.log(data);
            data.data.forEach(function (value) {
                $("#type").append('<option value="'+value.nav_id+'">'+value.nav_name+'</option>');
            })
            var old_data = JSON.parse(sessionStorage.getItem("textData"));
            if (old_data!=null){
                $("#type").val(old_data.type);
                $("#title").val(old_data.title);
            }
            layui.form.render('select');
            if (old_data!=null)
                layui.layedit.setContent(index, old_data.content, false);

        },
        error:function (e) {
            console.error(e);
        }
    });
});

function back() {
    document.location.href = "text.html";
}
var index;
layui.use('layedit', function(){
    var layedit = layui.layedit;
    index = layedit.build('content'); //建立编辑器
});
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

layui.use('layer', function () {
})
function add(){
    var type = $("#type").val();
    var title = $("#title").val();
    var content = layui.layedit.getContent(index);
    if (type === ""||title === ""||content===""){
        layui.layer.msg("请把数据填写完整");
        return;
    }
    $.ajax({
        url: "/articleController/upsertById",
        contentType: "application/x-www-form-urlencoded",
        type:"post",
        data:{
            articleId:getQueryString("id"),
            articleTitle:title,
            articleContent:content,
            navId:type
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
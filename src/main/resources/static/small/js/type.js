
$(function () {
    sessionStorage.removeItem("typeData");
});
function addBtn(){
    document.location.href = "typeEdit.html?id=''";
}
layui.use('table', function(){
    var table = layui.table;
    table.render({
        elem: '#type'
        ,height: 500
        ,url: '/navController/getAllMsgByPage' //数据接口
        ,page: true //开启分页
        ,request: {
            pageName: 'page' //页码的参数名称，默认：page
            ,limitName: 'rows' //每页数据量的参数名，默认：limit
        }
        ,parseData: function(res){ //res 即为原始返回的数据
            return {
                "code": res.code, //解析接口状态
                "msg": res.msg, //解析提示文本
                "count": res.data.total, //解析数据长度
                "data": res.data.rows //解析数据列表
            };
        }
        ,cols: [[ //表头
            // {field: 'checked', title: '选择', type:"checkbox", sort: true}
            {field: 'id', title: '序号',type:"numbers",width:80, sort: true}
            ,{field: 'nav_name', title: '类别'}
            ,{field: 'nav_feight', title: '排序权重',  sort: true}
            ,{fixed: 'right', width:150, align:'center', toolbar: '#bar'}
        ]]
    });


    //监听工具条
    table.on('tool(test)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        var tr = obj.tr; //获得当前行 tr 的DOM对象
        if(layEvent === 'add'){ //添加
            document.location.href = "typeEdit.html?id=''";
            //do somehing
        } else if(layEvent === 'del'){ //删除
            layer.confirm('真的删除行么', function(index){
                obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                layer.close(index);
                deleteById(data.nav_id);
                //向服务端发送删除指令
            });
        } else if(layEvent === 'edit'){ //编辑
            //do something
            var type_data = {};
            type_data.navName = data.nav_name;
            type_data.navFeight = data.nav_feight;
            sessionStorage.setItem("typeData",JSON.stringify(type_data));
            document.location.href = "typeEdit.html?id="+data.nav_id;
        }
    });
});

function deleteById(id) {
    $.ajax({
        url: "/navController/deleteByNavId",
        contentType: "application/x-www-form-urlencoded",
        type:"post",
        data:{
            navId:id
        },
        success: function(data){
            console.log(data);
            if (data.code == 0){
                layui.use('layer', function () {
                    layui.layer.confirm('删除成功', {
                        btn: ['确定']
                        , btn1:function(index){
                            layer.close(index);
                        },cancel:function f() {
                            return;
                        }
                    });
                })
            } else {
                $("#msg").text("删除失败");
            }
        },
        error:function (e) {
            console.error(e);
        }
    });
}
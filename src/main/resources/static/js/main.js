$(function () {
 pageLoad();

});


//页面加载时执行的函数
function pageLoad() {
    var page = getQueryString("page");
    var content = $("#content");
    content.empty();
    switch (page) {
        case "1" : content.append('<iframe style="height: 98%; width: 100%" src="../small/index.html"></iframe>');console.log(123);break;
    }
}

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
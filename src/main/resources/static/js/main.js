$(function () {
    pageLoad();

});


//页面加载时执行的函数
function pageLoad() {
    var page = getQueryString("page");
    var content = $("#content");
    content.empty();
    var url = "";
    switch (page) {
        case "1" :
            url = "../small/index.html";
            break;
    }
    var html_page = '<iframe style="height: 98%; width: 100%" src="' + url + '"></iframe>';
    content.append(html_page);
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
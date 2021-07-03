var currentPage = 1;
var PathName = window.location.pathname.substring(1);
var ProjectName = PathName.substring(0, PathName.indexOf("/"));
var URL = window.location.protocol + "//" + window.location.host + "/" + ProjectName;
var totalPage;

function getTotalPage() {
    $.ajax({
        type: "get",
        url: URL + "/getTotalPage",
        success(result) {
            totalPage = result;
            $("#totalPage").html("总页数:" + result);
        }
    })
}

function page() {
    $("#currentPage").text("当前页数:"+currentPage);
    $.ajax({
        type: "get",
        url: URL + "/getAllGoods",
        dataType: 'json',
        data: {"currentPage": currentPage},
        success(result) {
            $(".show").empty();//首先把旧的元素都清空
            $.each(result, function (index, item) {
                var str = ".show:eq(" + index + ")";
                $(str).append("<div class=\"tphoto\">\n" +
                    "                        <img src='./img/" + item.imgs[0].imgAddr + "'>\n" +
                    "                    </div>\n" +
                    "                    <div class=\"caption\">\n" +
                    "                        <h3 style='color: lightpink'>￥" + item.goodsPrice + "</h3>\n" +
                    "                        <p style='color: orange'>" + item.goodsName + "</p>\n" +
                    "                        <p>卖家：" + item.ownUser.userName + "</p>\n" +
                    "                        <p>\n" +
                    "                            <a href=\"#\" class=\"btn btn-primary\" role=\"button\">\n" +
                    "                                购买\n" +
                    "                            </a>\n" +
                    "                            <a href=\"#\" class=\"btn btn-default\" role=\"button\">\n" +
                    "                                加入购物车\n" +
                    "                            </a>\n" +
                    "                        </p>\n" +
                    "                    </div>");
            })

        }
    })
}

$(function () {
    page();
    getTotalPage();
    console.log($("#logOut").text());
    if ($("#logOut").text()=='') $("#logOut").hide();

});

function reducePage() {
    if (currentPage > 1) {
        currentPage--;
        page();
    }
    else alert("这是第一页哦!")
}

function addPage() {
    if (currentPage < totalPage) {
        currentPage++;
        page();
    }
    else alert("已经是最后一页啦!");
}
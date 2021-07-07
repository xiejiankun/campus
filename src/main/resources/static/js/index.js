var currentPage = 1;
var PathName = window.location.pathname.substring(1);
var ProjectName = PathName.substring(0, PathName.indexOf("/"));
var URL = window.location.protocol + "//" + window.location.host + "/" + ProjectName;
var totalPage=1;
console.log("bianliang======");
var sessionUserId;
function success(result) {
    console.log("ajax=======");
    totalPage=result.totalPage;
    $("#totalPage").text(totalPage);
    $(".show").empty();//首先把旧的元素都清空
    $.each(result.list, function (index, item) {
        console.log(URL);
        var str = ".show:eq(" + index + ")";
        $(str).append("<div class=\"tphoto\">\n" +
            "                        <a href='"+URL+"/goodsDetial/"+item.goodsId+"'><img src='"+URL+"/img/" + item.mainImg + "'></a> \n" +
            "                    </div>\n" +
            "                    <div class=\"caption\">\n" +
            "                        <h3 style='color: lightpink'>￥<span class='goodsMoney'>"+ item.goodsPrice +"</span>  </h3>\n" +
            "                        <p style='color: orange'>" + item.goodsName + "</p>\n" +
            "                        <p>卖家：" + item.ownUser.userName + "</p>\n" +
            "                        <p>\n" +
            "                            <a class=\"btn btn-primary buy\" role=\"button\" href='"+URL+"/addOrder/"+sessionUserId+"/"+item.goodsPrice.toString()+"/"+item.goodsId+"'>\n" +
            "                                购买\n" +
            "                            </a>\n" +
            "                            <a href='"+URL+"/addGoodsToShoppingCart/"+item.goodsId+"/"+sessionUserId+"' class=\"btn btn-default\" role=\"button\">\n" +
            "                                加入购物车\n" +
            "                            </a>\n" +
            "                        </p>\n" +
            "                    </div>");
    });

}

function page() {
    $("#currentPage").text("当前页数:"+currentPage);
    $.ajax({
        type: "get",
        url: URL + "/getAllGoods",
        dataType: 'json',
        data: {"currentPage": currentPage},
        success
    })
}

$(function () {
    sessionUserId=$("#userId").text();
    page();
    console.log("asdasdasdasd")
    if ($("#logOut").text()=='') $("#logOut").hide();

    /*搜索功能的实现*/
    $("#searchBtn").click(function () {
        console.log("进入了search方法")
        currentPage=1;
        var text=$("#inputText").val();
        console.log(text);
        console.log(currentPage);
        $.ajax({
            type: "get",
            url: URL+"/getGoodsByName",
            dataType: 'json',
            data: {"currentPage":currentPage,"goodsName":text},
            success

        })

    })

});


function reducePage() {
    if (currentPage > 1) {
        currentPage--;
        page();
    }
    else alert("这是第一页哦!")
}

function addPage() {
    console.log(totalPage);
    if (currentPage < totalPage) {
        currentPage++;
        page();
    }
    else alert("已经是最后一页啦!");
}

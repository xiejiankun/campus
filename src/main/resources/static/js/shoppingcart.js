var PathName = window.location.pathname.substring(1);
var ProjectName = PathName.substring(0, PathName.indexOf("/"));
var URL = window.location.protocol + "//" + window.location.host + "/" + ProjectName;
var list;
var totalMoney;
$(function(){
    $(":checkbox").click(function () {
        console.log("进入了循环");
        var count=0;
        totalMoney=0;
        list = new Array();
       $.each($(":checkbox"),function (index,element) {
           var temp=".price:eq("+index+")";
           var goodsId=".goodsId:eq("+index+")";
           console.log($(temp).text());
            if($(element).is(':checked')) {
                list[count]=$(goodsId).text();
                count++;
                totalMoney+=parseInt($(temp).text());
            }
       })
        console.log(count);
        $("#count").text(count);
        console.log(totalMoney);
        console.log(list);
        $("#totalMoney").text(totalMoney);
    });

    $("#shopCarButton").click(function () {
        $.ajax({
            type : "get",
            url : URL + "/addOrder/"+$("#userId").text()+"/"+totalMoney,
            data : {"goodsIdList":list.toString()},
            success(result) {
                alert(result);
            }
        })
    });
});
var PathName = window.location.pathname.substring(1);
var ProjectName = PathName.substring(0, PathName.indexOf("/"));
var URL = window.location.protocol + "//" + window.location.host + "/" + ProjectName;
$(function () {
    var flag1 = false;
    var flag2 = false;

    function judge() {
        if (flag1 && flag2) {
            $('#regbutton').removeAttr("disabled", "disabled");
        } else {
            $('#regbutton').attr("disabled", "disabled");
        }
    }

    $("#userName").blur(function () {
        var userName = $("#userName").val();
        if (userName == "") {
            flag1 = false;
            $('.tips').html("用户名不能为空!");
            judge();
            return;
        }
        $.ajax({
            type: "get",
            url: URL + "/userNameUnique",
            data: {"userName": $("#userName").val()},
            success(result) {
                console.log($('.tips'));
                $('.tips').html(result);
                if (result == "") {
                    flag1 = true;
                } else {
                    flag1 = false;
                }
                judge();
            }

        })
    });

    $("#userPwd").blur(
        function() {
            var userPwd = $("#userPwd").val();
            if (userPwd == "") {
                flag2 = false;
                $('.tips').html("密码不能为空!");
            } else if (userPwd.length < 6) {
                flag2 = false;
                $('.tips').html("密码长度需要>=6!");
            } else {
                flag2 = true;
            }
            judge();
        }
    );
})
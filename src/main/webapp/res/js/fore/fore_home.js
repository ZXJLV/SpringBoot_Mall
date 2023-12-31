var index = 1;
$(function () {
    //主页切换动画
    getTimer();
    var timer = setInterval(getTimer, 3000);
    $(".banner_main > a").attr("href", contextPath + "/product/" + $("#banner1").attr("name"));
    //单击商品分类链接时
    $(".banner_div a").click(function () {
        $(".banner_main").unbind("click");
    });
    //悬浮到分类导航时
    $(".banner_nav>li").hover(function () {
        $(this).find(">a").css("color", "#6347ED");
        var div = $(this).find(">.banner_div").css("display", "block");
        if ($(this).attr("data-status") === "ajaxShow") {
            return;
        }
        $(this).attr("data-status", "ajaxShow");
        let productId = $(this).attr("data-toggle")
        $.ajax({
            type: "GET",
            url: contextPath + "/homeNav",
            data: {"productId": productId},
            dataType: "json",
            success: function (data) {
                if (data != null) {
                    var list = data;
                    console.log(list)

                    for (var i = 0; i < list.length; i++) {
                        if (list[i].length === 0) {
                            continue;
                        }
                        div.append("<div class='hot_word'></div>");
                        var hot_word_div = div.children(".hot_word").last();
                        var productTitle = list[i].productTitle;
                        console.log("productTitle:" + productTitle);
                        var index = productTitle.indexOf(' ');
                        if (index !== -1) {
                            productTitle = productTitle.substring(0, index);
                        }
                        hot_word_div.append("<a href='product/" + list[i].productId + "'>" + productTitle + "</a>");

                    }
                    //热词样式
                    div.find("a").each(function () {
                        var random = parseInt(Math.random() * 10);
                        if (random > 7) {
                            $(this).css("color", "#6347ED");
                        }
                    });
                }
            },
            error: function (data) {

            },
            beforeSend: function () {

            }
        });
    }, function () {
        $(this).find(">a").css("color", "#FFFFFF");
        $(this).find(".banner_div").css("display", "none");
    });
    //搜索框验证
    $('form').submit(function () {
        if ($(this).find("input[name='productName']").val() === "") {
            alert("请输入关键字！");
            return false;
        }
    });
    //悬浮到指定节点时
    $(".banner_slider>li").hover(function () {
        index = parseInt($(this).attr("id").substring($(this).attr("id").indexOf("_") + 1));
        clearInterval(timer);
        getTimer();
    }, function () {
        timer = setInterval(getTimer, 3000);
    });
});

function getTimer() {
    var banner = $(".banner");
    var sliders = $(".banner_slider>li");
    var color;
    var img = $("#banner" + index);
    $(".banner_main > a").attr("href", contextPath + "/product/" + img.attr("name"));
    if (index === 1) {
        color = "#0F1322";
    } else if (index === 2 || index === 5) {
        color = "#E8E8E8";
    } else if (index === 3) {
        color = "#FBB4B0";
    } else if (index === 4) {
        color = "#262C42";
    } else {
        color = "#BD160D";
    }
    sliders.css("background", "rgba(0,0,0,0.4)");
    $("#slider_" + index).css("background", "rgba(255,255,255,0.4)");
    img.stop(true, true).fadeIn(1000);
    banner.stop(true, true).animate({
        "backgroundColor": color
    }, 800);
    img.siblings('img').stop(true, true).fadeOut(1000);
    index++;
    index = index > 6 ? 1 : index;
}
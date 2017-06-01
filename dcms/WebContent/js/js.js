$(function () {
    var i = 0;
    var width = $(".li").width();
    var time;

    function setTime() {
        time = setInterval(function () {
            if (i < 2) {
                i++;
            }
            else {
                i = 0;
            }
            $(".ppt-per").animate({
                "left": -i * width + "px"
            });
            $(".cc").eq(i).addClass("h").siblings(".cc").removeClass("h");
        }, 3000)
    }
    setTime();
    $(".ppt").mouseover(function () {
        clearInterval(time);
    })
    $(".ppt").mouseleave(function () {
            setTime();
        })
        //
    $(".left").click(function () {
        if (i < 2) {
            i++;
        }
        else {
            i = 0;
        }
        $(".ppt-per").animate({
            "left": -i * width + "px"
        });
        $(".cc").eq(i).addClass("h").siblings(".cc").removeClass("h");
    })
    $(".right").click(function () {
        if (i > 0) {
            i--;
        }
        else {
            i = 2;
        }
        $(".ppt-per").animate({
            "left": -i * width + "px"
        });
        $(".cc").eq(i).addClass("h").siblings(".cc").removeClass("h");
    })
    $(".cc").click(function () {
        var index_ = $(this).index();
        i = index_;
        $(".ppt-per").animate({
            "left": -i * width + "px"
        });
        $(".cc").eq(i).addClass("h").siblings(".cc").removeClass("h");
    })
    $(".cc").mouseover(function () {
        var index_ = $(this).index();
        i = index_;
        $(".ppt-per").animate({
            "left": -i * width + "px"
        });
        $(".cc").eq(i).addClass("h").siblings(".cc").removeClass("h");
    })
})
$(function(){
    $(".loginB").click(function(){
//        $(".bg, .login").show(0);
//        $(".bg, .login").css("display", "block");
//        $(".bg, .login").fadeIn();
        $(".bg, .login").fadeIn(1000);//1000ms
        // $(".bg, .login").slideDown();
    })
    
    
    $(".circles").click(function(){
//        $(".bg, .login").hide(0);
//        $(".bg, .login").hide(1000);//1000ms
//        $(".bg, .login").css("display", "none");
//        $(".bg, .login").fadeOut();
        $(".bg, .login").slideUp(1000);        
    })
})
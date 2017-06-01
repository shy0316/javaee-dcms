$("#manage-name-inp").focusout(function(){
    var manageNameInpValue = $("#manage-name-inp").val();
    var manageNameInp = $.trim(manageNameInpValue).length;
    console.log(manageNameInp);
    console.log(manageNameInpValue);
    
    if(manageNameInp>50){
        alert("请您重新输入50字以内的新闻标题");
        $("#manage-name-inp").attr("value","");
    }
});

$("#manage-issuer-inp").focusout(function(){
    var InpValue = $("#manage-issuer-inp").val();
    var Inp = $.trim(InpValue).length;
    console.log(Inp);
    console.log(InpValue);
    
    if(Inp>25){
        alert("请您重新输入25字以内的新闻发布者");
        $("#manage-issuer-inp").attr("value","");
    }
});

$("#manage-content-inp").focusout(function(){
    var InpValue = $("#manage-issuer-inp").val();
    var Inp = $.trim(InpValue).length;
    console.log(Inp);
    console.log(InpValue);
    
    if(Inp>4294967295){
        alert("请您重新输入4294967295(2^32-1)个字以内的新闻内容");
        $("#manage-content-inp").attr("value","");
    }
});
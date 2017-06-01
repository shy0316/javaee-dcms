

$("#manage-noticecontent-info").focusout(function(){
    var Value = $("#manage-noticecontent-info").val();
    var len = $.trim(Value).length;
    console.log(Value);
    console.log(len);
    
    if(len>75){
        alert("请您重新输入75个字以内的公告内容");
        $("#manage-noticecontent-info").attr("value","");
    }
});

$("#ntitle").focusout(function(){
    var Value = $("#ntitle").val();
    var len = $.trim(Value).length;
    console.log(Value);
    console.log(len);
    
    if(len>75){
        alert("请您重新输入75个字以内的公告内容");
        $("#manage-noticecontent-info").attr("value","");
    }
});
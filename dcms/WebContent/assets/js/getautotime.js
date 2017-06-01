function time(){
	var now=new Date();
	var h = now.getFullYear();
	var m = now.getMonth()+1;//月份在js里是从0开始的，所以需要加1
	if(m<10){
		m ="0"+m;
	}
	var s = now.getDate();
	var tt = h+"-"+m+"-"+s;
	return tt;}
	window.onload = function(){
	var input=document.getElementById("time");
	setInterval(function(){
		input.value=time();
	},1000)
}
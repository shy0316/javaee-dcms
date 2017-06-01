var pageSize = 6; //每页显示的记录条数
var curPage = 0; //当前页
var lastPage; //最后页
var direct = 0; //方向
var len; //总行数
var page; //总页数
var begin;
var end;
$(document).ready(
		function display() {
			len = $(".news_con ul li").length; // 求这个表的总行数
			page = len % pageSize == 0 ? len / pageSize : Math.floor(len
					/ pageSize) + 1;//根据记录条数，计算页数
			//floor向下取整函数
			curPage = 1; // 设置当前为第一页
			displayPage(1);//显示第一页
		});
function displayPage() {
	if (curPage <= 1 && direct == -1) {
		direct = 0;
		return;
	}
	lastPage = curPage;
	// 修复当len=1时，curPage计算得0的bug
	if (len > pageSize) {
		curPage = ((curPage + direct + len) % len);
	} else {
		curPage = 1;
	}
	begin = (curPage - 1) * pageSize + 1;// 起始记录号
	end = begin + 1 * pageSize - 1; // 末尾记录号
	if (end > len)
		end = len;
	$(".news_con ul li").hide(); // 首先，设置这行为隐藏
	$(".news_con ul li").each(function(i) { // 然后，通过条件判断决定本行是否恢复显示
		if ((i >= begin && i <= end) || i == 0)//显示begin<=x<=end的记录
			$(this).show();
	});
}
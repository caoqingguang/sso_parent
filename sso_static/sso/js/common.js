//转换服务端返回数据
function convData(data){
	var result={};
	result.total=data.total;
	result.totalPage=data.totalPages;
	result.pageRow=data.rowNum;
	result.rows=data.rows;
	result.pageIndex=data.pageIndex;
	return result;
}

//业务区最大化 扩展easyui
$.extend($.fn.layout.methods, {
	full : function (jq) {
		return jq.each(function () {
			var layout = $(this);
			var center = layout.layout('panel', 'center');
			center.panel('maximize');
			center.parent().css('z-index', 10);

			$(window).on('resize.full', function () {
				layout.layout('unFull').layout('resize');
			});
		});
	},
	unFull : function (jq) {
		return jq.each(function () {
			var center = $(this).layout('panel', 'center');
			center.parent().css('z-index', 'inherit');
			center.panel('restore');
			$(window).off('resize.full');
		});
	}
});
function winFull() {
	$("body").layout("full");
}
function winUnFull() {
	$("body").layout("unFull");
}

$(function(){
	var html="";
	html+='<div id="win-maxmin">';
	html+='	<input id="win-maxmin-btn-min" type="button" class="win-maxmin-btn current" value="min"/>';
	html+='	<input id="win-maxmin-btn-max" type="button" class="win-maxmin-btn" value="max"/>';
	html+='</div>';
	$(html).appendTo($('body'));
	$('#win-maxmin-btn-min').click(function(){
		winUnFull();
		$(".win-maxmin-btn").removeClass('current');
		$(this).addClass('current');
		
	});
	$('#win-maxmin-btn-max').click(function(){
		winFull();
		$(".win-maxmin-btn").removeClass('current');
		$(this).addClass('current');
	});
})

 
$.fn.serializeJson=function(){  
    var serializeObj={};  
    $(this.serializeArray()).each(function(){  
        serializeObj[this.name]=this.value;  
    });  
    return serializeObj;  
};  
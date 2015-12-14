/*
 * Created with MyElipse.
 * Version:				v1.0.0
 * Company：				
 * Author: 				quliu
 * Date: 				2013/07/23
 * Time: 				下午3:49:13
 * 
 * Problem:
 * 不知道为什么采用JS生产的form,请看下面的js,也就是说不是普通的方式,
 * 即使在页面设定了pageEncoding="UTF-8"，以及采用post提交，从页面传过来后还是ISO8859-1这个编码
 */


/**
 * contextPath：项目的ContextPath,必填项
 * className:实现ExcleList接口类的名字,必添项
 * excelName:导出Excel文件的名字,必添项
 * search:查询条件,可选
 * dataFormat:Excle文件中的日期格式，可选，默认是yyyy-MM-dd
 */
function exportExl(contextPath,className,excleName,search,dataFormat)
{
	$("#exportExcelFormId").remove();
	var form = $('<form style="display:none" action="' + contextPath + '/exportExcelControler/exportExcel.html" method="post" name="exportExcelForm" id="exportExcelFormId"></form>');
	$('<input type="hidden" name="className" value="' + className + '" />').appendTo(form);
	$('<input type="hidden" name="excelName" value="' + excleName + '" />').appendTo(form);
	if(undefined != dataFormat && "" != dataFormat)
	{
		$('<input type="hidden" name="dataFormat" value="' + dataFormat + '" />').appendTo(form);
	}
	if(search)
	{
		for(var i in search)
		{
			$('<input type="hidden" name="' + i + '" value="' + search[i] + '" />').appendTo(form);
		}			
	}
	$(form).appendTo("body");
	$("#exportExcelFormId").submit();
}

/**
 * 库存Excle文件导出
*/
function exportExlForStock12(contextPath,positionIds,search)
{
	$("#exportExcelForStockFormId").remove();
	var form = $('<form style="display:none" action="' + contextPath + '/exportExcelForStock/exportExcel.do" method="post" id="exportExcelForStockFormId"></form>');
	$('<input type="hidden" name="positionIds" value="' + positionIds + '" />').appendTo(form);
	if(search)
	{
		for(var i in search)
		{
			$('<input type="hidden" name="' + i + '" value="' + search[i] + '" />').appendTo(form);
		}			
	}
	$(form).appendTo("body");
	$("#exportExcelForStockFormId").submit();
}

/**
 * 库存Excle文件导出
*/
function exportExlForStock(contextPath,positionIds,search)
{
	var href = contextPath + "/exportExcelForStock/exportExcel.do?positionIds="+positionIds;
	if(search)
	{
		for(var i in search)
		{
			href +="&"+ i +"="+search[i];
		}			
	}
	$("#downloadExcel").attr("href",href);
	
	window.open(href,'_blank');
}
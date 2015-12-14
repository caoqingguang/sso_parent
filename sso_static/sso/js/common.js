function convData(data){
	var result={};
	result.total=data.total;
	result.totalPage=data.totalPages;
	result.pageRow=data.rowNum;
	result.rows=data.rows;
	result.pageIndex=data.pageIndex;
	return result;
}
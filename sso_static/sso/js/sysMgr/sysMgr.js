$(function(){
	getList();
})

function getList(){
		$('#list').datagrid({
			url : "/sysMgr/list",
			width : '80%',
			height : '450',
			loadMsg : '数据加载中...',
			rownumbers : true,
			singleSelect : true,
			pagination : true,
			rownumbers : true,//是否显示行号
			sortOrder:'asc',
			sortName:'id',
			loadFilter:convData,
			columns : [[
			 {field : 'id',title : '系统id',width : 100,align : 'center'},
			 {field : 'sysName',title : '系统名称(en)',width : 100,align : 'center'},
			 {field : 'sysChName',title : '系统名称(ch)',width : 100,align : 'center'},
			 {field : 'sysLev',title : '系统等级',width : 100,align : 'center'},
			 {field : 'indexStr',title : '索引',width : 100,align : 'center'},
			 {field : 'defUrl',title : '系统首页',width : 150,align : 'center'},
			 {field : 'aa',title : '操作',width : 250,align : 'center',
				 formatter:function(value,row,index){
					 var html='';
					 html="<input type='button' value='角色列表' onclick=\"goRolePage('"+row.id+"')\"/>";
					 html+='&nbsp;&nbsp;'
					 html+="<input type='button' value='URL列表' onclick=\"goUrlPage('"+row.id+"')\"/>";
					 return html;
				 }
			 }
			] ],
			onLoadError : function(error) {
				alert("系统提示：查询出错");
			},
			onLoadSuccess : function(data) {},
			onDblClickRow : function(rowIndex,rowData) {},
			rowStyler : function(index, row,css) {
			},
			onSelect : function(rowIndex,rowData) {
			}
		})
}
function search(flag){
	var data=$('#'+flag).serializeJson();
	$('#list').datagrid('reload',data);
}


function goRolePage(id){
	var url="/roleMgr?sysId="+id;
	window.open(url,'_self');
}

function goUrlPage(id){
	var url="/urlMgr?sysId="+id;
	window.open(url,'_self');
}




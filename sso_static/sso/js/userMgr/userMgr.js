$(function(){
	getList();
})

function getList(){
		$('#list').datagrid({
			url : "/userMgr/list",
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
			 {field : 'userName',title : '用户名称',width : 150,align : 'center'},
			 {field : 'email',title : '邮箱',width : 100,align : 'center'},
			 {field : 'phone',title : '手机',width : 100,align : 'center'},
			 {field : 'resetHint',title : '忘记密码 时 重置信息',width : 130,align : 'center'},
			 {field : 'deleted',title : '状态',width : 100,align : 'center'},
			 {field : 'aa',title : '操作',width : 150,align : 'center',
				 formatter:function(value,row,index){
					 var html='';
					 html="<input type='button' value='编辑' onclick=\"showEditUser('save','"+row.id+"')\"/>";
					 html+='&nbsp;&nbsp;'
					 html+="<input type='button' value='角色' onclick=\"modUserRole('"+row.id+"')\"/>";
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

function modUserRole(id){
	$('#dlg-modUserRole').dialog('open');
}
function showEditUser(doflag,id){
	$('#dlg-editUser').dialog('open');
}




$(function(){
	getList();
})

function getList(){
		$('#list').datagrid({
			url : "/roleMgr/list",
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
			 {field : 'id',title : '角色id',width : 100,align : 'center'},
			 {field : 'roleName',title : '角色名称',width : 100,align : 'center'},
			 {field : 'roleDefUrl',title : '默认主页',width : 200,align : 'center'},
			 {field : 'sysChName',title : '系统名称',width : 150,align : 'center'},
			 {field : 'deleted',title : '状态',width : 200,align : 'center'},
			 {field : 'aa',title : '操作',width : 150,align : 'center',
				 formatter:function(value,row,index){
					 var html='';
					 html="<input type='button' value='编辑' onclick=\"showEditUser('save','"+row.id+"')\"/>";
					 html+='&nbsp;&nbsp;'
					 html+="<input type='button' value='权限' onclick=\"modUserRole('"+row.id+"')\"/>";
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
function modUserRole(id){
	$('#dlg-modUserRole').dialog('open');
}
function showNewUser(flag){
	$('#'+flag+'-form')[0].reset();
	$('#dlg-'+flag).dialog('open');
}
function newUser(flag){
	var data=$('#'+flag+'-form').serialize();
	$.ajax({
		url:"/userMgr/newUser",
		type:"POST",
		data:data,
		success:function(data){
			if(data.code=='success'){
				$('#list').datagrid('reload');
				$('#dlg-'+flag).dialog('close');
			}else{
				alert(data.message);
			}
			return false;
		},
		error:function(jpXHR,textStatus,errorThrown){
			alert("系统正忙...");
			return false;
		}
	});
}




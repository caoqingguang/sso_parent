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
			 {field : 'id',title : '用户id',width : 100,align : 'center'},
			 {field : 'userName',title : '用户名称',width : 100,align : 'center'},
			 {field : 'email',title : '邮箱',width : 200,align : 'center'},
			 {field : 'phone',title : '手机',width : 150,align : 'center'},
			 {field : 'deleted',title : '状态',width : 200,align : 'center'},
			 {field : 'aa',title : '操作',width : 180,align : 'center',
				 formatter:function(value,row,index){
					 var html='';
					 html="<input type='button' value='编辑' onclick=\"showEditUser('save','"+row.id+"')\"/>";
					 html+='&nbsp;';
					 html+="<input type='button' value='角色' onclick=\"modUserRole('"+row.id+"')\"/>";
					 html+='&nbsp;';
					 html+="<input type='button' value='删除' onclick=\"rmvUser('"+row.id+"')\"/>";
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
	data.page=1;
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

function rmvUser(id){
	alert("删除用户"+id);
}




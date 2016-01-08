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
			{field : 'deleted',title : '状态',width : 200,align : 'center',
				 formatter:function(value,row,index){
					 if(value==2){
						 return "正常使用";
					 }else{
						 return "已经禁用";
					 }
				 }
			 },
			 {field : 'aa',title : '操作',width : 200,align : 'center',
				 formatter:function(value,row,index){
					 var html='';
					 html="<input type='button' value='编辑' onclick=\"showSaveRole('"+row.id+"','"+row.roleName+"','"+row.roleDefUrl+"','"+row.sysChName+"')\"/>";
					 html+='&nbsp;'
					 html+="<input type='button' value='权限' onclick=\"showRoleUrl('"+row.id+"','"+row.roleName+"')\"/>";
					 html+='&nbsp;';
					 if(row.deleted==2){
						 html+="<input type='button' value='删除' onclick=\"rmvRole('"+row.id+"')\"/>";
					 }
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

var zTree={};
function showRoleUrl(id,name){
	$('#tree-id').val(id);
	$('#tree-roleName').val(name);
	var setting = {
			view: {
				dblClickExpand: true,
				showIcon: true
			},
			check: {
				enable: true
			},
			data: {
				simpleData: {
					enable: true
				}
			}
	};
	$.ajax({
		url:"/roleMgr/tree",
		type:"POST",
		data:{id:id},
		dataType:"json",
		success:function(data){
			if(data.code=='success'){
				var result=data.data;
				zTree=$.fn.zTree.init($("#tree-tree"), setting, result);
				$('#dlg-tree').dialog('open');
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

function saveRoleUrl(){
	
	var nodes=zTree.getCheckedNodes(true);
	var ids=[];
	for(var i in nodes){
		ids.push(nodes[i].noteInfo.id);
	}
	var ids=ids.join(',');
	var id=$('#tree-id').val();
	var data={id:id,ids:ids};
	$.ajax({
		url:"/roleMgr/modRoleUrl",
		type:"POST",
		data:data,
		dataType:"json",
		success:function(data){
			if(data.code=='success'){
				$('#dlg-tree').dialog('close');
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

function showNewRole(flag){
	$('#'+flag+'-form')[0].reset();
	$('#dlg-'+flag).dialog('open');
}
function newRole(flag){
	var data=$('#'+flag+'-form').serialize();
	$.ajax({
		url:"/roleMgr/newRole",
		type:"POST",
		data:data,
		dataType:'json',
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

function showSaveRole(id,roleName,roleDefUrl,sysChName){
	$('#modUserRole-form')[0].reset();
	$('#modUserRole-id').val(id);
	$('#modUserRole-roleName').val(roleName);
	$('#modUserRole-roleDefUrl').val(roleDefUrl);
	$('#modUserRole-sysChName').val(sysChName);
	$('#dlg-modUserRole').dialog('open');
}
function saveRole(){
	var flag='modUserRole';
	var data=$('#'+flag+'-form').serialize();
	$.ajax({
		url:"/roleMgr/modRole",
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

function rmvRole(id){
	var data={id:id};
	$.ajax({
		url:"/roleMgr/rmvRole",
		type:"POST",
		data:data,
		success:function(data){
			if(data.code=='success'){
				$('#list').datagrid('reload');
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




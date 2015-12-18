$(function(){
	getList();
})

function getList(){
		$('#list').datagrid({
			url : "/urlMgr/list",
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
			 {field : 'id',title : 'id',width : 100,align : 'center'},
			 {field : 'urlName',title : '名称',width : 100,align : 'center'},
			 {field : 'indexStr',title : '索引',width : 100,align : 'center'},
			 {field : 'url',title : '访问路径',width : 200,align : 'center'},
			 {field : 'urlLev',title : '等级',width : 50,align : 'center'},
			 {field : 'sysId',title : '系统名称',width : 80,align : 'center',
				 formatter:function(value,row,index){
					 return sysDic[value];
				 }
			 },
			 {field : 'aa',title : '操作',width : 220,align : 'center',
				 formatter:function(value,row,index){
					 var html='';
					 html="<input type='button' value='编辑' onclick=\"showEditUrl('save','"+row.id+"')\"/>";
					 html+='&nbsp;'
					 html+="<input type='button' value='进入' onclick=\"childURL('"+row.id+"','"+row.urlName+"')\"/>";
					 html+='&nbsp;';
					 if(row.pid>0){
						 html+="<input type='button' value='返回' onclick=\"parentURL0()\"/>";
					 }else{
						 html+="<input type='button' value='返回' disabled='disabled'/>";
					 }	 
					 html+='&nbsp;'
					 html+="<input type='button' value='删除' onclick=\"rmvURL('"+row.id+"')\"/>";
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
function showNewURL(flag){
	$('#'+flag+'-form')[0].reset();
	var parent=$('#parent').val()
	$('#'+flag+'-parent').val(parent);
	var pid=$('#pid').val()
	$('#'+flag+'-pid').val(pid);
	$('#dlg-'+flag).dialog('open');
}
function newURL(flag){
	var data=$('#'+flag+'-form').serialize();
	$.ajax({
		url:"/urlMgr/newURL",
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

function rmvURL(id){
	$.ajax({
		url:"/urlMgr/rmvURL",
		type:"POST",
		data:{id:id},
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
function childURL(id,urlName){
	setPidAndName(id,urlName);
	search('search-form');
}
function parentURL(pid){
	setPidAndName(pid,"");
	search('search-form');
}
function parentURL0(){
	var id=$('#pid').val();
	if(id==0){
		parentURL(id);
		search('search-form');
		return ;
	}
	$.ajax({
		url:"/urlMgr/getURL",
		type:"POST",
		data:{id:id},
		success:function(data){
			if(data.code=='success'){
				setPidAndName(data.data.pid,data.data.urlName);
				search('search-form');
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

function setPidAndName(pid,name){
	$('#pid').val(pid);
	if(pid==0){
		$('#parent').val("");
		return;
	}
	if(name!==""){
		$('#parent').val(name);
		return ;
	}
	$.ajax({
		url:"/urlMgr/getURL",
		type:"POST",
		data:{id:pid},
		success:function(data){
			if(data.code=='success'){
				$('#parent').val(data.data.urlName);
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



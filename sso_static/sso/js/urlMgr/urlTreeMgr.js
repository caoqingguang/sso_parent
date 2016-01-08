$(function(){
	setBtnCan(false,false);
	loadTree('urlTree');
})

var TreeUtil=function(){
	var zTree={};
	var nodeNow={};
	function rightClick(event, treeId, treeNode) {
		nodeNow=treeNode;
		zTree.selectNode(treeNode);
		if (!treeNode && event.target.tagName.toLowerCase() != "button" && $(event.target).parents("a").length == 0) {
			zTree.cancelSelectedNode();
		} else {
			if(treeNode.noteType=="sys"){
				showRMenu(true,false,false,event.clientX,event.clientY);
			}else if(treeNode.noteType=="url"){
				showRMenu(true,true,true,event.clientX,event.clientY);
			}else{
				showRMenu(false,false,false,event.clientX,event.clientY);
			}
		}
	}
	function leftClick(event, treeId, treeNode) {
		nodeNow=treeNode;
		showModTreeNode(treeNode);	
	};
	//菜单show
	function menuShow(menuId, posLeft, posTop){
		var pos={};
		if(posLeft) pos.left=posLeft+'px';
		if(posTop) pos.top=posTop+'px';
		$("#"+menuId).menu('show',pos);
	}

	//菜单项disable
	function menuBtnDis(menuId,menuBtnId){
		var menuBtn = $("#"+menuBtnId)[0];
		$("#"+menuBtnId).menu("disableItem",menuBtn);
	}

	//菜单项enable
	function menuBtnEn(menuId,menuBtnId){
		var menuBtn = $("#"+menuBtnId)[0];
		$("#"+menuBtnId).menu("enableItem",menuBtn);
	}

	//菜单显示
	function showRMenu(addflag,modflag,delflag, x, y) {
		addflag? menuBtnEn("menu","add"):menuBtnDis("menu","add");
		modflag? menuBtnEn("menu","mod"):menuBtnDis("menu","mod");
		modflag? menuBtnEn("menu","del"):menuBtnDis("menu","del");
		menuShow("menu", x, y );
	}
	function setTree(tree){
		zTree=tree;
	}
	function getTree(){
		return zTree;
	}
	function setNode(node){
		nodeNow=node;
	}
	function getNode(){
		return nodeNow;
	}
	return {leftClick:leftClick,rightClick:rightClick,setTree:setTree,getTree:getTree,getNode:getNode};
}();



var setting = {
		view: {
			dblClickExpand: true,
			showIcon: true
		},
		check: {
			enable: false
		},
		callback: {
			onRightClick: TreeUtil.rightClick,
			onClick: TreeUtil.leftClick
		},
		data: {
			simpleData: {
				enable: true
			}
		}
};


//加载树信息
function loadTree(tree){
	$.ajax({
		url:"/urlMgr/tree",
		type:"POST",
		dataType:"json",
		success:function(data){
			if(data.code=='success'){
				var result=data.data;
				TreeUtil.setTree($.fn.zTree.init($("#"+tree), setting, result));
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

//显示新增
function showAddTreeNode(){
	setBtnCan(false,false);
	$('#edit_url')[0].reset();
	var node=TreeUtil.getNode();
	var noteInfo=node.noteInfo;
	if(node.noteType=="url"){
		$('#edit_url_pid').val(noteInfo.id);
		$('#edit_url_indexStr').val(noteInfo.indexStr+"_*");
		$('#edit_url_urlLev').val(noteInfo.urlLev+1);
		$('#edit_url_sysId').val(noteInfo.sysId);
		setBtnCan(true,false);
	}else if(node.noteType=="sys"){
		$('#edit_url_pid').val("0");
		//$('#edit_url_url').val(noteInfo.defUrl);
		$('#edit_url_indexStr').val(noteInfo.indexStr+"_*");
		$('#edit_url_urlLev').val("1");
		$('#edit_url_sysId').val(noteInfo.id);
		setBtnCan(true,false);
	}
}

//删除
function showRemoveTreeNode(){
	var id=TreeUtil.getNode().noteInfo.id;
	$('#edit_url')[0].reset();
	$.ajax({
			url:"/urlMgr/rmvURL",
			type:"POST",
			data:{id:id},
			success:function(data){
				if(data.code=='success'){
					loadTree('urlTree');
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

//显示修改
function showModTreeNode(treeNode){
	setBtnCan(false,false);
	$('#edit_url')[0].reset();
	var node=treeNode||TreeUtil.getNode();
	var noteInfo=node.noteInfo;
	if(node.noteType=="url"){
		$('#edit_url_id').val(noteInfo.id);
		$('#edit_url_pid').val(noteInfo.pid);
		$('#edit_url_urlName').val(noteInfo.urlName);
		$('#edit_url_indexStr').val(noteInfo.indexStr);
		$('#edit_url_urlLev').val(noteInfo.urlLev);
		$('#edit_url_sysId').val(noteInfo.sysId);
		$('#edit_url_sn').val(noteInfo.sn);
		$('#edit_url_url').val(noteInfo.url);
		$('#edit_url_canShow_'+noteInfo.canShow).attr("checked",true);
		setBtnCan(false,true);
	} else if(treeNode.noteType=="sys") {
		setBtnCan(false,false);
	}
	
}

function setBtnCan(btnNew,btnSave){
	if(btnNew){
		$("#edit_url_new").attr("disabled",false);
	}else{
		$("#edit_url_new").attr("disabled","disabled");
	}
	if(btnSave){
		$("#edit_url_save").attr("disabled",false);
	}else{
		$("#edit_url_save").attr("disabled","disabled");
	}
}


//新增
function newURL(){
	var data=$('#edit_url').serialize();
	$.ajax({
		url:"/urlMgr/newURL",
		type:"POST",
		data:data,
		success:function(data){
			if(data.code=='success'){
				loadTree('urlTree');
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
//修改
function saveURL(){
	var data=$('#edit_url').serializeJson();
	$.ajax({
		url:"/urlMgr/modURL",
		type:"POST",
		data:data,
		success:function(data){
			if(data.code=='success'){
				loadTree('urlTree');
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


package sso.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sso.entity.Sys;
import sso.entity.SysRoleUrl;
import sso.entity.SysUrl;
import sso.service.ISysUrlService;
import sso.service.mapper.ISysUrlMapper;
import sso.util.framework.mapper.IBaseMapper;
import sso.util.framework.service.BaseServiceImpl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Component
public class SysUrlServiceImpl extends BaseServiceImpl<SysUrl> implements ISysUrlService{
	
	@Autowired
	private ISysUrlMapper mapper;
	
	@Override
	protected IBaseMapper<SysUrl> getMapper() {
		return this.mapper;
	}

	public SysUrl selectSysUrlByPid(Long pid) {
		// TODO Auto-generated method stub
		SysUrl url=new SysUrl();
		url.setPid(pid);
		return this.selectObj(url);
	}

	public JSONArray selectSysUrlTree(List<Sys> sysList) {
		JSONArray tree=new JSONArray();
		for(Sys sys : sysList){
			Sys tmp=new Sys();
			tmp.setId(sys.getId());
			tmp.setDefUrl(sys.getDefUrl());
			tmp.setSysChName(sys.getSysChName());
			tmp.setIndexStr(sys.getIndexStr());
			this.selectSysUrlTree(tree,tmp,true);
		}
		return tree;
	}
	
	public JSONArray selectSysUrlTreeWithSelect(Long sysId,Long roleId,boolean open){
		List<Long> allChecked=this.mapper.selectSysUrlIdByRoleId(roleId);
		Set<Long> ids=new HashSet<Long>(allChecked);
		JSONArray tree=new JSONArray();
		SysUrl sysUrl=new SysUrl();
		sysUrl.setSysId(sysId);
		List<SysUrl> urlList=this.mapper.selectSysUrlList(sysUrl);
		for(SysUrl url:urlList){
			JSONObject one=new JSONObject();
			one.put("id", url.getId());
			if(url.getUrlLev()<2){
				one.put("pId",url.getSysId());
			}else{
				one.put("pId", url.getPid());
			}
			one.put("name", url.getUrlName());
			one.put("noteInfo", url);
			one.put("noteType", "url");
			one.put("open", open);
			if(ids.contains(url.getId())){
				one.put("checked", true);
			}
			tree.add(one);
		}
		return tree;
	}
	
	private void selectSysUrlTree(JSONArray tree,Sys sys,boolean open){
		JSONObject parent=new JSONObject();
		parent.clear();
		parent.put("id", sys.getId());
		parent.put("pId","0");
		parent.put("name", sys.getSysChName());
		parent.put("noteInfo", sys);
		parent.put("noteType", "sys");
		parent.put("open", open);
		tree.add(parent);
		SysUrl sysUrl=new SysUrl();
		sysUrl.setSysId(sys.getId());
		List<SysUrl> urlList=this.mapper.selectSysUrlList(sysUrl);
		for(SysUrl url:urlList){
			JSONObject one=new JSONObject();
			one.put("id", url.getId());
			if(url.getUrlLev()<2){
				one.put("pId",url.getSysId());
			}else{
				one.put("pId", url.getPid());
			}
			one.put("name", url.getUrlName());
			one.put("noteInfo", url);
			one.put("noteType", "url");
			one.put("open", open);
			tree.add(one);
		}
		
	}
	
	public void updateRoleUrl(Long roleId,Long[] ids){
		this.mapper.deleteSysRoleUrlByRoleId(roleId);
		if(ids!=null&&ids.length>0){
			for(Long urlId:ids){
				SysRoleUrl sru=new SysRoleUrl();
				sru.setRoleId(roleId);
				sru.setUrlId(urlId);
				this.mapper.insertSysRoleUrl(sru);
			}
		}
	}
	
	
}

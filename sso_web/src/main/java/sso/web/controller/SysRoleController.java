package sso.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sso.entity.Sys;
import sso.entity.SysRole;
import sso.entity.enums.DeletedEnum;
import sso.service.ISysRoleService;
import sso.service.ISysService;
import sso.service.ISysUrlService;
import sso.util.msg.JsonMsg;
import sso.util.pager.PageForm;

@RequestMapping("roleMgr")
@Controller
public class SysRoleController {
	
	@Autowired
	private ISysRoleService roleService;
	@Autowired
	private ISysService sysService;
	@Autowired
	private ISysUrlService urlService;
	
	@RequestMapping("")
	public String index(Model model,Long sysId){
		if(sysId==null){
			sysId=0l;
		}
		model.addAttribute("sysId", sysId);
		model.addAttribute("sysList", sysService.selectObjList(null,null));
		return "roleMgr/index";
	}
	
	@RequestMapping("list")
	@ResponseBody
	public Object list(@ModelAttribute PageForm pager,@ModelAttribute SysRole role){
		return this.roleService.queryPager(pager.genRequest(), role,null);
	}
	
	@RequestMapping("newRole")
	@ResponseBody
	public Object newRole(@ModelAttribute SysRole role,@RequestParam("sysId")Long sysId){
		JsonMsg msg=JsonMsg.newSuccess("成功添加用户");
		Sys sys=this.sysService.selectObjById(sysId);
		if(sys==null){
			return msg.setError("sysId="+sysId+",系统不存在");
		}
		role.setSysChName(sys.getSysChName());
		this.roleService.insertObj(role);
		return msg;
	}
	
	@RequestMapping("modRole")
	@ResponseBody
	public Object modRole(@ModelAttribute SysRole role,@RequestParam("id")Long id){
		JsonMsg msg=JsonMsg.newSuccess("成功添加用户");
		SysRole role2=new SysRole();
		role2.setId(id);
		role2.setRoleName(role.getRoleName());
		role2.setRoleDefUrl(role.getRoleDefUrl());
		role2.setSysChName(role.getSysChName());
		this.roleService.updateObjById(role2);
		return msg;
	}
	@RequestMapping("rmvRole")
	@ResponseBody
	public Object rmvRole(@RequestParam("id")Long id){
		JsonMsg msg=JsonMsg.newSuccess("成功添加用户");
		SysRole role=roleService.selectObjById(id);
		if(role==null){
			return msg.setError("不存在这个角色,id="+id);
		}
		SysRole role2=new SysRole();
		role2.setId(id);
		role2.setDeleted(DeletedEnum.DELETED.getValue());
		this.roleService.updateObjById(role2);
		return msg;
	}
	
	@RequestMapping("tree")
	@ResponseBody
	public Object getTree(@RequestParam("id")Long id){
		JsonMsg msg=JsonMsg.newSuccess("成功获取树");
		SysRole role=roleService.selectObjById(id);
		if(role==null){
			return msg.setError("不存在这个角色,id="+id);
		}
		msg.setData(this.urlService.selectSysUrlTreeWithSelect(role.getSysId(),role.getId(), true));
		return msg;
	}
	
	@RequestMapping("modRoleUrl")
	@ResponseBody
	public Object modRoleUrl(@RequestParam("id")Long id,@RequestParam("ids")Long[] ids){
		JsonMsg msg=JsonMsg.newSuccess("成功获取树");
		SysRole role=roleService.selectObjById(id);
		if(role==null){
			return msg.setError("不存在这个角色,id="+id);
		}
		this.urlService.updateRoleUrl(id, ids);
		return msg;
	}
}

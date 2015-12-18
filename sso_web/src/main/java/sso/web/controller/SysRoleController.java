package sso.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sso.entity.SysRole;
import sso.service.ISysRoleService;
import sso.service.ISysService;
import sso.util.pager.PageForm;

@RequestMapping("roleMgr")
@Controller
public class SysRoleController {
	
	@Autowired
	private ISysRoleService roleService;
	@Autowired
	private ISysService sysService;
	
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
}

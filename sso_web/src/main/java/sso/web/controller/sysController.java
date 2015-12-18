package sso.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sso.entity.Sys;
import sso.service.ISysService;
import sso.util.pager.PageForm;

@RequestMapping("sysMgr")
@Controller
public class SysController {
	
	@Autowired
	private ISysService sysService;
	
	@RequestMapping("")
	public String index(){
		return "sysMgr/index";
	}
	
	@RequestMapping("list")
	@ResponseBody
	public Object list(@ModelAttribute PageForm pager,@ModelAttribute Sys sys){
		return this.sysService.queryPager(pager.genRequest(), sys,null);
	}
}

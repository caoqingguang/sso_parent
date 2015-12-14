package sso.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sso.service.IUserService;
import sso.util.pager.PageForm;
import sso.util.pager.PagerRequest;

@RequestMapping("userMgr")
@Controller
public class userController {
	
	@Autowired
	private IUserService userService;
	@RequestMapping("")
	public String index(){
		return "userMgr/index";
	}
	
	@RequestMapping("list")
	@ResponseBody
	public Object list(@ModelAttribute PageForm pager){
		PagerRequest pr=pager.genRequest();
		System.out.println(pr);
		return this.userService.queryUserPager(pr);
	}
	
	
}

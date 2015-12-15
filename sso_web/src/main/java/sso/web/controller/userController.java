package sso.web.controller;


import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sso.entity.User;
import sso.service.IUserService;
import sso.service.mapper.IUserMapper;
import sso.util.msg.JsonMsg;
import sso.util.pager.PageForm;
import sso.util.pager.PagerRequest;

@RequestMapping("userMgr")
@Controller
public class userController {
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	@Autowired
	private IUserService userService;
	@SuppressWarnings("unused")
	@Autowired
	private IUserMapper userMapper;
	
	
	@RequestMapping("")
	public String index(){
		return "userMgr/index";
	}
	
	@RequestMapping("list")
	@ResponseBody
	public Object list(@ModelAttribute PageForm pager,@ModelAttribute User user){
		PagerRequest pr=pager.genRequest();
		System.out.println(pr);
		return this.userService.queryUserPager(pr,user);
	}
	
	@RequestMapping("newUser")
	@ResponseBody
	public Object newUser(@ModelAttribute User user){
		JsonMsg msg=JsonMsg.newSuccess("成功添加用户");
		try{
			user.setCrTime(new Date());
			this.userService.newUser(user);
		} catch(Exception e){
			this.logger.error("新建用户出错,%s",e,user.getUserName());
			msg.setError(e.toString());
		}
		return msg;
	}
	
	
}

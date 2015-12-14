package sso.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sso.entity.User;
import sso.service.mapper.IUserMapper;
import sso.util.pager.PagerHelper;
import sso.util.pager.PagerRequest;

@RequestMapping("test")
@Controller
public class TestController {
	
	@Autowired
	private IUserMapper userMapper;
	@RequestMapping("test")
	public Object test(){
		return "test";
	}
	
	@RequestMapping("count")
	@ResponseBody
	public Object count(){
		return this.userMapper.countAll();
	}
	
	@RequestMapping("select")
	@ResponseBody
	public Object select(Long id){
		return this.userMapper.selectUserById(id);
	}
	
	@RequestMapping("list")
	@ResponseBody
	public Object list(@ModelAttribute PagerRequest pager){
		System.out.println(pager);
		//PagerModel<User> model=pager.genModel(User.class);
		PagerHelper.setPagerRequest(pager);
		this.userMapper.selectUserList();
		return PagerHelper.getPagerResponse(User.class);
	}
	
}

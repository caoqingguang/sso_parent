package sso.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sso.service.mapper.IUserMapper;

@RequestMapping("test")
@Controller
public class TestController {
	
	@Autowired
	private IUserMapper userMapper;
	@RequestMapping("test")
	@ResponseBody
	public Object test(){
		return "123";
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
	
}

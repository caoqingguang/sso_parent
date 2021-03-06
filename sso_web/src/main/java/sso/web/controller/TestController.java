package sso.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sso.service.mapper.ISysMapper;
import sso.service.mapper.IUserMapper;

@RequestMapping("test")
@Controller
public class TestController {
	
	@SuppressWarnings("unused")
	@Autowired
	private RedisTemplate<String, String> jedisTemplate;
	@SuppressWarnings("unused")
	@Autowired
	private IUserMapper userMapper;
	@Autowired
	private ISysMapper sysMapper;
	@RequestMapping("test")
	public Object test(){
		return "test";
	}
	
	@RequestMapping("id")
	@ResponseBody
	public Object count(Long id){
		return this.sysMapper.selectObjById(id);
	}
	
	@RequestMapping("select")
	@ResponseBody
	public Object select(){
		return this.sysMapper.selectObjList(null,null);
	}
	
	
}

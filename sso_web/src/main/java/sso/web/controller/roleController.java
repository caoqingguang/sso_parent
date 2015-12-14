package sso.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("roleMgr")
@Controller
public class roleController {
	
	@RequestMapping("")
	public String index(){
		return "roleMgr/index";
	}
}

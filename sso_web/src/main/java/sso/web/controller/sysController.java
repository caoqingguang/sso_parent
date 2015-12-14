package sso.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("sysMgr")
@Controller
public class sysController {
	
	@RequestMapping("")
	public String index(){
		return "sysMgr/index";
	}
}

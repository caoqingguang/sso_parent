package sso.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("urlMgr")
@Controller
public class urlMgr {
	@RequestMapping("")
	public String index(){
		return "urlMgr/index";
	}

}

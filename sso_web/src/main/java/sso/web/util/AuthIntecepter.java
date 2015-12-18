package sso.web.util;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import sso.entity.Sys;
import sso.entity.User;

public class AuthIntecepter implements HandlerInterceptor{
	
	@Autowired
	private Sys sys;
	@Autowired
	private User user;
	private List<Sys> list=new ArrayList<Sys>();
	{
		for(int i=0;i<10;i++){
			Sys sys=new Sys();
			sys.setId((long)i);
			sys.setSysChName("系统"+i);
			sys.setDefUrl("http://sso.cqg.cn/sysMgr?id="+i);
			list.add(sys);
		}
		
	}

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		return true;
	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if(modelAndView!=null){
			modelAndView.addObject("vko_userName", user);
			modelAndView.addObject("vko_sysList", list);
			modelAndView.addObject("vko_sys_now", sys);
		}
	}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}

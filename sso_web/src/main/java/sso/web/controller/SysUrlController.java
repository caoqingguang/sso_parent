package sso.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sso.entity.SysUrl;
import sso.service.ISysService;
import sso.service.ISysUrlService;
import sso.util.msg.JsonMsg;
import sso.util.pager.PageForm;


@RequestMapping("urlMgr")
@Controller
public class SysUrlController {
	@Autowired
	private ISysUrlService urlService;
	@Autowired
	private ISysService sysService;

	@RequestMapping("")
	public String index(Model model,Long sysId){
		if(sysId==null){
			sysId=0l;
		}
		model.addAttribute("sysId", sysId);
		model.addAttribute("sysList", sysService.selectObjList(null,null));
		return "urlMgr/index";
	}
	
	@RequestMapping("list")
	@ResponseBody
	public Object list(@ModelAttribute PageForm pager,@ModelAttribute SysUrl sysUrl){
		if(sysUrl.getUrl()==""){
			sysUrl.setUrl(null);
		}
		if(sysUrl.getIndexStr()==""){
			sysUrl.setIndexStr(null);
		}
		if(sysUrl.getUrlName()==""){
			sysUrl.setUrlName(null);
		}
		if(sysUrl.getUrl()!=null||sysUrl.getIndexStr()!=null||sysUrl.getUrlName()!=null){
			sysUrl.setPid(null);
		}
		return this.urlService.queryPager(pager.genRequest(), sysUrl,null);
	}
	
	@RequestMapping("getURL")
	@ResponseBody
	public Object getURL(@RequestParam("id")Long id){
		JsonMsg msg=new JsonMsg();
		SysUrl url=this.urlService.selectObjById(id);
		if(url!=null){
			return msg.setSuccess("获取成功").setData(url);
		}
		return msg.setError("不存在对应id"+id);
	}
	
	@RequestMapping("newURL")
	@ResponseBody
	public Object newURL(@ModelAttribute SysUrl sysUrl){
		JsonMsg msg=JsonMsg.newSuccess("新建url成功");
		Long pid=sysUrl.getPid();
		SysUrl parent=this.urlService.selectObjById(pid);
		if(pid==null||parent==null){
			return msg.setError("pid or pid对应的Url 不能为 null");
		}
		if(pid==0){
			if(sysUrl.getSysId()==null){
				return msg.setError("sysId 不能 为 null");
			}
		}else{
			sysUrl.setSysId(parent.getSysId());
		}
		sysUrl.setPids(parent.getPids()+pid+"/");
		sysUrl.setUrlLev(parent.getUrlLev()+1);
		this.urlService.insertObj(sysUrl);
		msg.setData(sysUrl);
		return msg;
	}
	
	@RequestMapping("rmvURL")
	@ResponseBody
	public Object rmvURL(@RequestParam("id")Long id){
		JsonMsg msg=JsonMsg.newSuccess("删除成功");
		this.urlService.deleteObjById(id);
		return msg;
	}

}

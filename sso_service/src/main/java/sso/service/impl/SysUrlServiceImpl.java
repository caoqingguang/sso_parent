package sso.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sso.entity.SysUrl;
import sso.service.ISysUrlService;
import sso.service.mapper.ISysUrlMapper;
import sso.util.framework.mapper.IBaseMapper;
import sso.util.framework.service.BaseServiceImpl;

@Component
public class SysUrlServiceImpl extends BaseServiceImpl<SysUrl> implements ISysUrlService{
	
	@Autowired
	private ISysUrlMapper mapper;

	@Override
	protected IBaseMapper<SysUrl> getMapper() {
		return this.mapper;
	}

	public SysUrl selectSysUrlByPid(Long pid) {
		// TODO Auto-generated method stub
		SysUrl url=new SysUrl();
		url.setPid(pid);
		return this.selectObj(url);
	}
	
	
}

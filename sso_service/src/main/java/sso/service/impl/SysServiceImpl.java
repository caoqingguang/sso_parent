package sso.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sso.entity.Sys;
import sso.service.ISysService;
import sso.service.mapper.ISysMapper;
import sso.util.framework.mapper.IBaseMapper;
import sso.util.framework.service.BaseServiceImpl;

@Component
public class SysServiceImpl extends BaseServiceImpl<Sys> implements ISysService{
	
	@Autowired
	private ISysMapper mapper;

	@Override
	protected IBaseMapper<Sys> getMapper() {
		return this.mapper;
	}

}

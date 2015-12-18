package sso.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sso.entity.SysRole;
import sso.service.ISysRoleService;
import sso.service.mapper.ISysRoleMapper;
import sso.util.framework.mapper.IBaseMapper;
import sso.util.framework.service.BaseServiceImpl;

@Component
public class SysRoleServiceImpl extends BaseServiceImpl<SysRole> implements ISysRoleService{
	
	@Autowired
	private ISysRoleMapper mapper;

	@Override
	protected IBaseMapper<SysRole> getMapper() {
		return this.mapper;
	}

}

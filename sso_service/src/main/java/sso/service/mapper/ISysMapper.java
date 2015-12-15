package sso.service.mapper;

import java.util.List;

import sso.entity.Sys;
import sso.entity.User;

public interface ISysMapper {
	int countAll();
	Sys selectSysById(Long id);
	List<User> selectSysList(Sys sys);
	

}

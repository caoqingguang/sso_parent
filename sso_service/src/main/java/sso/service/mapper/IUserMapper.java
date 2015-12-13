package sso.service.mapper;

import sso.entity.User;

public interface IUserMapper {
	int countAll();
	User selectUserById(Long id);
}

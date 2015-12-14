package sso.service.mapper;

import java.util.List;

import sso.entity.User;

public interface IUserMapper {
	int countAll();
	User selectUserById(Long id);
	List<User> selectUserList();
}

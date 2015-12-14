package sso.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sso.entity.User;
import sso.service.IUserService;
import sso.service.mapper.IUserMapper;
import sso.util.pager.PagerHelper;
import sso.util.pager.PagerRequest;
import sso.util.pager.PagerResponse;

@Component
public class UserServiceImpl implements IUserService{
	@Autowired
	private IUserMapper userMapper;

	public PagerResponse<User> queryUserPager(PagerRequest request) {
		// TODO Auto-generated method stub
		PagerHelper.setPagerRequest(request);
		this.userMapper.selectUserList();
		return PagerHelper.getPagerResponse(User.class);
	}

}

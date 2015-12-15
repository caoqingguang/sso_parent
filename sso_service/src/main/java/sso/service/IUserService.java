package sso.service;

import sso.entity.User;
import sso.service.remote.IUserServiceRemote;
import sso.util.pager.PagerRequest;
import sso.util.pager.PagerResponse;


public interface IUserService extends IUserServiceRemote{
	
	PagerResponse<User> queryUserPager(PagerRequest request,User user);
	void newUser(User user);

}

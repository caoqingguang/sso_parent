package sso.util.framework.service;

import sso.util.framework.entity.SupperBaseEntity;
import sso.util.pager.PagerRequest;
import sso.util.pager.PagerResponse;

public interface IBaseService<T extends SupperBaseEntity> extends ISupperBaseService<T>{
	PagerResponse<T> queryPager(PagerRequest request,T entity,Object anyObj);
}

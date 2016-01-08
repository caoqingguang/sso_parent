package sso.util.framework.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import sso.util.framework.entity.SupperBaseEntity;
import sso.util.pager.PagerRequest;
import sso.util.pager.PagerResponse;

public interface IBaseService<T extends SupperBaseEntity>{
	void insertObj(T obj);
	void deleteObjById(Long id);
	void updateObjById(T obj);
	T selectObjById(Long id);
	T selectObj(T obj);
	List<T> selectObjList(@Param("args")T obj,@Param("argsEx")Object anyObj);
	PagerResponse<T> queryPager(PagerRequest request,T entity,Object anyObj);
}

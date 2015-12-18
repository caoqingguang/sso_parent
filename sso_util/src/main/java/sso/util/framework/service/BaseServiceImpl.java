package sso.util.framework.service;

import java.util.List;

import sso.util.framework.entity.SupperBaseEntity;
import sso.util.framework.mapper.IBaseMapper;
import sso.util.pager.PagerHelper;
import sso.util.pager.PagerRequest;
import sso.util.pager.PagerResponse;

public abstract class BaseServiceImpl<T extends SupperBaseEntity> implements IBaseService<T>{
	
	protected abstract IBaseMapper<T> getMapper();
	@Override
	public void insertObj(T obj) {
		this.getMapper().insertObj(obj);
	}

	@Override
	public void deleteObjById(Long id) {
		this.getMapper().deleteObjById(id);
	}

	@Override
	public void updateObjById(T obj) {
		this.getMapper().updateObjById(obj);
	}

	@Override
	public T selectObjById(Long id) {
		return this.getMapper().selectObjById(id);
	}
	
	@Override
	public T selectObj(T obj) {
		return this.getMapper().selectObj(obj);
	}

	@Override
	public List<T> selectObjList(T obj,Object anyObj) {
		return this.getMapper().selectObjList(obj,anyObj);
	}

	@SuppressWarnings("unchecked")
	@Override
	public PagerResponse<T> queryPager(PagerRequest request, T entity,Object anyObj) {
		PagerHelper.setPagerRequest(request);
		this.getMapper().selectObjList(entity,anyObj);
		return (PagerResponse<T>) PagerHelper.getPagerResponse(entity.getClass());
	}
	
}

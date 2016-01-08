package sso.util.framework.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import sso.util.framework.entity.SupperBaseEntity;

public interface IBaseMapper<T extends SupperBaseEntity>{
	void insertObj(T obj);
	void deleteObjById(Long id);
	void updateObjById(T obj);
	T selectObjById(Long id);
	T selectObj(T obj);
	List<T> selectObjList(@Param("args")T obj,@Param("argsEx")Object anyObj);
}

package sso.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import sso.entity.SysRoleUrl;
import sso.entity.SysUrl;
import sso.util.framework.mapper.IBaseMapper;

public interface ISysUrlMapper extends IBaseMapper<SysUrl>{

	List<SysUrl> selectSysUrlList(@Param("args")SysUrl url);
	List<Long> selectSysUrlIdByRoleId(Long id);
	void insertSysRoleUrl(SysRoleUrl sru);
	void deleteSysRoleUrlByRoleId(Long id);
}

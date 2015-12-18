package sso.entity.base;

@SuppressWarnings("serial")
public class SysUrlBase extends BaseEntity{
	  private String urlName;
	  private String indexStr;
	  private String url;
	  private Integer urlLev;
	  private Long pid;
	  private String pids;
	  private Integer hasChild;
	  private Integer canShow;
	  private Long sysId;
	  private Integer sn;
	
	public Integer getCanShow() {
		return canShow;
	}
	public void setCanShow(Integer canShow) {
		this.canShow = canShow;
	}
	public Integer getHasChild() {
		return hasChild;
	}
	public void setHasChild(Integer hasChild) {
		this.hasChild = hasChild;
	}
	public String getUrlName() {
		return urlName;
	}
	public void setUrlName(String urlName) {
		this.urlName = urlName;
	}
	public String getIndexStr() {
		return indexStr;
	}
	public void setIndexStr(String indexStr) {
		this.indexStr = indexStr;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getUrlLev() {
		return urlLev;
	}
	public void setUrlLev(Integer urlLev) {
		this.urlLev = urlLev;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getPids() {
		return pids;
	}
	public void setPids(String pids) {
		this.pids = pids;
	}
	public Long getSysId() {
		return sysId;
	}
	public void setSysId(Long sysId) {
		this.sysId = sysId;
	}
	public Integer getSn() {
		return sn;
	}
	public void setSn(Integer sn) {
		this.sn = sn;
	}
	  
}

package sso.entity.base;

import java.util.Date;

@SuppressWarnings("serial")
public class UserBase extends BaseEntity{
	private String userName;
	private String passWord;
	private String token;
	private String info;
	private String resetHint;
	private String resetPw;
	private String email;
	private String phone;
	private Date crTime;
	private Integer deleted;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getResetHint() {
		return resetHint;
	}
	public void setResetHint(String resetHint) {
		this.resetHint = resetHint;
	}
	public String getResetPw() {
		return resetPw;
	}
	public void setResetPw(String resetPw) {
		this.resetPw = resetPw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getCrTime() {
		return crTime;
	}
	public void setCrTime(Date crTime) {
		this.crTime = crTime;
	}
	public Integer getDeleted() {
		return deleted;
	}
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}
	
}

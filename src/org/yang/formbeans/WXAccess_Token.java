package org.yang.formbeans;

import java.time.LocalDateTime;

/**
 * 微信通过code获取access_token时返回参数集合封装
 * 
 * @author MACHENIKE
 *
 */
public class WXAccess_Token {

	private String access_token = "";
	private int expires_in;
	private String refresh_token = "";
	private String openid = "";
	private String scope = "";
	private String errcode ="";
	private String errmsg = "";
	private LocalDateTime begin_time;
	
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public int getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}
	public String getRefresh_token() {
		return refresh_token;
	}
	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	
	public String getErrcode() {
		return errcode;
	}
	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	public LocalDateTime getBegin_time() {
		return begin_time;
	}
	public void setBegin_time(LocalDateTime begin_time) {
		this.begin_time = begin_time;
	}
	public boolean testAccess_token()
	{
		if(!(this.errcode == null || "".equals(this.errcode))) return false;
		if(LocalDateTime.now().plusSeconds(60*10 - this.expires_in).isBefore(this.begin_time))//access_token处于有效期内
			return !(this.access_token == null || "".equals(this.access_token));
		 return false;
	}
	
	public boolean testOpenid()
	{
		if(!(this.errcode == null || "".equals(this.errcode))) return false;
		return !(this.openid == null || "".equals(this.openid));
		
	}
	
	public boolean testRefresh_token()
	{
		return !(this.refresh_token == null || "".equals(this.refresh_token));
	}
}

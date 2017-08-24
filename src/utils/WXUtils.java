package utils;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.hc.client5.http.impl.sync.CloseableHttpClient;
import org.apache.hc.client5.http.impl.sync.HttpClients;
import org.apache.hc.client5.http.methods.CloseableHttpResponse;
import org.apache.hc.client5.http.methods.HttpGet;
import org.apache.hc.client5.http.methods.HttpPost;
import org.apache.hc.client5.http.ssl.SSLConnectionSocketFactory;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.entity.ContentType;
import org.apache.hc.core5.http.entity.EntityUtils;
import org.apache.hc.core5.http.entity.StringEntity;
import org.apache.hc.core5.ssl.SSLContexts;
import org.apache.hc.core5.ssl.TrustStrategy;
import org.yang.formbeans.WXAccess_Token;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * 微信相关操作,获取access_token,openid等相关数据
 * 创建时间:2017-08-09 11:18:08
 * 最后修改人:杨殊缘
 * 最后修改时间:2017-08-10 09:15:04
 * @author 杨殊缘
 *
 */
public class WXUtils {

	private static CloseableHttpClient httpClient;//发送请求的工具
	private static WXAccess_Token ACCESS_TOKEN;//全局access_token
	private final static String APPID = "wx716bd29326d0d724";//公众号的appid
	private final static String APPSECRET = "a81a5e176bcd9b3d6a3c84094300e362";//公众号密匙
	
	//预处理
	static{
		
		//ssl证书管理器加载
		SSLContext sslcontext = null;
			try {
				sslcontext = SSLContexts.custom().loadTrustMaterial(new TrustStrategy() {
					
					@Override
					public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
						// TODO Auto-generated method stub
						return false;
					}
				}).build();
			} catch (KeyManagementException | NoSuchAlgorithmException | KeyStoreException e) {
				// TODO Auto-generated catch block
				System.err.println("ssl证书加载失败");
			}
		
		//仅允许TLSv1协议,可能出错
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext , new String[]{"TLSv1"},null,SSLConnectionSocketFactory.getDefaultHostnameVerifier());
		
		//构建http客户端
		httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).build();;
	}
	
	/**
	 * 通过微信的code获取access_token参数
	 * @param code 微信发送的一次性code,用于换取access_token
	 * @return 可以使用的access_token参数
	 */
	public static String getAccess_Token(HttpServletRequest request , String code)
	{
		//排除空参数的影响
		if(request == null)
			return null;
		
		HttpSession session = request.getSession(false);
		if(session == null || session.getAttribute("access_token") == null)//需要通过code获取access_token
		{
			WXAccess_Token access_token = getAccess_token(code);
			request.getSession().setAttribute("access_token", access_token);
			return access_token.getAccess_token();
		}
		else//session中存在必要的参数 access_token
		{
			WXAccess_Token access_token = (WXAccess_Token) session.getAttribute("access_token");
			if(access_token.testAccess_token()) return access_token.getAccess_token();
			else//access_token不可使用
			{
				if(access_token.testRefresh_token())//access_token可以通过刷新出来
				{
//					refAccess_token(access_token);//优选
					access_token = getAccess_token(code);
					request.getSession().setAttribute("access_token", access_token);
					return access_token.getAccess_token();
				}
				else//只能通过code换取access_token
				{
					access_token = getAccess_token(code);
					request.getSession().setAttribute("access_token", access_token);
					return access_token.getAccess_token();
				}
			}
		}
	}
	

	/**
	 * 通过微信的code码获取当前对应的会员的openid
	 * @param code 微信发送的一次性code码,用于获取access_token
	 * @return 将跟随access_token同时返回的openid作为返回
	 */
	public static String getOpenId(HttpServletRequest request , String code)
	{
		//排除空参数的影响
		if(request == null)
			return null;
				
		HttpSession session = request.getSession(false);
		if(session == null || session.getAttribute("access_token") == null)//需要通过code获取openid
		{
			WXAccess_Token access_token = getAccess_token(code);
			request.getSession().setAttribute("access_token", access_token);
			return access_token.getOpenid();
		}
		else//session中存在必要的参数 access_token
		{
			WXAccess_Token access_token = (WXAccess_Token) session.getAttribute("access_token");
			if(access_token.testOpenid()) return access_token.getOpenid();
			else//openid不可使用,需要重新获取
			{
				access_token = getAccess_token(code);
				request.getSession().setAttribute("access_token", access_token);
				return access_token.getOpenid();
			}
		}
	}
	
	/**
	 * 通过code直接去获取access_token
	 * 并将获取时间设定在新的access_token中
	 * @param code 获取access_token的依据
	 * @return 将获取操作的返回结果加上时间作为返回对象
	 */
	private static WXAccess_Token getAccess_token(String code) {
		// TODO Auto-generated method stub
		//排除空参数的影响
		if(code == null || "".equals(code)) return null;
		HttpGet get = new HttpGet("https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + APPID + "&secret=" + APPSECRET + "&code="+code+"&grant_type=authorization_code");
		WXAccess_Token access_token = null;
		try {
			do{
				//执行GET请求
				CloseableHttpResponse response = httpClient.execute(get);
				access_token = new ObjectMapper().readValue(EntityUtils.toString(response.getEntity()), WXAccess_Token.class);
				access_token.setBegin_time(LocalDateTime.now());
			}while(access_token != null && access_token.testAccess_token());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return access_token;
	}
	
	/**
	 * 刷新网页授权access_token,两种方式刷新--暂时不用
	 * @param code 换取access_token的凭据
	 * @return 将换取回来的access_token作为返回
	 */
	private static WXAccess_Token refAccess_token(String code) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 获取全局接口调用凭证
	 * @return
	 */
	private static String getGlobalAccess_token()
	{
		//排除空参数
		if(ACCESS_TOKEN != null && ACCESS_TOKEN.testAccess_token())
			return ACCESS_TOKEN.getAccess_token();
		else
		{
			HttpGet get = new HttpGet("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + APPID + "&secret=" + APPSECRET);
			try {
				do{
					//执行GET请求
					CloseableHttpResponse response = httpClient.execute(get);
					ACCESS_TOKEN = new ObjectMapper().readValue(EntityUtils.toString(response.getEntity()), WXAccess_Token.class);
					ACCESS_TOKEN.setBegin_time(LocalDateTime.now());
				}while(!(ACCESS_TOKEN != null && ACCESS_TOKEN.testAccess_token()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return ACCESS_TOKEN.getAccess_token();
		}
	}
	
	/**
	 * 微信信息推送操作
	 * 必要参数openid,信息参数
	 * 可选参数url,miniprogram
	 * @param map 包含必要参数的信息集合
	 * @return 发送信息时是否产生异常状况,正常返回true
	 */
	public static boolean sendOneToOneMsg(Map<String, String> map)
	{
		HttpPost post = new HttpPost("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=" + getGlobalAccess_token());
		
		Map<String, Object> entity = new HashMap<String, Object>();

		entity.put("touser", map.get("openid"));
		entity.put("template_id", "SyiyjF0oW2qXnq8A8rISyMwGUGF-ytcomstfZNqWckQ");
		entity.put("url", map.get("url"));
		entity.put("miniprogram","{'appid':'xiaochengxuappid12345','pagepath':'index?foo=bar'}");
		Map<String, Object> temp = new HashMap<String, Object>();
		Map<String, String> lin01 = new HashMap<String, String>();
		Map<String, String> lin02 = new HashMap<String, String>();
		lin01.put("value", map.get("leaguer"));
		temp.put("leaguer",lin01);
		lin02.put("value", map.get("check_num"));
		temp.put("check_num",lin02);
		
		entity.put("data", temp);
		//加载对应的json数据包--可能出现乱码
		try {
			//执行请求
			post.setEntity(new StringEntity(new ObjectMapper().writeValueAsString(entity), ContentType.APPLICATION_JSON));
			httpClient.execute(post);
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return false;
		}
		
		return true;
	}
	
	/**
	 * 手动创建公众号的菜单
	 * @param entity 包含菜单创建的json包
	 * @return 将创建是否成功作为返回
	 */
	public static boolean createMenu(HttpEntity entity)
	{
		HttpPost post = new HttpPost("https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + getGlobalAccess_token());
		post.setEntity(entity);
		
		try {
			CloseableHttpResponse response = httpClient.execute(post);
			WXAccess_Token access_Token = new ObjectMapper().readValue(EntityUtils.toString(response.getEntity()), WXAccess_Token.class);
			return "0".equals(access_Token.getErrcode());
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 订餐成功后推送微信消息
	 */
	public static void sendMsg(String openid ,String userName,String arriveTime,String auditing){
		String token=getGlobalAccess_token();
		String jsonRespTextMessage = "{\"touser\":\""+openid+"\",\"template_id\":\"EiBUDMI28MVrJh9d0tTYU6GNezrslRs9_ARQsP5cUZ4\", \"data\":{\"user\": {\"value\":\""+userName+"\"},\"date\":{\"value\":\""+arriveTime+"\"}, \"result\": {\"value\":\""+auditing+"\"}}}";
		HttpRequest.sendPost("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+token, jsonRespTextMessage);
		
		}
}

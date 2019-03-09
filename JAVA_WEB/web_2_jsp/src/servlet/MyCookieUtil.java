package servlet;

import javax.servlet.http.Cookie;
/*
 * 作者:Lijianbo
 * 日期:2016年7月12日:下午2:31:59
 * 程序作用:cookie工具类,根据名字得到cookie
**/

public class MyCookieUtil {
	
	/**
	 * 通过指定名称查找指定的cookie
	 */
	public static Cookie getCookieByName(Cookie [] cookies,String name){
		// 如果数组是null
		if(cookies == null){
			return null;
		}else{
			// 循环遍历，目的：和name进行匹配，如果匹配成功，返回当前的cookie
			for (Cookie cookie : cookies) {
				// 获取cookie的名称，和name进行匹配
				if(cookie.getName().equals(name)){
					return cookie;
				}
			}
			return null;
		}
	}
	
}















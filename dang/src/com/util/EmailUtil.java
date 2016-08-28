package com.util;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailUtil {
	public static void sendEmail(String emailAddr,String code){
		SimpleEmail email = new SimpleEmail();
		email.setHostName("imap.163.com");//smtp.sina.cn
		email.setAuthentication("邮箱", "密码");
		email.setCharset("UTF-8");
		try {
			email.addTo(emailAddr);
			email.setFrom("新浪邮箱");//必须和Authentication使用的用户相同，否则失败
			email.setSubject("欢迎注册当当系统,激活邮箱");
			email.setMsg("激活码："+code);
			email.send();
		} catch (EmailException e) {
			e.printStackTrace();
		}
	}
}

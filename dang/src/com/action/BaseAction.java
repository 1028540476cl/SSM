package com.action;

import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

public class BaseAction implements SessionAware, ServletContextAware {
	protected ServletContext sct;
	protected Map<String, Object> session;
	public void setSession(Map<String, Object> session) {
         this.session=session;
	}

	public void setServletContext(ServletContext sct) {
		this.sct=sct;
	}
}

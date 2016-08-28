package com.interceptor;

import java.util.Map;

import org.apache.struts2.ServletActionContext;
import com.util.Constant;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String doIntercept(ActionInvocation invocation) throws Exception {
		Map<String,Object> session = invocation.getInvocationContext().getSession();
		if(session.get(Constant.LOGIN_KEY) == null){
			//��Ŀ���ַ��ȡ��������4����¼�ɹ��󷵻�Ŀ��ҳ��
			String url = ServletActionContext.getRequest().getServletPath();
			String param = ServletActionContext.getRequest().getQueryString();
			session.put(Constant.RET_URL_KEY, url+"?"+param);
			//��λ����½����
			return "login";
		}
		return invocation.invoke();
	}

}

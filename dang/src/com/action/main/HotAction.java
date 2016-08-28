package com.action.main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.dao.imp.MainDaoImp;

public class HotAction {
	private HttpServletRequest request;
	private Integer hotid;//是否为热销图书id
	
	 public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	

	public Integer getHotid() {
		return hotid;
	}

	public void setHotid(Integer hotid) {
		this.hotid = hotid;
	}

	public String execute(){
	    	MainDaoImp bookDao = new MainDaoImp();
	    	List hotlist = bookDao.findHotBook(hotid);
	    	request.setAttribute("hotlist", hotlist);
	    	return "success";
	    }
}

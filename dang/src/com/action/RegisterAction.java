package com.action;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dao.UserDao;
import com.dao.imp.UserDaoImp;
import com.entity.User;
import com.util.MessageDigestUtil;
import com.util.VertifyUtil;
public class RegisterAction extends BaseAction{
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
   public String execute() throws Exception {
		UserDao imp = new UserDaoImp();
        user.setUserIntegral(0);
        user.setEmailVerifyCode(VertifyUtil.genarateEmailCode());
        user.setPassword(MessageDigestUtil.digestByMD5(user.getPassword()));
        String ip=ServletActionContext.getRequest().getRemoteAddr();
        user.setLastLoginIp(ip);
        user.setLastLoginTime(System.currentTimeMillis());
        user.setEmailVerify(false);
       User checkuser = imp.findUser(user.getEmail());
        	if(checkuser!=null){
        		session.put("message", "该邮箱已经注册过");
            	return "500";
        		}
    
        imp.save(user);
        session.put("user", user);
        //EmailUtil.sendEmail(user.getEmail(), user.getEmailVerifyCode());
        
		return "success";
	}
}

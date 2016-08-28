package com.action;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.dao.UserDao;
import com.dao.imp.UserDaoImp;
import com.entity.User;
import com.util.MessageDigestUtil;
public class CheckLoginerAction extends BaseAction{
    private String name;
    private String password;
	private String nickName;
	
    public String execute() throws Exception{
    	UserDao dao=new UserDaoImp();
    	List<User> users=dao.findUserByEmail(name);
    	if(users.size()!=0&&users!=null){
    		String dbEmail=users.get(0).getEmail();
        	String Pwd=MessageDigestUtil.digestByMD5(password);
        	String dbPwd=users.get(0).getPassword();
			nickName=users.get(0).getNickname();
        	if(dbEmail.equals(name)&&Pwd.equals(dbPwd)){
        		User user=users.get(0);
        		user.setLastLoginTime(System.currentTimeMillis());
        		user.setLastLoginIp(ServletActionContext.getRequest().getRemoteAddr());
        		dao.save(user);
        		session.put("user",user);
        		return "success";
        	}
    	}
    	return "fail";
    }
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
    
}

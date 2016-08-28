package com.action;
public class CheckEmailCodeAction extends BaseAction{
    private String code;
    private boolean flag;
    public String execute() {
   	   if(code.equals("aaa")){
   		   flag=true;
   	   }else{
   		   flag=false;
   	   }   	   
//   	   String genarateCode=VertifyUtil.genarateEmailCode();
//   	   if (code.equals("genarateCode")) {
//		      flag = true;
//            User user=(User) session.get("user");
//            user.setEmailVerify(true);s
//            UserDaoImp dao=new UserDaoImp();
//            dao.save(user);//有异常要抛出
//		  } else {
//			flag = false;
//	   }
   	   
    	return "success";
    }
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
    
}

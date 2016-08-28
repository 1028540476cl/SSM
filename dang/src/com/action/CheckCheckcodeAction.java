package com.action;

public class CheckCheckcodeAction extends BaseAction{
	private String number;
	private boolean flag;
   public String execute(){
	   String num=(String) session.get("number");
	   if(number.equals(num)){
		   flag=true;
	   }else{
		   flag=false;
	   }
	   return "success";
   }
public boolean isFlag() {
	return flag;
}
public String getNumber() {
	return number;
}
public void setFlag(boolean flag) {
	this.flag = flag;
}
public void setNumber(String number) {
	this.number = number;
}
   
}

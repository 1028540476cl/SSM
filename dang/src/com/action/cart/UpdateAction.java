package com.action.cart;

import com.action.BaseAction;
import com.action.Cart;
import com.action.CartFactory;

public class UpdateAction extends BaseAction{
	private String numName;
	private int id;
    public String execute() throws Exception{
    	Cart cart =new CartFactory().getSessionCart(session);
    	int num=Integer.parseInt(numName);
    	cart.updateNum(id,num);
    	session.put("cart",cart);
    	return "success";
    }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumName() {
		return numName;
	}
	public void setNumName(String numName) {
		this.numName = numName;
	}
        
}

package com.action.cart;

import com.action.BaseAction;
import com.action.Cart;
import com.action.CartFactory;

public class DelAction extends BaseAction{
	private int id;
    public String execute() throws Exception{
    	Cart cart=(Cart)new CartFactory().getSessionCart(session);
    	cart.deleteCart(id);
    	session.put("cart", cart);
    	return "success";
    }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
    
}

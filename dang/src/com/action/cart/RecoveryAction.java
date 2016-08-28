package com.action.cart;

import com.action.BaseAction;
import com.action.Cart;
import com.action.CartFactory;

public class RecoveryAction extends BaseAction{
	private int id;
    public String execute() throws Exception{
    	Cart cart=(Cart)new CartFactory().getSessionCart(session);
    	cart.recovery(id);
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

package com.action;

import java.util.Map;

import com.action.cart.CartImp;

public class CartFactory {
    public Cart getSessionCart(Map<String,Object> session){
    	Cart cart=(Cart) session.get("cart");
    	if(cart==null){
    		cart=new CartImp();
    		
    	}
    	return cart;
    }
}

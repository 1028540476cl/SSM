package com.action.cart;
import java.util.List;

import com.action.BaseAction;
import com.action.Cart;
import com.action.CartFactory;
import com.action.CartItem;
public class CartAction extends BaseAction{
	
	private List<CartItem> buyList;
	private List<CartItem> delList;
	private double total;
	private double onSale;
	
    public String execute() throws Exception{
    	Cart cart = (Cart) new CartFactory().getSessionCart(session);
		total = cart.totalDangPrice();
		onSale = cart.onSale();
		buyList = cart.getPros(true);
		delList = cart.getPros(false);
		session.put("cart", cart);
		session.put("buyList", buyList);
    	return "success";
    }

	public List<CartItem> getBuyList() {
		return buyList;
	}
	public List<CartItem> getDelList() {
		return delList;
	}
	public double getOnSale() {
		return onSale;
	}
	public double getTotal() {
		return total;
	}
	public void setBuyList(List<CartItem> buyList) {
		this.buyList = buyList;
	}
	public void setDelList(List<CartItem> delList) {
		this.delList = delList;
	}
	public void setOnSale(double onSale) {
		this.onSale = onSale;
	}
	public void setTotal(double total) {
		this.total = total;
	}
}

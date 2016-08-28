package com.action.order;

import java.util.List;

import com.action.BaseAction;
import com.action.CartItem;

public class OrderAction extends BaseAction{
	private double total;
	private List<CartItem> items;
	@SuppressWarnings("unchecked")
	public String execute() {
		items=(List<CartItem>) session.get("buyList");
		
		return "success";
	}
	public List<CartItem> getItems() {
		return items;
	}
	public double getTotal() {
		return total;
	}
	public void setItems(List<CartItem> items) {
		this.items = items;
	}
	public void setTotal(double total) {
		this.total = total;
	}
    	
}

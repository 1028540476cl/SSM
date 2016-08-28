package com.action;

import java.util.List;


public interface Cart {
    public void addCart(int id) throws Exception;
    public void updateNum(int id,int num) throws Exception;
    public void deleteCart(int id) throws Exception;
	public void recovery(int id) throws Exception;
	public double totalDangPrice() throws Exception;
	public double totalFixedPrice() throws Exception;
	public List<CartItem> getPros(boolean buyOrDel)throws Exception;
	public double onSale() throws Exception;
	
}

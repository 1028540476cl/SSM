package com.action;

import com.entity.Product;

public class CartItem {
    private Product product;
    private int num=1;
    private boolean buyOrDel=true;
    
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public boolean isBuyOrDel() {
		return buyOrDel;
	}
	public void setBuyOrDel(boolean buyOrDel) {
		this.buyOrDel = buyOrDel;
	}
    
} 

package com.action.cart;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.action.Cart;
import com.action.CartItem;
import com.dao.ProductDao;
import com.dao.imp.BookDaoImp;
import com.entity.Product;
public class CartImp implements Cart{
    private Map<Integer,CartItem> store=new HashMap<Integer,CartItem>();
	public void addCart(int id) throws Exception{
		ProductDao dao=new BookDaoImp();
    	Product product=dao.findById(id);
        if(store.containsKey(id)){
        	CartItem item=new CartItem();
        	item.setProduct(product);
        	item.setNum(item.getNum()+1);
        	store.put(id, item);
        }else{
        	CartItem item=new CartItem();
        	item.setProduct(product);
        	store.put(id, item);
        }
	}
	public void deleteCart(int id) throws Exception {
		if(store.containsKey(id)){
			CartItem item=new CartItem();
			item=store.get(id);
			item.setBuyOrDel(false);
			item.setNum(0);
			store.put(id, item);
		}
	}
	public List<CartItem> getPros(boolean buyOrDel) throws Exception {
		List<CartItem> delItem = new ArrayList<CartItem>();
		List<CartItem> buyItem = new ArrayList<CartItem>();
		Iterator<CartItem> cartItems = store.values().iterator();
		while (cartItems.hasNext()) {
			CartItem cartItem = new CartItem();
			cartItem = cartItems.next();
			if (cartItem.isBuyOrDel() == true) {
				buyItem.add(cartItem);
			} else {
				delItem.add(cartItem);
			}
		}
		if(buyOrDel==true){
		   return buyItem;
		}else{
			 return delItem;
		}
	}
	
	public void recovery(int id) throws Exception {
		if(store.containsKey(id)){
			CartItem item=store.get(id);
			item.setBuyOrDel(true);
			item.setNum(1);
			store.put(id, item);
		}
		
	}
	public double totalDangPrice() throws Exception {
		double totalDangPrice=0;
		Iterator<Integer> ids=store.keySet().iterator();
		List<Double> perProductTotalDangPrices=new ArrayList<Double>();
		while(ids.hasNext()){
			CartItem item=store.get(ids.next());
			int num=item.getNum();
			double price=item.getProduct().getDangPrice();
			double perProductTotalDangPrice=num*price;
			perProductTotalDangPrices.add(perProductTotalDangPrice);
		}
		for(int i=0;i<perProductTotalDangPrices.size();i++){
			totalDangPrice+=perProductTotalDangPrices.get(i);
		}
		return totalDangPrice;
	}
	public double totalFixedPrice() throws Exception {
		double totalFixedPrice=0;
		Iterator<Integer> ids=store.keySet().iterator();
		List<Double> perProductTotalFixedPrices=new ArrayList<Double>();
		while(ids.hasNext()){
			CartItem item=store.get(ids.next());
			int num=item.getNum();
			double price=item.getProduct().getFixedPrice();
			double perProducttotalFixedPrice=num*price;
			perProductTotalFixedPrices.add(perProducttotalFixedPrice);
		}
		for(int i=0;i<perProductTotalFixedPrices.size();i++){
			totalFixedPrice+=perProductTotalFixedPrices.get(i);
		}
		return totalFixedPrice;
	}
	public void updateNum(int id, int num) throws Exception {
		if(store.containsKey(id)){
			CartItem item=store.get(id);
			item.setNum(num);
			store.put(id, item);
		}
	}
	public double onSale() throws Exception {
		double onSale=totalFixedPrice()-totalDangPrice();
		return onSale;
	}
}

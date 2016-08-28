package com.dao;

import java.util.List;

import com.entity.Product;

public interface ProductDao {
    public Product findById(int id);
    public List<Product> findProductsByCatId(int catId,int begin,int size);
    public List<Product> findProduct(int catId);
    public int getTotalPages(int catId,int size);
    	
}

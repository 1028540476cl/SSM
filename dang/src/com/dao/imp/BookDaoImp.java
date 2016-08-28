package com.dao.imp;

import java.util.List;

import org.hibernate.Query;

import com.dao.ProductDao;
import com.entity.Book;
import com.entity.Product;
import com.dao.BaseDao;

public class BookDaoImp extends BaseDao implements ProductDao {

	public Product findById(int id) {
		return (Product) getSession().get(Book.class, id);
	}

	public List<Product> findProductsByCatId(int catId,int begin,int size) {
		String hql="select book from Book book inner join book.cats c where c.id=:catId";
		Query query=getSession().createQuery(hql);
		query.setParameter("catId", catId);
		query.setFirstResult(begin);
		query.setMaxResults(size);
		return query.list();
	}
    public List<Product> findProduct(int catId){
    	String hql="select book from Book book inner join book.cats c where c.id=:catId";
    	Query query=getSession().createQuery(hql);
    	query.setParameter("catId", catId);
    	return query.list();
    }

	public int getTotalPages(int catId,int size) {
		String hql="select book from Book book inner join book.cats c where c.id=:catId";
    	Query query=getSession().createQuery(hql);
    	query.setParameter("catId", catId);
    	List<Product>pros=query.list();
    	int num=pros.size();
    	int totalPages=0;
    	if(num%size==0){
    		totalPages=num/size;
    	}else{
    		totalPages=num/size+1;
    	}
		return totalPages;
	}
	
    
}

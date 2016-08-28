package com.dao.imp;
import java.util.List;

import org.hibernate.Query;

import com.dao.MainDao;
import com.entity.Book;
import com.entity.Category;
import com.entity.Product;
import com.dao.BaseDao;
public class MainDaoImp extends BaseDao implements MainDao{
	public List<Category> findCategoryByParentId(int pid) {
		String hql="select distinct  c from Category c join fetch c.subCats where c.parentId=:pid";
		Query query=getSession().createQuery(hql);
		query.setParameter("pid", pid);
		List<Category> cats=query.list();
		return cats;
	    }
	public List<Category> findCategoryByPid(int pid){
		String hql="select distinct  c from Category c where c.parentId=:pid";
		Query query=getSession().createQuery(hql);
		query.setParameter("pid", pid);
		return query.list();
	}
	/**
	 * 查看hot分类图书
	 * @param hotid
	 * @return
	 */
	public List<Product> findHotBook(int hotid){
		String hql="select distinct  c from Category c where c.parentId=:pid";
    	Query query=getSession().createQuery(hql);
    	query.setParameter("pid", hotid);
		return query.list();
	}
	
}

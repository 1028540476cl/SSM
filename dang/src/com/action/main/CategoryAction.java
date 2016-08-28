package com.action.main;

import java.util.List;

import com.action.BaseAction;
import com.dao.MainDao;
import com.dao.imp.MainDaoImp;
import com.entity.Category;

public class CategoryAction extends BaseAction {
	private List<Category> cats;
    public String execute(){
    	MainDao dao=new MainDaoImp();
    	cats=dao.findCategoryByParentId(1);
    	return "success";
    }
	public List<Category> getCats() {
		return cats;
	}
	public void setCats(List<Category> cats) {
		this.cats = cats;
	}
    
}

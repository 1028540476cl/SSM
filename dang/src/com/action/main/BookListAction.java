package com.action.main;

import java.util.List;

import com.action.BaseAction;
import com.dao.MainDao;
import com.dao.ProductDao;
import com.dao.imp.BookDaoImp;
import com.dao.imp.MainDaoImp;
import com.entity.Category;
import com.entity.Product;

public class BookListAction extends BaseAction{
	private int id;
	private int pid;
	private List<Category>cats;
	private List<Product> pros;
	private int page=1;
	private int size=5;
    private int num=0;
    private int maxPage=1;
    public String execute(){
    	MainDao mainDao=new MainDaoImp();
    	cats=mainDao.findCategoryByPid(pid);
    	ProductDao dao=new BookDaoImp();
    	int begin=(page-1)*size;
    	pros=dao.findProductsByCatId(id,begin,size);
    	List<Product> pros1=dao.findProduct(pid);
    	num=pros1.size();
    	maxPage=dao.getTotalPages(id, size);
    	return "success";
    }
    
	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getPage() {
		return page;
	}

	public int getSize() {
		return size;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setPros(List<Product> pros) {
		this.pros = pros;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public List<Category> getCats() {
		return cats;
	}
	public int getId() {
		return id;
	}
	public int getPid() {
		return pid;
	}
	public List<Product> getPros() {
		return pros;
	}
	public void setCats(List<Category> cats) {
		this.cats = cats;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
}

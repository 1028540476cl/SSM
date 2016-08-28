package com.dao;

import java.util.List;

import com.entity.Category;

public interface MainDao {
    public List<Category> findCategoryByParentId(int pid);
    public List<Category> findCategoryByPid(int id);	
}

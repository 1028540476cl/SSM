package com.dao;

import java.util.List;

import com.entity.User;

public interface UserDao {
   public void save(User user)throws Exception;
   public List<User> findUserByEmail(String email)throws Exception;
   public User findUser(String email)throws Exception;
}

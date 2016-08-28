package com.dao.imp;
import java.util.List;

import org.hibernate.Query;

import com.dao.UserDao;
import com.entity.User;
import com.dao.BaseDao;
public  class UserDaoImp extends BaseDao implements UserDao{
	public void save(User user) throws Exception {
		getSession().saveOrUpdate(user);
	}

	@SuppressWarnings("unchecked")
	public  List<User> findUserByEmail(String email) throws Exception {
		String hql="from User u where u.email=:email";
		Query query = getSession().createQuery(hql);
		query.setParameter("email", email);
		List<User> users=query.list();
		return users;
	}
	public  User findUser(String email) throws Exception {
		String hql="from User u where u.email=?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, email);
		return (User) query.uniqueResult();
	}
}

package com.dao;
import org.hibernate.Session;

import com.util.*;
public class BaseDao {
    public Session getSession(){
    	return HibernateSessionFactory.getSession();
    }
}

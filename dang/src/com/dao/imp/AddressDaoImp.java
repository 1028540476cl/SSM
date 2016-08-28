package com.dao.imp;

import com.dao.AddressDao;
import com.entity.Address;
import com.dao.BaseDao;

public class AddressDaoImp extends BaseDao implements AddressDao{

	public void save(Address address) throws Exception {
		 getSession().saveOrUpdate(address);		
	}

}

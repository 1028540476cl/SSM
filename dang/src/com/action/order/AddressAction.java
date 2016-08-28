package com.action.order;
import com.dao.AddressDao;
import com.dao.imp.AddressDaoImp;
import com.entity.Address;
public class AddressAction{
	private Address address;
    public String execute() throws Exception{
    	AddressDao dao=new AddressDaoImp();
    	address.setUserId(1);
    	dao.save(address);
    	return "success";
    }
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
    
}

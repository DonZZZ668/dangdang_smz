package com.baizhi.action;

import java.util.List;

import com.baizhi.entity.Address;
import com.baizhi.service.AddressService;
import com.baizhi.service.impl.AddressServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class AddressAction extends ActionSupport{
	private String addressId;
	private List<Address> alist;
	private Address address;
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	
	public List<Address> getAlist() {
		return alist;
	}
	public void setAlist(List<Address> alist) {
		this.alist = alist;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public String selectAddresses(){
		
		AddressService service=new AddressServiceImpl();
		alist=service.queryByUserId();
		if(addressId!=null && !"".equals(addressId) && !addressId.equals(0)){
			address=service.queryByAddressId(addressId);
		}
		return "success";
	}
	
}

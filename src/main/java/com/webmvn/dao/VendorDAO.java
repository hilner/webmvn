package com.webmvn.dao;

import com.webmvn.pojo.Vendor;

public class VendorDAO extends GenericDAO<Vendor>{

	public VendorDAO(){}

	@Override
	public Class<Vendor> getObjectClass() {		
		return Vendor.class;
	}

}

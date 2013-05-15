package com.webmvn.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.webmvn.dao.GenericDAO;
import com.webmvn.dao.VendorDAO;
import com.webmvn.pojo.Vendor;

@SuppressWarnings("serial")
@ManagedBean
@RequestScoped
public class VendorBean extends GenericBean<Vendor> {

	@Override
	public GenericDAO<Vendor> getDAO() {
		return new VendorDAO();
	}

	@Override
	public Vendor getNewObject() {
		return new Vendor();
	}
	
}

package com.webmvn.dao;

import java.util.Date;

import com.webmvn.pojo.Product;

public class ProductDAO extends GenericDAO<Product>{

	public ProductDAO(){}

	@Override
	public Class<Product> getObjectClass() {		
		return Product.class;
	}
	
	@Override
	public void saveOrUpdate(Product object) {
		if(object.getDateOfRegistration() == null){
			object.setDateOfRegistration(new Date());
		} 
		super.saveOrUpdate(object);
	}

}

package com.webmvn.dao;

import java.util.Date;

import com.webmvn.pojo.Product;

public class ProductDAO extends GenericDAO<Product>{

	public ProductDAO(){}

	@Override
	public void saveOrUpdate(Product product) {
		if(product.getDateOfRegistration() == null){
			product.setDateOfRegistration(new Date());
		} 
		super.saveOrUpdate(product);
	}

}

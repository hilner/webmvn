package com.webmvn.dao;

import com.webmvn.pojo.Product;

public class ProductDAO extends GenericDAO<Product>{

	public ProductDAO(){}

	@Override
	public Class<Product> getObjectClass() {		
		return Product.class;
	}

}

package com.webmvn.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.webmvn.dao.GenericDAO;
import com.webmvn.dao.ProductDAO;
import com.webmvn.pojo.Product;

@SuppressWarnings("serial")
@ManagedBean
@RequestScoped
public class ProductBean extends GenericBean<Product> {

	@Override
	public GenericDAO<Product> getDAO() {
		return new ProductDAO();
	}

	@Override
	public Product getNewObject() {
		return new Product();
	}
	
}

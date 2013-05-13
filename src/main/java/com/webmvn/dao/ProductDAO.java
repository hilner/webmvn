package com.webmvn.dao;

import static com.webmvn.util.HibernateUtil.getSession;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;

import com.webmvn.pojo.Product;

public class ProductDAO {

	public ProductDAO(){}
	
	public void saveOrUpdate(Product product){		
		if(product.getDateOfRegistration() == null){
			product.setDateOfRegistration(new Date());
		}
		getSession().saveOrUpdate(product);
	}
	
	public void delete(Product product){
		getSession().delete(product);	
	}
	
	public Product getById(int id){
		Product product = (Product) getSession().get(Product.class, id);
		return product;
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> getAll(){
		Criteria criteria = getSession().createCriteria(Product.class);
	 	return  (List<Product>) criteria.addOrder(Order.asc("id")).list();
	}

}

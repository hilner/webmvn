package com.webmvn.dao;

import static com.webmvn.util.HibernateUtil.getSession;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;

import com.webmvn.pojo.Product;

public abstract class GenericDAO <T extends Serializable>{
	
	public GenericDAO(){}
	
	public abstract Class<T> getObjectClass();
	
	public void saveOrUpdate(T object){				
		getSession().saveOrUpdate(object);
	}
	
	public void delete(T object){
		getSession().delete(object);	
	}
	
	public Product getById(int id){
		Product product = (Product) getSession().get(Product.class, id);
		return product;
	}
	
	@SuppressWarnings("unchecked")
	public List<T> getAll(){
		Criteria criteria = getSession().createCriteria(getObjectClass());
	 	return  (List<T>) criteria.addOrder(Order.asc("id")).list();
	}
	
}

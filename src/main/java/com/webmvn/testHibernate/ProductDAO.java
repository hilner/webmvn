package com.webmvn.testHibernate;

import static com.webmvn.testHibernate.HibernateUtil.getSession;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;

public class ProductDAO {

	public ProductDAO(){}
	
	public void saveOrUpdate(Product produto){
		getSession().beginTransaction();
	 	getSession().saveOrUpdate(produto);
	 	getSession().getTransaction().commit();
	}
	
	public void delete(Product produto){
		getSession().beginTransaction();
	 	getSession().delete(produto);
	 	getSession().getTransaction().commit();
	}
	
	public Product getById(int id){
		Product product = (Product) getSession().get(Product.class, id);
		getSession().getTransaction().commit();
		return product;
	}
	
	public List<Product> getAll(){
		getSession().beginTransaction();
		Criteria criteria = getSession().createCriteria(Product.class);
	 	@SuppressWarnings("unchecked")
		List<Product> lista = (List<Product>) criteria.addOrder(Order.asc("id")).list();
	 	getSession().getTransaction().commit();
	 	return lista;
	}

}

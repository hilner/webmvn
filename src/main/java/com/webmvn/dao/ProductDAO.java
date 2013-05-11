package com.webmvn.dao;

import static com.webmvn.util.HibernateUtil.getSession;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import com.webmvn.pojo.Product;

public class ProductDAO {

	public ProductDAO(){}
	
	public void saveOrUpdate(Product produto){
		Session session = getSession();
		session.saveOrUpdate(produto);
		session.getTransaction().commit();
		session.close();
	}
	
	public void delete(Product produto){
		Session session = getSession();
		session.delete(produto);
		session.getTransaction().commit();		
		session.close();		
	}
	
	public Product getById(int id){
		Session session = getSession();
		Product product = (Product) session.get(Product.class, id);
		session.getTransaction().commit();
		session.close();
		return product;
	}
	
	public List<Product> getAll(){
		Session session = getSession();
		Criteria criteria = session.createCriteria(Product.class);
	 	@SuppressWarnings("unchecked")
		List<Product> lista = (List<Product>) criteria.addOrder(Order.asc("id")).list();
	 	session.getTransaction().commit();
	 	session.close();
	 	return lista;
	}

}

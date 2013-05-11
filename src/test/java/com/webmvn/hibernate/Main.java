package com.webmvn.hibernate;

import static com.webmvn.util.HibernateUtil.getSession;
import java.util.List;

import com.webmvn.dao.ProductDAO;
import com.webmvn.pojo.Product;

public class Main {

	public static void main(String[] args) {		
		//Simple Test Hibernate
		
		ProductDAO productDAO = new ProductDAO();

		//Save
		productDAO.saveOrUpdate(new Product("PRODUCT ONE"));	
		productDAO.saveOrUpdate(new Product("PRODUCT TWO"));

		//List
		List<Product> list1 = productDAO.getAll();
		for (Product product : list1) {
			System.out.println(product);
		}

		//Delete/getById
		productDAO.delete(productDAO.getById(1));		


		//List again
		List<Product> list2 = productDAO.getAll();
		for (Product product : list2) {
			System.out.println(product);
		}
	}

}
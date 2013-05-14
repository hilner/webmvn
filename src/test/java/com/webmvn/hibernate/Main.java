package com.webmvn.hibernate;

import static com.webmvn.util.HibernateUtil.getSession;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.SessionFactory;

import com.webmvn.dao.InvoiceDAO;
import com.webmvn.dao.InvoiceProductDAO;
import com.webmvn.dao.ProductDAO;
import com.webmvn.dao.VendorDAO;
import com.webmvn.pojo.Invoice;
import com.webmvn.pojo.InvoiceProduct;
import com.webmvn.pojo.Product;
import com.webmvn.pojo.Vendor;
import com.webmvn.util.HibernateUtil;

public class Main {

	public static void main(String[] args) {		
		//Simple Test Hibernate
		SessionFactory sf = HibernateUtil.getSessionFactory();
		sf.getCurrentSession().beginTransaction();
		
		//2 products
		Product p = new Product("p1");
		new ProductDAO().saveOrUpdate(p);
		Product p2 = new Product("p2");
		new ProductDAO().saveOrUpdate(p2);
		
		System.out.println(p);
		
		//1 invoice
		Invoice i = new Invoice("111111");
		new InvoiceDAO().saveOrUpdate(i);
		System.out.println(i);
		
		//2 invoice products
		InvoiceProduct ip1= new InvoiceProduct(p, new BigDecimal(10));
		new InvoiceProductDAO().saveOrUpdate(ip1);

		InvoiceProduct ip2 = new InvoiceProduct(p, new BigDecimal(10));
		new InvoiceProductDAO().saveOrUpdate(ip2);
				
		//save invoice in vendor
		//2 vendor for invoice
		Vendor v1 = new Vendor("vendor 1");
		v1.getInvoices().add(i);
		new VendorDAO().saveOrUpdate(v1);
		Vendor v2 = new Vendor("vendor 2");
		v2.getInvoices().add(i);
		new VendorDAO().saveOrUpdate(v2);
				
		
		//save vendor in invoice
		//2 vendor for invoice
		/*Vendor v1 = new Vendor("vendor 1");		
		new VendorDAO().saveOrUpdate(v1);
		Vendor v2 = new Vendor("vendor 2");		
		new VendorDAO().saveOrUpdate(v2);
		i.getVendors().add(v1);
		i.getVendors().add(v2);*/
		
		
		sf.getCurrentSession().getTransaction().commit();
		
		//Criteria test
		sf.getCurrentSession().beginTransaction();
		
		//all products from invoice
		
		//all vendors from invoice
		
		sf.getCurrentSession().getTransaction().commit();		
	}

}
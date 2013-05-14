package com.webmvn.dao;

import com.webmvn.pojo.InvoiceProduct;

public class InvoiceProductDAO extends GenericDAO<InvoiceProduct>{

	public InvoiceProductDAO(){}

	@Override
	public Class<InvoiceProduct> getObjectClass() {		
		return InvoiceProduct.class;
	}

}

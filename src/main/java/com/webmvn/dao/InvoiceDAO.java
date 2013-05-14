package com.webmvn.dao;

import com.webmvn.pojo.Invoice;

public class InvoiceDAO extends GenericDAO<Invoice>{

	public InvoiceDAO(){}

	@Override
	public Class<Invoice> getObjectClass() {		
		return Invoice.class;
	}

}

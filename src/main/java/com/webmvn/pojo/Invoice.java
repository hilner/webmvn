package com.webmvn.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "invoice")
public class Invoice implements GenericPojo{

	//Properties
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String number;
	
	@OneToMany(mappedBy="invoice", cascade=CascadeType.ALL, fetch=FetchType.LAZY)  	
	List<InvoiceProduct> products;
	
	@ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "VENDOR_INVOICE",
    joinColumns = @JoinColumn(name = "ID_INVOICE", referencedColumnName = "ID"),
    inverseJoinColumns = @JoinColumn(name = "ID_VENDOR", referencedColumnName = "ID"))
    private List<Vendor> vendors;
	
	//Constructors
	
	public Invoice(){}
	
	public Invoice(String number){
		this.number = number;
	}
	
	//Getters and Setters
	
	@Override
	public Integer getId() {
		return id;
	}
	
	@Override
	public void setId(Integer id) {		
		this.id = id;
	}
	
	public List<InvoiceProduct> getProducts() {
		return products;
	}

	public void setProducts(List<InvoiceProduct> products) {
		this.products = products;
	}

	public List<Vendor> getVendors() {
		if(vendors==null){
			return new ArrayList<Vendor>();
		}
		return vendors;
	}

	public void setVendors(List<Vendor> vendors) {
		this.vendors = vendors;
	}

	//Methods Override
	

	@Override
	public String toString() {	
		return "Id: " + this.getId() + " number: " + this.getNumber(); 
	}
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Invoice other = (Invoice) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
	
}

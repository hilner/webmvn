package com.webmvn.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "vendor")
public class Vendor implements GenericPojo{

	//Properties
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;

	//Constructors
	
	public Vendor(){}
	
	public Vendor(String name){
		this.name = name;
	}
	
	@ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "VENDOR_INVOICE",
    joinColumns = @JoinColumn(name = "ID_VENDOR", referencedColumnName = "ID"),
    inverseJoinColumns = @JoinColumn(name = "ID_INVOICE", referencedColumnName = "ID"))
    private List<Invoice> invoices;
	
	//Getters and Setters
	
	@Override
	public Integer getId() {
		return id;
	}
	
	@Override
	public void setId(Integer id) {		
		this.id = id;
	}
	
	public List<Invoice> getInvoices() {
		if(invoices == null){
			invoices = new ArrayList<Invoice>();
		}
		return invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}

	//Methods Override
	

	@Override
	public String toString() {	
		return "Id: " + this.getId() + " name: " + this.getName(); 
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		Vendor other = (Vendor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
	
}

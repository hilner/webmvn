package com.webmvn.pojo;

import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table(name = "products")
public class Product implements GenericPojo{

	//Properties
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 50)
	private String name;
	
	@Column(name = "price", precision=25, scale=10)
	private BigDecimal price;
	
	@Column(name = "situation", length=1) //new, good, more or less and broken
	private Byte situation;
	
	private Boolean inactive;
	
	@Lob
	private String observations;			
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_registration", nullable = false, updatable = false)
	private Date dateOfRegistration;
	
	//Constructors
	
	public Product(){}
	
	public Product(String name){
		this.name = name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Byte getSituation() {
		return situation;
	}

	public void setSituation(Byte situation) {
		this.situation = situation;
	}

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	public Boolean getInactive() {
		return inactive;
	}

	public void setInactive(Boolean inactive) {
		this.inactive = inactive;
	}

	public Date getDateOfRegistration() {
		return dateOfRegistration;
	}

	public void setDateOfRegistration(Date dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}

	//Methods Override
	
	@Override
	public String toString() {	
		return "Id: " + this.getId() + " Name: " + this.getName();
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
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
	
}

package com.webmvn.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.webmvn.dao.ProductDAO;
import com.webmvn.pojo.Product;

@ManagedBean
@RequestScoped
public class ProductBean implements Serializable {

	//Properties
	
	private Product selectedRecord = new Product();
	private List<Product> list = null;
	private ProductDAO productDAO = new ProductDAO();
	
	//Constants
	
	private static final long serialVersionUID = 1L;
	private final String LIST_PAGE = "list?faces-redirect=true";
	private final String EDIT_PAGE = "edit"; //don't use redirect for edit with ajax	

	//Contructors
	
	public ProductBean() {
	}

	//Methods
	
	public String insert() {
		this.selectedRecord = new Product();
		return EDIT_PAGE;
	}
	
	public String edit() {
		return EDIT_PAGE;
	}
	
	public String save() {		
		if (selectedRecord.getId() == 0){ //JSF set 0 in null values for default
			selectedRecord.setId(null);
		}
		productDAO.saveOrUpdate(selectedRecord);
		return LIST_PAGE;
	}
	
	public String cancel(){
		return LIST_PAGE;
	}

	public String delete() {
		productDAO.delete(selectedRecord);	
		return LIST_PAGE;
	}
	
	//Getters and Setters

	public Product getSelectedRecord() {
		return selectedRecord;
	}

	public void setSelectedRecord(Product selectedRecord) {
		this.selectedRecord = selectedRecord;
	}

	public List<Product> getList() {
		if(list == null){
			list = productDAO.getAll();
		}
		return list;
	}

	public void setList(List<Product> list) {
		this.list = list;
	}
	
}

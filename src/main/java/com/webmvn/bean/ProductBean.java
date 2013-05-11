package com.webmvn.bean;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.webmvn.dao.ProductDAO;
import com.webmvn.pojo.Product;

@ManagedBean
@RequestScoped
public class ProductBean implements Serializable {

	//
	private Product selectedRecord = new Product();
	private List<Product> list = null;
	private ProductDAO productDAO = new ProductDAO();
	
	//
	private static final long serialVersionUID = 1L;
	private final String LIST_PAGE = "list?faces-redirect=true";
	private final String EDIT_PAGE = "edit?faces-redirect=true";	

	//
	public ProductBean() {
	}

	//
	public String insert() {
		return EDIT_PAGE;
	}
	
	public String edit() {
		return EDIT_PAGE;
	}
	
	public String save() {
		return LIST_PAGE;
	}
	
	public String cancel(){
		return LIST_PAGE;
	}

	public String delete() {
		return LIST_PAGE;
	}
	
	//

	public Product getSelectedRecord() {
		return selectedRecord;
	}

	public void setSelectedRecord(Product selectedRecord) {
		this.selectedRecord = selectedRecord;
	}

	public List<Product> getList() {
		//bug here		
		if(list == null){
			list = productDAO.getAll();
		}
		return list;
	}

	public void setList(List<Product> list) {
		this.list = list;
	}
	
}

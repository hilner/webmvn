package com.webmvn.bean;

import java.io.Serializable;
import java.util.List;
import java.lang.reflect.ParameterizedType;

import com.webmvn.dao.GenericDAO;
import com.webmvn.pojo.GenericPojo;

public abstract class GenericBean<T extends GenericPojo, E extends GenericDAO<T>> implements Serializable{

	// Properties

	private T selectedRecord = getNewObject();
	
	private List<T> list = null;

	// Constants

	private static final long serialVersionUID = 1L;
	private final String LIST_PAGE = "list?faces-redirect=true";
	private final String EDIT_PAGE = "edit"; // don't use redirect for edit with ajax											

	// Contructors

	public GenericBean() {
	}

	// Methods
	
	@SuppressWarnings ("unchecked")
	public GenericDAO<T> getDAO(){
		ParameterizedType paramType = (ParameterizedType) getClass().getGenericSuperclass();
	    try {
	    	return ((Class<E>) paramType.getActualTypeArguments()[1]).newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace(); //add log here
		}
		return null;
	}
	
	@SuppressWarnings ("unchecked")
	public T getNewObject(){
		ParameterizedType paramType = (ParameterizedType) getClass().getGenericSuperclass();
	    try {
	    	return ((Class<T>) paramType.getActualTypeArguments()[0]).newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace(); //add log here
		}
		return null;
	}

	public String insert() {
		setSelectedRecord(getNewObject());
		return EDIT_PAGE;
	}

	public String edit() {
		return EDIT_PAGE;
	}

	public String save() {
		if (getSelectedRecord().getId() == 0){
			getSelectedRecord().setId(null);
		}
		getDAO().saveOrUpdate(getSelectedRecord());
		return LIST_PAGE;
	}

	public String cancel() {
		return LIST_PAGE;
	}

	public String delete() {
		getDAO().delete(getSelectedRecord());
		return LIST_PAGE;
	}

	// Getters and Setters

	public List<T> getList() {
		if (list == null) {
			list = getDAO().getAll();
		}
		return list;
	}
	
	public void setList(List<T> list) {
		this.list = list;
	}

	public T getSelectedRecord() {
		return selectedRecord;
	}

	public void setSelectedRecord(T selectedRecord) {
		this.selectedRecord = selectedRecord;
	}

}

package com.webmvn.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class TesteBean implements Serializable{

	//Constants
	private static final long serialVersionUID = 1L;
	
	//Properties
	private String umaString = "";
	
	//Constructors
	public TesteBean(){}
	
	//Methods
	public String goToPage1(){
		setUmaString("chegando na pg1");
		return "page1";
	}
	
	public String goToPage2(){
		setUmaString("chegando na pg2");
		return "page2";
	}
	
	public String goToPage3(){
		setUmaString("chegando na pg3");
		return "page3";
	}

	//Getters and Setters
	public String getUmaString() {
		return umaString;
	}

	public void setUmaString(String umaString) {
		this.umaString = umaString;
	}
	
}

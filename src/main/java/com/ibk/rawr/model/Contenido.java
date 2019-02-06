package com.ibk.rawr.model;

import java.util.List;

public class Contenido {
	public List<?> data;
	public int recordsTotal;
	public int recordsFiltered;
	public String sEcho;
	
	public List<?> getData() {
		return data;
	}
	public void setData(List<?> data) {
		this.data = data;
	}
	

}

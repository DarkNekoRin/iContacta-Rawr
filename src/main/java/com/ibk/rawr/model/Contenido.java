package com.ibk.rawr.model;

import java.util.List;

import com.ibk.rawr.entity.MaestraDataEntry;

public class Contenido {
	public List<MaestraDataEntry> data;
	public int recordsTotal;
	public int recordsFiltered;
	public String sEcho;
	
	public List<MaestraDataEntry> getData() {
		return data;
	}
	public void setData(List<MaestraDataEntry> data) {
		this.data = data;
	}
	

}

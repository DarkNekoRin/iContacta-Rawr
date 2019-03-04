package com.ibk.rawr.model;

public class RequestVenta {
private String fechaInicio;
private String fechaFin;
private String codSiebel;
private String numeroPagina;
public String getFechaInicio() {
	return fechaInicio;
}
public void setFechaInicio(String fechaInicio) {
	this.fechaInicio = fechaInicio;
}
public String getFechaFin() {
	return fechaFin;
}
public void setFechaFin(String fechaFin) {
	this.fechaFin = fechaFin;
}
public String getCodSiebel() {
	return codSiebel;
}
public void setCodSiebel(String codSiebel) {
	this.codSiebel = codSiebel;
}
public String getNumeroPagina() {
	return numeroPagina;
}
public void setNumeroPagina(String numeroPagina) {
	this.numeroPagina = numeroPagina;
}

}

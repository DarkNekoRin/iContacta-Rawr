package com.ibk.rawr.model;

public class PaginacionVenta {
private int totalRegistros;
private int totalPaginas;
private int cantPorPagina;
private int paginaActual;
private int start;
private int end;
public int getTotalRegistros() {
	return totalRegistros;
}
public void setTotalRegistros(int totalRegistros) {
	this.totalRegistros = totalRegistros;
}
public int getTotalPaginas() {
	return totalPaginas;
}
public void setTotalPaginas(int totalPaginas) {
	this.totalPaginas = totalPaginas;
}
public int getCantPorPagina() {
	return cantPorPagina;
}
public void setCantPorPagina(int cantPorPagina) {
	this.cantPorPagina = cantPorPagina;
}
public int getPaginaActual() {
	return paginaActual;
}
public void setPaginaActual(int paginaActual) {
	this.paginaActual = paginaActual;
}
public int getStart() {
	return start;
}
public void setStart(int start) {
	this.start = start;
}
public int getEnd() {
	return end;
}
public void setEnd(int end) {
	this.end = end;
}

}

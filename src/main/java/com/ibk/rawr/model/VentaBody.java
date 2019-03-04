package com.ibk.rawr.model;

import java.util.List;

import com.ibk.rawr.entity.Venta;

public class VentaBody {
private List<Venta> listVentaDigital;
private PaginacionVenta paginacion;
public List<Venta> getListVentaDigital() {
	return listVentaDigital;
}
public void setListVentaDigital(List<Venta> listVentaDigital) {
	this.listVentaDigital = listVentaDigital;
}
public PaginacionVenta getPaginacion() {
	return paginacion;
}
public void setPaginacion(PaginacionVenta paginacion) {
	this.paginacion = paginacion;
}

}

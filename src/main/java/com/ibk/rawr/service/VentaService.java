package com.ibk.rawr.service;

import java.io.File;
import java.util.List;

import com.ibk.rawr.entity.Venta;
import com.ibk.rawr.model.RequestVenta;
import com.ibk.rawr.model.ResponseVenta;

public interface VentaService {
	public List<Venta> listar();
	public File generarCTL(File pathTXT);
	public ResponseVenta obtenerVentas(String url,String usuario,String password,RequestVenta requestVenta)throws Exception;
	public File grabarVentaTxt(List<Venta> lista,String pathDirectorio,String user)throws Exception;
	public int ejecutarCarga(File datos,String nombrebat);

}

package com.ibk.rawr.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ibk.rawr.entity.Venta;
import com.ibk.rawr.model.RequestVenta;
import com.ibk.rawr.model.ResponseVenta;
import com.ibk.rawr.repository.VentaRepository;
import com.ibk.rawr.util.Util;
@Service
public class VentaServiceImpl implements VentaService{
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private VentaRepository ventaRepository;

	@Override
	public List<Venta> listar() {		
		return ventaRepository.findAll();
	}



	@Override
	public File generarCTL(File pathTXT) {
		String ctl="OPTIONS (SKIP=1)\n" + 
				"Load DATA \n" + 
				"infile '"+pathTXT.getName()+"'\n" + 
				"TRUNCATE \n" + 
				"PRESERVE BLANKS\n" + 
				"INTO TABLE DGOV_VENTA_DIGITAL_JSON\n" + 
				"fields terminated by \"|\"\n" + 
				"TRAILING NULLCOLS\n" + 
				"(\n" + 
				"ID_EXPEDIENTE,\n" + 
				"DOCUMENTO,\n" + 
				"CORREO ,\n" + 
				"CELULAR , \n" + 
				"ESTADO ,\n" + 
				"CODIGO_SIEBEL , \n" + 
				"TIPO_DOCUMENTO ,\n" + 
				"FECHA, \n" + 
				"CAMPANIA_WEB, \n" + 
				"LPDP,\n" + 
				"NUMPAG \n" + 
				")";
		File fileCtl=new File(pathTXT.getParent()+File.separator+pathTXT.getName().replace(".txt", ".CTL"));
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileCtl));
			writer.write(ctl);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fileCtl;
		
	}


	@Override
	public ResponseVenta obtenerVentas(String url, String usuario, String password, RequestVenta requestVenta)
			throws Exception {
		String plainCreds = usuario + ":" + password;
		byte[] plainCredsBytes = plainCreds.getBytes();
		byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
		String base64Creds = new String(base64CredsBytes);

		String fechaIni = "", fechaFin = "";

		fechaIni = Util.cambiarFormatoFechaString("yyyy-MM-dd", "dd-MM-yyyy", requestVenta.getFechaInicio());
		fechaFin = Util.cambiarFormatoFechaString("yyyy-MM-dd", "dd-MM-yyyy", requestVenta.getFechaFin());

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + base64Creds);

		HttpEntity<String> request = new HttpEntity<String>(headers);
		ResponseEntity<ResponseVenta> response = null;
		url = url + "/" + fechaIni + "/" + fechaFin + "/" + requestVenta.getCodSiebel() + "/1";
		try {
			response = restTemplate.exchange(url, HttpMethod.GET, request, ResponseVenta.class);
		} catch (Exception e1) {
			throw new Exception("Error en la invocacion del servivio ventas");
		}
		ResponseVenta responseVenta = response.getBody();
		return responseVenta;
	}


	@Override
	public File grabarVentaTxt(List<Venta> lista, String pathDirectorio,String user) throws Exception {
		File cargaArchivo=null;
		if (lista != null && lista.size() > 0) {
			Date fechaHoy=new Date();
			cargaArchivo = new File(pathDirectorio + "ventas"+user+Util.fechaToString(fechaHoy, "yyyyMMddHHmmss")+".txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(cargaArchivo));
			StringBuilder stringBuilder = new StringBuilder();

			stringBuilder.append(
					"idExpediente|documento|correo|celular|estado|codigoSiebel|tipDocumento|fechaRegistro|campaniaWeb|lpdp|num")
					.append("\n");
			for (Venta v : lista) {
				stringBuilder.append(v.getIdExpediente()).append("|").append(v.getDocumento()).append("|")
						.append(v.getCorreo()).append("|").append(v.getCelular()).append("|").append(v.getEstado())
						.append("|").append(v.getCodigoSiebel()).append("|").append(v.getTipDocumento()).append("|")
						.append(v.getFechaRegistro()).append("|").append(v.getCampaniaWeb()).append("|")
						.append(v.getLpdp()).append("|").append(v.getNum()).append("|").append("\n");

			}
			writer.write(stringBuilder.toString());
			writer.close();

		}
		return cargaArchivo;
	}



	@Override
	public int ejecutarCarga(File datos,String nombrebat) {
		List<String> listComan=new ArrayList<>();
		listComan.add(datos.getParent()+File.separator+nombrebat);//"D:\\test.bat"
		listComan.add(datos.getName());//IBK_CRM_CARGA_JSON_VENTAS.CTL
		listComan.add(datos.getName().replace(".CTL",".LOG"));//IBK_CRM_CARGA_JSON_VENTAS.LOG
		listComan.add(datos.getAbsolutePath().replace(".CTL",".txt"));//C:\Proyectos\CTL_Carga_Oracle\IBK_CRM_CARGA_JSON_VENTAS\PROCESO\IBK_CRM_CARGA_JSON_VENTAS.TXT

		return Util.ejecutarBat(listComan);
		
	}
}

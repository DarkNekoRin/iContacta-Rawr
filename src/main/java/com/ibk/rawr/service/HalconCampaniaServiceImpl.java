package com.ibk.rawr.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class HalconCampaniaServiceImpl implements HalconCampaniaService{
	@Autowired
	private RestTemplate restTemplate; 
	

	
	@Override
	public JSONArray obtenerCampania(String url,String usuario,String password,String codCampania) throws Exception {
		   
		String plainCreds = usuario+":"+password;
		byte[] plainCredsBytes = plainCreds.getBytes();
		byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
		String base64Creds = new String(base64CredsBytes);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + base64Creds);
		
		HttpEntity<String> request = new HttpEntity<String>(headers);
        //adding the query params to the URL
		Map<String, String> mapParam=new HashMap();
		mapParam.put("valor", codCampania);
		ResponseEntity<JSONObject> response=null;
		
		try {
			response = restTemplate.
					exchange(url, 						
							HttpMethod.GET, 
							request, 
							JSONObject.class,
							mapParam);
		} catch (Exception e1) {
			throw new Exception("Error en la invocacion del servivio campania");
		}

		JSONObject jsonResponse = response.getBody();		

		JSONObject jsonBody;
		JSONArray lista=null;
		try {
			jsonBody = (JSONObject) jsonResponse.get("body");
			lista= jsonBody.getJSONArray("listarLlamadaAutomatica");
			
		} catch (JSONException e1) {
			throw new Exception("Error al procesar respuesta");
		}
		
		return lista;
	}



	@Override
	public void grabarDatos(JSONArray lista) throws Exception {
		if(lista!=null) {
//			for(JSONObject fila:lista) {
//				
//			}
		}
		
	}
	
	


}

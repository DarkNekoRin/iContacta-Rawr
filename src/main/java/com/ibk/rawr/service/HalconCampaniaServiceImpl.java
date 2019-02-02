package com.ibk.rawr.service;

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
	public String obtenerCampania(String url) {

		   url = "http://localhost:8080/assets/input_json_api.json";
		   
		String plainCreds = "mromerola:V#qTnxsYVkMzjf22FiH";
		byte[] plainCredsBytes = plainCreds.getBytes();
		byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
		String base64Creds = new String(base64CredsBytes);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + base64Creds);
		
		HttpEntity<String> request = new HttpEntity<String>(headers);
		ResponseEntity<JSONObject> response = restTemplate.exchange(url, HttpMethod.GET, request, JSONObject.class);
		JSONObject jsonResponse = response.getBody();
		
//		account=account.replace("\"","").replaceAll("\\\\", "\"");

		
//		   final String uri = "http://localhost:8080/assets/input_json_api.json";
//		     
//		    RestTemplate restTemplate = new RestTemplate();
//		    String result = restTemplate.getForObject(uri, String.class);
//		     
		JSONObject jsonBody;
		try {
			jsonBody = (JSONObject) jsonResponse.get("body");
			JSONArray lista= jsonBody.getJSONArray("listarLlamadaAutomatica");
			
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		
		
		    System.out.println("");
		
		
		return null;
	}
	
	


}

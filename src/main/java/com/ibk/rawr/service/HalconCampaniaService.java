package com.ibk.rawr.service;

import org.json.JSONArray;

public interface HalconCampaniaService {
	public JSONArray obtenerCampania(String url,String usuario,String password,String codCampania)throws Exception;
	public void grabarDatos(JSONArray lista)throws Exception;
}

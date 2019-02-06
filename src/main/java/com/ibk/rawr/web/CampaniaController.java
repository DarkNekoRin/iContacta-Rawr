package com.ibk.rawr.web;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibk.rawr.model.Contenido;
import com.ibk.rawr.model.Respuesta;
import com.ibk.rawr.service.CampaniaService;
import com.ibk.rawr.service.HalconCampaniaService;

@Controller
public class CampaniaController {
	private static final Logger logger = LoggerFactory.getLogger(CampaniaController.class);
	
	@Value("${uri.campania}")
	private String uriCampania;
	
	@Value("${campania.usuario}")
	private String usuarioCampania;
	
	@Value("${campania.password}")
	private String passwordCampania;
	
	
	@Autowired
	private CampaniaService campaniaService;
    @Autowired
    private HalconCampaniaService  halcon;
	@GetMapping(value = "/mostrarCampania")
    public @ResponseBody Contenido mostrarCampania(HttpServletRequest httpRequest, Locale locale){
		Contenido resp=new Contenido();		
		resp.setData(campaniaService.listar());
		
		return resp;
	}
	@GetMapping(value = {"/campania"})
    public String campania(Model model,HttpServletRequest request) { 
        return "campania";
    }

    
    @PostMapping("/procesar") 
    public @ResponseBody Respuesta procesar(@RequestBody Map<String,Object> body ) {
    	logger.info("Inicio Consulta Rest Campania");	
    	Respuesta resp = new Respuesta();
    	JSONArray lista=null;
    	try {
    		
    		lista=halcon.obtenerCampania(uriCampania,usuarioCampania,passwordCampania,body.get("filtroCodCampania").toString());
    		
		} catch (Exception e) {
			resp.setResponseCode(-1);
			resp.setEstado(false);
			resp.setMensaje(e.getMessage());
		}
    	if(lista!=null) {
    		try {
				halcon.grabarDatosTxt(lista);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	
    	return resp;
    }
}


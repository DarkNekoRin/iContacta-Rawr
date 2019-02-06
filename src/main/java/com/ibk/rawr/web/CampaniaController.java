package com.ibk.rawr.web;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibk.rawr.model.Contenido;
import com.ibk.rawr.service.CampaniaService;

@Controller
public class CampaniaController {
	private static final Logger logger = LoggerFactory.getLogger(CampaniaController.class);
	
	@Value("${uri.campania")
	private String uriCampania;
	@Autowired
	private CampaniaService campaniaService;
	
	@GetMapping(value = "/mostrarCampania")
    public @ResponseBody Contenido mostrarCampania(HttpServletRequest httpRequest, Locale locale){
		Contenido resp=new Contenido();		
		// resp.setData(campaniaService.listar());
		
		return resp;
	}
    @RequestMapping(value = {"/campania"}, method = RequestMethod.GET)
    public String campania(Model model,HttpServletRequest request) { 
        return "campania";
    }
	
}
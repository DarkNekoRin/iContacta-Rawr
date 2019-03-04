package com.ibk.rawr.web;

import java.io.File;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibk.rawr.model.Contenido;
import com.ibk.rawr.model.RequestVenta;
import com.ibk.rawr.model.ResponseVenta;
import com.ibk.rawr.model.Respuesta;
import com.ibk.rawr.service.UserService;
import com.ibk.rawr.service.VentaService;

@Controller
public class VentaController {
	private static final Logger logger = LoggerFactory.getLogger(VentaController.class);
	
	@Value("${uri.venta}")
	private String uriVenta;
	
	@Value("${venta.usuario}")
	private String usuarioVenta;
	
	@Value("${venta.password}")
	private String passwordVenta;
	
	@Value("${plantilla.bat}")
	private String nombreBat;
	
    @Value("${ruta.archivo}")
    private String UPLOADED_FOLDER;
	@Autowired
	private VentaService ventaService;
    @Autowired
    private UserService userService;
    
	@GetMapping(value = "/mostrarVenta")
    public @ResponseBody Contenido mostrarCampania(HttpServletRequest httpRequest, Locale locale){
		Contenido resp=new Contenido();		
		resp.setData(ventaService.listar());
		
		return resp;
	}
	@GetMapping(value = {"/venta"})
    public String campania(Model model,HttpServletRequest request) { 
        return "venta";
    }

    
    @PostMapping("/procesarVenta") 
    public @ResponseBody Respuesta procesar(@ModelAttribute RequestVenta requestVenta ) {
    	logger.info("Inicio Consulta Rest Venta");	
    	Respuesta resp = new Respuesta();
    	ResponseVenta responseVenta=null;
    	try {
    		
    		responseVenta=ventaService.obtenerVentas(uriVenta,usuarioVenta,passwordVenta,requestVenta);
    		
		} catch (Exception e) {
			resp.setResponseCode(-1);
			resp.setEstado(false);
			resp.setMensaje(e.getMessage());
		}
    	if(responseVenta!=null && responseVenta.getBody()!=null) {
    		 User userSecurity = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();            
             com.ibk.rawr.entity.User userModel=userService.findByUsername(userSecurity.getUsername());            
             File txtVentas=null;
    		try {
    			txtVentas=ventaService.grabarVentaTxt(responseVenta.getBody().getListVentaDigital(),UPLOADED_FOLDER,userModel.getUsername());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		txtVentas=ventaService.generarCTL(txtVentas);
    		ventaService.ejecutarCarga(txtVentas,nombreBat);
			resp.setResponseCode(0);
			resp.setEstado(true);
			resp.setMensaje("Carga Correcta");
    	}else {
			resp.setResponseCode(-1);
			resp.setEstado(false);
			resp.setMensaje("Sin resultados");
    	}
    	
    	return resp;
    }
}


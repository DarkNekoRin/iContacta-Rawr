package com.ibk.rawr.web;


import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ibk.rawr.entity.MaestraDataEntry;
import com.ibk.rawr.model.Contenido;
import com.ibk.rawr.model.DataEntryView;
import com.ibk.rawr.model.Respuesta;
import com.ibk.rawr.service.DataEntryService;
import com.ibk.rawr.service.MaestraDataEntryService;
import com.ibk.rawr.service.UserService;
import com.ibk.rawr.util.ExcelGenerator;
import com.ibk.rawr.util.OracleSqlLoader;
import com.ibk.rawr.util.OracleSqlLoader.ExitCode;
import com.ibk.rawr.util.OracleSqlLoader.Results;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Controller
public class UploadController {
	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
	@Autowired
	DataSource dataSource;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
	
    @Value("${ora.instance}")
    private String instance;
	
	
	
    
    @Value("${ruta.archivo}")
    private String UPLOADED_FOLDER;
    @Autowired
    private DataEntryService dataEntryService;
    @Autowired
    private UserService userService;

    @Autowired
    private MaestraDataEntryService maestraDataEntryService;
    
    
    @PostMapping("/upload")
    public @ResponseBody Respuesta singleFileUpload(@ModelAttribute DataEntryView dataEntryView ,
                                   RedirectAttributes redirectAttributes) {
    	logger.info("Inicio Carga Archivo");	
    	Respuesta resp = new Respuesta();
		
        if (dataEntryView.getFile().isEmpty()) {
        	 resp.setEstado(false);
             resp.setResponseCode(-1);
             resp.setMensaje("Adjuntar el archivo");
        	return resp;
        }
        BufferedWriter bw = null;
		FileWriter fw = null; 
        try {
            // Get the file and save it somewhere
            byte[] bytes = dataEntryView.getFile().getBytes();
            File f=new File(UPLOADED_FOLDER);
            if(!f.exists()) {
            	f.mkdirs();
            }
            
            Path path = Paths.get(UPLOADED_FOLDER + dataEntryView.getFile().getOriginalFilename());
            Files.write(path, bytes);
            
            User userSecurity = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();            
            com.ibk.rawr.entity.User userModel=userService.findByUsername(userSecurity.getUsername());            
            Calendar fechaActual = Calendar.getInstance();
            String idSolicitud=userModel.getUsername().toUpperCase();
           
            SimpleDateFormat formatmat = new SimpleDateFormat("yyyyMMddHHmmss");
            String fechaStr=formatmat.format(fechaActual.getTime());
            idSolicitud=idSolicitud+fechaStr;
            
            
    		try (Scanner scanner = new Scanner(new File(path.toString()))) {
    			 fw = new FileWriter(UPLOADED_FOLDER+idSolicitud+".txt");
    			 bw = new BufferedWriter(fw);	
    			 bw.write("TIPODOC|DOCUMENTO|FAGDIRECCION|FAGEMAIL|FAGTELEFONO|USERIDSOLICITUD|IDSOLICITUD");
    			 bw.newLine();
    			 scanner.nextLine();//primera columna
    			String columna[]=null;
//    			DataEntry dataEntry=null;
    			while (scanner.hasNext()){
    				columna=scanner.nextLine().split(",");
//    				dataEntry=new DataEntry();
//    				dataEntry.setTipoDocumento(columna[0]);
//    				dataEntry.setDocumento(columna[1]);
//    				dataEntry.setFechaRegistro(fechaActual);
//    				dataEntry.setFlgDireccion(dataEntryView.getDireccion());
//    				dataEntry.setFlgEmail(dataEntryView.getEmail());
//    				dataEntry.setFlgTelefono(dataEntryView.getTelefono());
//    				dataEntry.setUsuarioSolicitud(userModel);
//    				dataEntry.setIdSolicitud(idSolicitud);    				
    				bw.write(columna[0]+"|"+columna[1]+"|"+(dataEntryView.getDireccion()?1:0)+"|"+(dataEntryView.getEmail()?1:0)+"|"+(dataEntryView.getTelefono()?1:0)+"|"+userModel.getId()+"|"+idSolicitud);
    				bw.newLine();    				
//    				list.add(dataEntry);
    			}

    		} catch (IOException e) {
    			 logger.error("Error al procesar el archivo");
    			 resp.setMensaje("Error al procesar el archivo");
    			 resp.setEstado(false);
	             resp.setResponseCode(-1);
    			 e.printStackTrace();
    		}

//    		dataEntryService.saveIterable(list);
            
    	  ejecutaCarga(UPLOADED_FOLDER+idSolicitud);               		
          dataEntryService.ejecutarEtl(idSolicitud);
     		
             //eliminar archivo original
 		 File original=new File(path.toString());
 		 original.delete();	
 		 resp.setMensaje("Procesado Correctamente");	
   		 resp.setEstado(true);
         resp.setResponseCode(0);
         Map<String, String> map=new HashMap<>();
         map.put("idSolicitud", idSolicitud);
         resp.setValues(map);
         logger.info("Procesado Correctamente");	
        }catch(java.lang.ArrayIndexOutOfBoundsException ex) {
            resp.setEstado(false);
            resp.setResponseCode(-1);
            resp.setMensaje("El formato de archivo no es el correcto");
            logger.error("El formato de archivo no es el correcto");
        }
        catch (Exception e) {          
            resp.setEstado(false);
            resp.setResponseCode(-1);
            resp.setMensaje("Error en el Proceso");
            logger.error("Error en el Proceso");
        }finally {
    		try {

			if (bw != null)
				bw.close();

			if (fw != null)
				fw.close();

			} catch (IOException ex) {

	            resp.setEstado(false);
	            resp.setResponseCode(-1);
	            resp.setMensaje("Error en el Proceso");
	            logger.error("Error en el Proceso");

			}
		}

        return resp;
    }

    @GetMapping(value = "/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }
    
   
    public void ejecutaCarga(String path) {
    	Connection conn;
		try {
			conn = dataSource.getConnection();
	    	File dataFile=new File(path); 
	    	  final Results results = OracleSqlLoader.bulkLoad(conn, username, password, instance, "DGOV_DATAENTRY_TMP", dataFile);
		
	        // ========================================================================================================
	        // Analyze
	        // ========================================================================================================
	        if (results.exitCode != ExitCode.SUCCESS) {
	                System.err.println("Failed. Exit code: " + results.exitCode + ". See log file: " + results.logFile);
	                logger.error("Error al ejcutar la carga via CTL: " + results.exitCode + ". See log file: " + results.logFile);
	        }
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("Error ejecutar en la BD: "+e.getMessage());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

    }
    
	@GetMapping(value = "/mostrarSalida")
    public @ResponseBody Contenido mostrarSalida(HttpServletRequest httpRequest, Locale locale){
		Contenido resp=new Contenido();
		resp.setData(new ArrayList<MaestraDataEntry>());
		if (httpRequest.getParameter("filtroIdSolicitud") != null && httpRequest.getParameter("filtroIdSolicitud").length()>0 ){		
			resp.setData(maestraDataEntryService.listarTo10PorIdSolicitud( httpRequest.getParameter("filtroIdSolicitud")  ));
		}
		return resp;
	}

    
    @GetMapping(value = "/download/output.xlsx")
    public ResponseEntity<InputStreamResource> excelCustomersReport(@RequestParam("idSolicitud") String idSolicitud  ) throws IOException {
    	List<MaestraDataEntry> maestraData =maestraDataEntryService.listarPorIdSolicitud( idSolicitud );
		
		ByteArrayInputStream in = ExcelGenerator.maestraDataEntrysToExcel(maestraData);

		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename="+idSolicitud+".xlsx");
		
		 return ResponseEntity
	                .ok()
	                .headers(headers)
	                .body(new InputStreamResource(in));
    }

}
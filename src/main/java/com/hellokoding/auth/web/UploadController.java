package com.hellokoding.auth.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hellokoding.auth.model.DataEntry;
import com.hellokoding.auth.model.DataEntryView;
import com.hellokoding.auth.service.DataEntryService;

@Controller
public class UploadController {


    
    @Value("${ruta.archivo}")
    private String UPLOADED_FOLDER;
    @Autowired
    private DataEntryService dataEntryService;

//    @GetMapping("/")
//    public String index() {
//        return "upload";
//    }

    
//    @RequestMapping(value = "/upload", method = RequestMethod.POST)
//    public String singleFileUpload(@RequestParam("file") MultipartFile file,
//                                   RedirectAttributes redirectAttributes) {
    
    
//    @PostMapping("/upload") // //new annotation since 4.3
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String singleFileUpload(@ModelAttribute DataEntryView dataEntryView , Model model,
                                   RedirectAttributes redirectAttributes) {

        if (dataEntryView.getFile().isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = dataEntryView.getFile().getBytes();
            File f=new File(UPLOADED_FOLDER);
            if(!f.exists()) {
            	f.mkdirs();
            }
            
            
            Path path = Paths.get(UPLOADED_FOLDER + dataEntryView.getFile().getOriginalFilename());
            Files.write(path, bytes);
            
          //leer
//    		String fileName = "c://lines.txt";
            List<DataEntry> list = new ArrayList<DataEntry>();

            
    		try (Scanner scanner = new Scanner(new File(path.toString()))) {
    			scanner.nextLine();//primera columna
    			String columna[]=null;
    			DataEntry dataEntry=null;
    			while (scanner.hasNext()){
    				columna=scanner.nextLine().split(",");
    				dataEntry=new DataEntry();
    				dataEntry.setTipoDocumento(columna[0]);
    				dataEntry.setDocumento(columna[1]);
    				dataEntry.setFechaRegistro(new Date());
    				dataEntry.setFlgDireccion(dataEntryView.getDireccion());
    				dataEntry.setFlgEmail(dataEntryView.getEmail());
    				dataEntry.setFlgTelefono(dataEntryView.getTelefono());
    				list.add(dataEntry);
    			}

    		} catch (IOException e) {
    			e.printStackTrace();
    		}
            
    		dataEntryService.saveIterable(list);
            
            

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + dataEntryView.getFile().getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/uploadStatus";
    }

    @RequestMapping(value = "/uploadStatus",method = RequestMethod.GET)
    public String uploadStatus() {
        return "uploadStatus";
    }
    
    public static List<String> splitComa(String str){
        return Stream.of(str.split(","))
          .map (elem -> new String(elem))
          .collect(Collectors.toList());
    }

}
package com.hellokoding.auth.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hellokoding.auth.model.DataEntryView;

@Controller
public class UploadController {

    //Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "D://temp//";

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

}
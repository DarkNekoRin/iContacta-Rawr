package com.ibk.rawr.web;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ibk.rawr.entity.User;
import com.ibk.rawr.service.SecurityService;
import com.ibk.rawr.service.UserService;
import com.ibk.rawr.validator.UserValidator;

@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;
    

    @RequestMapping(value = "/resetpassword", method = RequestMethod.GET)
    public String resetpassword(Model model) {
        model.addAttribute("userForm", new User());

        return "resetpassword";
    }
    
    
    @RequestMapping(value = "/resetpassword", method = RequestMethod.POST)
    public String resetpassword(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        //userValidator.validate(userForm, bindingResult);
         User user =userService.findByUsername(userForm.getUsername());
        if (user == null) {
        	bindingResult.rejectValue("username", "Usuario.noexiste");
        }
        
        logger.info("Inicio resetpassword");
        if (bindingResult.hasErrors()) {
            return "resetpassword";
        }
        user.setBloqueado(true);
        user.setResetPassword(true);
        user.setPassword(user.getUsername());//pasword sera su user
        userService.save(user);
//      securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());
        model.addAttribute("username", userForm.getUsername());
        model.addAttribute("titulo", "Su contraseña fue restablecida");
        
        return "solicitud";
    }
    
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
    	userForm.setPassword(userForm.getUsername());//pasword sera su user
    	userForm.setPasswordConfirm(userForm.getUsername());//pasword sera su user
    	userValidator.validate(userForm, bindingResult);
        logger.info("Inicio registration");
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userForm.setBloqueado(true);
        userForm.setResetPassword(true);
        
        userService.save(userForm);
//      securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());
        model.addAttribute("username", userForm.getUsername());
        model.addAttribute("titulo", "FELICITACIONES");
        return "solicitud";
    }
    
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
                @RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout, 
                HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", 
                           getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
		}

		if (logout != null) {
			model.addObject("message", "Te haz deslogueado correctamente.");
		}
		model.setViewName("login");

		return model;

	}
    
	//customize the error message
	private String getErrorMessage(HttpServletRequest request, String key){
	
		Exception exception = 
                   (Exception) request.getSession().getAttribute(key);
		
		String error = "";
		if (exception instanceof BadCredentialsException) {
			error = "Tu usuario y tu contraseña son invalidos.";
		}else if(exception instanceof LockedException) {
			error = "Usuario inactivo";
		}else{
			error = "Tu usuario y tu contraseña son invalidos.";
		}
		
		return error;
	}

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model,HttpServletRequest request) {    	
    	 User user =userService.findByUsername(request.getUserPrincipal().getName());
    	 if(user.getResetPassword()!=null && user.getResetPassword()) {
    		 return "redirect:/cambiarpassword"; 
    	 }
    	 user.setUltimaSesion(Calendar.getInstance());
    	 userService.update(user);    	
        return "welcome";
    }
    @RequestMapping(value = "/cambiarpassword", method = RequestMethod.GET)
    public String cambiarpassword(Model model) {
        model.addAttribute("userForm", new User());
        return "cambiarpassword";
    }
    
    @RequestMapping(value = "/cambiarpassword", method = RequestMethod.POST)
    public String cambiarpassword(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
    	org.springframework.security.core.userdetails.User userSecurity = (org.springframework.security.core.userdetails.User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();            
        com.ibk.rawr.entity.User user=userService.findByUsername(userSecurity.getUsername()); 
        userForm.setUsername(userSecurity.getUsername());
        user.setPassword(userForm.getPassword());
        user.setPasswordConfirm(userForm.getPasswordConfirm());
        userValidator.validateCambioPasword(user, bindingResult);

        logger.info("Inicio cambiarpassword");
        if (bindingResult.hasErrors()) {
            return "cambiarpassword";
        }
        user.setResetPassword(false);
        userService.save(user);
        //securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());
        return "redirect:/welcome";
    }
}

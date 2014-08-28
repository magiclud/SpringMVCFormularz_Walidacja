package net.codejava.spring.controller;

import java.util.Map;

import net.codejava.spring.model.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

	@RequestMapping(method = RequestMethod.GET)
    public String viewRegistration(Map<String, Object> model) {
        User loginUser = new User();    
        model.put("loginForm",  loginUser);
         
         
        return "Logowanie";
    }
     
    @RequestMapping(method = RequestMethod.POST)
    public String processRegistration(@ModelAttribute("loginUser") User user,
            Map<String, Object> model) {
         
        // implement your own registration logic here...
         
        // for testing purpose:
    	System.out.println("Zalogowany uzytkownik to: ");
        System.out.println("username: " + user.getUsername());
        System.out.println("password: " + user.getPassword());
        
         
        return "LogowaniePozytywne";
    }
}

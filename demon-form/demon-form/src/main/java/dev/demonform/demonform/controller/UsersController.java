package dev.demonform.demonform.controller;

import dev.demonform.demonform.mode.Usermode;
import dev.demonform.demonform.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsersController{

    @Autowired
    private UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model){
        model.addAttribute("registerRequest", new Usermode());
        return "register_page";
    }
    @GetMapping("/login")
    public String getLoginPage(Model model){
        model.addAttribute("loginRequest", new Usermode());
        return "login_page";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute Usermode usermode, Model model) {
        System.out.println("login request:" + usermode);
        Usermode authenticated = usersService.authenticate(usermode.getLogin(), usermode.getPassword());
        if (authenticated != null) {

            model.addAttribute("userLogin", authenticated.getLogin());
            return "personal_page";
        } else {
            return "error_page";
        }
    }
        @PostMapping("/register")
        public String register(@ModelAttribute Usermode usermode){
            System.out.println("register request:" + usermode);
            Usermode registeredUser = usersService.registerUser(usermode.getLogin(), usermode.getPassword(), usermode.getEmail());
            return registeredUser == null ? "error_page" : "redirect:/login";


       }

}

package com.example.finalfinalback3.Controller;

import com.example.finalfinalback3.DTO.TourAddDTO;
import com.example.finalfinalback3.DTO.UserAuthDTO;
import com.example.finalfinalback3.DTO.UserRegisterDTO;
import com.example.finalfinalback3.Entity.UserEntity;
import com.example.finalfinalback3.Service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;

@Controller
public class WebController {

    //private final String VIEW_COUNT = "VIEW_COUNT";
    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("user", new UserRegisterDTO());
        try {
            return "registration";
        }
        catch (Exception e){
            return "";
        }
    }

    @GetMapping("/signin")
    public String signin(Model model) {
        model.addAttribute("user", new UserAuthDTO());
        return "signin";
    }

//    @GetMapping("/")
//    public String tours(Model model) {
//        return "tours";
//    }
    @GetMapping("/main")
    public String main(Model model, Principal principal, HttpSession session){
        try {
            //incrimentCount(session, VIEW_COUNT);
            //model.addAttribute("user_info", principal);
            //model.addAttribute("user_visit", session.getAttribute(VIEW_COUNT));
            //model.addAttribute("user_list", Arrays.asList(userService.showAll()));
            return "main";
        }
        catch (Exception e){
            return "";
        }
    }

    private void incrimentCount(HttpSession session, String attr) {
        var attr_count = session.getAttribute(attr) == null ? 0 : (Integer) session.getAttribute(attr);
        session.setAttribute(attr, attr_count + 1);
    }


}

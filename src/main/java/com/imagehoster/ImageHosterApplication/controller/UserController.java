package com.imagehoster.ImageHosterApplication.controller;

import com.imagehoster.ImageHosterApplication.model.User;
import com.imagehoster.ImageHosterApplication.model.UserProfile;
import com.imagehoster.ImageHosterApplication.service.ImageService;
import com.imagehoster.ImageHosterApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ImageService imageService;

    @RequestMapping(method = RequestMethod.GET,value = "/users/login")
    public String login(Model model){
        model.addAttribute("user",new User());
        return "/users/login";
    }
    @RequestMapping(method = RequestMethod.POST,value = "/users/login")
    public String loginUser(User user, HttpSession session){
        User exsitingUser = userService.login(user);
        if(exsitingUser == null){
            System.out.println("User Not found");
            return "/users/login";
        }
        else{
            session.setAttribute("LoggedUser",exsitingUser);
            System.out.println("User found");
            return "redirect:/images";
        }
    }

    @RequestMapping(method = RequestMethod.GET,value = "/users/signup")
    public String singup(Model model){
        User user = new User();
        UserProfile userProfile = new UserProfile();
        user.setUserProfile(userProfile);
        model.addAttribute("user",user);
        
        return "/users/signup";
    }
    
    @RequestMapping(method = RequestMethod.POST,value = "/users/signup")
    public String userSignup(User user){
        userService.signupUser(user);
        return "redirect:/users/login";
    }

    @RequestMapping("/users/logout")
    public String userLogout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }

}

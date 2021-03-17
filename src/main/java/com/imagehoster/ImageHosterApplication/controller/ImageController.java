package com.imagehoster.ImageHosterApplication.controller;

import com.imagehoster.ImageHosterApplication.model.Image;
import com.imagehoster.ImageHosterApplication.model.User;
import com.imagehoster.ImageHosterApplication.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class ImageController {

    @Autowired
    private ImageService imageService;

    @RequestMapping(value = "/images")
    public String getAllImage(Model model, HttpSession session){
        User user = (User) session.getAttribute("LoggedUser");
        List<Image> images = imageService.getAllImages(user.getId());
        model.addAttribute("images",images);
        return "images";
    }

    @RequestMapping(method = RequestMethod.GET,value = "/images/hostnewimage")
    public String newImageHost(){
        return "/image/hostimage";
    }

    @RequestMapping(method = RequestMethod.POST,value = "/images/create")
    public String hostNewImage(Image newImage,HttpSession session){
        User user = (User) session.getAttribute("LoggedUser");
        newImage.setUser(user);
        newImage.setDate(new Date());
        imageService.hostImage(newImage);
        return "redirect:/images";
    }
}

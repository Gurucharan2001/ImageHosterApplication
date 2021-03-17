package com.imagehoster.ImageHosterApplication.controller;

import java.util.ArrayList;
import java.util.List;

import com.imagehoster.ImageHosterApplication.model.Image;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
public class HomeController {


    @RequestMapping("/")
    public String getAllPosts(Model model) {
        // Call getAllImages() method in ImageService class to get the list of all images
        // Add the list of images in the model with the key as "images"
        List<Image> images = new ArrayList<>();
        model.addAttribute("images", images);
        return "index";
    }
}
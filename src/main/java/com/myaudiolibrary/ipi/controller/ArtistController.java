package com.myaudiolibrary.ipi.controller;

import com.myaudiolibrary.ipi.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    //liste des Artists
    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listArtists", artistService.getAllArtists());
        return "index";
    }
}

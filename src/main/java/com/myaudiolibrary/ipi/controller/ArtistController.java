package com.myaudiolibrary.ipi.controller;

import com.myaudiolibrary.ipi.model.Artist;
import com.myaudiolibrary.ipi.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("showNewArtistForm")
    public String showNewArtistForm(Model model){
        Artist artist = new Artist();
        model.addAttribute("artist", artist);
        return "new_artist";
    }

    @PostMapping("/saveArtist")
    public String saveArtist(@ModelAttribute("artist") Artist artist){
        artistService.saveArtist(artist);
        return "redirect:/";
    }
}

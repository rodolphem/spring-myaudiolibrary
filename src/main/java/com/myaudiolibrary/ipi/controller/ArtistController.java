package com.myaudiolibrary.ipi.controller;

import com.myaudiolibrary.ipi.model.Artist;
import com.myaudiolibrary.ipi.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    //affiche la page de création d'un artiste
    @GetMapping("showNewArtistForm")
    public String showNewArtistForm(Model model){
        Artist artist = new Artist();
        model.addAttribute("artist", artist);
        return "new_artist";
    }

    //sauvegarde l'artiste, utilisé pour la création et la modification d'un artiste
    @PostMapping("/saveArtist")
    public String saveArtist(@ModelAttribute("artist") Artist artist){
        artistService.saveArtist(artist);
        return "redirect:/";
    }

    //affiche la page de modification d'un artiste
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable (value = "id") long id, Model model){
        Artist artist = artistService.getArtistById(id);

        model.addAttribute("artist", artist);
        return "update_artist";
    }

    @GetMapping("/deleteArtist/{id}")
    public String deleteArtist(@PathVariable (value = "id") long id){
        this.artistService.deleteArtistById(id);
        return "redirect:/";
    }
}

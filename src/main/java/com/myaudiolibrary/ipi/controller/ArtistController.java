package com.myaudiolibrary.ipi.controller;

import com.myaudiolibrary.ipi.model.Album;
import com.myaudiolibrary.ipi.model.Artist;
import com.myaudiolibrary.ipi.service.AlbumService;
import com.myaudiolibrary.ipi.service.ArtistService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    //liste des Artists paginée
    @GetMapping("/")
    public String viewHomePage(Model model){
       return findPaginated(1, model);
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

    //supression
    @GetMapping("/deleteArtist/{id}")
    public String deleteArtist(@PathVariable (value = "id") long id){
        this.artistService.deleteArtistById(id);
        return "redirect:/";
    }

    //pagination
    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo")int pageNo, Model model){
        int pageSize = 10;

        Page<Artist> page = artistService.findPaginated(pageNo, pageSize);
        List<Artist> listArtists = page.getContent();


        Artist artist = new Artist();
        model.addAttribute("artist", artist);

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listArtists", listArtists);

        return "index";

    }

    //Détail artist, albums
    @GetMapping("/artist/{id}")
    public String showAlbums(@PathVariable (value = "id") long id, Model model){

        Artist artist = artistService.getArtistById(id);
        Album album = new Album();
        album.setArtist(artist);

        model.addAttribute("album", album);
        model.addAttribute("artist", artist);

        return "detail_art";
    }

    @PostMapping("/artists")
    public String findByName(@ModelAttribute("artist") Artist artist, Model model){
        String name = new String();
        artistService.saveArtist(artist);
        model.addAttribute("name", name);

        return "artists";
    }
}

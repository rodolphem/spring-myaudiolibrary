package com.myaudiolibrary.ipi.controller;

import com.myaudiolibrary.ipi.exception.ArtistException;
import com.myaudiolibrary.ipi.model.Album;
import com.myaudiolibrary.ipi.model.Artist;
import com.myaudiolibrary.ipi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;

@Controller
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @PostMapping("/saveAlbum")
    public String saveArtist(@ModelAttribute("album") Album album){
        this.albumService.saveAlbum(album);
        return "redirect:/";
    }

    @GetMapping("/delAlbum/{id}")
    public String delAlbum(@PathVariable("id") Long id) throws ArtistException {
        this.albumService.delAlbum(id);
        return "redirect:/";
    }

    @GetMapping("/showAlbumUpdate/{id}")
    public String showAlbumUpdate(@PathVariable (value = "id") long id, Model model){
        Album album = albumService.getAlbumById(id);

        model.addAttribute("album", album);
        return "update_album";
    }


}

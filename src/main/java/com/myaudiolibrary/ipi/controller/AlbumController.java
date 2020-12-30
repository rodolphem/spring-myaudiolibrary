package com.myaudiolibrary.ipi.controller;

import com.myaudiolibrary.ipi.exception.ArtistException;
import com.myaudiolibrary.ipi.model.Album;
import com.myaudiolibrary.ipi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

}

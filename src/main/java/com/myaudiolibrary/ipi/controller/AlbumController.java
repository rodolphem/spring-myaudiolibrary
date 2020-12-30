package com.myaudiolibrary.ipi.controller;

import com.myaudiolibrary.ipi.model.Album;
import com.myaudiolibrary.ipi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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



}

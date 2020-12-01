package com.myaudiolibrary.web.controller;

import com.myaudiolibrary.web.model.Artist;
import com.myaudiolibrary.web.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/artists")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    //findById
    @RequestMapping(value="/{id}", method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public Artist avoirArtist(@PathVariable(value="id")Long id){
        Artist art = artistService.getArtist(id);
        return art;
    }

    //affiche tout les artists
    @RequestMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public Page<Artist> findAll(@RequestParam(value="page") Integer page,
                                @RequestParam(value="size") Integer size,
                                @RequestParam(defaultValue="name") String sortProperty,
                                @RequestParam(value="sortDirection", defaultValue="ASC") String sortDirection) {
        return artistService.getAllArtist(page, size, sortProperty, sortDirection);
    }
}

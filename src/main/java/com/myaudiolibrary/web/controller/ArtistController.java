package com.myaudiolibrary.web.controller;

import com.myaudiolibrary.web.exception.ArtistException;
import com.myaudiolibrary.web.model.Artist;
import com.myaudiolibrary.web.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
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

    //creer un artist
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "")
    public Artist createArtist(@RequestBody Artist artist){
        return this.artistService.creerArtist(artist);
    }

    //supprimer un artist
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delArtist(@PathVariable("id") Long id) throws ArtistException {
        this.artistService.suprArtist(id);
    }

    //modification d'un artist
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public Artist modifArtist(@PathVariable("id") Long id, @RequestBody Artist employe){
        return this.artistService.modifArtist(id,employe);
    }
}

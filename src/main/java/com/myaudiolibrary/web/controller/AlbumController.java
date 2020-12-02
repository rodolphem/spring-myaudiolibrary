package com.myaudiolibrary.web.controller;

import com.myaudiolibrary.web.exception.ArtistException;
import com.myaudiolibrary.web.model.Album;
import com.myaudiolibrary.web.model.Artist;
import com.myaudiolibrary.web.service.AlbumService;
import com.myaudiolibrary.web.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/albums")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    //supprimer un album
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delAlbum(@PathVariable("id") Long id) throws ArtistException {
        this.albumService.suprAlbum(id);
    }

    //creer un album
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "")
    public Album createAlbum(@RequestBody Album album){
        return this.albumService.creerAlbum(album);
    }
}

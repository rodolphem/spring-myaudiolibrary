package com.myaudiolibrary.web.service;

import com.myaudiolibrary.web.model.Album;
import com.myaudiolibrary.web.model.Artist;
import com.myaudiolibrary.web.repository.AlbumRespository;
import com.myaudiolibrary.web.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;

@Service
public class AlbumService {

    @Autowired
    private AlbumRespository albumRespository;

    public void suprAlbum(Long id){
        albumRespository.deleteById(id);
    }

    public Album creerAlbum(Album a) {
        return albumRespository.save(a);
    }
}

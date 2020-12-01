package com.myaudiolibrary.web.service;

import com.myaudiolibrary.web.model.Artist;
import com.myaudiolibrary.web.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class ArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    public Artist getArtist(@PathVariable(value="id")Long id){
        Optional<Artist> art = artistRepository.findById(id);
        if (art.isEmpty()) {
            //erreur 404
            throw new EntityNotFoundException("L'artist d'id: "+id+" n'a pas été trouvé");
        }
        return art.get();
    }
}

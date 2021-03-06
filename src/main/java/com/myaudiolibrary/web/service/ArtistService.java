package com.myaudiolibrary.web.service;

import com.myaudiolibrary.web.model.Artist;
import com.myaudiolibrary.web.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class ArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    //findByID
    public Artist getArtist(@PathVariable(value="id")Long id){
        Optional<Artist> art = artistRepository.findById(id);
        if (art.isEmpty()) {
            //erreur 404
            throw new EntityNotFoundException("L'artist d'id: "+id+" n'a pas été trouvé");
        }
        return art.get();
    }

    //affiche tout les artists
    public Page<Artist> getAllArtist(@RequestParam(value="page") Integer page,
                                     @RequestParam(value="size") Integer size,
                                     @RequestParam(defaultValue="name") String sortProperty,
                                     @RequestParam(value="sortDirection", defaultValue="ASC") String sortDirection){

        Page<Artist> allArtist = artistRepository.findAll(PageRequest.of(page, size, Sort.Direction.fromString(sortDirection), sortProperty));

        return allArtist;
    }

    //creer un artist
    public Artist creerArtist(Artist a) {
        if(artistRepository.existsByName(a.getName())){
            throw new EntityExistsException("Cette artist existe déjà, nom de l'artist : " + a.getName());
        }
        return artistRepository.save(a);
    }

    //supprimer un Artist
    public void suprArtist(Long id){
        artistRepository.deleteById(id);
    }

    //modfier l'artist
    public <T extends Artist> T modifArtist(Long id, T employe) {
        if(!artistRepository.existsById(id)) {
            throw new EntityNotFoundException("L'employé d'identifiant " + id + " n'existe pas !");
        }
        if(!id.equals(employe.getId())) {
            throw new IllegalArgumentException("Requête invalide");
        }
        return artistRepository.save(employe);
    }

    public Artist GetName(@PathVariable(value="name") String name) {
        Optional<Artist> artist = artistRepository.findByName(name);
        if(artist.isEmpty()){
            throw new EntityNotFoundException("L'artist '" + name + "n'existe pas");
        }
        return artist.get();
    }
}

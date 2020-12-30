package com.myaudiolibrary.ipi.service;

import com.myaudiolibrary.ipi.model.Artist;
import com.myaudiolibrary.ipi.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArtistServiceImpl implements ArtistService{

    @Autowired
    private ArtistRepository artistRepository;

    //renvoie tout les artiste
    @Override
    public List<Artist> getAllArtists() {
        return artistRepository.findAll();
    }

    //sauvegarde l'artiste, utilisé pour la création et la modification d'un artiste
    @Override
    public void saveArtist(Artist artist) {
        this.artistRepository.save(artist);
    }

    //renvoie un artiste suivant l'Id qui lui est passé
    @Override
    public Artist getArtistById(long id) {
        Optional<Artist> optional = artistRepository.findById(id);
        Artist artist = null;
        if(optional.isPresent()){
            artist = optional.get();
        }else {
            throw new RuntimeException("Aucun artiste n'a été trouvé avec l'id :: " + id);
        }
        return artist;
    }

    //suppression artiste
    @Override
    public void deleteArtistById(long id) {
        this.artistRepository.deleteById(id);
    }

    //pagination
    @Override
    public Page<Artist> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.artistRepository.findAll(pageable);
    }

    @Override
    public ArrayList<Artist> findByName(@RequestParam(value="name") String name) {
        ArrayList<Artist> listArtists = artistRepository.findByNameContainsIgnoreCase(name);
        return listArtists;
    }

}

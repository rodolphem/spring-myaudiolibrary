package com.myaudiolibrary.ipi.service;

import com.myaudiolibrary.ipi.model.Album;
import com.myaudiolibrary.ipi.model.Artist;
import com.myaudiolibrary.ipi.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    public void delAlbum(Long id){
        albumRepository.deleteById(id);
    }

    public Album saveAlbum(Album a) {
        return albumRepository.save(a);
    }

    public Album getAlbumById(long id) {
        Optional<Album> optional = albumRepository.findById(id);
        Album album = null;
        if(optional.isPresent()){
            album = optional.get();
        }else {
            throw new RuntimeException("Aucun album n'a été trouvé avec l'id :: " + id);
        }
        return album;
    }
}

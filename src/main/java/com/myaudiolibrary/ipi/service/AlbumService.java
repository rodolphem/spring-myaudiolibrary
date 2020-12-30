package com.myaudiolibrary.ipi.service;

import com.myaudiolibrary.ipi.model.Album;
import com.myaudiolibrary.ipi.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

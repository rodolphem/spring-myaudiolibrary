package com.myaudiolibrary.ipi.service;

import com.myaudiolibrary.ipi.model.Artist;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface ArtistService {
    List<Artist> getAllArtists();
    void saveArtist(Artist artist);
    Artist getArtistById(long id);
    void deleteArtistById(long id);
    Page<Artist> findPaginated(int pageNo, int pageSize);
    ArrayList<Artist> findByName(String name);
}

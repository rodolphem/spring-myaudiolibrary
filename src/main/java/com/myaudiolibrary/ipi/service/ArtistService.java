package com.myaudiolibrary.ipi.service;

import com.myaudiolibrary.ipi.model.Artist;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArtistService {
    List<Artist> getAllArtists();
}

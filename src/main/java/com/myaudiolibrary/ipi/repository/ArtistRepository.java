package com.myaudiolibrary.ipi.repository;

import com.myaudiolibrary.ipi.model.Artist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {
    ArrayList<Artist> findByNameContainsIgnoreCase(String name);
}

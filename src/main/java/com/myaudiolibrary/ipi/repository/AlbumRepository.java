package com.myaudiolibrary.ipi.repository;

import com.myaudiolibrary.ipi.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
}

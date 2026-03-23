package com.dreamflow.api.repository;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.dreamflow.api.entity.Song;

@Repository
public interface SongRepository extends JpaRepository<Song, Long>{
}

package com.shaybrow.songr;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepo extends JpaRepository<Album, Long> {
//    this will load methods that let us interact with our psql server
}

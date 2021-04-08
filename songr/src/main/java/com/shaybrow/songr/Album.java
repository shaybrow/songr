package com.shaybrow.songr;

import javax.persistence.*;
import java.util.List;


@Entity
public class Album {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            long id;
    String title;
    String artist;
    int songCount;
    int length;
//    this or @Lob tells postgress to change to a larger variable type
    @Column(columnDefinition = "TEXT")
    String imageUrl;
    @OneToMany(mappedBy="partOf", cascade = CascadeType.ALL)
    List<Song> songs;

    public Album(String title, String artist, int songCount, int length, String imageUrl) {
        this.title = title;
        this.artist = artist;
        this.songCount = songCount;
        this.length = length;
        this.imageUrl = imageUrl;
    }

    Album(){}

    public void setId(long id) {
        this.id = id;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setSongCount(int songCount) {
        this.songCount = songCount;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getSongCount() {
        return songCount;
    }

    public int getLength() {
        return length;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public long getId(){
        return id;
    }
}

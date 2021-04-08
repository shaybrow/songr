package com.shaybrow.songr;

import javax.persistence.*;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String title;
    int trackNumber;
    int length;

    @ManyToOne
    Album partOf;

    public Song(String title,  int length, int trackNumber) {
        this.title = title;
        this.length = length;
        this.trackNumber = trackNumber;

    }
    public Song (){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Album getPartOf() {
        return partOf;
    }

    public void setPartOf(Album partOf) {
        this.partOf = partOf;
    }
}

package com.example.gui10v3;

import javafx.scene.image.Image;

import java.io.Serializable;

public class Music implements Serializable {
import java.io.Serializable;

public class Music implements Serializable {
    private static final long serialVersionUID = 1L;
    private String artist;
    private String year;
    private Integer rank;
    private String title;

    public String getArtist() {
        return artist;
    }

    public String getYear() {
        return year;
    }

    public Integer getRank() {
        return rank;
    }

    public String getTitle() {
        return title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Music(String artist, String year, Integer rank, String title) {
        this.artist = artist;
        this.year = year;
        this.rank = rank;
        this.title = title;
    }

      public String toString() {

          return title + " by: " + artist + " released in " + year + " is ranked #: " + rank;
      }


}

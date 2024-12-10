package com.example.gui10v3;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        Song.readAllSongData();
        Song.describeAllSongs();
        System.out.println("Newest song on the list is: " + Song.newest());
       // ArrayList<Song> songs = new ArrayList<Song>();
        //Tours.readAllData();
       // Tours.describeAllTours();
        Album.readAllData();

    }

}
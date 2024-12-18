package com.example.gui10v3;

import java.util.ArrayList;
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        Song.readAllSongData();
        //Song.describeAllSongs();
        Tours.readAllData();
        Tours.describeAllTours();

    }

}
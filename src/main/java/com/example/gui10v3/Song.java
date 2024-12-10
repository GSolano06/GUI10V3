package com.example.gui10v3;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Song extends Music {

   static ArrayList<Song> allSongs = new ArrayList<Song>();
    Double streams;

    private Double getStreams() {
        return streams;
    }


    public Song(String artist, String year, Integer rank, String title, Double streams) {
        super(artist, year, rank, title);
        this.streams = streams;
    }

    public String toString(){
            String musicString = super.toString();
            return  "Song " + musicString + " with " + streams + " billion streams";
    }

    static String newest() {
        return null;
    }
    long averageRevenue(){
        return 0;
    }
    static void readAllSongData() throws Exception {
        File dataFile = new File("src/SongRankingData");
        Scanner textScanner = new Scanner(dataFile);
        textScanner.useDelimiter("\n");
        while (textScanner.hasNext()) {
            String fullRow = textScanner.nextLine();
            Scanner rowScanner = new Scanner(fullRow);
            rowScanner.useDelimiter("\t");

            //2	"Shape of You"	Ed Sheeran	4.036	6 January 2017	[3]
            int data1 = rowScanner.nextInt();
            System.out.println("data1: " + data1);

            String data2 = rowScanner.next();
            System.out.println(("data2: " + data2));


            String data3 = rowScanner.next();
            System.out.println("data3: " + data3 );

            double data4 = rowScanner.nextDouble();
            System.out.println("data4: " + data4);

            String data5 = rowScanner.next();
            System.out.println("data5: " + data5);

            String data6 = rowScanner.next();
            System.out.println("IGNORE data6: " + data6);
            String artist = data3;
            Integer rank = data1;
            Double streams = data4;
            String title = data2;
            String year = data5;

            Song newSong = new Song(artist, year, rank, title, streams);
            allSongs.add(newSong);


        }


    }

   static void describeAllSongs(){
        for (Song eachSong: allSongs) {
            System.out.println(eachSong);
        }

    }

}



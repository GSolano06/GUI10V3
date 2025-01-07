package com.example.gui10v3;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Song extends Music implements Serializable {

   static ArrayList<Song> allSongs = new ArrayList<Song>();
    Double streams;
    transient Image songCoverImage;
    private static final long serialVersionUID = 1L;

    public Image getSongCoverImage() {
        return songCoverImage;
    }

    public void setSongCoverImage(Image songCoverImage) {
        this.songCoverImage = songCoverImage;
    }

    public Double getStreams() {
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

    public void setStreams(Double streams) {
        this.streams = streams;
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

    static void saveData() throws Exception {
        FileOutputStream fileOut = new FileOutputStream("SavedSongFile");
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        objectOut.writeObject(allSongs);
        objectOut.close();
        fileOut.close();


}
    static void restoreData() throws Exception {
        FileInputStream fileIn = new FileInputStream("SavedSongFile");
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        allSongs = (ArrayList<Song>)objectIn.readObject();
        objectIn.close();
        fileIn.close();
    }

    @Serial
    private void writeObject(ObjectOutputStream s) throws IOException {
        // write NON-transient fields
        s.defaultWriteObject();
        // write transient fields
        if (songCoverImage != null) {
            ImageIO.write(SwingFXUtils.fromFXImage(songCoverImage, null), "png", s);
        }
    }

    @Serial
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
// read NON-transient fields
        s.defaultReadObject();
        // read transient fields
        Image maybeSongCover = null;
        try {
            maybeSongCover = SwingFXUtils.toFXImage(ImageIO.read(s), null);
        } catch (Exception ex) {
            // do nothing
        }
        songCoverImage = maybeSongCover;
    }



}







import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * contains song information
 * @author Ronak Bakshi
 */
public class Song {

    private String title;
    private String singer;
    private int length;
    List<Integer> ratings;

    public Song(String title, String singer, int length, List<Integer> ratings) {
        this.title = title;
        this.singer = singer;
        this.length = length;
        this.ratings = ratings;
    }

    public String getTitle() {
        return title;
    }

    public String getSinger() {
        return singer;
    }

    public int getLength() {
        return length;
    }

    public List<Integer> getRatings() {
        return ratings;
    }

    public double getAverageRating() {
        double average;
        double sum = 0.0;
        for (int L : ratings) {
            sum += L;
        }
        average = sum / ratings.size();
        return average;
    }

    @Override
    public String toString() {
        String str = String.format("%-25s %-25s %3d %5.1f", title, singer, length, getAverageRating());
        return str;
    }

}

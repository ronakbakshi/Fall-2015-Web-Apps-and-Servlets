
import java.io.IOException;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import org.xml.sax.SAXException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Song Information main class
 *
 * @author Ronak Bakshi
 */
public class SongInformation {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
        SongParser SongParserObj = new SongParser();
        List<Song> songList = SongParserObj.getSongsFromXMLFile("songs.xml");
        double minAverage = songList.get(0).getAverageRating();
        String title = "";
        String LongSongtitle = "";
        int length = songList.get(0).getLength();
        double sum = 0.0;
        String averageStr;
        System.out.println("Song Information\n");
        System.out.println(String.format("%-25s %-23s %s %5s", "Title", "Singer", "Length", "Average Rating"));
        for (Song song : songList) {
            System.out.println(song.toString());
        }
        System.out.println("\nAll Songs More Than Six Minutes Long");
        for (int i = 0; i < songList.size(); i++) {
            if (songList.get(i).getLength() >= 6) {
                System.out.println(songList.get(i).getTitle());
            }
        }

        for (int i = 1; i < songList.size(); i++) {
            if (songList.get(i).getAverageRating() <= minAverage) {
                minAverage = songList.get(i).getAverageRating();
            }
        }
        for (int i = 0; i < songList.size(); i++) {
            if (songList.get(i).getAverageRating() == minAverage) {
                if (title.equals("")) {
                    title = songList.get(i).getTitle();
                } else {
                    title += "," + songList.get(i).getTitle();
                }
            }
        }
        System.out.println("\nThe song with the lowest average rating is " + title);
        for (int i = 0; i < songList.size(); i++) {
            if (length <= songList.get(i).getLength()) {
                length = songList.get(i).getLength();
            }
        }
        for (int i = 0; i < songList.size(); i++) {

            if (songList.get(i).getLength() == length) {
                if (LongSongtitle.equals("")) {
                    LongSongtitle = songList.get(i).getTitle();
                } else {
                    LongSongtitle += "," + songList.get(i).getTitle();
                }
            }
        }
        System.out.println("The longest song is " + LongSongtitle);
        for (int i = 0; i < songList.size(); i++) {
            sum += songList.get(i).getLength();
        }
        averageStr = String.format("%.1f", (sum / songList.size()));
        System.out.println("The average length of the songs is " + averageStr + " minutes");
    }
}

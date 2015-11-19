
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import static sun.org.mozilla.javascript.internal.ScriptRuntime.name;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * class to parse the song
 * @author Ronak Bakshi
 */
public class SongParser {

    private DocumentBuilder builder;
    private XPath path;

    public SongParser() throws ParserConfigurationException {
        builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        path = XPathFactory.newInstance().newXPath();
    }

    public List<Song> getSongsFromXMLFile(String fileName) throws SAXException, IOException, XPathExpressionException {
        // Parse file and build DOM tree.
        Document doc = builder.parse(new File(fileName));
        int songCount = Integer.parseInt(path.evaluate("count(/songList/song)", doc));
        ArrayList<Song> songList = new ArrayList<>();
        for (int i = 1; i <= songCount; ++i) {
            String title = path.evaluate("/songList/song[" + i + "]/title", doc);
            String singer = path.evaluate("/songList/song[" + i + "]/singer", doc);
            int length = Integer.parseInt(path.evaluate("/songList/song[" + i + "]/length", doc));
            List<Integer> ratingList = new ArrayList<>();
            int ratingCount = Integer.parseInt(path.evaluate("count(/songList/song[" + i + "]/ratingList/rating)", doc));
            for (int j = 1; j <= ratingCount; j++) {
                int rating = Integer.parseInt(path.evaluate("/songList/song[" + i + "]/ratingList/rating[" + j + "]", doc));
                ratingList.add(rating);
            }
            songList.add(new Song(title, singer, length, ratingList));
        }
        return songList;
    }
}

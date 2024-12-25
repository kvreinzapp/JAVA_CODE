
/**
 * The Part4 class is responsible for fetching and printing the content of a given URL.
 * It uses the URLResource class from the edu.duke package to read the content line by line.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
import edu.duke.URLResource;
import java.io.*;

public class Part4 {
    public void printURLContent(String url, String webLink) {
        URLResource urlResource = new URLResource(url);
        for (String s : urlResource.words()) {
            int pos = s.toLowerCase().indexOf(webLink.toLowerCase());
            if (s.indexOf(webLink) != -1) {
                int startIndex = s.lastIndexOf("\"", pos + 1);
                int stopIndex = s.indexOf("\"", pos);
                System.out.println(s.substring(startIndex + 1, stopIndex));
            }

        }
    }

    public void testing() {
        Part4 part4 = new Part4();
        part4.printURLContent("https://www.dukelearntoprogram.com/course2/data/manylinks.html", "youtube.com");
    }
}

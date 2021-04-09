import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> images = new ArrayList<>();
        String htmlFile = parseFile("E:/skillbox/java_basics/09_FilesAndNetwork/dz4_1/data/code.html");
        Document doc = Jsoup.parse(htmlFile);

        Elements link = doc.select("img.g-picture");
        for (Element element : link) {
            String image = element.attr("src");
            if (image.startsWith("https")) images.add(image);
        }
        download(images);
    }

    public static void download(List<String> images) throws IOException {
        String strPath = "E:/skillbox/java_basics/09_FilesAndNetwork/dz4_1/images/";
        for (String image : images) {
            try (InputStream in = new URL(image).openStream()) {
                Files.createDirectories(Paths.get(strPath));
                Files.copy(in, Paths.get(strPath
                        + new File(image).getName()), StandardCopyOption.REPLACE_EXISTING);
            }
        }
    }


    public static String parseFile(String path) {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            lines.forEach(line -> builder.append(line + "\n"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return builder.toString();
    }
}

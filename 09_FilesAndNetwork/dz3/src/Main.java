import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class Main {
    private static String path = "E:/skillbox/java_basics/09_FilesAndNetwork/dz3/file/movementList.csv";

    public static void main(String[] args) {
        File file = new File(path);
        CSVParser CSVParser = new CSVParser();

        try {
            List<String> lines = Files.readAllLines(file.toPath(),
                    StandardCharsets.UTF_8);

            for (int i = 1; i < lines.size(); i++) {
                CSVParser.CalculateData(lines.get(i));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }


        CSVParser.printData();
    }
}
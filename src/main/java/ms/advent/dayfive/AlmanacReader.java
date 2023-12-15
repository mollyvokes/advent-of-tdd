package ms.advent.dayfive;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class AlmanacReader {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("src/main/resources/day-five-almanac.txt");
        List<String> allLines = Files.readAllLines(path);

        System.out.println(allLines);

    }
}

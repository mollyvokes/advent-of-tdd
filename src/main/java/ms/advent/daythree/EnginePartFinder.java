package ms.advent.daythree;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class EnginePartFinder {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/main/resources/day-three-engine-schematic.txt");
        List<String> engineSchematic = Files.readAllLines(path);

        EngineSchematic schematic = new EngineSchematic();
        schematic.setSchematic(engineSchematic);

        int partNumberSum = schematic.findPartNumbers();

//        System.out.println("The part numbers for this are: " + schematic.partNumbers);
        System.out.println("The gear number sum for this schematic is: " + partNumberSum);

    }
}

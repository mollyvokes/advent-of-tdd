package ms.advent.daysix;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class BoatContest {

    public static List<Integer> getDataLines(String data) {
        List<Integer> dataSplit = new ArrayList<>();
        String[] dataValues = data.split(":")[1].stripLeading().split(" ");
        for (String split: dataValues) {
            String timeValue = split.strip();
            if (!(timeValue.isEmpty())) {
                dataSplit.add(Integer.parseInt(timeValue));
            }
        }
        return dataSplit;
    }

    public static List<Integer> getDistancesForTime(int time) {
        List<Integer> distancesArray = new ArrayList<>();
        for (int i=1; i<time; i++) {
            int timeToMove = time - i;
            int distance = timeToMove*i;
            distancesArray.add(distance);
        }
        return distancesArray;
    }

    public static int numberWaysToWin(int record, List<Integer> distances) {
        int winningWays = 0;
        for (int dist: distances) {
            if (dist > record) {
                winningWays++;
            }
        }
        return winningWays;
    }

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/main/resources/day-six-race-times.txt");
        List<String> allLines = Files.readAllLines(path);

        List<Integer> times = getDataLines(allLines.get(0));
        List<Integer> distances = getDataLines(allLines.get(1));

        int winningProduct = 1;

        for (int i=0; i<times.size(); i++) {
            List<Integer> distanceRange = getDistancesForTime(times.get(i));
            int winningWays = numberWaysToWin(distances.get(i), distanceRange);

            winningProduct *= winningWays;
        }

        System.out.println("the product of winning ways is: " + winningProduct);

    }
}

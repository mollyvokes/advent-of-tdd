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

    public static Long getFigure(String data) {
        String numberChars = "";
        String[] dataValues = data.split(":")[1].stripLeading().split(" ");
        for (String split: dataValues) {
            numberChars = numberChars.concat(split.strip());
        }
        return Long.parseLong(numberChars);
    }

    public static List<Long> getDistancesForTime(Long time) {
        List<Long> distancesArray = new ArrayList<>();
        for (int i=1; i<time; i++) {
            long timeToMove = time - i;
            Long distance = timeToMove*i;
            distancesArray.add(distance);
        }
        return distancesArray;
    }

    public static int numberWaysToWin(Long record, List<Long> distances) {
        int winningWays = 0;
        for (Long dist: distances) {
            if (dist > record) {
                winningWays++;
            }
        }
        return winningWays;
    }

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/main/resources/day-six-race-times.txt");
        List<String> allLines = Files.readAllLines(path);

        Long time = getFigure(allLines.get(0));
        Long recordDistance = getFigure(allLines.get(1));

        List<Long> distanceRange = getDistancesForTime(time);
        int winningWays = numberWaysToWin(recordDistance, distanceRange);

        System.out.println("the number of ways to win is: " + winningWays);

        // part 1
//        int winningProduct = 1;
//
//        for (int i=0; i<times.size(); i++) {
//            List<Integer> distanceRange = getDistancesForTime(times.get(i));
//            int winningWays = numberWaysToWin(distances.get(i), distanceRange);
//
//            winningProduct *= winningWays;
//        }
//
//        System.out.println("the product of winning ways is: " + winningProduct);

    }
}

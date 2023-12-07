package ms.advent.dayfour;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class WinningScratchCards {

    public static String[] getWinningNumbers(String card) {
        String winningSide = card.split(":")[1].split("\\|")[0].strip().replace("  ", " ");
        return winningSide.split(" ");
    }

    public static String[] getCardNumbers(String card) {
        String cardNumbers = card.split("\\|")[1].strip().replace("  ", " ");
        return cardNumbers.split(" ");
    }

    public static int cardPoints(String card) {
        String[] winningNumbers = getWinningNumbers(card);
        String[] cardNumbers = getCardNumbers(card);

        int cardScore = 0;

        for (String number: cardNumbers) {
            if (List.of(winningNumbers).contains(number) && cardScore==0) {
                cardScore=1;
            } else if (List.of(winningNumbers).contains(number)) {
                cardScore=cardScore*2;
            }
        }
        return cardScore;
    }


    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/main/resources/day-four-scratch-cards.txt");
        List<String> allCards = Files.readAllLines(path);

        int winningTotal = 0;
        for (String card: allCards) {
            winningTotal += cardPoints(card);
        }

        System.out.println("The total of winning cards is:" + winningTotal);

    }
}

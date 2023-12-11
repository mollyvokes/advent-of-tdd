package ms.advent.dayfour;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
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

    public static int numCardWinners(String card) {
        String[] winningNumbers = getWinningNumbers(card);
        String[] cardNumbers = getCardNumbers(card);

        int cardWinners = 0;

        for (String number: cardNumbers) {
            if (List.of(winningNumbers).contains(number)) {
                cardWinners++;
            }
        }
        return cardWinners;
    }

    public static List<Integer> winningCardCopies(int index, String card, List<Integer> copiesList) {

        int cardNumber = index+1;

        List<Integer> collectedCards = new ArrayList<>();
        collectedCards.add(cardNumber);
        int winningNumbers = numCardWinners(card);
        int repeats = findRepeats(cardNumber, copiesList);

        // do this as many times as the card number currently appears in the copies list - use chatgpt to find count of occurance in list
        for (int r = 0; r < repeats+1; r++) {
            for (int i = cardNumber + 1; i < cardNumber + winningNumbers + 1; i++) {
                collectedCards.add(i);
            }
        }
        return collectedCards;
    }

    public static int findRepeats(int cardNum, List<Integer> copiesList) {
        int repeats = 0;
        for (int c: copiesList) {
            if (c == cardNum) {
                repeats++;
            }
        }
        return repeats;
    }

    public static List<Integer> findAllCardsAndCopies(List<String> allCards) {
        List<Integer> allCopies = new ArrayList<>();
        for (int i=0; i < allCards.size(); i++) {
            allCopies.addAll(winningCardCopies(i, allCards.get(i), allCopies));
        }
        return allCopies;
    }


    public static void main(String[] args) throws IOException {

        Path path = Paths.get("src/main/resources/day-four-scratch-cards.txt");
        List<String> allCards = Files.readAllLines(path);

        List<Integer> totalCardCollection = findAllCardsAndCopies(allCards);

        System.out.println("the number of cards won is: " + totalCardCollection.size());

//        int winningTotal = 0;
//        for (String card: allCards) {
//            winningTotal += numCardWinners(card);
//        }
//
//        System.out.println("The total of winning cards is:" + winningTotal);

    }
}

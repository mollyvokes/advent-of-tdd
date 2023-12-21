package ms.advent.dayseven;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class CamelCards {
    public static List<String> types = new ArrayList<>();
    static {
        types.add("five_of_a_kind");
        types.add("four_of_a_kind");
        types.add("full_house");
        types.add("three_of_a_kind");
        types.add("two_pair");
        types.add("one_pair");
        types.add("high_card");
    }

    public static boolean compareIfHigherHand(List<Integer> originalHand, List<Integer> addedHand) {
        for (int i=0; i<5; i++) {
            if (addedHand.get(i) > originalHand.get(i)) {
                return true;
            } else if (addedHand.get(i) < originalHand.get(i)) {
                return false;
            }
        }
        return false;
    }

    public static int findIndexToInsert(List<CamelCardHand> currentList, CamelCardHand addedHand) {
        int indexToInsert = currentList.size();
        for (CamelCardHand currentHand: currentList) {
            if (compareIfHigherHand(currentHand.hand, addedHand.hand)) {
                indexToInsert = currentList.indexOf(currentHand);
                break;
            }
        }
        return indexToInsert;
    }

    public static Map<String, List<CamelCardHand>> getHandsInTypes(List<String> cards) {
        Map<String, List<CamelCardHand>> camelCardHands = new HashMap<>();
        for (String card: cards) {
            String[] details = card.split(" ");
            CamelCardHand handDetails = new CamelCardHand(details[0], Integer.parseInt(details[1]));
            List<CamelCardHand> currentHands = camelCardHands.getOrDefault(handDetails.type, new ArrayList<>());
            if (currentHands.isEmpty()) {
                currentHands.add(handDetails);
            } else {
                int positionToAdd = findIndexToInsert(currentHands, handDetails);
                currentHands.add(positionToAdd, handDetails);
            }
            camelCardHands.put(handDetails.type, currentHands);
        }
        return camelCardHands;
    }

    public static List<CamelCardHand> getOrderedHands(Map<String, List<CamelCardHand>> handsInTypes) {
        List<CamelCardHand> orderedHands = new ArrayList<>();
        for (String type: types) {
            if (handsInTypes.containsKey(type)) {
                orderedHands.addAll(handsInTypes.get(type));
            }
        }
        return orderedHands;
    }

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/main/resources/day-seven-camel-cards.txt");
        List<String> allCards = Files.readAllLines(path);

        Map<String, List<CamelCardHand>> handsInTypes = getHandsInTypes(allCards);
        List<CamelCardHand> orderedHands = getOrderedHands(handsInTypes);

        int sumOfBets = 0;
        for (int j=0; j<orderedHands.size(); j++) {
            int bet = orderedHands.get(j).bet;
            int moneyWon = (orderedHands.size()-j)*bet;
            sumOfBets += moneyWon;
        }

        System.out.println("The sum of all bets is " + sumOfBets);
    }
}

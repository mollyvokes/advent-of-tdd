package ms.advent.dayseven;

import java.util.*;

public class CamelCardHand {
    List<Integer> hand;
    int bet;
    String type;
    public static Map<String, Integer> cardValue = new HashMap<>();
    static
    {
        cardValue.put("T", 10);
        cardValue.put("J", 11);
        cardValue.put("Q", 12);
        cardValue.put("K", 13);
        cardValue.put("A", 14);
    }

    public CamelCardHand(String handInput, int bet) {
        this.hand = getHandOrder(handInput);
        this.bet = bet;
        this.type = this.getHandType();
    }

    static Integer getNumberValue(String card) {
        if (cardValue.containsKey(card)) {
            return cardValue.get(card);
        } else {
            return Integer.valueOf(card);
        }
    }

    static List<Integer> getHandOrder(String hand) {
        char[] handList =  hand.toCharArray();
        List<Integer> constructedHand = new ArrayList<>();
        for (char card:handList) {
            constructedHand.add(getNumberValue(String.valueOf(card)));
        }
        return constructedHand;
    }

    public Map<Integer, Integer> findDuplicates() {
        Map<Integer, Integer> duplicates = new HashMap<>();
        for (Integer card: this.hand) {
            duplicates.put(card, duplicates.getOrDefault(card, 0) + 1);
        }
        duplicates.entrySet().removeIf(entry -> entry.getValue() <= 1);
        return duplicates;
    }

    public String getHandType() {
        Map<Integer, Integer> cardCount = findDuplicates();
        if (cardCount.isEmpty()) {
            return "high_card";
        }
        if (cardCount.size() == 1) {
            if (cardCount.containsValue(2)) {
                return "one_pair";
            } else if (cardCount.containsValue(3)) {
                return "three_of_a_kind";
            } else if (cardCount.containsValue(4)) {
                return "four_of_a_kind";
            } else {
                return "five_of_a_kind";
            }
        }
        if (cardCount.containsValue(3)) {
            return "full_house";
        }
        return "two_pair";
    }
}

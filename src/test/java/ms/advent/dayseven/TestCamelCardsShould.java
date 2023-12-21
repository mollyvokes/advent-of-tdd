package ms.advent.dayseven;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static ms.advent.dayseven.CamelCardHand.*;
import static ms.advent.dayseven.CamelCards.compareIfHigherHand;
import static ms.advent.dayseven.CamelCards.findIndexToInsert;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;

public class TestCamelCardsShould {

    @Test
    void get_number_value() {
        String cardLetter = "T";
        String cardNumber = "4";
        assertThat(getNumberValue(cardLetter), Matchers.equalTo(10));
        assertThat(getNumberValue(cardNumber), Matchers.equalTo(4));
    }

    @Test
    void set_card_class_hand() {
        CamelCardHand cardHand = new CamelCardHand("T55J5", 684);
        List<Integer> handValue = new ArrayList<>();
        handValue.add(10);
        handValue.add(5);
        handValue.add(5);
        handValue.add(11);
        handValue.add(5);
        assertThat(cardHand.hand, Matchers.equalTo(handValue));
        assertThat(cardHand.bet, Matchers.equalTo(684));
    }

    @Test
    void get_duplicates() {
        CamelCardHand cardHand = new CamelCardHand("32T3K", 765);
        Map<Integer, Integer> duplicates = new HashMap<>();
        duplicates.put(3, 2);
        assertThat(cardHand.findDuplicates(), Matchers.equalTo(duplicates));
    }

    static Stream<Arguments> getHandsTestCases() {
        return Stream.of(
                Arguments.arguments("32T3K", "one_pair"),
                Arguments.arguments("J55J5", "full_house"),
                Arguments.arguments("KK677", "two_pair"),
                Arguments.arguments("QQQJA", "three_of_a_kind"),
                Arguments.arguments("K62JT", "high_card")
        );
    }
    @ParameterizedTest
    @MethodSource("getHandsTestCases")
    void get_type_of_hand(String hand, String type) {
        CamelCardHand testHand = new CamelCardHand(hand, 1);
        assertThat(testHand.getHandType(), comparesEqualTo(type));
    }

    @Test
    void correctly_determines_hand_lower() {
        List<Integer> handOne = new ArrayList<>();
        handOne.add(2);
        handOne.add(3);
        handOne.add(3);
        handOne.add(10);
        handOne.add(13);
        List<Integer> handTwo = new ArrayList<>();
        handTwo.add(2);
        handTwo.add(3);
        handTwo.add(3);
        handTwo.add(10);
        handTwo.add(11);
        assertThat(compareIfHigherHand(handOne, handTwo), comparesEqualTo(false));
    }

    @Test
    void correctly_determines_hand_higher() {
        List<Integer> handOne = new ArrayList<>();
        handOne.add(2);
        handOne.add(3);
        handOne.add(3);
        handOne.add(10);
        handOne.add(13);
        List<Integer> handTwo = new ArrayList<>();
        handTwo.add(2);
        handTwo.add(13);
        handTwo.add(3);
        handTwo.add(10);
        handTwo.add(11);
        assertThat(compareIfHigherHand(handOne, handTwo), comparesEqualTo(true));
    }

    @Test
    void correct_finds_index_to_insert() {
        List<CamelCardHand> currentTestList = new ArrayList<>();
        CamelCardHand testHandOne = new CamelCardHand("K66JT", 1);
        CamelCardHand testHandTwo = new CamelCardHand("32T3K", 1);
        currentTestList.add(testHandOne);
        currentTestList.add(testHandTwo);
        CamelCardHand testHandThree = new CamelCardHand("3QQJA", 1);
        assertThat(findIndexToInsert(currentTestList, testHandThree), Matchers.equalTo(1));
    }

}

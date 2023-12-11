package ms.advent.dayfour;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;

public class TestWinningScratchCardsShould {

    static Stream<Arguments> getPointsTestCases() {
        return Stream.of(
                Arguments.arguments("Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53", 8),
                Arguments.arguments("Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19", 2),
                Arguments.arguments("Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1", 2),
                Arguments.arguments("Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36", 0)
        );
    }

    @ParameterizedTest
    @MethodSource("getPointsTestCases")
    void validate_test_cards_against_expected(String card, int expected) {
        assertThat(WinningScratchCards.cardPoints(card), comparesEqualTo(expected));
    }

    static Stream<Arguments> getNumTestCases() {
        return Stream.of(
                Arguments.arguments("Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53", 4),
                Arguments.arguments("Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19", 2),
                Arguments.arguments("Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1", 2),
                Arguments.arguments("Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36", 0)
        );
    }

    @ParameterizedTest
    @MethodSource("getNumTestCases")
    void validate_test_number_cards_against_expected(String card, int expected) {
        assertThat(WinningScratchCards.numCardWinners(card), comparesEqualTo(expected));
    }


    @Test
    void get_correct_num_repeats() {
        List<Integer> testStartingCards = new ArrayList<>();
        testStartingCards.add(1);
        testStartingCards.add(2);
        testStartingCards.add(3);
        testStartingCards.add(2);
        testStartingCards.add(3);
        testStartingCards.add(2);
        assertThat(WinningScratchCards.findRepeats(2, testStartingCards), Matchers.equalTo(3));
    }



}




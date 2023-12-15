package ms.advent.daysix;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static ms.advent.daysix.BoatContest.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestBoatContestShould {

    @Test
    void get_times_list() {
        String times = "Time:      7  15   30";
        List<Integer> timesList = new ArrayList<>();
        timesList.add(7);
        timesList.add(15);
        timesList.add(30);
        assertThat(getDataLines(times), Matchers.equalTo(timesList));
    }

    @Test
    void get_distances_for_time() {
        int testTime = 7;
        List<Integer> possibleDistances = new ArrayList<>();
        possibleDistances.add(6);
        possibleDistances.add(10);
        possibleDistances.add(12);
        possibleDistances.add(12);
        possibleDistances.add(10);
        possibleDistances.add(6);
        assertThat(getDistancesForTime(testTime), Matchers.equalTo(possibleDistances));
    }

    @Test
    void get_number_ways_to_win() {
        List<Integer> possibleDistances = new ArrayList<>();
        possibleDistances.add(6);
        possibleDistances.add(10);
        possibleDistances.add(12);
        possibleDistances.add(12);
        possibleDistances.add(10);
        possibleDistances.add(6);
        int recordDist = 9;
        assertThat(numberWaysToWin(recordDist, possibleDistances), Matchers.equalTo(4));
    }
}

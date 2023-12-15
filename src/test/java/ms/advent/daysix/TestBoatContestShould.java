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
    void get_full_figure() {
        String times = "Time:      7  15   30";
        Long totalTime = 71530L;
        assertThat(getFigure(times), Matchers.equalTo(totalTime));
    }

    @Test
    void get_distances_for_time() {
        Long testTime = 7L;
        List<Long> possibleDistances = new ArrayList<>();
        possibleDistances.add(6L);
        possibleDistances.add(10L);
        possibleDistances.add(12L);
        possibleDistances.add(12L);
        possibleDistances.add(10L);
        possibleDistances.add(6L);
        assertThat(getDistancesForTime(testTime), Matchers.equalTo(possibleDistances));
    }

    @Test
    void get_number_ways_to_win() {
        List<Long> possibleDistances = new ArrayList<>();
        possibleDistances.add(6L);
        possibleDistances.add(10L);
        possibleDistances.add(12L);
        possibleDistances.add(12L);
        possibleDistances.add(10L);
        possibleDistances.add(6L);
        Long recordDist = 9L;
        assertThat(numberWaysToWin(recordDist, possibleDistances), Matchers.equalTo(4));
    }
}

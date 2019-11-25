package Snapchat;

/*

Given an array of time intervals (start, end) for classroom lectures (possibly overlapping),
find the minimum number of rooms required.

For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.

*/

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static Snapchat.Problem1.overlappingRooms;
import static org.assertj.core.api.Assertions.assertThat;

class Test1 {

    @Test
    void overlappingRooms_shouldReturnOne_whenOnInterval() {

        List<Pair> input = Arrays.asList(
                new Pair(60, 150)
        );

        assertThat(overlappingRooms(input)).isEqualTo(1);
    }

    @Test
    void overlappingRooms_shouldReturnOne_whenNoOverlappingIntervals() {

        List<Pair> input = Arrays.asList(
                new Pair(0, 50),
                new Pair(60, 150)
        );

        assertThat(overlappingRooms(input)).isEqualTo(1);
    }

    @Test
    void overlappingRooms_shouldReturnTwo_whenTwoOverlappingIntervals() {

        List<Pair> input = Arrays.asList(
                new Pair(30, 75),
                new Pair(0, 50),
                new Pair(60, 150)
        );

        assertThat(overlappingRooms(input)).isEqualTo(2);
    }

    @Test
    void overlappingRooms_shouldReturnThree_whenThreeOverlappingIntervals() {

        List<Pair> input = Arrays.asList(
                new Pair(30, 75),
                new Pair(0, 50),
                new Pair(65, 200),
                new Pair(60, 150)
        );

        assertThat(overlappingRooms(input)).isEqualTo(3);
    }

    @Test
    void overlappingRooms_shouldReturnEmpty_whenEmptyInput() {

        List<Pair> input = Collections.emptyList();

        assertThat(overlappingRooms(input)).isEqualTo(0);
    }
}

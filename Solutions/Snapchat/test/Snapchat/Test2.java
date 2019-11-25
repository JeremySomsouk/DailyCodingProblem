package Snapchat;

/*

Given a list of possibly overlapping intervals, return a new list of intervals where all overlapping intervals have been merged.

The input list is not necessarily ordered in any way.

For example, given [(1, 3), (5, 8), (4, 10), (20, 25)], you should return [(1, 3), (4, 10), (20, 25)].

*/

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static Snapchat.Problem2.removeOverlappingIntervals;
import static org.assertj.core.api.Assertions.assertThat;

class Test2 {

    private Pair p0 = new Pair(0, 0);
    private Pair p1 = new Pair(1, 3);
    private Pair p2 = new Pair(5, 8);
    private Pair p3 = new Pair(4, 10);
    private Pair p4 = new Pair(20, 25);

    @Test
    void removeOverlappingIntervals_shouldRemoveOverlappedIntervals_whenOneOverlapping() {

        List<Pair> input = Arrays.asList(p1, p2, p3, p4);
        List<Pair> expected = Arrays.asList(p1, p3, p4);

        assertThat(removeOverlappingIntervals(input)).isEqualTo(expected);
    }

    @Test
    void removeOverlappingIntervals_shouldRemoveAllDuplicates() {

        List<Pair> input = Arrays.asList(p0, p0, p0, p2, p2, p2);
        List<Pair> expected = Arrays.asList(p0, p2);

        assertThat(removeOverlappingIntervals(input)).isEqualTo(expected);
    }


    @Test
    void removeOverlappingIntervals_shouldDoNothing_whenConsecutiveIntervals() {

        List<Pair> input = Arrays.asList(p1, p3, p4);
        List<Pair> expected = Arrays.asList(p1, p3, p4);

        assertThat(removeOverlappingIntervals(input)).isEqualTo(expected);
    }


    @Test
    void removeOverlappingIntervals_shouldRemoveAllExceptOne_whenOnlyDuplicates() {

        List<Pair> input = Arrays.asList(p1, p1, p1, p1);
        List<Pair> expected = Arrays.asList(p1);

        assertThat(removeOverlappingIntervals(input)).isEqualTo(expected);
    }
}

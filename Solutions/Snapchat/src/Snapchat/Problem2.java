package Snapchat;

/*

Given a list of possibly overlapping intervals, return a new list of intervals where all overlapping intervals have been merged.

The input list is not necessarily ordered in any way.

For example, given [(1, 3), (5, 8), (4, 10), (20, 25)], you should return [(1, 3), (4, 10), (20, 25)].

*/

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Problem2 {

    static List<Pair> removeOverlappingIntervals(List<Pair> input) {
        List<Pair> orderedIntervals = input.stream()
                .sorted(Comparator.comparingInt(Pair::getX))
                .distinct()
                .collect(Collectors.toList());

        for (int i = 0; i < orderedIntervals.size() - 1; i++) {
            if (isNextYLessOrEqualsThanCurrent(orderedIntervals, i)) {
                orderedIntervals.remove(i + 1);
            }
        }

        return orderedIntervals;
    }

    private static boolean isNextYLessOrEqualsThanCurrent(List<Pair> orderedIntervals, int index) {
        return orderedIntervals.get(index + 1).getY() <= orderedIntervals.get(index).getY();
    }
}

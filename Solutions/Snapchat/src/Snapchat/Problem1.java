package Snapchat;

/*

Given an array of time intervals (start, end) for classroom lectures (possibly overlapping),
find the minimum number of rooms required.

For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.

*/

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Problem1 {

    static int overlappingRooms(List<Pair> inputList) {

        List<Pair> startListWeighted = inputList.stream()
                .map(interval -> new Pair(interval.getX(), 1))
                .collect(Collectors.toList());

        List<Pair> endListWeighted = inputList.stream()
                .map(interval -> new Pair(interval.getY(), -1))
                .collect(Collectors.toList());

        List<Integer> weightsInOrder = Stream.concat(startListWeighted.stream(), endListWeighted.stream())
                .sorted(Comparator.comparingInt(Pair::getX))
                .map(Pair::getY)
                .collect(Collectors.toList());

        int maxRoomsNeeded = 0;
        int currentOccupation = 0;
        for (Integer weight : weightsInOrder) {
            currentOccupation += weight;
            if (maxRoomsNeeded < currentOccupation) {
                maxRoomsNeeded = currentOccupation;
            }
        }

        return maxRoomsNeeded;
    }
}

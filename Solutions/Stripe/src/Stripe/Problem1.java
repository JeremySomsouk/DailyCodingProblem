package Stripe;

/*

Given an array of integers, find the first missing positive integer in linear time and constant space.
In other words, find the lowest positive integer that does not exist in the array.
The array can contain duplicates and negative numbers as well.

For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.

You can modify the input array in-place.

*/

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Problem1 {

    /**
     * Not so constant in space
     * O(n) in time, O(n) in space
     **/
    static int firstMissingPositiveInteger(List<Integer> input) {

        if (input == null || input.isEmpty()) {
            return 1;
        }

        Set<Integer> inputSet = new HashSet<>(input);

        int i = 1;
        while (i > 0) {
            if (!inputSet.contains(i)) {
                return i;
            }
            ++i;
        }

        return i;
    }
}

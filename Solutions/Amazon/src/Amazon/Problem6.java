package Amazon;

/*

Given an array of numbers, find the maximum sum of any contiguous subarray of the array.

For example, given the array [34, -50, 42, 14, -5, 86], the maximum sum would be 137,
since we would take elements 42, 14, -5, and 86.

Given the array [-5, -1, -8, -9], the maximum sum would be 0, since we would not take any elements.

Do this in O(N) time.

*/

import java.util.ArrayList;
import java.util.List;

class Problem6 {

    static int maxSumContiguous(List<Integer> input) {

        int maxSum = 0;
        int currentSum = 0;

        for (Integer integer : input) {

            currentSum = currentSum + integer;
            if (currentSum < 0) {
                currentSum = 0;
            } else if (maxSum < currentSum) {
                maxSum = currentSum;
            }

        }
        return maxSum;
    }

}

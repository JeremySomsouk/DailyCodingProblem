package Uber;

/*

Given an array of integers, return a new array such that each element at index i of the new array is the product of all
the numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24].
If our input was [3, 2, 1], the expected output would be [2, 3, 6].

Follow-up: what if you can't use division?

*/

import java.util.List;

import static java.util.stream.Collectors.toList;

class Problem1 {

    static List<Integer> multiplyArray(List<Integer> input) {

        Integer allMultiplied = input.stream().reduce(1, (i, j) -> i * j);
        return input.stream()
                .filter(number -> number != 0)
                .map(number -> allMultiplied / number)
                .collect(toList());
    }
}

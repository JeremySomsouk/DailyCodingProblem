package Stripe;

/*

Given an array of integers, return a new array such that each element at index i of the new array is the product of all
the numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24].
If our input was [3, 2, 1], the expected output would be [2, 3, 6].

Follow-up: what if you can't use division?

*/

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static Stripe.Problem1.firstMissingPositiveInteger;
import static org.assertj.core.api.Assertions.assertThat;

class Test1 {

    @Test
    void firstMissingPositiveInteger_shouldReturnTwo() {

        List<Integer> input = Arrays.asList(3, 4, -1, 1, 1);
        int expectedOutput = 2;

        assertThat(firstMissingPositiveInteger(input)).isEqualTo(expectedOutput);
    }

    @Test
    void firstMissingPositiveInteger_shouldReturnThree() {

        List<Integer> input = Arrays.asList(1, 2, 0);
        int expectedOutput = 3;

        assertThat(firstMissingPositiveInteger(input)).isEqualTo(expectedOutput);
    }

    @Test
    void firstMissingPositiveInteger_shouldReturnOne_whenOnlyZero() {

        List<Integer> input = Collections.singletonList(0);
        int expectedOutput = 1;

        assertThat(firstMissingPositiveInteger(input)).isEqualTo(expectedOutput);
    }

    @Test
    void firstMissingPositiveInteger_shouldReturnOne_whenEmptyInput() {

        List<Integer> input = Collections.emptyList();
        int expectedOutput = 1;

        assertThat(firstMissingPositiveInteger(input)).isEqualTo(expectedOutput);
    }


    @Test
    void firstMissingPositiveInteger_shouldReturnOne_whenNullInput() {

        List<Integer> input = null;
        int expectedOutput = 1;

        assertThat(firstMissingPositiveInteger(input)).isEqualTo(expectedOutput);
    }
}

package Uber;

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

import static Uber.Problem1.multiplyArray;
import static org.assertj.core.api.Assertions.assertThat;

class Test1 {

    @Test
    void multiplyArray_shouldReturnMultipliedOutput_whenValidInput() {

        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> expectedOutput = Arrays.asList(120, 60, 40, 30, 24);

        assertThat(multiplyArray(input)).isEqualTo(expectedOutput);
    }

    @Test
    void multiplyArray_shouldReturnSwitchPosition_whenTwoValidNumbers() {

        List<Integer> input = Arrays.asList(3, 2);
        List<Integer> expectedOutput = Arrays.asList(2, 3);

        assertThat(multiplyArray(input)).isEqualTo(expectedOutput);
    }

    @Test
    void multiplyArray_shouldReturnEmpty_whenOnlyZero() {

        List<Integer> input = Collections.singletonList(0);
        List<Integer> expectedOutput = Collections.emptyList();

        assertThat(multiplyArray(input)).isEqualTo(expectedOutput);
    }

    @Test
    void multiplyArray_shouldReturnEmpty_whenEmptyInput() {

        List<Integer> input = Collections.emptyList();
        List<Integer> expectedOutput = Collections.emptyList();

        assertThat(multiplyArray(input)).isEqualTo(expectedOutput);
    }
}

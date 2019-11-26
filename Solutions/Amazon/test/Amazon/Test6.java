package Amazon;

/*

Given an array of numbers, find the maximum sum of any contiguous subarray of the array.

For example, given the array [34, -50, 42, 14, -5, 86], the maximum sum would be 137,
since we would take elements 42, 14, -5, and 86.

Given the array [-5, -1, -8, -9], the maximum sum would be 0, since we would not take any elements.

Do this in O(N) time.


*/

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static Amazon.Problem6.maxSumContiguous;
import static org.assertj.core.api.Assertions.assertThat;

class Test6 {

    @Test
    void maxSumContiguous_shouldReturn137_whenValidInput() {

        List<Integer> input = Arrays.asList(34, -50, 42, 14, -5, 86);
        int expected = 137;

        assertThat(maxSumContiguous(input)).isEqualTo(expected);
    }

    @Test
    void maxSumContiguous_shouldReturn86_whenOnlyLastOnePositive() {

        List<Integer> input = Arrays.asList(-34, -50, -5, 86);
        int expected = 86;

        assertThat(maxSumContiguous(input)).isEqualTo(expected);
    }

    @Test
    void maxSumContiguous_shouldReturn86_whenOnlyFistOnePositive() {

        List<Integer> input = Arrays.asList(86, -1, -2, -1010);
        int expected = 86;

        assertThat(maxSumContiguous(input)).isEqualTo(expected);
    }


    @Test
    void maxSumContiguous_shouldReturn0_whenOnlyNegativeNumbers() {

        List<Integer> input = Arrays.asList(-5, -1, -8, -9);
        int expected = 0;

        assertThat(maxSumContiguous(input)).isEqualTo(expected);
    }

    @Test
    void maxSumContiguous_shouldReturn0_whenEmptyList() {

        List<Integer> input = Collections.emptyList();
        int expected = 0;

        assertThat(maxSumContiguous(input)).isEqualTo(expected);
    }
}

package Facebook;

/*

Given a multiset of integers, return whether it can be partitioned into two subsets whose sums are the same.

For example, given the multiset {15, 5, 20, 10, 35, 15, 10},
it would return true, since we can split it up into {15, 5, 10, 15, 10} and {20, 35}, which both add up to 55.

Given the multiset {15, 5, 20, 10, 35}, it would return false,
since we can't split it up into two subsets that add up to the same sum.

*/

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static Facebook.Problem10.canBePartitionedEquallyInTwo;
import static Facebook.Problem8.getMaxProfit;
import static org.assertj.core.api.Assertions.assertThat;

class Test10 {

    @Test
    void canBePartitionedEquallyInTwo_shouldReturnFalse_whenEmpty() {

        List<Integer> input = Collections.emptyList();
        assertThat(canBePartitionedEquallyInTwo(input)).isFalse();
    }

    @Test
    void canBePartitionedEquallyInTwo_shouldReturnFalse_whenOneValue() {

        List<Integer> input = Collections.singletonList(9);
        assertThat(canBePartitionedEquallyInTwo(input)).isFalse();
    }

    @Test
    void canBePartitionedEquallyInTwo_shouldReturnTrue_whenTwoSameValues() {

        List<Integer> input = Arrays.asList(1, 1);
        assertThat(canBePartitionedEquallyInTwo(input)).isTrue();
    }

    @Test
    void canBePartitionedEquallyInTwo_shouldReturnTrue_whenThreeValidValues() {

        List<Integer> input = Arrays.asList(1, 1, 2);
        assertThat(canBePartitionedEquallyInTwo(input)).isTrue();
    }

    @Test
    void canBePartitionedEquallyInTwo_shouldReturnTrue_whenInitialValidTestCase() {

        List<Integer> input = Arrays.asList(15, 5, 20, 10, 35, 15, 10);
        assertThat(canBePartitionedEquallyInTwo(input)).isTrue();
    }

    @Test
    void canBePartitionedEquallyInTwo_shouldReturnFalse_whenInitialInvalidTestCase() {

        List<Integer> input = Arrays.asList(15, 5, 20, 10, 35);
        assertThat(canBePartitionedEquallyInTwo(input)).isFalse();
    }
}
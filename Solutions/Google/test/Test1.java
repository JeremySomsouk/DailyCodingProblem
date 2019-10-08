/*

Good morning! Here's your coding interview problem for today.

This problem was recently asked by Google.

Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

Bonus: Can you do this in one pass

*/

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Test1 {

    @Test
    void isSumPossible_shouldReturnTrue_whenSumPossible1() {

        List<Integer> nbList = Arrays.asList(10, 15, 3, 7);
        int k = 17;

        assertThat(Problem1.isSumPossible(k, nbList)).isTrue();
    }



    @Test
    void isSumPossible_shouldReturnTrue_whenSumPossible2() {

        List<Integer> nbList = Arrays.asList(10, 7, 10, 7);
        int k = 17;

        assertThat(Problem1.isSumPossible(k, nbList)).isTrue();
    }


    @Test
    void isSumPossible_shouldReturnTrue_whenTwoRightNumber() {

        List<Integer> nbList = Arrays.asList(10, 7);
        int k = 17;

        assertThat(Problem1.isSumPossible(k, nbList)).isTrue();
    }

    @Test
    void isSumPossible_shouldReturnFalse_whenEmpty() {

        List<Integer> nbList = Arrays.asList();
        int k = 17;

        assertThat(Problem1.isSumPossible(k, nbList)).isFalse();
    }

    @Test
    void isSumPossible_shouldReturnFalse_whenOneNumber() {

        List<Integer> nbList = Arrays.asList(1);
        int k = 17;

        assertThat(Problem1.isSumPossible(k, nbList)).isFalse();
    }

    @Test
    void isSumPossible_shouldReturnFalse_whenExpectedZero() {

        List<Integer> nbList = Arrays.asList(10, 15, 3, 7);
        int k = 0;

        assertThat(Problem1.isSumPossible(k, nbList)).isFalse();
    }

    @Test
    void isSumPossible_shouldReturnFalse_whenSumImpossible() {

        List<Integer> nbList = Arrays.asList(10, 15, 3, 6);
        int k = 17;

        assertThat(Problem1.isSumPossible(k, nbList)).isFalse();
    }
}

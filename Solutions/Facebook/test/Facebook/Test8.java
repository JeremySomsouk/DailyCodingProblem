package Facebook;

/*

Given a array of numbers representing the stock prices of a company in chronological order,
write a function that calculates the maximum profit you could have made from buying and selling that stock once.
You must buy before you can sell it.

For example, given [9, 11, 8, 5, 7, 10], you should return 5,
since you could buy the stock at 5 dollars and sell it at 10 dollars.

*/

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static Facebook.Problem8.getMaxProfit;
import static org.assertj.core.api.Assertions.assertThat;

class Test8 {

    @Test
    void getMaxProfit_shouldReturn5_whenInitialTestCase() {

        List<Integer> input = Arrays.asList(9, 11, 8, 5, 7, 10);
        int expected = 5;
        assertThat(getMaxProfit(input)).isEqualTo(expected);
    }

    @Test
    void getMaxProfit_shouldReturn0_whenStocksGoDown() {

        List<Integer> input = Arrays.asList(10, 9, 8, 7, 6, 5);
        int expected = 0;
        assertThat(getMaxProfit(input)).isEqualTo(expected);
    }

    @Test
    void getMaxProfit_shouldReturn10_whenStocksGoUpAtFirstIndex() {

        List<Integer> input = Arrays.asList(1, 11, 8, 5, 7, 11);
        int expected = 10;
        assertThat(getMaxProfit(input)).isEqualTo(expected);
    }


    @Test
    void getMaxProfit_shouldReturn0_whenNoStock() {

        List<Integer> input = Collections.emptyList();
        int expected = 0;
        assertThat(getMaxProfit(input)).isEqualTo(expected);
    }

    @Test
    void getMaxProfit_shouldReturn1_whenOnlyTwoValues() {

        List<Integer> input = Arrays.asList(9, 10);
        int expected = 1;
        assertThat(getMaxProfit(input)).isEqualTo(expected);
    }
}

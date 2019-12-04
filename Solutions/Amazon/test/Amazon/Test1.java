package Amazon;

/*

There exists a staircase with N steps, and you can climb up either 1 or 2 steps at a time. Given N,
write a function that returns the number of unique ways you can climb the staircase. The order of the steps matters.

For example, if N is 4, then there are 5 unique ways:

1, 1, 1, 1
2, 1, 1
1, 2, 1
1, 1, 2
2, 2

What if, instead of being able to climb 1 or 2 steps at a time, you could climb any number from a set of positive integers X? For example,
if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at a time.

*/

import org.junit.jupiter.api.Test;

import static Amazon.Problem1.nbWaysToClimb;
import static Amazon.Problem3.runLengthDecode;
import static Amazon.Problem3.runLengthEncode;
import static org.assertj.core.api.Assertions.assertThat;

class Test1 {

    @Test
    void nbWaysToClimb_shouldReturn1_whenInput0() {

        int input = 0;
        int expectedOutput = 1;

        assertThat(nbWaysToClimb(input)).isEqualTo(expectedOutput);
    }


    @Test
    void nbWaysToClimb_shouldReturn1_whenInput1() {

        int input = 1;
        int expectedOutput = 1;

        assertThat(nbWaysToClimb(input)).isEqualTo(expectedOutput);
    }


    @Test
    void nbWaysToClimb_shouldReturn3_whenInput3() {

        int input = 3;
        int expectedOutput = 3;

        assertThat(nbWaysToClimb(input)).isEqualTo(expectedOutput);
    }

    @Test
    void nbWaysToClimb_shouldReturn5_whenInput4() {

        int input = 4;
        int expectedOutput = 5;

        assertThat(nbWaysToClimb(input)).isEqualTo(expectedOutput);
    }

    @Test
    void nbWaysToClimb_shouldReturn8_whenInput5() {

        int input = 5;
        int expectedOutput = 8;

        assertThat(nbWaysToClimb(input)).isEqualTo(expectedOutput);
    }

}

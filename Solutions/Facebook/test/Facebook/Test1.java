package Facebook;

/*

Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.
For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.
You can assume that the messages are decodable. For example, '001' is not allowed.

*/

import org.junit.jupiter.api.Test;

import static Facebook.Problem1.countDecodableWays;
import static org.assertj.core.api.Assertions.assertThat;

class Test1 {

    @Test
    void countDecodableWays_shouldReturn3_whenInput111() {

        //GIVEN
        String input = "111";
        int expectedOutput = 3;

        //WHEN
        //THEN
        assertThat(countDecodableWays(input)).isEqualTo(expectedOutput);
    }

    @Test
    void countDecodableWays_shouldReturn1_whenInput333() {

        //GIVEN
        String input = "333";
        int expectedOutput = 1;

        //WHEN
        //THEN
        assertThat(countDecodableWays(input)).isEqualTo(expectedOutput);
    }

    @Test
    void countDecodableWays_shouldReturn2_whenInput323() {

        //GIVEN
        String input = "323";
        int expectedOutput = 2;

        //WHEN
        //THEN
        assertThat(countDecodableWays(input)).isEqualTo(expectedOutput);
    }

    @Test
    void countDecodableWays_shouldReturn0_whenEmptyInput() {

        //GIVEN
        String input = "";
        int expectedOutput = 0;

        //WHEN
        //THEN
        assertThat(countDecodableWays(input)).isEqualTo(expectedOutput);
    }
}

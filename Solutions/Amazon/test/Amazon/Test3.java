package Amazon;

/*

Run-length encoding is a fast and simple method of encoding strings.
The basic idea is to represent repeated successive characters as a single count and character.
For example, the string "AAAABBBCCDAA" would be encoded as "4A3B2C1D2A".

Implement run-length encoding and decoding.
You can assume the string to be encoded have no digits and consists solely of alphabetic characters.
You can assume the string to be decoded is valid.

*/

import org.junit.jupiter.api.Test;

import static Amazon.Problem3.runLengthDecode;
import static Amazon.Problem3.runLengthEncode;
import static org.assertj.core.api.Assertions.assertThat;

class Test3 {

    @Test
    void runLengthEncode_shouldReturnEmptyString_whenEmptyInput() {

        String input = "";
        String expectedOutput = "";

        assertThat(runLengthEncode(input)).isEqualTo(expectedOutput);
    }

    @Test
    void runLengthEncode_shouldReturnCorrectEncoding_whenValidInput() {

        String input = "AAAABBBCCDAA";
        String expectedOutput = "4A3B2C1D2A";

        assertThat(runLengthEncode(input)).isEqualTo(expectedOutput);
    }

    @Test
    void runLengthEncode_shouldReturnCorrectEncoding_whenValidInputEndingWithSingleChar() {

        String input = "AAAABBBCCD";
        String expectedOutput = "4A3B2C1D";

        assertThat(runLengthEncode(input)).isEqualTo(expectedOutput);
    }


    @Test
    void runLengthEncode_shouldReturnCorrectEncoding_whenSingleCharInput() {

        String input = "Z";
        String expectedOutput = "1Z";

        assertThat(runLengthEncode(input)).isEqualTo(expectedOutput);
    }


    @Test
    void runLengthDecode_shouldReturnEmptyString_whenEmptyInput() {

        String input = "";
        String expectedOutput = "";

        assertThat(runLengthDecode(input)).isEqualTo(expectedOutput);
    }

    @Test
    void runLengthDecode_shouldReturnCorrectDecoding_whenValidInput() {

        String input = "4A3B2C1D2A";
        String expectedOutput = "AAAABBBCCDAA";

        assertThat(runLengthDecode(input)).isEqualTo(expectedOutput);
    }

    @Test
    void runLengthDecode_shouldReturnCorrectDecoding_whenValidInputEndingWithSingleChar() {

        String input = "4A3B2C1D";
        String expectedOutput = "AAAABBBCCD";

        assertThat(runLengthDecode(input)).isEqualTo(expectedOutput);
    }


    @Test
    void runLengthDecode_shouldReturnCorrectDecoding_whenSingleCharInput() {

        String input = "1Z";
        String expectedOutput = "Z";

        assertThat(runLengthDecode(input)).isEqualTo(expectedOutput);
    }
}

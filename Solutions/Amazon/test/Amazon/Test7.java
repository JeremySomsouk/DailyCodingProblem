package Amazon;

/*

Given a string s and an integer k, break up the string into multiple lines such that each line has a length of k or less.

You must break it up so that words don't break across lines.
Each line has to have the maximum possible amount of words.
If there's no way to break the text up, then return null.

You can assume that there are no spaces at the ends of the string
and that there is exactly one space between each word.

For example, given the string "the quick brown fox jumps over the lazy dog" and k = 10,
you should return: ["the quick", "brown fox", "jumps over", "the lazy", "dog"].
No string in the list has a length of more than 10.

*/

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static Amazon.Problem6.maxSumContiguous;
import static Amazon.Problem7.*;
import static org.assertj.core.api.Assertions.assertThat;

class Test7 {

    @Test
    void splitSentence_shouldEmptyStringArray_whenValidEmptyInput() {

        String sentence = "";
        int k = 10;
        List<String> expected = Arrays.asList("");

        assertThat(splitSentence(sentence, k)).isEqualTo(expected);
    }

    @Test
    void splitSentence_shouldValidArray_whenValidInput() {

        String sentence = "the quick brown fox jumps over the lazy dog";
        int k = 10;
        List<String> expected = Arrays.asList("the quick", "brown fox", "jumps over", "the lazy", "dog");

        assertThat(splitSentence(sentence, k)).isEqualTo(expected);
    }

    @Test
    void splitSentence_shouldValidOneWordArray_whenInvalidInputK() {

        String sentence = "the quick brown fox jumps over the lazy dog";
        int k = 5;
        List<String> expected = Arrays.asList("the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog");

        assertThat(splitSentence(sentence, k)).isEqualTo(expected);
    }
}

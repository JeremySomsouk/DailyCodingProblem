package Palantir;

/*

Write an algorithm to justify text. Given a sequence of words and an integer line length k, return a list of strings which represents each line, fully justified.

More specifically, you should have as many words as possible in each line. There should be at least one space between each word.
Pad extra spaces when necessary so that each line has exactly length k.
Spaces should be distributed as equally as possible, with the extra spaces, if any, distributed starting from the left.

If you can only fit one word on a line, then you should pad the right-hand side with spaces.

Each word is guaranteed not to be longer than k.

For example, given the list of words ["the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"] and k = 16, you should return the following:

["the  quick brown", # 1 extra space on the left
"fox  jumps  over", # 2 extra spaces distributed evenly
"the   lazy   dog"] # 4 extra spaces distributed evenly

*/

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static Palantir.Problem1.justifyText;
import static org.assertj.core.api.Assertions.assertThat;

class Test1 {

    @Test
    void justifyText_shouldReturnExpectedFormatting_whenMultipleWords() {

        List<String> expectedResult = Arrays.asList("the  quick brown", "fox  jumps  over", "the   lazy   dog");
        List<String> wordList = Arrays.asList("the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog");
        int maxSizeSentence = 16;

        assertThat(justifyText(wordList, maxSizeSentence)).isEqualTo(expectedResult);
    }


    @Test
    void justifyText_shouldReturnExpectedFormatting_whenOneWordOnly() {

        List<String> expectedResult = Arrays.asList("thequickbrown   ", "fox  jumps  over", "thelazydog      ");
        List<String> wordList = Arrays.asList("thequickbrown", "fox", "jumps", "over", "thelazydog");
        int maxSizeSentence = 16;

        assertThat(justifyText(wordList, maxSizeSentence)).isEqualTo(expectedResult);
    }


    @Test
    void justifyText_shouldDoNothing_whenEmpty() {

        List<String> expectedResult = Collections.emptyList();
        List<String> wordList = Collections.emptyList();
        int maxSizeSentence = 16;

        assertThat(justifyText(wordList, maxSizeSentence)).isEqualTo(expectedResult);
    }
}

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

import java.util.ArrayList;
import java.util.List;

class Problem7 {

    static List<String> splitSentence(String sentence, int k) {

        String[] splitSentence = sentence.split(" ");
        List<String> result = new ArrayList<>();

        int currentCount = 0;
        StringBuilder currentString = new StringBuilder();
        for (String word : splitSentence) {
            int wordSize = word.length();

            if (currentCount + wordSize <= k) {
                currentString = getAppendedWord(currentString, word);
                currentCount += wordSize + 1;
            } else {
                flushLine(result, currentString);
                currentString = new StringBuilder(word);
                currentCount = wordSize;
            }

        }

        flushLine(result, currentString);
        return result;
    }

    private static void flushLine(List<String> result, StringBuilder currentString) {
        result.add(currentString.toString());
    }

    private static StringBuilder getAppendedWord(StringBuilder currentString, String word) {

        if (currentString.length() == 0) {
            currentString = new StringBuilder(word);
        } else {
            currentString.append(" ").append(word);
        }
        return currentString;
    }
}

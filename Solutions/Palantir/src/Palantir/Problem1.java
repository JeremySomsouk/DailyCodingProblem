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

import java.util.ArrayList;
import java.util.List;

class Problem1 {

    static List<String> justifyText(List<String> wordList, int maxSizePerSentence) {

        List<List<String>> sentences = buildSentences(wordList, maxSizePerSentence);
        return formatSentencesWithSpaces(sentences, maxSizePerSentence);
    }

    /**
     * Result :
     * [
     *   ["the", "quick", "brown"],
     *   ["fox", "jumps", "over"],
     *   ["the", "lazy", "dog"]
     * ]
     **/
    private static List<List<String>> buildSentences(List<String> wordList, int maxSizeSentence) {

        List<List<String>> sentences = new ArrayList<>();

        List<String> tmpWordList = new ArrayList<>();
        for (int i = 0; i < wordList.size(); i++) {
            String currentWord = wordList.get(i);

            if (tmpWordList.isEmpty()) {
                tmpWordList.add(currentWord);
            } else {
                if (isSentenceAlreadyFullForWord(currentWord, tmpWordList, maxSizeSentence)) {
                    dumpWordsToSentence(tmpWordList, sentences);
                }

                tmpWordList.add(currentWord);

                if (isLastWord(wordList, i)) {
                    dumpWordsToSentence(tmpWordList, sentences);
                }
            }
        }

        return sentences;
    }

    /**
     * Result :
     * [
     *   ["the  quick brown"],
     *   ["fox  jumps  over"],
     *   ["the   lazy   dog"]
     * ]
     **/
    private static List<String> formatSentencesWithSpaces(List<List<String>> sentences, int maxSizePerSentence) {

        List<String> formattedSentences = new ArrayList<>();

        sentences.forEach(sentence -> {

            int spacesForSentence = maxSizePerSentence - totalWordsLength(sentence);

            int[] spacesPerWord = computeSpacesPerWord(sentence, spacesForSentence);

            String formattedSentence = appendWordsAndSpaces(sentence, spacesPerWord);

            formattedSentences.add(formattedSentence);
        });

        return formattedSentences;
    }

    /**
     * Result : (["the", "quick", "brown"], 16) -> [ 2 , 1 ]
     **/
    private static int[] computeSpacesPerWord(List<String> sentence, int spacesForSentence) {

        if (sentence.size() == 1) {
            return new int[]{spacesForSentence};
        }

        return distributeSpaces(sentence, spacesForSentence);
    }

    private static String appendWordsAndSpaces(List<String> sentence, int[] spacesPerWord) {

        StringBuilder sentenceBuilder = new StringBuilder();

        for (int i = 0; i < sentence.size(); i++) {
            String currentWord = sentence.get(i);

            if (sentence.size() == 1) {
                sentenceBuilder.append(currentWord).append(repeatSpaces(spacesPerWord[i]));
            } else {
                if (isLastWord(sentence, i)) {
                    sentenceBuilder.append(currentWord);
                } else {
                    sentenceBuilder.append(currentWord).append(repeatSpaces(spacesPerWord[i]));
                }
            }
        }

        return sentenceBuilder.toString();
    }

    private static String repeatSpaces(int size) {

        return new String(new char[size]).replace("\0", " ");
    }

    private static int[] distributeSpaces(List<String> sentence, int spacesForSentence) {

        int[] spacesCounters = new int[sentence.size() - 1];

        int index = 0;
        for (int i = 0; i < spacesForSentence; ++i) {

            spacesCounters[index] += 1;

            if (index >= spacesCounters.length - 1) {
                index = 0;
            } else {
                ++index;
            }
        }

        return spacesCounters;
    }

    private static boolean isSentenceAlreadyFullForWord(String word, List<String> wordList, int maxSizeSentence) {

        int spacesBetweenWords = wordList.size() - 1;
        return totalWordsLength(wordList) + spacesBetweenWords + word.length() >= maxSizeSentence;
    }

    private static boolean isLastWord(List<String> wordList, int index) {

        return index == wordList.size() - 1;
    }

    private static void dumpWordsToSentence(List<String> wordList, List<List<String>> sentences) {

        sentences.add(new ArrayList<>(wordList));
        wordList.clear();
    }

    private static int totalWordsLength(List<String> wordList) {

        return wordList.stream()
                .mapToInt(String::length)
                .sum();
    }
}

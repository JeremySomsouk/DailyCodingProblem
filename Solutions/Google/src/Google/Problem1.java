package Google;

/*

Good morning! Here's your coding interview problem for today.

This problem was recently asked by Google.

Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

Bonus: Can you do this in one pass

*/

import java.util.List;

class Problem1 {

    static boolean isSumPossible(int expectedSum, List<Integer> nbList) {

        if (expectedSum == 0 || nbList.size() <= 1) {
            return false;
        }

        int beforeLastIndex = nbList.size() - 2;
        int lastIndex = nbList.size() - 1;

        for (int i = 0; i <= beforeLastIndex; ++i) {
            for (int next = i + 1; next <= lastIndex; ++next) {
                if (nbList.get(i) + nbList.get(next) == expectedSum) {
                    return true;
                }
            }
        }

        return false;
    }
}

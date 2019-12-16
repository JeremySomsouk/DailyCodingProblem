package Facebook;

/*

Given a multiset of integers, return whether it can be partitioned into two subsets whose sums are the same.

For example, given the multiset {15, 5, 20, 10, 35, 15, 10},
it would return true, since we can split it up into {15, 5, 10, 15, 10} and {20, 35}, which both add up to 55.

Given the multiset {15, 5, 20, 10, 35}, it would return false,
since we can't split it up into two subsets that add up to the same sum.

*/

import java.util.List;

class Problem10 {

    static boolean canBePartitionedEquallyInTwo(List<Integer> multiset) {

        if (multiset == null || multiset.size() <= 1) {
            return false;
        }

        Integer max = multiset.stream().reduce(0, Integer::sum);

        if (max % 2 != 0) {
            return false;
        }

        return isSubsetSumPossible(multiset, multiset.size(), max / 2);
    }

    private static boolean isSubsetSumPossible(List<Integer> multiset, int size, Integer sum) {

        if (sum == 0) {
            return true;
        } else if (size == 0) {
            return false;
        }

        int lastValue = multiset.get(size - 1);
        if (lastValue > sum) {
            return isSubsetSumPossible(multiset, size - 1, sum);
        }

        return isSubsetSumPossible(multiset, size - 1, sum) ||
                isSubsetSumPossible(multiset, size - 1, sum - lastValue);
    }
}

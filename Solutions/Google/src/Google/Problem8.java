package Google;

/*

Given two singly linked lists that intersect at some point, find the intersecting node. The lists are non-cyclical.
For example, given A = 3 -> 7 -> 8 -> 10 and B = 99 -> 1 -> 8 -> 10, return the node with value 8.

In this example, assume nodes with the same value are the exact same node objects.
Do this in O(M + N) time (where M and N are the lengths of the lists) and constant space.

*/

import java.util.*;

class Problem8 {

    static <T> Optional<T> getIntersect(List<T> listA, List<T> listB) {

        if (listA.isEmpty() || listB.isEmpty()) {
            return Optional.empty();
        }

        Set<T> valuesRegisteredFromA = new HashSet<>(listA);

        Iterator<T> iteratorB = listB.iterator();
        T currentB = iteratorB.next();

        while (true) {
            if (valuesRegisteredFromA.contains(currentB)) {
                return Optional.of(currentB);
            }

            if (iteratorB.hasNext()) {
                currentB = iteratorB.next();
            } else {
                return Optional.empty();
            }
        }
    }
}

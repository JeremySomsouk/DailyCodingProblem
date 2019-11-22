package Google;

/*

Given two singly linked lists that intersect at some point, find the intersecting node. The lists are non-cyclical.
For example, given A = 3 -> 7 -> 8 -> 10 and B = 99 -> 1 -> 8 -> 10, return the node with value 8.

In this example, assume nodes with the same value are the exact same node objects.
Do this in O(M + N) time (where M and N are the lengths of the lists) and constant space.

*/

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static Google.Problem8.getIntersect;
import static org.assertj.core.api.Assertions.assertThat;

class Test8 {

    @Test
    void getIntersect_shouldReturnEmpty_whenOneListEmpty() {

        //GIVEN
        List<Integer> listA = Collections.singletonList(1);
        List<Integer> listB = Collections.emptyList();

        //WHEN
        Optional<Integer> intersect = getIntersect(listA, listB);

        //THEN
        assertThat(intersect).isEqualTo(Optional.empty());
    }

    @Test
    void getIntersect_shouldReturnFirstElement_whenSameList() {

        //GIVEN
        List<Integer> listA = Collections.singletonList(1);
        List<Integer> listB = Collections.singletonList(1);

        //WHEN
        Optional<Integer> intersect = getIntersect(listA, listB);

        //THEN
        assertThat(intersect.orElse(null)).isEqualTo(1);
    }

    @Test
    void getIntersect_shouldReturnSecondElement_whenSecondOneIsTheSame() {

        //GIVEN
        List<Integer> listA = Arrays.asList(1, 3);
        List<Integer> listB = Arrays.asList(2, 3);

        //WHEN
        Optional<Integer> intersect = getIntersect(listA, listB);

        //THEN
        assertThat(intersect.orElse(null)).isEqualTo(3);
    }

    @Test
    void getIntersect_shouldReturn4_whenDifferentSizedLists() {

        //GIVEN
        List<Integer> listA = Arrays.asList(1, 4);
        List<Integer> listB = Arrays.asList(2, 3, 4);

        //WHEN
        Optional<Integer> intersect = getIntersect(listA, listB);

        //THEN
        assertThat(intersect.orElse(null)).isEqualTo(4);
    }

    @Test
    void getIntersect_shouldReturn8_whenDifferentSizedLists() {

        //GIVEN
        List<Integer> listA = Arrays.asList(3, 7, 8, 10);
        List<Integer> listB = Arrays.asList(99, 1, 8, 10);

        //WHEN
        Optional<Integer> intersect = getIntersect(listA, listB);

        //THEN
        assertThat(intersect.orElse(null)).isEqualTo(8);
    }


    @Test
    void getIntersect_shouldReturn8_whenDifferentSizedLists2() {

        //GIVEN
        List<Integer> listA = Arrays.asList(3, 7, 6, 2, 8, 10);
        List<Integer> listB = Arrays.asList(99, 1, 8, 10);

        //WHEN
        Optional<Integer> intersect = getIntersect(listA, listB);

        //THEN
        assertThat(intersect.orElse(null)).isEqualTo(8);
    }
}

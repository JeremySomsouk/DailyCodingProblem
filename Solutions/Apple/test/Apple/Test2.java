package Apple;

/*

Implement a queue using two stacks.
Recall that a queue is a FIFO (first-in, first-out) data structure with the following methods:
enqueue, which inserts an element into the queue, and dequeue, which removes it.

*/

import Apple.Problem2.MyFIFO;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Test2 {

    @Test
    void myFIFO_shouldReturnInsertedValue_whenEnqueueOnce() {

        //GIVEN
        MyFIFO<Integer> myQueue = new MyFIFO<>();

        //WHEN
        myQueue.enqueue(6);

        //THEN
        assertThat(myQueue.dequeue()).isEqualTo(6);
    }

    @Test
    void myFIFO_shouldReturnInsertedValuesInOrder_whenMultipleEnqueues() {

        //GIVEN
        MyFIFO<Integer> myQueue = new MyFIFO<>();

        //WHEN
        myQueue.enqueue(0);
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        myQueue.enqueue(4);

        //THEN
        assertThat(myQueue.dequeue()).isEqualTo(0);
        assertThat(myQueue.dequeue()).isEqualTo(1);
        assertThat(myQueue.dequeue()).isEqualTo(2);
        assertThat(myQueue.dequeue()).isEqualTo(3);
        assertThat(myQueue.dequeue()).isEqualTo(4);
    }

    @Test
    void myFIFO_shouldReturnInsertedValuesInOrder_whenEnqueueAfterDequeue() {

        //GIVEN
        MyFIFO<Integer> myQueue = new MyFIFO<>();

        //WHEN
        myQueue.enqueue(0);
        myQueue.enqueue(1);
        myQueue.enqueue(2);

        //THEN
        assertThat(myQueue.dequeue()).isEqualTo(0);
        assertThat(myQueue.dequeue()).isEqualTo(1);
        myQueue.enqueue(3);
        myQueue.enqueue(4);
        assertThat(myQueue.dequeue()).isEqualTo(2);
        assertThat(myQueue.dequeue()).isEqualTo(3);
        assertThat(myQueue.dequeue()).isEqualTo(4);
    }

    @Test
    void myFIFO_shouldReturnNull_whenEmptyQueue() {

        //GIVEN
        MyFIFO<Integer> myQueue = new MyFIFO<>();

        //THEN
        assertThat(myQueue.dequeue()).isEqualTo(null);
    }
}

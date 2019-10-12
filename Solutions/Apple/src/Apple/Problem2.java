package Apple;

/*

Implement a queue using two stacks.
Recall that a queue is a FIFO (first-in, first-out) data structure with the following methods:
enqueue, which inserts an element into the queue, and dequeue, which removes it.

*/

import java.util.Stack;

class Problem2 {

    public static class MyFIFO<T> {

        private Stack<T> bottomStack;
        private Stack<T> topStack;

        MyFIFO() {
            bottomStack = new Stack<>();
            topStack = new Stack<>();
        }

        void enqueue(T newElement) {
            bottomStack.add(newElement);
        }

        T dequeue() {

            if (!topStack.isEmpty()) {
                return topStack.pop();
            }

            if (bottomStack.isEmpty()) {
                return null;
            }

            while (bottomStack.peek() != null) {
                T currentBottomElement = bottomStack.pop();
                if (wasLastInserted()) {
                    return currentBottomElement;
                } else {
                    addElementToTopStack(currentBottomElement);
                }
            }

            return null;
        }

        private void addElementToTopStack(T element) {
            topStack.add(element);
        }

        private boolean wasLastInserted() {
            return bottomStack.isEmpty();
        }
    }
}

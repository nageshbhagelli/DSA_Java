/*
What is a Queue?
    A queue is a linear data structure which models real world queues by having two primary operations,
    namely enqueue and dequeue.

When and where is a Queue used?
    -any waiting line models a queue, for example: a lineup at a movie counter
    -can be used to efficiently keep track of the x most recently added elements
    -web server request management where you want first come first serve
    -can be used to do a Breadth First Search(BFS) on a graph
*/

public class Queue<T> implements Iterable<T> {

    private java.util.LinkedList<T> list = new java.util.LinkedList<T>();

    public Queue() {
    }

    public Queue(T firstElem) {
        offer(firstElem);
    }

    // Return the size of the queue
    public int size() {
        return list.size();
    }

    // Returns whether or not the queue is empty
    public boolean isEmpty() {
        return size() == 0;
    }

    // Peek the element at the front of the queue
    // The method throws an error is the queue is empty
    public T peek() {
        if (isEmpty())
            throw new RuntimeException("Queue Empty");
        return list.peekFirst();
    }

    // Poll an element from the front of the queue
    // The method throws an error is the queue is empty
    public T poll() {
        if (isEmpty())
            throw new RuntimeException("Queue Empty");
        return list.removeFirst();
    }

    // Add an element to the back of the queue
    public void offer(T elem) {
        list.addLast(elem);
    }

    // Return an iterator to alow the user to traverse
    // through the elements found inside the queue
    @Override
    public java.util.Iterator<T> iterator() {
        return list.iterator();
    }
}
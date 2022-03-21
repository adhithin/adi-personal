package LinkedLists;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.*;


public class Queue<T> implements Iterable<T> {
    LinkedList<T> head = null, tail = null; // this is saying that the head and tail are null
    // meaning that this linked list is currently empty


    public void add(T data) {
        // we're adding a new object to the end of the queue
        // when we add T ( T is a data Type) we are doing what we call inQ
        // in a stack, this is called push

        LinkedList<T> tail = new LinkedList<>(data, null);
        // this is adding to the list


        if (this.head == null)  // initial condition, if the head is null (empty)
            this.head = this.tail = tail; // we're going to add new object to the queue
            // this object is both the tail and the head, since there's only one end and start object.
        else {  // nodes in queue
            this.tail.setNextNode(tail); // current tail points to new tail
            this.tail = tail;  // update tail
        }
    }

    /**
     *  Returns the data of head.
     *
     * @return  data, the dequeued data
     */
    public T delete() {
        T data = this.peek(); // what does this mean?
        if (this.tail != null) { // initial condition
            this.head = this.head.getNext(); // current tail points to new tail
            if (this.head != null) {
                this.head.setPrevNode(tail);
            }
        }
        return data;
    }

    /**
     *  Returns the data of head.
     *
     * @return  this.head.getData(), the head data in Queue.
     */
    public T peek() {
        return this.head.getData(); // this is just returning the object and data from the head object
    }

    /**
     *  Returns the head object.
     *
     * @return  this.head, the head object in Queue.
     */

    public LinkedList<T> getHead() {
        return this.head;

    }

    /**
     *  Returns the tail object.
     *
     * @return  this.tail, the last object in Queue
     */

    public LinkedList<T> getTail() {
        return this.tail;

    }



    /**
     *  Returns the iterator object.
     *
     * @return  this, instance of object
     */

    public Iterator<T> iterator() {
        return new QueueIterator<>(this);
    }
}

/**
 * Queue Iterator
 *
 * 1. "has a" current reference in Queue
 * 2. supports iterable required methods for next that returns a data object
 */
class QueueIterator<T> implements Iterator<T> {
    LinkedList<T> current;  // current element in iteration

    // Returns the head of the list
    public QueueIterator(Queue<T> q) {
        current = q.getHead();

    }

    // hasNext informs if next element exists
    public boolean hasNext() {
        return current != null;
    }

    // next returns data object and advances to next position in queue
    public T next() {
        T data = current.getData();
        current = current.getNext();

        return data;
    }
}

/**
 * Queue Manager
 * 1. "has a" Queue
 * 2. support management of Queue tasks (aka: titling, adding a list, printing)
 */
class QueueManager<T> {
    // queue data
    static public boolean DEBUG = false;
    private final String name; // name of queue
    private long count = 0; // number of objects in queue
    private final Queue<T> queue = new Queue<>(); // queue object

    /**
     *  Queue constructor
     *  Title with empty queue
     */

    public QueueManager(String name) {
        this.name = name;
    }

    /**
     *  Queue constructor
     *  Title with series of Arrays of Objects
     */
    @SafeVarargs
    public QueueManager(String name, T[]... seriesOfObjects) {
        this.name = name;
        this.addList(seriesOfObjects);
    }

    /**
     *  Queue constructor
     *  Title with empty queue
     */
    public long size() {
        return count;
    }

    /**
     * Add a list of objects to queue
     */
    @SafeVarargs
    public final void addList(T[]... seriesOfObjects) {
        for (T[] objects: seriesOfObjects)
            for (T data : objects) {
                this.add(data);
            }
    }

    /**
     * Delete or dequeue all objects
     */
    public void deleteList() {
        while (this.queue.getHead() != null) {
            this.delete();
        }
    }

    /**
     * Add an object to queue
     */
    public void add(T data) {
        this.queue.add(data);
        this.count++;
        if (DEBUG) {
            System.out.println("Enqueued data: " + data);
            printQueue();
        }
        printQueue();
    }

    /**
     * Remove an object from the queue
     */
    public T delete() {
        T data = this.queue.delete();
        this.count--;
        if (DEBUG) {
            System.out.println("Dequeued data: " + data);
            printQueue();
        }
        printQueue(); // printing the linkedlist for challenge
        return data;
    }

    /**
     * Print objects from queue
     */
    public void printQueue() {
        System.out.print(this.name + " count: " + this.size());
        System.out.println(", data: ");
        if (this.queue.getHead() == null) {
            System.out.println( "null");
        } else {
            for (Object o : this.queue)
                System.out.println(o + " ");
                System.out.println();
        }
    }
}

/**
 * Driver Class
 * Tests queue with string, integers, and mixes of Classes and types
 */
class QueueTester {
    public static void main(String[] args)
    {
        // Create iterable Queue of Words
        QueueManager.DEBUG = false;
        // the below string is a new list of string objects
        String[] words = new String[] { "seven", "slimy", "snakes", "sallying", "slowly", "slithered", "southward"};
        QueueManager<String> qWords = new QueueManager<>("Words", words );
        qWords.printQueue();
        qWords.deleteList();

        // Create iterable Queue of Integers
        QueueManager.DEBUG = false;
        //the below numbers are a list of number objects, using the Integer Wrapper class
        Object[] numbers = new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        QueueManager<Object> qNums = new QueueManager<>("Integers", numbers );
        qNums.printQueue(); // printing the queue
        qNums.deleteList(); // deleting the queue, and the obejcts in it

        // Create iterable Queue of Mixed types of data.
        // Remember: what this is doing is just combining two, but not actually mixing.
        QueueManager.DEBUG = false;
        QueueManager<Object> qMix = new QueueManager<>("Mixed");
        qMix.add("Start");

        qMix.add("End");







        // i can't use "get" since this isn't an array.

        qMix.printQueue();
        qMix.deleteList();




    }
}
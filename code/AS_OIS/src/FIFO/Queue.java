/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FIFO;

/**
 *
 * @author tomascosta
 */

public class Queue<T> {
    
    private Object[] queue;       // The underlying array
    private int size;             // The maximal capacity
    private int head      = 0;    // Pointer to head of queue
    private int tail      = 0;    // Pointer to tail of queue
    private boolean empty = true; // Whether the queue is empty or not
    private int count;

    /**
     * Implements a generic FIFO queue with only the three basic
     * operations, getCount, enqueue and dequeue that inserts and retrieves
     * and element respectively.
     * @param size the number of elements the queue can maximally hold
     */
    public Queue(int size) {
        this.queue = new Object[size];
        this.size  = size;
        this.count=0;
    }

    /**
     * Inserts an element into the queue.
     * @param elem the element to insert into the queue
     * @throws Exception when the queue is full
     */
    public void in(T elem) {
        // Check if the queue is full and throw exception
        if (head == tail && !empty) {
            System.out.println("Cannot enqueue " + elem);
            return;
        }

        // The queue has space left, enqueue the item
        queue[tail] = elem;
        tail        = (tail + 1) % size;
        empty       = false;
        count++;
    }

    /**
     * Removes an element from the queue and returns it.
     * @throws Exception when the queue is empty
     */
    public T out(){
        // Check if queue is empty and throw exception
        if (empty) {
            return null;
        }

        // The queue is not empty, return element
        T elem = (T) queue[head];
        head   = (head + 1) % size;
        empty  = (head == tail);
        count--;
        return elem;
    }
    
    /**
     * Checks if the queue is not full, so a new element can be pushed
     * @throws Exception when the queue is empty
     */
    public boolean hasSpace(){

        if (head == tail && !empty) {
            return false;
        }
        
        return true;
    }
    
    public int getSize() {
        return this.size;
    }
    
    public int getCount() {
        return this.count;
    }

    /**
     * A simple test driver for the queue.
     * It creates the queue, inserts and element, and then
     * fetches and prints the element.
 
    public static void main(String[] args) throws Exception {
        // Create a queue of integers of size 10
        Queue<Integer> q = new Queue<Integer>(3);
        // Insert a number
        q.in(42);
        q.in(52);
        System.out.println("Has space? " + q.hasSpace());
        q.in(11);
        // Get an element form the queue and print it
        System.out.println(q.out());
    }
    *     */

}
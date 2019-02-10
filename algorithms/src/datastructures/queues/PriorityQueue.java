package datastructures.queues;

/**
 * This class implements a PriorityQueue.
 *
 * A priority queue adds elements into positions based on their priority.
 * So the most important elements are placed at the front/on the top.
 * In this example I give numbers that are bigger, a higher priority.
 */

public class PriorityQueue {
    /* Queues don't have max size,
    but using array implementation, so will have
     */
    private int maxSize;

    private int[] queueArray;

    private int numItems;

    public PriorityQueue(int maxSize) {
        this.maxSize = maxSize;
        this.queueArray = new int[maxSize];
        this.numItems = 0;
    }

    public void insert(int value) {

    }
}

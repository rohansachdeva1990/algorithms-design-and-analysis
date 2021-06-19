package com.rohan.dsa.foundations.queue;

import java.util.Arrays;

/**
 * Example 1
 * <p>
 * Priority lowest (have high) priority
 * <p>
 * The priority queue features fast removal of the high-priority
 * item but slow insertion of new items. Write a program with a revised
 * PriorityQ class that has fast O(1) insertion time but slower removal of the highpriority
 * item. Include a method that displays the contents of the priority
 * queue,
 */
public class PriorityQueue {

    private int[] pQ;
    private int head;

    public PriorityQueue(int size) {
        pQ = new int[size];
        head = 0;
    }

    /**
     *  - Always add to the end of the array
     *  - The array should look like 50 40 30 20 10 ....
     *
     * @param data
     */
    public void enqueue(int data) {
        if (isFull()) {
            throw new IllegalStateException("Queue is Full!");
        }

        if (isEmpty()) {
            pQ[head] = data;
        } else {
            // Find the position to insert
            int i;
            for(i = head - 1; i < head; i++){
                if(data > pQ[i] ){
                    pQ[i + 1] = pQ[i];
                }
                else {
                    break;
                }
            }
            pQ[i] = data;
            head++;
        }


        head++;
    }

    public int dequeue(int data) {

        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty!");
        }
        return pQ[head--];
    }


    public boolean isFull() {
        return head == pQ.length;
    }

    public boolean isEmpty() {
        return head == 0;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(pQ).forEach(v -> sb.append(v).append(" <-- "));
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}

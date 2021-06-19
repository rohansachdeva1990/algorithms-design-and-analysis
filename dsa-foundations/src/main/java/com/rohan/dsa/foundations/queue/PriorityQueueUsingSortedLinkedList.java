package com.rohan.dsa.foundations.queue;

public class PriorityQueueUsingSortedLinkedList {

    private SortedLinkedList sortedLinkedList;

    public PriorityQueueUsingSortedLinkedList() {
        this.sortedLinkedList = new SortedLinkedList();
    }

    public void enqueue(int data) {
        sortedLinkedList.insert(data);
    }

    public int dequeue() {
        return sortedLinkedList.delete();
    }

    public int peek() {
        return sortedLinkedList.getFirst();
    }

    public int size() {
        return sortedLinkedList.size();
    }

    public boolean isEmpty() {
        return sortedLinkedList.isEmpty();
    }

    @Override
    public String toString() {
        return sortedLinkedList.toString();
    }

    public static void main(String[] args) {
        PriorityQueueUsingSortedLinkedList pQ = new PriorityQueueUsingSortedLinkedList();
        pQ.enqueue(50);
        pQ.enqueue(60);
        pQ.enqueue(40);
        pQ.enqueue(10);
        pQ.enqueue(20);

        System.out.println(pQ);

        pQ.dequeue();
        pQ.dequeue();

        System.out.println(pQ);

        pQ.enqueue(45);
        System.out.println("Peeking : " + pQ.peek());
        System.out.println(pQ);
    }

    private static class SortedLinkedList {
        private Node head;
        private int size = 0;

        public void insert(int data) {
            Node newNode = new Node(data);
            Node prev = null;
            Node curr = head;

            while (curr != null && data > curr.data) {
                prev = curr;
                curr = curr.next;
            }

            // If no element
            if (prev == null) {
                head = newNode;
            } else {
                prev.next = newNode;
            }
            newNode.next = curr;
            size++;
        }

        public boolean isEmpty() {
            return head == null;
        }

        public int delete() {
            if (isEmpty()) {
                throw new IllegalStateException("Is Empty");
            }

            int data = head.data;
            head = head.next;
            size--;
            return data;
        }

        public int getFirst() {

            if (isEmpty()) {
                throw new IllegalStateException("Is Empty");
            }

            return head.data;
        }

        public int size() {
            return size;
        }

        @Override
        public String toString() {
            if (isEmpty()) {
                return "Empty!";
            }
            StringBuilder sb = new StringBuilder();
            Node temp = head;
            while (temp.next != null) {
                sb.append(temp).append(" <-- ");
                temp = temp.next;
            }
            sb.append(temp).append("\n");
            return sb.toString();
        }

        private static class Node {
            int data;
            Node next;

            public Node(int data) {
                this.data = data;
            }

            @Override
            public String toString() {
                return "[ " + data + " ]";
            }
        }
    }
}

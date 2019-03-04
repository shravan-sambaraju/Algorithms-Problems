package problems.queues;

/* Implement queue in linkedlist */

import common.utils.ListNode;

class LinkedListQueue {
    private int length;
    private ListNode front, rear;

    public LinkedListQueue() {
        length = 0;
        front = rear = null;
    }

    public static void main(String args[]) throws Exception {

        LinkedListQueue llq = new LinkedListQueue();
        llq.enqueue(1);
        llq.enqueue(2);
        llq.enqueue(3);
        llq.dequeue();
        System.out.println(llq.toString());
    }

    private void enqueue(int data) {
        ListNode node = new ListNode(data);
        if (isEmpty()) {
            front = node;
        } else {
            rear.setNext(node);
        }
        rear = node;
        length++;
    }

    private int dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("queue");
        }
        int result = front.getData();
        front = front.getNext();
        length--;
        if (isEmpty()) {
            rear = null;
        }
        return result;
    }

    private int first() throws Exception {
        if (isEmpty()) {
            throw new Exception();
        }
        return front.getData();
    }

    private boolean isEmpty() {
        return (length == 0);
    }

    private int size() {
        return length;
    }

    public String toString() {
        String result = "";
        ListNode current = front;
        while (current != null) {
            result = result + current.getData() + "\n";
            current = current.getNext();
        }
        return result;
    }
}

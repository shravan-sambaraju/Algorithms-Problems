package datastructures;

public class MyQueue {

  private int size;
  private int queueArray[];
  private int front;
  private int back;
  private int numofItems;

  public MyQueue(int s) {
    size = s;
    queueArray = new int[size];
    front = 0;
    back = -1;
    numofItems = 0;
  }

  public static void main(String[] args) {
    MyQueue queue = new MyQueue(5);
    queue.enqueue(2);
    queue.enqueue(4);
    queue.enqueue(6);
    queue.enqueue(8);
    queue.enqueue(10);

    queue.dequeue();
    queue.dequeue();

    queue.enqueue(12);
    queue.enqueue(14);

    System.out.println("Queue:");
    while (!queue.isEmpty()) {
      System.out.print(queue.dequeue() + " ");
    }
  }

  public void enqueue(int value) {
    if (isFull()) {
      System.err.println("Your queue is full!");
      return;
    }
    if (back == size - 1) {
      back = -1;
    }
    queueArray[++back] = value;
    ++numofItems;
  }

  public int dequeue() {
    if (isEmpty()) {
      System.err.println("Your queue is empty!");
      return -1;
    }
    int tmp = queueArray[front++];
    if (front == size) {
      front = 0;
    }
    numofItems--;
    return tmp;
  }

  public int top() {
    return queueArray[front];
  }

  public boolean isEmpty() {
    return numofItems == 0;
  }

  public boolean isFull() {
    return numofItems == size;
  }

  public int size() {
    return numofItems;
  }
}

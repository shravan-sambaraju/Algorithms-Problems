package problems.queues;

/* Implement dynamic size array queue */

class DynamicSizeArrayQueue {

  private static int CAPACITY = 16;
  private static int MINCAPACITY = 1 << 15;
  private int[] queueRep;
  private int size, front, rear;

  public DynamicSizeArrayQueue() {
    queueRep = new int[CAPACITY];
    size = 0;
    front = 0;
    rear = 0;
  }

  public DynamicSizeArrayQueue(int cap) {
    queueRep = new int[cap];
    size = 0;
    front = 0;
    rear = 0;
  }

  public static void main(String args[]) {

    DynamicSizeArrayQueue darray = new DynamicSizeArrayQueue();
    darray.enQueue(1);
    darray.enQueue(2);
    darray.enQueue(3);
    darray.deQueue();
    System.out.println(darray.toString());
  }

  private void enQueue(int data) throws NullPointerException, IllegalStateException {
    if (size == CAPACITY) {
      expand();
    }
    size++;
    queueRep[rear] = data;
    rear = (rear + 1) % CAPACITY;
  }

  private int deQueue() throws IllegalStateException {
    if (size == 0) {
      throw new IllegalStateException("Queue is empty: Underflow");
    } else {
      size--;
      int data = queueRep[(front % CAPACITY)];
      queueRep[front] = Integer.MIN_VALUE;
      front = (front + 1) % CAPACITY;
      return data;
    }
  }

  private boolean isEmpty() {
    return (size == 0);
  }

  private boolean isFull() {
    return (size == CAPACITY);
  }

  private int size() {
    return size;
  }

  private void expand() {
    int length = size();
    int[] newQueue = new int[length << 1];
    for (int i = front; i <= rear; i++) {
      newQueue[i - front] = queueRep[i % CAPACITY];
    }
    queueRep = newQueue;
    front = 0;
    rear = size - 1;
    CAPACITY *= 2;
  }

  @SuppressWarnings("unused")
  private void shrink() {
    int length = size;
    if (length <= MINCAPACITY || length << 2 >= length) {
      return;
    }

    if (length < MINCAPACITY) {
      length = MINCAPACITY;
    }
    int[] newQueue = new int[length];
    System.arraycopy(queueRep, 0, newQueue, 0, length + 1);
    queueRep = newQueue;
  }

  public String toString() {
    String result = "[";
    for (int i = 0; i < size; i++) {
      result += Integer.toString(queueRep[(front + i) % CAPACITY]);
      if (i < size - 1) {
        result += ", ";
      }
    }
    result += "]";
    return result;
  }
}

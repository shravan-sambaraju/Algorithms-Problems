package problems.queues;



class ListNode {
	 int data;
	 ListNode next;

	 public ListNode() {

		}
		
		public ListNode(int data){
			next =null;
			this.data= data;
		}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public ListNode getNext() {
		return next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}

}

public class LinkedListQueue{
	private int length;
	private ListNode front, rear;

	//  Creates an empty queue.
	public LinkedListQueue(){
		length = 0;
		front = rear = null;
	}

	//  Adds the specified data to the rear of the queue.
	public void enqueue (int data){
		ListNode node = new ListNode(data);
		if (isEmpty())
			front = node;
		else
			rear.setNext (node);
		rear = node;
		length++;
	}

	//  Removes the data at the front of the queue and returns a
	//  reference to it. Throws an Exception if the
	//  queue is empty.

	public int dequeue() throws Exception{
		if (isEmpty())
			throw new Exception ("queue");
		int result = front.getData();
		front = front.getNext();
		length--;
		if (isEmpty())
			rear = null;
		return result;
	}

	//  Returns a reference to the data at the front of the queue.
	//  The data is not removed from the queue.  Throws an
	//  Exception if the queue is empty.  
	public int first() throws Exception{
		if (isEmpty())
			throw new Exception(); 

		return front.getData();
	}

	//  Returns true if this queue is empty and false otherwise. 
	public boolean isEmpty(){
		return (length == 0);
	}

	//  Returns the number of elements in this queue.
	public int size(){
		return length;
	}

	//  Returns a string representation of this queue. 
	public String toString(){
		String result = "";
		ListNode current = front;
		while (current != null){
			result = result + current.getData() + "\n";
			current = current.getNext();
		}
		return result;
	}
	
	public static void main(String args[]) throws Exception{
		
		LinkedListQueue llq = new LinkedListQueue();
		
		llq.enqueue(1);
		llq.enqueue(2);
		llq.enqueue(3);
		llq.dequeue();
		
		System.out.println(llq.toString());
		
	}
}

package datastructures;

// Implement linkedlist

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

public class LinkedListImplementation {

	public LinkedListImplementation() {
		length = 0;
	}

	ListNode head;
	private int length;

	public synchronized ListNode getHead() {
		return head;
	}

	public synchronized void insertAtBegin(ListNode node) {
		node.setNext(head);
		head = node;
		length++;
	}

	public synchronized void insertAtEnd(ListNode node) {
		if (head == null) {
			head = node;
		} else {
			ListNode p, q;
			for (p = head; (q = p.getNext()) != null; p = q)
				;
			p.setNext(node);
		}
		length++;
	}

	public void insert(int data, int position) {

		if (position < 0) {
			position = 0;
		}

		if (position > length) {
			position = length;
		}

		if (head == null) {
			head = new ListNode();
			head.setData(data);
		}

		else if (position == 0) {
			ListNode temp = new ListNode();
			temp.setData(data);
			temp.setNext(head);
			head = temp;
		}

		else {
			ListNode temp = head;
			for (int i = 1; i < position; i += 1) {
				temp = temp.getNext();
			}

			ListNode newNode = new ListNode();
			newNode.setData(data);
			newNode.setNext(temp.getNext());
			temp.setNext(newNode);

		}

		length += 1;

	}

	public synchronized ListNode removeFromBegin() {
		ListNode node = head;
		if (node != null) {
			head = node.getNext();
			node.setNext(null);

		}

		return node;

	}
	
	public synchronized ListNode removeFromEnd(){
		if(head==null){
			return null;
			
		}
		
		ListNode p = head, q=null, next= head.getNext();
		if(next==null){
			head = null;
			return p;
		}
		while((next=p.getNext())!=null){
			q= p;
			p= next;
			
		}
		q.setNext(null);
		
		return p;
	}
	
	public synchronized void removeMatched(ListNode node) {
		if (head == null) 
			return;
		if (node.equals(head)) { 
			head = head.getNext(); 
			length-=1;			
			return;
		}
		ListNode p = head, q = null;
		while((q = p.getNext()) != null) {
			if (node.equals(q)) {
				p.setNext(q.getNext());
				length-=1;				
				return;
			}
			p = q;
		}
	}
	
	public void remove(int position) {
		if (position < 0) {
			position = 0;
		}
		
		if (position >= length) {
			position = length-1;
		}
		
		if (head == null)
			return;
		
		if (position == 0) {
			head = head.getNext();
		}
		else {
			ListNode temp = head;
			for (int i=1; i<position; i+=1) {
				temp = temp.getNext();
			}
			temp.setNext(temp.getNext().getNext());
		}
		length -= 1;
	}
	
	public int getPosition(int data) {

		ListNode temp = head;
		int pos = 0;
		while (temp != null) {
			if (temp.getData() == data) {
				return pos;
			}
			pos += 1;
			temp = temp.getNext();
		}
		return Integer.MIN_VALUE;
	}

	public static void main(String args[]) {

		// insertion code and remove matched

		ListNode node = new ListNode();
		node.setData(1);
		LinkedListImplementation lli = new LinkedListImplementation();
		lli.insertAtBegin(node);
		System.out.println("**** insertion code and remove matched ****");
		System.out.println(node.getData());
		System.out.println(node.getNext());
		System.out.println(lli.length);
		ListNode node1 = new ListNode();
		node1.setData(2);
		lli.insertAtBegin(node1);
		System.out.println(node1.getData());
		System.out.println(node1.getNext().getData());
		System.out.println(node1.getNext().getNext());
		System.out.println(lli.length);
		lli.removeMatched(node1);
		System.out.println(lli.length);
		
		// insertion at the end
		LinkedListImplementation lli1 = new LinkedListImplementation();
		ListNode node2 = new ListNode();
		node2.setData(3);

		lli1.insertAtEnd(node2);
		System.out.println("**** insertion at the end ****");
		System.out.println(node2.getData());
		System.out.println(node2.getNext());
		System.out.println(lli1.length);

		ListNode node3 = new ListNode();
		node3.setData(4);
		lli1.insertAtEnd(node3);
		System.out.println(node2.getData());
		System.out.println(node2.getNext().getData());
		System.out.println(node3.getData());
		System.out.println(node3.getNext());
		System.out.println(lli1.length);

		// insert at position and remove at position and get position
		LinkedListImplementation lli2 = new LinkedListImplementation();
		System.out.println("**** insertion at position ****");
		lli2.insert(5, 0);
		System.out.println(lli2.getHead().getData());
		System.out.println(lli2.getHead().getNext());
		lli2.insert(6, 0);
		System.out.println(lli2.getHead().getData());
		System.out.println(lli2.getHead().getNext().getData());
		lli2.insert(7, 1);
		System.out.println(lli2.getHead().getData());
		System.out.println(lli2.getHead().getNext().getData());
		System.out.println(lli2.getHead().getNext().getNext().getData());
		lli2.insert(8, 1);
		System.out.println(lli2.getHead().getData()+"*");
		System.out.println(lli2.getHead().getNext().getData());
		System.out.println(lli2.getHead().getNext().getNext().getData());
		System.out.println(lli2.getHead().getNext().getNext().getNext().getData());
		lli2.remove(0);
		System.out.println(lli2.getHead().getData()+"*");
		lli2.insert(6, 0);
		System.out.println(lli2.getHead().getData()+"*");
		System.out.println(lli2.getPosition(100));
		System.out.println(lli2.getPosition(6));
		
		//remove from begin and end 
		
		System.out.println("**** remove from begin and end ****");
		System.out.println(lli2.getHead().getData());
		lli2.removeFromBegin();
		System.out.println(lli2.getHead().getData());
		System.out.println(lli2.getHead().getNext().getData());
		System.out.println(lli2.getHead().getNext().getNext().getData());
		System.out.println(lli2.getHead().getNext().getNext().getNext());
		lli2.removeFromEnd();
		System.out.println(lli2.getHead().getData());
		System.out.println(lli2.getHead().getNext().getData());
		System.out.println(lli2.getHead().getNext().getNext());		
	
	}

}

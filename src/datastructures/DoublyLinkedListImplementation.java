package datastructures;

class DLLNode{
	int data;
	DLLNode prev;
	DLLNode next;
	
	public DLLNode(){
		
	}
	public DLLNode(int data){
		this.data = data;
		
	}
	public DLLNode(int data, DLLNode prev, DLLNode next){
		this.data = data;
		this.prev = prev;
		this.next = next;
		
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public DLLNode getPrev() {
		return prev;
	}
	public void setPrev(DLLNode prev) {
		this.prev = prev;
	}
	public DLLNode getNext() {
		return next;
	}
	public void setNext(DLLNode next) {
		this.next = next;
	}

}

public class DoublyLinkedListImplementation {
	private DLLNode head;
	private DLLNode tail;
	private int length;
	

	// Create a new empty list.
	public DoublyLinkedListImplementation() {
		head = new DLLNode(-1,null,null);
		tail = new DLLNode(-1, head, null);
		head.setNext(tail);
		length = 0;
	} 
	public int get(int position) {
		return -1;
	}

	public int getPosition(int data) {
	
		DLLNode temp = head;
		int pos = 0;
		while (temp != null) {
			if (temp.getData() == data) {
			
				return pos;
			}
			pos += 1;
			temp = temp.getNext();
		}
		
		return -1;
	} 

	public int length() {
		return length;
	}

	public void insert(int newValue) {
		DLLNode newNode = new DLLNode(newValue,null,head.getNext());
		newNode.getNext().setPrev(newNode);
		head = newNode;
		length += 1;
	} 

	public void insertAtPosition(int data, int position) {
		if (position < 0) {
			position = 0;
		}
		if (position > length) {
			position = length;
		}


		if (head == null) {
			head = new DLLNode(data);
			tail = head;
		}
		
		else if (position == 0) {
			DLLNode temp = new DLLNode(data);
			temp.next = head;
			head = temp;
		}
	
		else {
			DLLNode temp = head;
			for (int i=1; i<position; i+=1) {
				temp = temp.getNext();
			}
			DLLNode newNode = new DLLNode(data);
			newNode.next = temp.next;
			newNode.prev = temp;
			newNode.next.prev = newNode;
			temp.next = newNode;
		}
		
		length += 1;
	} 
	
	
	public void insertTail(int newValue) {
		DLLNode newNode = new DLLNode(newValue,tail.getPrev(),tail);
		newNode.getPrev().setNext(newNode);
		tail.setPrev(newNode);
		length += 1;
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
			if (head == null)
				tail = null;
		}
		
		else {
			DLLNode temp = head;
			for (int i=1; i<position; i+=1) {
				temp = temp.getNext();
			}
			temp.getNext().setPrev(temp.getPrev());
			temp.getPrev().setNext(temp.getNext());
		}
	
		length -= 1;
	}
	
	  
	
	public synchronized void removeMatched(DLLNode node) {
		if (head == null) 
			return;
		if (node.equals(head)) { 
			head = head.getNext(); 
			if (head == null)
				tail = null;
			return;
		}
		DLLNode p = head;
		while(p != null) {
			if (node.equals(p)) {
				p.prev.next = p.next;
				p.next.prev = p.prev;
				return;
			}
		}
	}
	
	public int removeHead() {
		if (length == 0)
		    return -1;
		DLLNode save = head.getNext();
		head.setNext(save.getNext());
		save.getNext().setPrev(head);
		length -= 1;
		return save.getData();
	} 

	
	public int removeTail() {
		if (length == 0)
			return -1;
		DLLNode save = tail.getPrev();
		tail.setPrev(save.getPrev());
		save.getPrev().setNext(tail);
		length -= 1;
		return save.getData();
	} 

	
	public static void main(String args[]){
		
		// insertion code 
		DoublyLinkedListImplementation dll = new DoublyLinkedListImplementation();
		System.out.println(dll.head.data);
		System.out.println(dll.head.prev);
		System.out.println(dll.head.next.data);
		
		dll.insert(5);
		System.out.println(dll.head.data);
		System.out.println(dll.head.prev);
		System.out.println(dll.head.next.data);
		
		dll.insertTail(6);
		System.out.println(dll.head.data);
		System.out.println(dll.head.prev);
		System.out.println(dll.head.next.data);
		System.out.println(dll.head.next.next.data);
		
	}

	
} 

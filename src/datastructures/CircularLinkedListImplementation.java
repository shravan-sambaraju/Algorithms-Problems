package datastructures;

/* Java implementation of circular linkedlist */

class CircularLinkedListImplementation {

	private class CLLNode {
		private CLLNode next;
		private int data;

		public CLLNode() {
			next = null;
			data = -1;
		}

		public CLLNode(int data) {
			next = null;
			this.data = data;
		}

		private CLLNode getNext() {
			return next;
		}

		private void setNext(CLLNode node) {
			next = node;
		}

		private int getData() {
			return data;
		}

		private void setData(int elem) {
			data = elem;
		}

		public String toString() {
			return Integer.toString(data);
		}
	}

	private CLLNode tail;
	private int length;

	public CircularLinkedListImplementation() {
		tail = null;
		length = 0;
	}

	private void add(int data) {
		addToHead(data);
	}

	private void addToHead(int data) {
		CLLNode temp = new CLLNode(data);
		if (tail == null) {
			tail = temp;
			tail.setNext(tail);
		} else {
			temp.setNext(tail.getNext());
			tail.setNext(temp);
		}
		length++;
	}

	private void addToTail(int data) {
		addToHead(data);
		tail = tail.getNext();
	}

	private int peek() {
		return tail.getNext().getData();
	}

	private int tailPeek() {
		return tail.getData();
	}

	private int removeFromHead() {
		CLLNode temp = tail.getNext();
		if (tail == tail.getNext()) {
			tail = null;
		} else {
			tail.setNext(temp.getNext());
			temp.setNext(null);
		}
		length--;
		return temp.getData();
	}

	private int removeFromTail() {
		if (isEmpty()) {
			return -1;
		}
		CLLNode finger = tail;
		while (finger.getNext() != tail) {
			finger = finger.getNext();
		}

		CLLNode temp = tail;
		if (finger == tail) {
			tail = null;
		} else {
			finger.setNext(tail.getNext());
			tail = finger;
		}
		length--;
		return temp.getData();
	}

	private boolean contains(int data) {
		if (tail == null)
			return false;
		CLLNode finger;
		finger = tail.getNext();
		while (finger != tail && (!(finger.getData() == data))) {
			finger = finger.getNext();
		}
		return finger.getData() == data;
	}

	private int remove(int data) {
		if (tail == null)
			return -1;
		CLLNode finger = tail.getNext();
		CLLNode previous = tail;
		int compares;
		for (compares = 0; compares < length && (!(finger.getData() == data)); compares++) {
			previous = finger;
			finger = finger.getNext();
		}
		if (finger.getData() == data) {
			if (tail == tail.getNext()) {
				tail = null;
			} else {
				if (finger == tail)
					tail = previous;
				previous.setNext(previous.getNext().getNext());
			}
			finger.setNext(null);
			length--;
			return finger.getData();
		} else
			return -1;
	}

	private int size() {
		return length;
	}

	private int length() {
		return length;
	}

	private boolean isEmpty() {
		return tail == null;
	}

	private void clear() {
		length = 0;
		tail = null;
	}

	public String toString() {
		String result = "[";
		if (tail == null) {
			return result + "]";
		}
		result = result + tail.getData();
		CLLNode temp = tail.getNext();
		while (temp != tail) {
			result = result + "," + temp.getData();
			temp = temp.getNext();
		}
		return result + "]";
	}

	public static void main(String args[]) {

		CircularLinkedListImplementation cli = new CircularLinkedListImplementation();
		cli.addToHead(1);
		System.out.println(cli.peek());
		cli.addToHead(2);
		System.out.println(cli.peek());
		System.out.println(cli.toString());
		cli.addToTail(3);
		System.out.println(cli.peek());
		System.out.println(cli.toString());
	}
}

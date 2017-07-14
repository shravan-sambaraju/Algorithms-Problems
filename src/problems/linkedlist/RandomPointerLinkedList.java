package problems.linkedlist;

import java.util.HashMap;
import java.util.Map;

class RandomListNode{
	int data;
	RandomListNode next;
	RandomListNode random;
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public RandomListNode getNext() {
		return next;
	}
	public void setNext(RandomListNode next) {
		this.next = next;
	}
	public RandomListNode getRandom() {
		return random;
	}
	public void setRandom(RandomListNode random) {
		this.random = random;
	}
	
	
}

public class RandomPointerLinkedList {
	
	public RandomListNode cloneUsingCopy(RandomListNode head){
		if(head ==null){
			return head;
		}
		
		RandomListNode current = head;
		while(current!=null){
			RandomListNode temp = new RandomListNode();
			temp.setData(current.getData());
			temp.next = current.next;
			current.next = temp;
			current = current.next.next;
		}
		
		current = head;
		while(current!=null){
			current.next.random = current.random.next;
			current = current.next.next;
			
		}
		
		
		RandomListNode copy = head.next;
		current = head;
		while(current.next!=null){
			RandomListNode temp = current.next;
			current.setNext( current.next.next);
			current = temp;
		}
		
		
		return copy;
		
		
	}
	
	public RandomListNode usingHashMap(RandomListNode head){
		RandomListNode X,Y;
		X= head;
		
		Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
		while(X!=null){
			Y = new RandomListNode();
			Y.setData(X.data);
			Y.setNext(null);
			Y.setRandom(null);
			map.put(X, Y);
			X = X.getNext();
			 }
		X = head;
		while(X!=null){
			Y = map.get(X);
			Y.setData(X.getData());
			Y.setNext(map.get(X.getNext()));
			Y.setRandom(map.get(X.getRandom()));
			X=X.getNext();
			
		}
		
		
		return map.get(head);
		
	}
	
	public static void main(String args[]){
		RandomListNode node = new RandomListNode();
		node.setData(1);
		RandomListNode node2 = new RandomListNode();
		node2.setData(2);
		node.setNext(node2);
		RandomListNode node3 = new RandomListNode();
		node3.setData(3);
		node2.setNext(node3);
		RandomListNode node4 = new RandomListNode();
		node4.setData(4);
		node3.setNext(node4);
		node.setRandom(node3);
		node2.setRandom(node4);
		node3.setRandom(node);
		node4.setRandom(node2);
		
		RandomListNode nodetobeSent = node;
		
		while(node!=null){
			System.out.println(node.getData());
			System.out.println(node.getRandom().getData());
			node = node.next;
		}
		
		System.out.println("*****************");
		
		RandomPointerLinkedList rp = new RandomPointerLinkedList();
		 RandomListNode random =  rp.cloneUsingCopy(nodetobeSent);
		
		while(random!=null){
			System.out.println(random.getData());
			System.out.println(random.getRandom().getData());
			random = random.next;
		}
		
		System.out.println("*****************");
		
		 RandomListNode random2 = rp.usingHashMap(nodetobeSent);
		 
		 while(random2!=null){
				System.out.println(random2.getData());
				System.out.println(random2.getRandom().getData());
				random2 = random2.next;
			}
		
	
	}

}

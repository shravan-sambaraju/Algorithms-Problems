package problems.trees;

import java.util.ArrayList;
import java.util.Stack;

public class InOrderTraversal {

	public static void recursiveInorder(BinaryTreeNode head) {
		if (head != null) {
			recursiveInorder(head.left);
			System.out.println(head.data);
			recursiveInorder(head.right);

		}

	}
	
	public static ArrayList<Integer> iterativeInorder(BinaryTreeNode head){
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(head==null){
			return result;
			
		}
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		BinaryTreeNode current = head;
		boolean done = false;
		while(!done){
            if(current != null){
            	stack.push(current);
                current = current.left;
            }else{
                if(stack.isEmpty())
                    done = true;
                else{
                	current = stack.pop();
                	result.add(current.data);
                    current = current.right;
                }
            }
        }
        return result;
    }
	
	public static void main(String args[]) {
		BinaryTreeNode node = new BinaryTreeNode(1);
		node.left = new BinaryTreeNode(2);
		node.right = new BinaryTreeNode(3);
		node.left.left = new BinaryTreeNode(4);
		node.left.right = new BinaryTreeNode(5);
		node.right.left = new BinaryTreeNode(6);
		node.right.right = new BinaryTreeNode(7);

		System.out.println(iterativeInorder(node).toString());
		recursiveInorder(node);

	}
}
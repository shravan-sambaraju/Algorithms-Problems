package problems.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class FindHeightOfTree {

	public static int getDepthRecursive(BinaryTreeNode head) {
		if (head == null) {
			return 0;
		}

		int leftDepth = getDepthRecursive(head.left);
		int rightDepth = getDepthRecursive(head.right);
		if (leftDepth > rightDepth) {
			return leftDepth + 1;

		} else {
			return rightDepth + 1;
		}

	}
	
	 public static  int maxDepthIterativeUsingStack(BinaryTreeNode root){
	        if(root == null) return 0;
	        Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
	        s.push(root);
	        int maxDepth = 0;
	        BinaryTreeNode prev = null;
	        while(!s.isEmpty()){
	        	BinaryTreeNode curr = s.peek();
	            if(prev == null || prev.left == curr || prev.right == curr){
	                if(curr.left != null) s.push(curr.left);
	                else if(curr.right != null) s.push(curr.right);
	            }else if(curr.left == prev){
	                if(curr.right != null) s.push(curr.right);
	            }else
	                s.pop();
	            prev = curr;
	            if(s.size() > maxDepth)
	                maxDepth = s.size();
	        }
	        return maxDepth;
	    }
	 
	 public static int maxDepthLevelOrder(BinaryTreeNode root){
	    	if(root == null)
	            return 0;
	        int maxDepth = 1;
	        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
	        q.offer(root);
	        q.offer(null);
	        while(!q.isEmpty()){
	        	BinaryTreeNode tmp = q.poll();
	            if(tmp != null){
	                if(tmp.left != null)
	                    q.offer(tmp.left);
	                if(tmp.right != null)
	                    q.offer(tmp.right);
	            }else{
	                if(!q.isEmpty()){
	                    ++maxDepth;
	                    q.offer(null);
	                }
	            }
	        }
	        return maxDepth;
	    }
	
	public static void main(String args[]){
		BinaryTreeNode node = new BinaryTreeNode(1);
		node.left = new BinaryTreeNode(2);
		node.right = new BinaryTreeNode(3);
		node.left.left = new BinaryTreeNode(4);
		node.left.right = new BinaryTreeNode(5);
		node.right.left = new BinaryTreeNode(6);
		node.right.right = new BinaryTreeNode(7);
		node.right.right.left = new BinaryTreeNode(8);
		
		System.out.println(getDepthRecursive(node));
		System.out.println(maxDepthIterativeUsingStack(node));
		System.out.println(maxDepthLevelOrder(node));
		
	}

}

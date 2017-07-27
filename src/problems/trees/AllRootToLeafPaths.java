package problems.trees;

public class AllRootToLeafPaths {
	
	public void printPaths(BinaryTreeNode  root) {
		  int[] path = new int[256];
		  printPaths(root, path, 0);
	}
	private void printPaths(BinaryTreeNode  root, int[] path, int pathLen) {
		if (root == null) return;
		// append this node to the path array
		path[pathLen] = root.data;
		pathLen++;
		// it's a leaf, so print the path that led to here
		if (root.left == null && root.right== null) {
			printArray(path, pathLen);
		}
		else {	// otherwise try both subtrees
			printPaths(root.left, path, pathLen);
			printPaths(root.right, path, pathLen);
		}
	}
	private void printArray(int[] ints, int len) {
		for (int i=0; i<len; i++) {
			System.out.print(ints[i] + " ");
		}
		System.out.println();
	}
	
	 public static void main(String args[]) {
			BinaryTreeNode node = new BinaryTreeNode(1);
			node.left = new BinaryTreeNode(2);
			node.right = new BinaryTreeNode(3);
			node.left.left = new BinaryTreeNode(4);
			node.left.right = new BinaryTreeNode(5);
			node.right.left = new BinaryTreeNode(6);
			node.right.right = new BinaryTreeNode(7);
			
			AllRootToLeafPaths paths = new AllRootToLeafPaths();
			
			paths.printPaths(node);
			
	 }

}

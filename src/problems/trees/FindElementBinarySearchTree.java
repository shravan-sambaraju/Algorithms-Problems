package problems.trees;

public class FindElementBinarySearchTree {

	public BinaryTreeNode find(BinaryTreeNode root, int data) {

		if (root == null) {
			return null;

		}
		if (data == root.data) {
			return root;
		}
		if (data < root.data) {
			return find(root.left, data);

		}
		return find(root.right, data);

	}

	public BinaryTreeNode findLevelOrder(BinaryTreeNode node, int data){
		if(node==null){
			return null;
		}
		while(node!=null){
			if(data==node.data){
				return node;
			}
			else if(data<node.data){
					node = node.left;
			}else{
				node = node.right;
			}
			
		}
		return null;
	}

	public static void main(String args[]) {
		BinaryTreeNode node = new BinaryTreeNode(50);
		node.left = new BinaryTreeNode(30);
		node.right = new BinaryTreeNode(70);
		node.left.left = new BinaryTreeNode(20);
		node.left.right = new BinaryTreeNode(40);
		node.right.left = new BinaryTreeNode(60);
		node.right.right = new BinaryTreeNode(80);

		FindElementBinarySearchTree tree = new FindElementBinarySearchTree();

		System.out.println(tree.find(node, 60).data);
		System.out.println(tree.find(node, 133));
		System.out.println(tree.findLevelOrder(node, 30).data);
		
		

	}

}

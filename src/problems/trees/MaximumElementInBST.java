package problems.trees;

/* Find maximum element in binary search tree */

import common.utils.BinaryTreeNode;

class MaximumElementInBST {

    public static void main(String args[]) {

        BinaryTreeNode node = new BinaryTreeNode(50);
        node.setLeft(new BinaryTreeNode(30));
        node.setRight(new BinaryTreeNode(70));
        node.getLeft().setLeft(new BinaryTreeNode(20));
        node.getLeft().setRight(new BinaryTreeNode(40));
        node.getRight().setLeft(new BinaryTreeNode(60));
        node.getRight().setRight(new BinaryTreeNode(80));

        MaximumElementInBST max = new MaximumElementInBST();
        System.out.println(max.maximumElement(node).getData());
        System.out.println(max.maximumElementLevelOrder(node).getData());
    }

    private BinaryTreeNode maximumElement(BinaryTreeNode node) {
        if (node == null) {
            return node;
        } else {
            if (node.getRight() == null) {
                return node;
            } else {
                return maximumElement(node.getRight());
            }
        }
    }

    private BinaryTreeNode maximumElementLevelOrder(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }
        while (root.getRight() != null) {
            root = root.getRight();
        }
        return root;
    }
}

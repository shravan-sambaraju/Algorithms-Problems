package problems.trees;

/* Find width of binary tree */

import common.utils.BinaryTreeNode;

class WidthOfBinaryTree {

    private static int width(BinaryTreeNode root) {
        int max = 0;
        int height = maxDepthRecursive(root);
        for (int k = 0; k <= height; k++) {
            int tmp = width(root, k);
            if (tmp > max) {
                max = tmp;
            }
        }
        return max;
    }

    private static int width(BinaryTreeNode root, int depth) {
        if (root == null) {
            return 0;
        } else if (depth == 0) {
            return 1;
        } else {
            return width(root.getLeft(), depth - 1) + width(root.getRight(), depth - 1);
        }
    }

    private static int maxDepthRecursive(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepthRecursive(root.getLeft());
        int rightDepth = maxDepthRecursive(root.getRight());
        return (leftDepth > rightDepth) ? leftDepth + 1 : rightDepth + 1;
    }

    public static void main(String args[]) {

        BinaryTreeNode node = new BinaryTreeNode(1);
        node.setLeft(new BinaryTreeNode(2));
        node.setRight(new BinaryTreeNode(3));
        node.getLeft().setLeft(new BinaryTreeNode(4));
        node.getLeft().setRight(new BinaryTreeNode(5));
        node.getRight().setLeft(new BinaryTreeNode(6));
        node.getRight().setRight(new BinaryTreeNode(7));

        System.out.println(width(node));
    }
}

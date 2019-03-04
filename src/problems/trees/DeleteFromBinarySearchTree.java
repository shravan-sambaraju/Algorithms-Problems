package problems.trees;

import common.utils.BinaryTreeNode;

/* Delete a node from binary tree */

class DeleteFromBinarySearchTree {

    private static BinaryTreeNode deleteRecursive(BinaryTreeNode node, int value) {

        BinaryTreeNode temp;
        if (node == null) {
            return null;
        }

        if (value < node.getData()) {
            node.setLeft(deleteRecursive(node.getLeft(), value));

        } else if (value > node.getData()) {
            node.setRight(deleteRecursive(node.getRight(), value));
        } else {
            if (node.getLeft() != null && node.getRight() != null) {
                temp = findMax(node.getLeft());
                node.setData(temp.getData());
                node.setLeft(deleteRecursive(node.getLeft(), node.getData()));

            } else if (node.getLeft() == null && node.getRight() == null) {
                node = null;
            } else {
                temp = node;
                if (node.getLeft() == null && node.getRight() == null) {
                    node = null;
                }

                if (node.getLeft() == null) {
                    node = node.getRight();

                } else if (node.getRight() == null) {
                    node = node.getLeft();
                }
            }
        }

        return node;
    }

    private static BinaryTreeNode findMax(BinaryTreeNode root) {
        BinaryTreeNode leftMax = root;
        while (root.getRight() != null) {
            leftMax = root.getRight();
            root = root.getRight();
        }
        return leftMax;
    }

    public static void main(String args[]) {

        BinaryTreeNode node = new BinaryTreeNode(50);
        node.setLeft(new BinaryTreeNode(30));
        node.setRight(new BinaryTreeNode(70));
        node.getLeft().setLeft(new BinaryTreeNode(20));
        node.getLeft().setRight(new BinaryTreeNode(40));
        node.getRight().setLeft(new BinaryTreeNode(60));
        node.getRight().setRight(new BinaryTreeNode(80));
        node.getRight().getRight().setRight(new BinaryTreeNode(100));

        BinaryTreeNode node2 = new BinaryTreeNode(50);
        node2.setLeft(new BinaryTreeNode(30));
        node2.setRight(new BinaryTreeNode(70));
        node2.getLeft().setLeft(new BinaryTreeNode(20));
        node2.getLeft().setRight(new BinaryTreeNode(40));
        node2.getRight().setLeft(new BinaryTreeNode(60));
        node2.getRight().setRight(new BinaryTreeNode(80));
        node2.getRight().getRight().setRight(new BinaryTreeNode(100));

        BinaryTreeNode node3 = new BinaryTreeNode(50);
        node3.setLeft(new BinaryTreeNode(30));
        node3.setRight(new BinaryTreeNode(70));
        node3.getLeft().setLeft(new BinaryTreeNode(20));
        node3.getLeft().setRight(new BinaryTreeNode(40));
        node3.getRight().setLeft(new BinaryTreeNode(60));
        node3.getRight().getLeft().setLeft(new BinaryTreeNode(55));
        node3.getRight().setRight(new BinaryTreeNode(80));
        node3.getRight().getRight().setRight(new BinaryTreeNode(100));

        BinaryTreeNode leafDeleted = node;
        BinaryTreeNode noRightDeleted = node2;
        BinaryTreeNode twoChildDelete = node3;

        System.out.println(leafDeleted.getRight().getRight().getRight().getData());
        leafDeleted = deleteRecursive(leafDeleted, 100);
        if (null == leafDeleted.getRight().getRight().getRight()) {
            System.out.println("deleted");
        }
        System.out.println(noRightDeleted.getRight().getRight().getData());
        noRightDeleted = deleteRecursive(noRightDeleted, 80);
        System.out.println(noRightDeleted.getRight().getRight().getData());

        System.out.println(twoChildDelete.getRight().getData());
        twoChildDelete = deleteRecursive(twoChildDelete, 70);
        System.out.println(twoChildDelete.getRight().getData());
    }
}

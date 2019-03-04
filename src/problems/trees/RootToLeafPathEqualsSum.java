package problems.trees;

/* Print if root to leaf path equals sum */

import common.utils.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

class RootToLeafPathEqualsSum {

    public static void main(String args[]) {

        BinaryTreeNode node = new BinaryTreeNode(1);
        node.setLeft(new BinaryTreeNode(2));
        node.setRight(new BinaryTreeNode(3));
        node.getLeft().setLeft(new BinaryTreeNode(4));
        node.getLeft().setRight(new BinaryTreeNode(5));
        node.getRight().setLeft(new BinaryTreeNode(6));
        node.getRight().setRight(new BinaryTreeNode(7));

        List<BinaryTreeNode> resultList = new ArrayList<BinaryTreeNode>();
        RootToLeafPathEqualsSum rtsum = new RootToLeafPathEqualsSum();
        boolean result = rtsum.printPath(node, 10, resultList);

        if (result) {
            resultList.forEach(BinaryTreeNode -> System.out.print(BinaryTreeNode.getData() + " "));
        } else {
            System.out.println("No path for sum " + 10);
        }
    }

    private boolean printPath(BinaryTreeNode root, int sum, List<BinaryTreeNode> path) {
        if (root == null) {
            return false;
        }
        if (root.getLeft() == null && root.getRight() == null) {
            if (root.getData() == sum) {
                path.add(root);
                return true;
            } else {
                return false;
            }
        }
        if (printPath(root.getLeft(), sum - root.getData(), path)
            || printPath(root.getRight(), sum - root.getData(), path)) {
            path.add(root);
            return true;
        }
        return false;
    }
}

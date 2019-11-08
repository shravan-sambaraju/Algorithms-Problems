package problems.trees;

/** Find lowest common ancestor of given node */
import common.utils.BinaryTreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class FindLowestCommonAncestor {

  private static BinaryTreeNode lcaRecursion(
      BinaryTreeNode root, BinaryTreeNode n1, BinaryTreeNode n2) {
    if (root == null) {
      return null;
    }
    if (root == n1 || root == n2) {
      return root;
    }

    BinaryTreeNode left = lcaRecursion(root.getLeft(), n1, n2);
    BinaryTreeNode right = lcaRecursion(root.getRight(), n1, n2);

    if (left != null && right != null) {
      return root;
    }
    return left != null ? left : right;
  }

  public static BinaryTreeNode lowestCommonAncestorIterative(
      BinaryTreeNode root, BinaryTreeNode p, BinaryTreeNode q) {

    // Stack for tree traversal
    Deque<BinaryTreeNode> stack = new ArrayDeque<>();

    // HashMap for parent pointers
    Map<BinaryTreeNode, BinaryTreeNode> parent = new HashMap<>();

    parent.put(root, null);
    stack.push(root);

    // Iterate until we find both the nodes p and q
    while (!parent.containsKey(p) || !parent.containsKey(q)) {

      BinaryTreeNode node = stack.pop();

      // While traversing the tree, keep saving the parent pointers.
      if (node.left != null) {
        parent.put(node.left, node);
        stack.push(node.left);
      }
      if (node.right != null) {
        parent.put(node.right, node);
        stack.push(node.right);
      }
    }

    // Ancestors set() for node p.
    Set<BinaryTreeNode> ancestors = new HashSet<>();

    // Process all ancestors for node p using parent pointers.
    while (p != null) {
      ancestors.add(p);
      p = parent.get(p);
    }

    // The first ancestor of q which appears in
    // p's ancestor set() is their lowest common ancestor.
    while (!ancestors.contains(q)) q = parent.get(q);
    return q;
  }

  public static void main(String args[]) {

    BinaryTreeNode node = new BinaryTreeNode(1);
    node.setLeft(new BinaryTreeNode(2));
    node.setRight(new BinaryTreeNode(3));
    node.getLeft().setLeft(new BinaryTreeNode(4));
    node.getLeft().setRight(new BinaryTreeNode(5));
    node.getRight().setLeft(new BinaryTreeNode(6));
    node.getRight().setRight(new BinaryTreeNode(7));

    BinaryTreeNode result = lcaRecursion(node, node.getLeft().getLeft(), node.getRight().getLeft());
    BinaryTreeNode result1 =
        lowestCommonAncestorIterative(node, node.getLeft().getLeft(), node.getRight().getLeft());
    System.out.println(result.getData());
    System.out.println(result1.getData());

    BinaryTreeNode result2 =
        lcaRecursion(node, node.getRight().getLeft(), node.getRight().getRight());
    BinaryTreeNode result3 =
        lowestCommonAncestorIterative(node, node.getRight().getLeft(), node.getRight().getRight());
    System.out.println(result2.getData());
    System.out.println(result3.getData());
  }
}

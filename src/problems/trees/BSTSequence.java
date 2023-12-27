package problems.trees;

/* A binary tree is created using array print all combination of array */
import java.util.ArrayList;
import java.util.LinkedList;

class BSTSequence {

  private static void weaveLists(
      LinkedList<Integer> first,
      LinkedList<Integer> second,
      ArrayList<LinkedList<Integer>> results,
      LinkedList<Integer> prefix) {
    if (first.size() == 0 || second.size() == 0) {
      LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
      result.addAll(first);
      result.addAll(second);
      results.add(result);
      return;
    }
    int headFirst = first.removeFirst();
    prefix.addLast(headFirst);
    weaveLists(first, second, results, prefix);
    prefix.removeLast();
    first.addFirst(headFirst);
    int headSecond = second.removeFirst();
    prefix.addLast(headSecond);
    weaveLists(first, second, results, prefix);
    prefix.removeLast();
    second.addFirst(headSecond);
  }

  private static ArrayList<LinkedList<Integer>> allSequences(TreeNode node) {
    ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();

    if (node == null) {
      result.add(new LinkedList<Integer>());
      return result;
    }

    LinkedList<Integer> prefix = new LinkedList<Integer>();
    prefix.add(node.data);
    ArrayList<LinkedList<Integer>> leftSeq = allSequences(node.left);
    ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.right);
    for (LinkedList<Integer> left : leftSeq) {
      for (LinkedList<Integer> right : rightSeq) {
        ArrayList<LinkedList<Integer>> weaved = new ArrayList<LinkedList<Integer>>();
        weaveLists(left, right, weaved, prefix);
        result.addAll(weaved);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    TreeNode node = new TreeNode(100);
    int[] array = {100, 50, 20, 75, 150, 120, 170};
    for (int a : array) {
      node.insertInOrder(a);
    }
    ArrayList<LinkedList<Integer>> allSeq = allSequences(node);
    for (LinkedList<Integer> list : allSeq) {
      System.out.println(list);
    }
    System.out.println(allSeq.size());
  }

  private static class TreeNode {
    private int data;
    private TreeNode left;
    private TreeNode right;
    private TreeNode parent;
    private int size = 0;

    public TreeNode(int d) {
      data = d;
      size = 1;
    }

    private static TreeNode createMinimalBST(int arr[], int start, int end) {
      if (end < start) {
        return null;
      }
      int mid = (start + end) / 2;
      TreeNode n = new TreeNode(arr[mid]);
      n.setLeftChild(createMinimalBST(arr, start, mid - 1));
      n.setRightChild(createMinimalBST(arr, mid + 1, end));
      return n;
    }

    private static TreeNode createMinimalBST(int array[]) {
      return createMinimalBST(array, 0, array.length - 1);
    }

    private void setLeftChild(TreeNode left) {
      this.left = left;
      if (left != null) {
        left.parent = this;
      }
    }

    private void setRightChild(TreeNode right) {
      this.right = right;
      if (right != null) {
        right.parent = this;
      }
    }

    private void insertInOrder(int d) {
      if (d <= data) {
        if (left == null) {
          setLeftChild(new TreeNode(d));
        } else {
          left.insertInOrder(d);
        }
      } else {
        if (right == null) {
          setRightChild(new TreeNode(d));
        } else {
          right.insertInOrder(d);
        }
      }
      size++;
    }

    private int size() {
      return size;
    }

    private boolean isBST() {
      if (left != null) {
        if (data < left.data || !left.isBST()) {
          return false;
        }
      }

      if (right != null) {
        if (data >= right.data || !right.isBST()) {
          return false;
        }
      }
      return true;
    }

    private int height() {
      int leftHeight = left != null ? left.height() : 0;
      int rightHeight = right != null ? right.height() : 0;
      return 1 + Math.max(leftHeight, rightHeight);
    }

    private TreeNode find(int d) {
      if (d == data) {
        return this;
      } else if (d <= data) {
        return left != null ? left.find(d) : null;
      } else if (d > data) {
        return right != null ? right.find(d) : null;
      }
      return null;
    }
  }
}

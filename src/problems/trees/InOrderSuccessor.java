package problems.trees;

/** Create in order successor if given parent tag */

class InOrderSuccessor {

  private static TreeNode inorderSucc(TreeNode n) {
    if (n == null) {
      return null;
    }

    if (n.parent == null || n.right != null) {
      return leftMostChild(n.right);
    } else {
      TreeNode q = n;
      TreeNode x = q.parent;
      while (x != null && x.left != q) {
        q = x;
        x = x.parent;
      }
      return x;
    }
  }

  public static TreeNode leftMostChild(TreeNode n) {
    if (n == null) {
      return null;
    }
    while (n.left != null) {
      n = n.left;
    }
    return n;
  }

  public static void main(String[] args) {
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    TreeNode root = TreeNode.createMinimalBST(array);
    for (int i = 0; i < array.length; i++) {
      TreeNode node = root.find(array[i]);
      TreeNode next = inorderSucc(node);
      if (next != null) {
        System.out.println(node.data + "->" + next.data);
      } else {
        System.out.println(node.data + "->" + null);
      }
    }
  }

  static class TreeNode {
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

    public static TreeNode createMinimalBST(int array[]) {
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

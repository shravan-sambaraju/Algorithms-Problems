package problems.linkedlists;

/* Merge given sorted linkedlists */
import common.utils.ListNode;

class MergeSortedLinkedLists {

  private static ListNode mergeUsingRecursion(ListNode head, ListNode head1) {
    if (head == null) {
      return head1;
    }
    if (head1 == null) {
      return head;
    }

    ListNode head2 = new ListNode();
    if (head.getData() < head1.getData()) {
      head2 = head;
      head2.setNext(mergeUsingRecursion(head.getNext(), head1));
    } else {
      head2 = head1;
      head2.setNext(mergeUsingRecursion(head, head1.getNext()));
    }
    return head2;
  }

  private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

    ListNode head = new ListNode(0);
    ListNode p = head;

    while (l1 != null || l2 != null) {
      if (l1 != null && l2 != null) {
        if (l1.getData() < l2.getData()) {
          p.setNext(l1);
          l1 = l1.getNext();
        } else {
          p.setNext(l2);
          l2 = l2.getNext();
        }
        p = p.getNext();
      } else if (l1 == null) {
        p.setNext(l2);
        break;
      } else if (l2 == null) {
        p.setNext(l1);
        break;
      }
    }
    return head.getNext();
  }

  public static void main(String args[]) {

    ListNode node = new ListNode();
    node.setData(1);
    ListNode node2 = new ListNode();
    node2.setData(3);
    node.setNext(node2);
    ListNode node3 = new ListNode();
    node3.setData(5);
    node2.setNext(node3);
    ListNode node4 = new ListNode();
    node4.setData(7);
    node3.setNext(node4);
    ListNode node5 = new ListNode();
    node5.setData(9);
    node4.setNext(node5);

    ListNode node11 = new ListNode();
    node11.setData(2);
    ListNode node12 = new ListNode();
    node12.setData(4);
    node11.setNext(node12);
    ListNode node13 = new ListNode();
    node13.setData(6);
    node12.setNext(node13);
    ListNode node14 = new ListNode();
    node14.setData(8);
    node13.setNext(node14);

    /*
     * ListNode sortedNode = mergeUsingRecursion(node, node11);
     *
     * <p>while(sortedNode!=null){ System.out.println(sortedNode.getData()); sortedNode =
     * sortedNode.getNext(); }
     */
    System.out.println("**********");
    ListNode sortedNode2 = mergeTwoLists(node, node11);
    while (sortedNode2 != null) {
      System.out.println(sortedNode2.getData());
      sortedNode2 = sortedNode2.getNext();
    }
  }
}

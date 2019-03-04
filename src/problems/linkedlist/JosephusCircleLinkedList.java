package problems.linkedlist;

/* Implement josephus circle using linkedlist */

import common.utils.ListNode;

class JosephusCircleLinkedList {

  private static void getJosephusPosition(int N, int M) {

    ListNode p = new ListNode();
    ListNode q, n, l;
    p.setData(1);
    n = p;
    l = p;
    for (int i = 2; i <= N; i++) {
      q = new ListNode();
      q.setData(i);
      p.setNext(q);
      p = p.getNext();
    }

    p.setNext(n);
    while (n.getNext() != l) {
      System.out.println(n.getData());
      n = n.getNext();
    }

    for (int count = N; count > 1; --count) {
      for (int i = 0; i < M - 1; ++i) {
        p = p.getNext();
      }
      p.setNext(p.getNext().getNext());
    }
    System.out.println("survivor " + p.getData());
  }

  public static void main(String args[]) {
    getJosephusPosition(9, 4);
  }
}

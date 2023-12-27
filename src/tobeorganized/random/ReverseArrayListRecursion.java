package tobeorganized.random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Java Program to demonstrate how to reverse a List.
 * In this example, you will see two ways to reverse a List,
 * first, using Collections.reverse() method and second
 * by writing your own method using recursion.
 */
public class ReverseArrayListRecursion {

  public static void main(String args[]) {

    List<String> books = new ArrayList<>();
    books.add("Beautiful Code");
    books.add("Clean Code");
    books.add("Working Effectively with Legacy Code");

    System.out.println("Original order of List: " + books);

    // Easy way to reverse a List in Java, use Collections.reverse()
    // method, use this to reverse ArrayList or LinkedList in
    // production
    Collections.reverse(books);

    System.out.println("The reversed List: " + books);

    // Now, let's try to reverse a List using recursion
    List<String> output = reverseListRecursively(books);
    System.out.println("Reversed list reversed again: " + output);
  }

  /*
   * A recursive algorithm to reverse a List in Java
   *
   * @param list
   * @return
   */
  private static List<String> reverseListRecursively(List<String> list) {
    if (list.size() <= 1) {
      return list;
    }

    List<String> reversed = new ArrayList<>();
    reversed.add(list.get(list.size() - 1)); // last element
    reversed.addAll(reverseListRecursively(list.subList(0, list.size() - 1)));
    return reversed;
  }
}

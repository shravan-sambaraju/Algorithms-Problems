package problems.recursion;

/**
 * You have 3 towers and N disks of different sizes which can slide onto any tower. The puzzle
 * starts with disks sorted in ascending order of size from top to bottom (Le., each disk sits on
 * top of an even larger one). You have the following constraints: (1) Only one disk can be moved at
 * a time. (2) A disk is slid off the top of one tower onto another tower. (3) A disk cannot be
 * placed on top of a smaller disk. Write a program to move the disks from the first tower to the
 * last using recursion.
 */
class ToweOfHanoi {
  private static int count = 0;

  private static void makeAMove(int disks, char source, char auxillary, char destination) {
    if (disks == 1) {
      count++;
      System.out.println(source + " ->" + destination);
    } else {
      count++;
      makeAMove(disks - 1, source, destination, auxillary);
      System.out.println(source + "-->" + destination);
      makeAMove(disks - 1, auxillary, source, destination);
    }
  }

  public static void main(String args[]) {
    makeAMove(5, 'A', 'B', 'c');
    System.out.println(count);
  }
}

package problems.recursion;

/* Tower of hanoi using recursion */

public class ToweOfHanoi {
	static int count = 0;

	public static void makeAMove(int disks, char source, char auxillary, char destination) {
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

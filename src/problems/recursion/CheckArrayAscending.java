package problems.recursion;

/* Check if array is sorted in ascending order using recursion */

class CheckArrayAscending {

	private static boolean checkAscending(int[] A, int indexofA) {
		if (A.length == 1 || indexofA < 2) {
			return true;
		}
		return (A[indexofA - 1] < A[indexofA - 2]) ? false : checkAscending(A, indexofA - 1);
	}

	public static void main(String args[]) {
		int[] A = { 1, 2, 3 };
		System.out.println(checkAscending(A, A.length));
	}
}
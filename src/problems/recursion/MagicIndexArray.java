package problems.recursion;

/* Find Magic index array */

public class MagicIndexArray {

	public static int magicSlowUnsorted(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == i) {
				return i;
			}
		}
		return -1;
	}

	public static int magicFastUnsorted(int[] array, int start, int end) {
		if (end < start) {
			return -1;
		}
		int midIndex = (start + end) / 2;
		int midValue = array[midIndex];
		if (midValue == midIndex) {
			return midIndex;
		}
		/* Search left */
		int leftIndex = Math.min(midIndex - 1, midValue);
		int left = magicFastUnsorted(array, start, leftIndex);
		if (left >= 0) {
			return left;
		}

		/* Search right */
		int rightIndex = Math.max(midIndex + 1, midValue);
		int right = magicFastUnsorted(array, rightIndex, end);

		return right;
	}

	public static int magicFastUnsorted(int[] array) {
		return magicFastUnsorted(array, 0, array.length - 1);
	}

	public static int magicSlowSorted(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == i) {
				return i;
			}
		}
		return -1;
	}

	public static int magicFastSorted(int[] array, int start, int end) {
		if (end < start) {
			return -1;
		}
		int mid = (start + end) / 2;
		if (array[mid] == mid) {
			return mid;
		} else if (array[mid] > mid) {
			return magicFastSorted(array, start, mid - 1);
		} else {
			return magicFastSorted(array, mid + 1, end);
		}
	}

	public static int magicFastSorted(int[] array) {
		return magicFastSorted(array, 0, array.length - 1);
	}

	public static void main(String[] args) {

		int a[] = new int[5];// declaration and instantiation
		a[0] = 1;// initialization
		a[1] = 2;
		a[2] = 2;
		a[3] = 4;
		a[4] = 5;

		int a2[] = new int[5];// declaration and instantiation
		a[0] = 4;// initialization
		a[1] = 1;
		a[2] = 3;
		a[3] = 7;
		a[4] = 8;

		System.out.println(magicFastUnsorted(a2));
		System.out.println(magicFastSorted(a));
		System.out.println(magicSlowSorted(a));
		System.out.println(magicSlowSorted(a2));
	}

}

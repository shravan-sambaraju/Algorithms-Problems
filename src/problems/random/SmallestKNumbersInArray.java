package problems.random;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SmallestKNumbersInArray {

	public static class MaxHeapComparator implements Comparator<Integer> {
	    public int compare(Integer x, Integer y) {
	        return y - x;
	    }
	}
	
	public static int[] smallestK(int[] array, int k) {
		if (k <= 0 || k > array.length) {
			throw new IllegalArgumentException();
		}
		
		PriorityQueue<Integer> heap = getKMaxHeap(array, k);
		return heapToIntArray(heap);
	}
	
	/* Convert heap to int array. */
	public static int[] heapToIntArray(PriorityQueue<Integer> heap) {
		int[] array = new int[heap.size()];
		while (!heap.isEmpty()) {
			array[heap.size() - 1] = heap.poll();
		}
		return array;
	}	
	
	/* Create max heap of smallest k elements. */	
	public static PriorityQueue<Integer> getKMaxHeap(int[] array, int k) {
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k, new MaxHeapComparator());
		for (int a : array) {
			if (heap.size() < k) { // If space remaining
				heap.add(a);
			} else if (a < heap.peek()) { // If full and top is small
				heap.poll(); // remove highest
				heap.add(a); // insert new element
			}
		}
		return heap;
	}	

	public static void main(String[] args) {
		int[] array = {1, 5, 2, 9, -1, 11, 6, 13, 15};
		int[] smallest = smallestK(array, 3);
		System.out.println(arrayToString(smallest));
	}
	
	public static String arrayToString(int[] array) {
		if (array == null) return "";
		return arrayToString(array, 0, array.length - 1);
	}
	
	public static String arrayToString(int[] array, int start, int end) {
		StringBuilder sb = new StringBuilder();
		for (int i = start; i <= end; i++) {
			int v = array[i];
			sb.append(v + ", ");
		}
		return sb.toString();
	}	


}
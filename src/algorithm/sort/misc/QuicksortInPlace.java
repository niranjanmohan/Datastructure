package algorithm.sort.misc;

import java.util.Arrays;



public class QuicksortInPlace  {


	public static void sort(Integer[] value) {
		// check for empty or null array
		if (value ==null || value.length==0){
			return;
		}

		quicksort(value,0, value.length - 1);
	}
	public static void main(String[] args){
		//Integer A[] =RandomGen.randArray(20);
		Integer B[] = {3,4,10,20,33,65,12,91,88};
		System.out.println(Arrays.asList(B).toString());
		quicksort(B, 0, B.length-1);
		System.out.println(Arrays.asList(B).toString());

	}

	private static void quicksort(Integer numbers[],int low, int high) {
		int i = low, j = high;
		// Get the pivot element from the middle of the list
		int pivot = numbers[low + (high-low)/2];

		// Divide into two lists
		while (i <= j) {
			// If the current value from the left list is smaller then the pivot
			// element then get the next element from the left list
			while (numbers[i] < pivot) {
				i++;
			}
			// If the current value from the right list is larger then the pivot
			// element then get the next element from the right list
			while (numbers[j] > pivot) {
				j--;
			}

			// If we have found a values in the left list which is larger then
			// the pivot element and if we have found a value in the right list
			// which is smaller then the pivot element then we exchange the
			// values.
			// As we are done we can increase i and j
			if (i <= j) {
				exchange(numbers,i, j);
				i++;
				j--;
			}
		}
		// Recursion
		if (low < j)
			quicksort(numbers,low, j);
		if (i < high)
			quicksort(numbers,i, high);
	}

	private static void exchange(Integer[] numbers,int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
} 
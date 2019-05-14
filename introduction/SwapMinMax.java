package introduction;

import ctciLibrary.AsSortedMethods;

public class SwapMinMax {

	public static int getMinIndex(int[] array) {
		int minIndex = 0;
		for (int i = 1; i < array.length; i++)
			if (array[i] < array[minIndex])
				minIndex = i;
		return minIndex;
	}

	public static int getMaxIndex(int[] array) {
		int maxIndex = 0;
		for (int i = 1; i < array.length; i++)
			if (array[i] > array[maxIndex])
				maxIndex = i;
		return maxIndex;
	}
	
	public static void swap(int[] array, int m, int n) {
		int temp = array[m];
		array[m] = array[n];
		array[n] = temp;
	}
	
	public static void swapMinMax(int[] array) {
		int minIndex = getMinIndex(array);
		int maxIndex = getMaxIndex(array);
		swap(array, minIndex, maxIndex);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = AsSortedMethods.randomArray(10, -10, 10);
		System.out.println(AsSortedMethods.arrayToString(array));
		swapMinMax(array);
		System.out.println(AsSortedMethods.arrayToString(array));
	}

}

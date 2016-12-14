package sorting;

import java.util.Arrays;

public class Sorter {

	/**
	 * this method sorts an integer array from smallest to largest using selection sort
	 * 
	 * @param a
	 *           an int array that will be sorted
	 */
	public static void selection(int[] a) {
		int temp = 0;

		for (int i = 0; i < a.length; i++) {
			for (int j = i; j < a.length; j++) {
				if (a[i] > a[j]) {
					temp = a[j];
					a[j] = a[i];
					a[i] = temp;
				}
			}
		}
	}

	/**
	 * this method sorts an double array from smallest to largest using selection sort
	 * 
	 * @param a
	 *           a double array that will be sorted
	 */
	public static void selection(double[] a) {
		double temp = 0;

		for (int i = 0; i < a.length; i++) {
			for (int j = i; j < a.length; j++) {
				if (a[i] > a[j]) {
					temp = a[j];
					a[j] = a[i];
					a[i] = temp;
				}
			}
		}
	}

	/**
	 * this method sorts an String array from smallest to largest using selection sort
	 * 
	 * @param a
	 *           a String array that will be sorted
	 */
	public static void selection(String[] a) {
		String temp = null;

		for (int i = 0; i < a.length; i++) {
			for (int j = i; j < a.length; j++) {
				if (a[i].compareTo(a[j]) > 0) {
					temp = a[j];
					a[j] = a[i];
					a[i] = temp;
				}

			}

		}

	}

	/**
	 * this method sorts an integer array from smallest to largest using insertion sort
	 * 
	 * @param a
	 *           an integer array that will be sorted
	 */
	public static void insertion(int[] a) {

		int temp = 0;
		int j;

		for (int i = 1; i < a.length; i++) {
			temp = a[i];
			if (a[i] < a[i - 1]) {
				for (j = i - 1; (j >= 0) && a[j] > temp; j--) {
					a[j + 1] = a[j];
				}
				a[j + 1] = temp;
			}
		}
	}

	/**
	 * this method sorts a double array from smallest to largest using insertion sort
	 * 
	 * @param a
	 *           a double array that will be sorted
	 */
	public static void insertion(double[] a) {

		double temp = 0;
		int j;

		for (int i = 1; i < a.length; i++) {
			temp = a[i];
			if (a[i] < a[i - 1]) {
				for (j = i - 1; (j >= 0) && a[j] > temp; j--) {
					a[j + 1] = a[j];
				}
				a[j + 1] = temp;
			}
		}
	}

	/**
	 * this method sorts a String array from smallest to largest using insertion sort
	 * 
	 * @param a
	 *           a String array that will be sorted
	 */
	public static void insertion(String[] a) {

		String temp = null;
		int j;

		for (int i = 1; i < a.length; i++) {
			temp = a[i];
			if (a[i].compareTo(a[i - 1]) < 0) {
				for (j = i - 1; (j >= 0) && a[j].compareTo(temp) > 0; j--) {
					a[j + 1] = a[j];
				}
				a[j + 1] = temp;
			}
		}
	}

	/**
	 * this method sorts a int array using bubble sort
	 * 
	 * @param a
	 *           a int array that will be sorted
	 */
	public static void bubble(int[] a) {
		int temp = 0;
		int counter = 0;

		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a.length - 1 - i; j++) {
				if (a[j] > a[j + 1]) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					counter++;
				}
			}
			if (counter == 0) {
				break;
			}
			counter = 0;
		}
	}

	/**
	 * this method sorts a double array using bubble sort
	 * 
	 * @param a
	 *           a double array that will be sorted
	 */
	public static void bubble(double[] a) {
		double temp = 0;
		int counter = 0;

		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a.length - 1 - i; j++) {
				if (a[j] > a[j + 1]) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					counter++;
				}
			}
			if (counter == 0) {
				break;
			}
			counter = 0;
		}
	}

	/**
	 * this method sorts a String array using bubble sort
	 * 
	 * @param a
	 *           a String array that will be sorted
	 */
	public static void bubble(String[] a) {
		String temp = "";
		int counter = 0;

		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a.length - 1 - i; j++) {
				if (a[j].compareTo(a[j + 1]) > 1) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					counter++;
				}
			}
			if (counter == 0) {
				break;
			}
			counter = 0;
		}
	}

	public static void mergeSort(int[] a){

		if(a.length == 0 || a == null){
			return;
		}
		mergeSortRecursion(a);
	}

	private static void mergeSortRecursion(int[] list) {
		if(list.length > 1){
			int middle = list.length/2;
			int[] partOne = Arrays.copyOfRange(list, 0,middle);
			int[] partTwo = Arrays.copyOfRange(list, middle, middle *2);
			mergeSortRecursion(partOne);
			mergeSortRecursion(partTwo);
			merge(list , partOne , partTwo);
			}
	}

	private static void merge(int[] list, int[] partOne,int[] partTwo){
		int sumOfAllIndex = partOne.length + partTwo.length;
		int index ,indexOne, indexTwo;
		index = indexOne = indexTwo = 0;
		while(index < sumOfAllIndex){
			if((indexOne < partOne.length) &&(indexTwo<partTwo.length)){
				if(partOne[indexOne] < partTwo[indexTwo]){
					list[index] = partOne[indexOne];
					index++;
					indexOne++;
				}
				else{
					list[index] = partTwo[indexTwo];
					index++;
					indexTwo++;
				}
			}
			else{
				if(indexOne >= partOne.length){
					while(indexTwo < partTwo.length){
						list[index] = partTwo[indexTwo];
						index++;
						indexTwo++;
					}
				}
				if(indexTwo >= partTwo.length){
					while(indexOne < partOne.length){
						list[index] = partOne[indexOne];
						indexOne++;
						index++;
					}
				}
			}
		}
	}
}

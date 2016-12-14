package sorting;

import java.util.ArrayList;

public class Sorter {

	/**
	 * Performs a linear sort through an array of ints
	 * 
	 * @param array
	 *           int[] - the array you want to get a value from
	 * @param target
	 *           int - the value of your target
	 * @return the index at which the target occurs
	 */
	public static int linear(int[] array, int target) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == target) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Performs a linear sort through an array of doubles
	 * 
	 * @param array
	 *           double[] - the array you want to get a value from
	 * @param target
	 *           double - the value of your target
	 * @return the index at which the target occurs
	 */
	public static int linear(double[] array, double target) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == target) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Performs a linear sort through an array of Strings
	 * 
	 * @param array
	 *           String[] - the array you want to get a value from
	 * @param target
	 *           String - the value of your target
	 * @return the index at which the target occurs
	 */
	public static int linear(String[] array, String target) {
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(target)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Performs a linear sort through an array of ints
	 * 
	 * @param array
	 *           ArrayList<Integer> - the array you want to get a value from
	 * @param target
	 *           int - the value of your target
	 * @return the index at which the target occurs
	 */
	public static int linear(ArrayList<Integer> array, int target) {
		for (int i = 0; i < array.size(); i++) {
			if (array.get(i) == target) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Feeder method for binary search through an array of ints
	 * 
	 * @param array
	 *           int[] - the array you want to get a value from
	 * @param target
	 *           int - the value of your target
	 * @return the loader method
	 */
	public static int binary(int[] array, int target) {
		return binary(array, target, 0, array.length - 1);
	}

	/**
	 * Feeder method for binary search through an array of doubles
	 * 
	 * @param array
	 *           double[] - the array you want to get a value from
	 * @param target
	 *           double - the value of your target
	 * @return the loader method
	 */
	public static int binary(double[] array, double target) {
		return binary(array, target, 0, array.length - 1);
	}

	/**
	 * Feeder method for binary search through an array of Strings
	 * 
	 * @param array
	 *           String[] - the array you want to get a value from
	 * @param target
	 *           String - the value of your target
	 * @return the loader method
	 */
	public static int binary(String[] array, String target) {
		return binary(array, target, 0, array.length - 1);
	}

	/**
	 * Feeder method for binary search through an array of ints
	 * 
	 * @param array
	 *           ArrayList<Integer> - the array you want to get a value from
	 * @param target
	 *           int - the value of your target
	 * @return the loader method
	 */
	public static int binary(ArrayList<Integer> array, int target) {
		return binary(array, target, 0, array.size() - 1);
	}

	/**
	 * The loader method for binary search through an array of ints
	 * 
	 * @param array
	 *           int[] - the array you want to get a value from
	 * @param target
	 *           int - the value of your target
	 * @param startIndex
	 *           int - the starting index of the current instance of the array
	 * @param endIndex
	 *           int - the ending index of the current instance of the array
	 * @return the index at which the target occurs
	 */
	private static int binary(int[] array, int target, int startIndex, int endIndex) {
		int midpoint = (startIndex + endIndex) / 2;

		if (startIndex > endIndex) {
			return -1;
		}

		if (target == array[midpoint]) {
			return midpoint;
		}
		else if (target > array[midpoint]) {
			return binary(array, target, midpoint + 1, endIndex);
		}
		else if (target < array[midpoint]) {
			return binary(array, target, startIndex, midpoint - 1);
		}

		return -1;
	}

	/**
	 * The loader method for binary search through an array of doubles
	 * 
	 * @param array
	 *           double[] - the array you want to get a value from
	 * @param target
	 *           double - the value of your target
	 * @param startIndex
	 *           int - the starting index of the current instance of the array
	 * @param endIndex
	 *           int - the ending index of the current instance of the array
	 * @return the index at which the target occurs
	 */
	private static int binary(double[] array, double target, int startIndex, int endIndex) {
		int midpoint = (startIndex + endIndex) / 2;

		if (startIndex > endIndex) {
			return -1;
		}

		if (target == array[midpoint]) {
			return midpoint;
		}
		else if (target > array[midpoint]) {
			return binary(array, target, midpoint + 1, endIndex);
		}
		else if (target < array[midpoint]) {
			return binary(array, target, startIndex, midpoint - 1);
		}

		return -1;
	}

	/**
	 * The loader method for binary search through an array of Strings
	 * 
	 * @param array
	 *           String[] - the array you want to get a value from
	 * @param target
	 *           String - the value of your target
	 * @param startIndex
	 *           int - the starting index of the current instance of the array
	 * @param endIndex
	 *           int - the ending index of the current instance of the array
	 * @return the index at which the target occurs
	 */
	private static int binary(String[] array, String target, int startIndex, int endIndex) {
		int midpoint = (startIndex + endIndex) / 2;

		if (startIndex > endIndex) {
			return -1;
		}

		if (target.equals(array[midpoint])) {
			return midpoint;
		}
		else if (target.compareTo(array[midpoint]) > 0) {
			return binary(array, target, midpoint + 1, endIndex);
		}
		else if (target.compareTo(array[midpoint]) < 0) {
			return binary(array, target, startIndex, midpoint - 1);
		}

		return -1;
	}

	/**
	 * The loader method for binary search through an array of ints
	 * 
	 * @param array
	 *           ArrayList<Integer> - the array you want to get a value from
	 * @param target
	 *           int - the value of your target
	 * @param startIndex
	 *           int - the starting index of the current instance of the array
	 * @param endIndex
	 *           int - the ending index of the current instance of the array
	 * @return the index at which the target occurs
	 */
	private static int binary(ArrayList<Integer> array, int target, int startIndex, int endIndex) {
		int midpoint = (startIndex + endIndex) / 2;

		if (startIndex > endIndex) {
			return -1;
		}

		if (target == array.get(midpoint)) {
			return midpoint;
		}
		else if (target > array.get(midpoint)) {
			return binary(array, target, midpoint + 1, endIndex);
		}
		else if (target < array.get(midpoint)) {
			return binary(array, target, startIndex, midpoint - 1);
		}

		return -1;
	}

}

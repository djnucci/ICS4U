package searching;

import java.util.ArrayList;

public class TestingSearching {
	public static void main(String[] args) {
		int[] lotsOfInts = {1, 3, 4, 6, 8, 10, 11, 14, 16, 18, 20, 23, 43};
		ArrayList<Integer> listOfIntegers = new ArrayList<Integer>();
		double[] lotsOfDoubles = {1.0, 3.0, 4.0, 6.0, 8.0, 10.0, 11.0, 14.0, 16.0, 18.0, 20.0, 23.0, 43.0};
		String[] lotsOfStrings = {"Apple", "Banana", "Car", "Dog", "Zebra"};

		for (int i = 0; i < lotsOfInts.length; i++) {
			listOfIntegers.add(lotsOfInts[i]);
		}

		// testing the binary int
		System.out.println("Binary Ints");
		System.out.println(Searcher.binary(lotsOfInts, 6));
		System.out.println(Searcher.binary(lotsOfInts, 43));
		System.out.println(Searcher.binary(lotsOfInts, 7));
		System.out.println();

		// testing the linear int
		System.out.println("Linear Ints");
		System.out.println(Searcher.linear(lotsOfInts, 6));
		System.out.println(Searcher.linear(lotsOfInts, 43));
		System.out.println(Searcher.linear(lotsOfInts, 7));
		System.out.println();

		// testing the binary double
		System.out.println("Binary Doubles");
		System.out.println(Searcher.binary(lotsOfDoubles, 4.0));
		System.out.println(Searcher.binary(lotsOfDoubles, 20.0));
		System.out.println(Searcher.binary(lotsOfDoubles, 7.0));
		System.out.println();

		// testing the linear double
		System.out.println("Linear Doubles");
		System.out.println(Searcher.linear(lotsOfDoubles, 4.0));
		System.out.println(Searcher.linear(lotsOfDoubles, 20.0));
		System.out.println(Searcher.linear(lotsOfDoubles, 7.0));
		System.out.println();

		// testing the binary String
		System.out.println("Binary String");
		System.out.println(Searcher.binary(lotsOfStrings, "Apple"));
		System.out.println(Searcher.binary(lotsOfStrings, "Dog"));
		System.out.println(Searcher.binary(lotsOfStrings, "Thing"));
		System.out.println();

		// testing the linear String
		System.out.println("Linear String");
		System.out.println(Searcher.linear(lotsOfStrings, "Apple"));
		System.out.println(Searcher.linear(lotsOfStrings, "Dog"));
		System.out.println(Searcher.linear(lotsOfStrings, "Thing"));

		// testing the binary int
		System.out.println("Binary Ints");
		System.out.println(Searcher.binary(listOfIntegers, 1));
		System.out.println(Searcher.binary(listOfIntegers, 43));
		System.out.println(Searcher.binary(listOfIntegers, 7));
		System.out.println();

		// testing the linear int
		System.out.println("Linear Ints");
		System.out.println(Searcher.linear(listOfIntegers, 1));
		System.out.println(Searcher.linear(listOfIntegers, 43));
		System.out.println(Searcher.linear(listOfIntegers, 7));
		System.out.println();
	}
}

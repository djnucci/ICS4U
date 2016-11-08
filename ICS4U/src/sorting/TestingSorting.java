package sorting;

public class TestingSorting {
	public static void main(String[] args) {
		int[] lotsOfInts = {1, 3, 4, 6, 8, 10, 11, 14, 16, 18, 20, 23, 43};
		double[] lotsOfDoubles = {1.0, 3.0, 4.0, 6.0, 8.0, 10.0, 11.0, 14.0, 16.0, 18.0, 20.0, 23.0, 43.0};
		String[] lotsOfStrings = {"Apple", "Banana", "Car", "Dog", "Zebra"};

		// testing the binary int
		System.out.println(Sorter.binary(lotsOfInts, 6));
		System.out.println(Sorter.binary(lotsOfInts, 43));
		System.out.println(Sorter.binary(lotsOfInts, 7));
		System.out.println();

		// testing the linear int
		System.out.println(Sorter.linear(lotsOfInts, 6));
		System.out.println(Sorter.linear(lotsOfInts, 43));
		System.out.println(Sorter.linear(lotsOfInts, 7));
		System.out.println();

		// testing the binary double
		System.out.println(Sorter.binary(lotsOfDoubles, 4.0));
		System.out.println(Sorter.binary(lotsOfDoubles, 20.0));
		System.out.println(Sorter.binary(lotsOfDoubles, 7.0));
		System.out.println();

		// testing the linear double
		System.out.println(Sorter.linear(lotsOfDoubles, 4.0));
		System.out.println(Sorter.linear(lotsOfDoubles, 20.0));
		System.out.println(Sorter.linear(lotsOfDoubles, 7.0));
		System.out.println();

		// testing the binary String
		System.out.println(Sorter.binary(lotsOfStrings, "Apple"));
		System.out.println(Sorter.binary(lotsOfStrings, "Dog"));
		System.out.println(Sorter.binary(lotsOfStrings, "Thing"));
		System.out.println();

		// testing the linear String
		System.out.println(Sorter.linear(lotsOfStrings, "Apple"));
		System.out.println(Sorter.linear(lotsOfStrings, "Dog"));
		System.out.println(Sorter.linear(lotsOfStrings, "Thing"));
	}
}

package sorting;

public class MainTestThing {

	public static void main(String[] args) {

		int[] simpleIntArray = {5, 3, 4, 6, 9, 10, 15, 14, 16, 2, 1, 23, 13,-5};
		
		Sorter.mergeSort(simpleIntArray);
		
		for (int i = 0; i < simpleIntArray.length; i++){
			System.out.println(simpleIntArray[i]);
		}
	}
}

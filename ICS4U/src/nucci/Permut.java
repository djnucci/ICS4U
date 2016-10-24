package nucci;

/**
 * StarString.java
 * This program counts up
 * @author Daniel Nucci
 * @version September 14th, 2016
 */

import java.util.Scanner;

public class Permut {

	/**
	 * Main Method
	 * 
	 * @param args
	 *           - String[] an array of Strings passed to the main method
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int numN = 0;
		int numR = 0;

		int ans = 0;

		while (true) {
			while (true) {
				System.out.println("Please enter a number: ");

				try {
					numN = Integer.parseInt(scan.nextLine());
					System.out.println("Please enter another number: ");
					numR = Integer.parseInt(scan.nextLine());
					break;
				} catch (NumberFormatException ie) {
					System.out.println("Try an int next time");
				}

			}
			try {
				ans = permut(numN, numR);
			} catch (StackOverflowError i) {
				System.out.println("That number is too big!");
			}
			System.out.println(numN + "!" + " / (" + numN + "-" + numR + ")! = " + ans);

			System.out.println("Would you like to play again? (type no to end)");

			String input = scan.nextLine();

			if (input.equalsIgnoreCase("no") || input.equalsIgnoreCase("n")) {
				break;
			}

		}
		scan.close();
	}

	/**
	 * this method recursively calls itself to print out stars
	 * 
	 * @param num
	 *           - int the number the user inputed
	 */
	public static int permut(int n, int r) {
		return factorial(n) / factorial(n - r);

	}

	/**
	 * performs a factorial
	 * 
	 * @param num
	 *           int - the number to factorial
	 * @return int - the factorialized number
	 */
	public static int factorial(int num) {
		if (num == 1 || num == 0) {
			return 1;
		}
		return num * factorial(num - 1);

	}
}

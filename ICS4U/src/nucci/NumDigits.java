package nucci;

/**
 * NumDigits.java
 * This program finds the number of digits in a number (defined by the user) through recursion
 * @author Daniel Nucci
 * @version September 13th, 2016
 */

import java.util.Scanner;

public class NumDigits {

	public static int digits = 0;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int numInput = 0;
		while (true) {
			while (true) {
				System.out.println("Please enter a number: ");

				try {
					digits = 0;
					numInput = Integer.parseInt(scan.nextLine());
					break;
				} catch (NumberFormatException ie) {
					System.out.println("Try an int next time");
				}
			}
			numDigits(numInput);

			System.out.println("There are " + digits + " digit(s) in the number " + numInput);
			System.out.println("Would you like to play again? (type no to end)");

			String input = scan.nextLine();

			if (input.equalsIgnoreCase("no") || input.equalsIgnoreCase("n")) {
				break;
			}
		}
		scan.close();
	}

	/**
	 * This method finds the number of digits in a number that is passed into it
	 * 
	 * @param num
	 *           - int the number that is being recursively divided
	 */
	public static void numDigits(int num) {
		digits++;
		if (num / 10 != 0) {
			numDigits(num / 10);
		}
	}
}

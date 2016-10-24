package nucci;

/**
 * TowersOfHanoi.java
 * This program completes the towers of hanoi challenge
 * @author Daniel Nucci
 * @version September 19th, 2016
 */

import java.util.Scanner;

public class TowersOfHanoi {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int discs = 0;

		while (true) {
			while (true) {
				try {
					System.out.print("Enter number of discs: ");
					discs = Integer.parseInt(scan.nextLine());
					break;
				} catch (NumberFormatException ie) {
					System.out.println("Try an int next time");
				}
			}

			TowersOfHanoi.solve(discs, "A", "B", "C");

			System.out.println("Would you like to play again? (type no to end)");

			String input = scan.nextLine();

			if (input.equalsIgnoreCase("no") || input.equalsIgnoreCase("n")) {
				break;
			}
		}
		scan.close();

	}

	/**
	 * This method recursively calculates that moves needed to complete the towers of hanoi
	 * 
	 * @param n
	 *           - int number of discs
	 * @param start
	 *           - String where the disc originated
	 * @param auxiliary
	 *           - String where the disc did not touch
	 * @param end
	 *           - String where the disc ends up
	 */
	public static void solve(int n, String start, String auxiliary, String end) {
		if (n == 1) {
			System.out.println(start + " -> " + end);
		}
		else {
			solve(n - 1, start, end, auxiliary);
			System.out.println(start + " -> " + end);
			solve(n - 1, auxiliary, start, end);
		}
	}
}
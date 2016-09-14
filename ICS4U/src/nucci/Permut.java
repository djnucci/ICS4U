package nucci;

import java.util.Scanner;

/*
 * StarString.java
 * This program counts up, though the use of stars and recursion, from 2 to the power of zero to your number
 * @author Daniel Nucci
 * @version September 14th, 2016
 */

public class Permut {

	/**
	 * Main Method
	 * 
	 * @param args
	 *            - String[] an array of Strings passed to the main method
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
			ans = permut(numN, numR);
			
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
	 *            - int the number the user inputted
	 */
	public static int permut(int n, int r) {
		return factorial(n) / factorial(n - r);
		
	}

	public static int factorial(int num){
		
		if (num == 1){
			return 1;
		}
		return num*factorial(num-1);
		
	}
}

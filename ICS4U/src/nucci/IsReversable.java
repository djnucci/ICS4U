package nucci;

/*
 * IsReversable.java
 * This program finds out if two strings equal each other but reversed
 * @author Daniel Nucci
 * @version September 13th, 2016
 */

import java.util.Scanner;

public class IsReversable {

	public static int digits = 0;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int numInput = 0;

		String word1 = "";
		String word2 = "";

		while (true) {
			while (true) {
				System.out.println("Please enter a word: ");
				word1 = scan.nextLine().trim();
				System.out.println("Please enter another word: ");
				word2 = scan.nextLine().trim();
				try {
					digits = 0;
					numInput = Integer.parseInt(scan.nextLine());
					break;
				} catch (NumberFormatException ie) {
					System.out.println("Try an String next time");
				}
			}
			isReverse(word1, word2);

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
	 *            - int the number that is being recursively divided
	 */
	public static boolean isReverse(String wordForward, String wordBackward) {

		char[] firstWord = reverse(wordBackward);
		char[] secondWord = wordForward.toCharArray();

		if (firstWord == secondWord) {
			return true;
		}
		else {
			return false;
		}
	}

	public static char[] reverse(String wordBackward) {
		char[] newWord = wordBackward.toCharArray();

		return newWord;
	}
}

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

		String word1 = "";
		String word2 = "";
		
		boolean flag = false;

		while (true) {
			while (true) {
				try {
					System.out.println("Please enter a word: ");
					word1 = scan.nextLine().trim();
					System.out.println("Please enter another word: ");
					word2 = scan.nextLine().trim();
					break;
				} catch (NumberFormatException ie) {
					System.out.println("Try an String next time");
				}
			}
			System.out.println(isReverse(word1, word2));

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

		char[] firstWord = reverse(wordBackward).toCharArray();
		char[] secondWord = wordForward.toCharArray();

		if (compareArray(firstWord, secondWord)) {
			return true;
		}
		else {
			return false;
		}
	}

	public static String reverse(String wordBackward) {
	    if ((wordBackward == null) || (wordBackward.length() <= 1)) {
	        return wordBackward;
	    }
	    return reverse(wordBackward.substring(1)) + wordBackward.charAt(0);
	}

	public static boolean compareArray(char[] array1, char[] array2) {
		boolean flag = false;
		if (array1.length == array2.length) {
			for (int i = 0; i < array1.length; i++) {
				if (array1[i] == array2[i]) {
					flag = true;
				}
				else{
					flag = false;
					break;
				}
			}
		}
		else {
			return false;
		}
		return flag;
	}
}

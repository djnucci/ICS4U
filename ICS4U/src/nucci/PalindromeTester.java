package nucci;

import java.util.Scanner;

public class PalindromeTester {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String word1 = "";

		boolean flag = false;

		while (true) {
			while (true) {
				try {
					System.out.println("Please enter a word: ");
					word1 = scan.nextLine().trim();
					break;
				} catch (NumberFormatException ie) {
					System.out.println("Try an String next time");
				}
			}
			if (palindromeTester(word1)) {
				System.out.println(word1 + " is a palindrome.");
			}
			else {
				System.out.println(word1 + " is NOT a palindrome.");
			}

			System.out.println("Would you like to play again? (type no to end)");

			String input = scan.nextLine();

			if (input.equalsIgnoreCase("no") || input.equalsIgnoreCase("n")) {
				break;
			}
		}
		scan.close();
	}

	/**
	 * 
	 * @param word
	 * @return
	 */
	public static boolean palindromeTester(String word) {
		word = word.trim();
		
		String firstHalf = "";
		String secondHalf = "";

		char[] firstWord;
		char[] secondWord;
		
		if (word.length() % 2 == 0) {
			firstHalf = word.substring(0, word.length() / 2);
			secondHalf = word.substring(word.length() / 2, word.length());
		}
		else if (word.length() == 1) {
			firstHalf = word;
			secondHalf = word;
		}
		else {
			firstHalf = word.substring(0, word.length() / 2);
			secondHalf = word.substring((word.length() / 2) + 1, word.length());
		}
		// System.out.println(firstHalf + " " + secondHalf);
		
		firstWord = firstHalf.toCharArray();
		secondWord = reverse(secondHalf).toCharArray();

		if (compareArray(firstWord, secondWord)) {
			return true;
		}
		else {
			return false;
		}
	}

	/*
	public static boolean palindromeTester(char[] word) {
		int numberOfSpaces = 0;
		
		for (int i = 0; i < word.length; i++){
			if (word[i] == ' '){
				numberOfSpaces++;
			}
		} 
		
		char[] spacelessWord = new char[word.length - numberOfSpaces];
		
		for (int i = 0; i < word.length; i++){
			int j = 0; 
			if (word[i] != ' '){
				spacelessWord[j] = word[i];
			}
			else{
				j--;
			}
		}
		
		char[] firstHalf = new char[(spacelessWord.length / 2)];
		char[] secondHalf = new char[(spacelessWord.length / 2) + 10];
		
		if (word.length % 2 == 0) {
			for (int i = 0; i < spacelessWord.length / 2; i++){
				firstHalf[i] = spacelessWord[i];
			}
			for (int i = spacelessWord.length / 2; i < spacelessWord.length; i++){
				secondHalf[i] = spacelessWord[i];
			}
		}
		else if (word.length == 1) {
			firstHalf = spacelessWord;
			secondHalf = spacelessWord;
		}
		else {
			for (int i = 0; i < spacelessWord.length; i++){
				firstHalf[i] = spacelessWord[i];
			}
			for (int i = (spacelessWord.length / 2) + 1; i < spacelessWord.length; i++){
				secondHalf[i] = spacelessWord[i];
			}
		}
		 System.out.println(firstHalf + " " + secondHalf);
		
		if (compareArray(firstHalf, reverse(secondHalf, 0))) {
			return true;
		}
		else {
			return false;
		}
	}
	*/
	
	/**
	 * 
	 * @param wordBackward
	 * @return
	 */
	public static String reverse(String wordBackward) {
		if ((wordBackward == null) || (wordBackward.length() <= 1)) {
			return wordBackward;
		}
		return reverse(wordBackward.substring(1)) + wordBackward.charAt(0);
	}
	
	/*
	public static char[] reverse(char[] array, int i) {
      char[] empty = new char[0];
      if (array.length < 1) {
          System.out.println("you entered empty string");
          return empty;
      }
      char temp;
      temp = array[i];
      array[i] = array[array.length - 1 - i];
      array[array.length - 1 - i] = temp;
      i++;

      if (i >= array.length - 1 - i) {
          return array;
      } else {
          reverse(array, i);
          return array;
      }

  }
 */

	/**
	 * 
	 * @param array1
	 * @param array2
	 * @return
	 */
	public static boolean compareArray(char[] array1, char[] array2) {
		boolean flag = false;

		if (array1.length == array2.length) {
			for (int i = 0; i < array1.length; i++) {
				if (array1[i] == array2[i]) {
					flag = true;
				}
				else {
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

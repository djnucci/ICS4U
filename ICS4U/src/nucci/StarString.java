package nucci;

import java.util.Scanner;

/*
 * StarString.java
 * This program counts up, though the use of stars and recersion, from 2 to the power of zero to your number
 * @author Daniel Nucci
 * @version September 14th, 2016
 */

public class StarString {

	/**
	 * Main Method
	 * 
	 * @param args
	 * 			- String[] an array of Strings passed to the main method
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int numInput = 0;
		
		while(true){
			while(true){
				System.out.println("Please enter a number: ");

				try {
					numInput = Math.abs(Integer.parseInt(scan.nextLine()));
					break;
				} catch (NumberFormatException ie) {
					System.out.println("Try an int next time");
				}
				
				
			}
				starString(numInput);
				System.out.println("Would you like to play again? (type no to end)");
				
				String input = scan.nextLine();
				
				if (input.equalsIgnoreCase("no") || input.equalsIgnoreCase("n")){
					break;
				}
				
			
		}
		scan.close();
	}
	/**
	 * this method recursively calls itself to print out stars
	 * 
	 * @param num
	 * 			- int the number the user inputted
	 */
	public static void starString(int num){
		if (Math.pow(2, num) != 1){
			starString(num - 1);
		}
		for(int i = 0; i < Math.pow(2, num); i++){
			System.out.print("*");
		}
		System.out.println();
	}
}

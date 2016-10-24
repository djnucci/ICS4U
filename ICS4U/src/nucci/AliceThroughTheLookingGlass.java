package nucci;

/**
 * AliceThroughTheLookingGlass.java
 * This program completes the Through the Looking Glass CCC program (WIP)
 * @author Daniel Nucci
 * @version September 29th, 2016
 */

import java.util.Scanner;

public class AliceThroughTheLookingGlass {

	public static boolean[][] array;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int testCases = scan.nextInt();

		int[][] input = new int[3][testCases];

		for (int i = 0; i < testCases; i++) {
			for (int j = 0; j < 3; j++) {
				input[j][i] = scan.nextInt();
			}
		}

		for (int i = 0; i < input[0].length; i++) {

		}

		for (int i = 0; i < testCases; i++) {
			if (array[input[1][i]][input[2][i]]) {
				System.out.println("crystal");
			}
			else {
				System.out.println("empty");
			}
		}

	}

	// 3 * (mag - 1 ^ 5) if, mag >= 2
	// 3 * 1 if, mag = 1

	/*
	 * public static int squareAtX(int mag, int x){ if(mag >= 1){ int power = (int) Math.pow(5.0, mag) - 1; }
	 * 
	 * 
	 * 
	 * }
	 */
}

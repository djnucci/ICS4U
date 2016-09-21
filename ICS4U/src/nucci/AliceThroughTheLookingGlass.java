package nucci;

import java.util.Scanner;

public class AliceThroughTheLookingGlass {
//FIXME im sideways
	public static boolean[][] arrayPrime = {{false, false, false, false, false}, {false, false, false, false, false}, {false, false, false, false, false}, {false, false, true, false, false}, {false, true, true, true, false}, };
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int testCases = scan.nextInt();
		
		int[][] input = new int[3][testCases];
		
		for(int i = 0; i < testCases; i++){
			for(int j = 0; j < 3; j++){
				input[j][i] = scan.nextInt();
			}
		}
		
		for(int i = 0; i < testCases; i++){
				if(arrayPrime[input[1][i]][input[2][i]]){
					System.out.println("crystal");
				}
				else{
					System.out.println("empty");
				}
		}

		
		
	
		
		
	}

}

package competativeProgramming;

import java.util.Scanner;

public class ccc14j2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		scan.nextLine();
		char[] input = scan.nextLine().toCharArray();
		int a = 0;
		int b = 0;
		
		
		for(int i = 0; i < input.length; i++){
			if (input[i] == 'A'){
				a++;
			}
			else if (input[i] == 'B'){
				b++;
			}
		}
		
		if (a > b){
			System.out.println("A");
		}
		else if (a < b){
			System.out.println("B");
		}
		else {
			System.out.println("Tie");
		}
		
	}

}

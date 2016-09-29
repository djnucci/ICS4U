import java.util.ArrayList;
import java.util.Scanner;

public class SchoolSystem {

	public static ArrayList<Student> listOfStudents = new ArrayList<Student>();
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String directoryIndex = "";		
		
		while (true) {
			while (true) {
				try {
					printIntro();
					directoryIndex = scan.nextLine();
					break;
				} catch (NumberFormatException ie) {
					System.out.println("Try an String next time");
				}
			}
		}
			
	}
	
	/**
	 * 
	 */
	public static void addStudent(){
		Scanner scan = new Scanner(System.in);
		
		listOfStudents.trimToSize();
		listOfStudents.add(new Student());
		
		
		System.out.println("Please enter your first name: ");
		listOfStudents.get(listOfStudents.size() - 1).setFirstName(scan.nextLine());
		
		System.out.println("Please enter your last name: ");
		listOfStudents.get(listOfStudents.size() - 1).setLastName(scan.nextLine());
		
		System.out.println("Please enter your birth date (mm/dd/yyyy): ");
		listOfStudents.get(listOfStudents.size() - 1).setBirthDate(scan.nextLine());
		
		System.out.println("Please enter the city you live in: ");
		listOfStudents.get(listOfStudents.size() - 1).setCity(scan.nextLine());
		
		System.out.println("Please enter the province you live in: ");
		listOfStudents.get(listOfStudents.size() - 1).setProvince(scan.nextLine());
		
		System.out.println("Please enter your current street address: ");
		listOfStudents.get(listOfStudents.size() - 1).setStreetAddress(scan.nextLine());
		
		System.out.println("Please enter your postal code (X0X 0X0): ");
		listOfStudents.get(listOfStudents.size() - 1).setPostalCode(scan.nextLine());
		
		System.out.println("Please enter your phone number ((xxx) xxx - xxxx):");
		listOfStudents.get(listOfStudents.size() - 1).setPhoneNumber(scan.nextLine());
	}
	
	/**
	 * 
	 */
	public static void printIntro(){
		System.out.println("School System Database Directions");
		System.out.println("Type ( 1 ) to enter a new student.");
		System.out.println("Type ( 2 ) to print out a single student.");
		System.out.println("Type ( 3 ) to print out the entire directory of students.");
		System.out.println("Type ( 4 ) to ");
		System.out.println("Type ( 5 ) to ");
		System.out.println("Type ( 6 ) to ");
		System.out.println("Type ( 7 ) to ");
		System.out.println("Type ( 8 ) to ");
		System.out.println("Type ( 9 ) to ");
		System.out.println("Type ( 10 ) to ");
	}
	
	

}

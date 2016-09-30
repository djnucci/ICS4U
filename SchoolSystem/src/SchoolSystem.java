import java.util.ArrayList;
import java.util.Scanner;

public class SchoolSystem {

	public static ArrayList<Student> listOfStudents = new ArrayList<Student>();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int directoryIndex = 0;
		int studentNumber = 0;

		while (true) {
			while (true) {
				try {
					printIntro();
					directoryIndex = Integer.parseInt(scan.nextLine());
					break;
				} catch (NumberFormatException ie) {
					System.out.println("Try an int next time");
				}
			}
			if (directoryIndex == 1) {
				addStudent();
			} else if (directoryIndex == 2) {
				System.out.println("What student do you want to print? (number)");
				while (true) {
					try {
						studentNumber = Integer.parseInt(scan.nextLine()) - 1;
						break;
					} catch (NumberFormatException ie) {
						System.out.println("Try an int next time");
					}

				}
				printStudent(studentNumber);
			}
			else if(directoryIndex == 3){
				listOfStudents.trimToSize();
				
				for (int i = 0; i < listOfStudents.size(); i++){
					printStudent(i);
					System.out.println("_______________________________");
				}
			}
			else if(directoryIndex == 4){
				System.out.println("NOT IMPLEMENTED YET");
			}
			else if(directoryIndex == 5){
				System.out.println("NOT IMPLEMENTED YET");
			}
			else if(directoryIndex == 6){
				System.out.println("NOT IMPLEMENTED YET");
			}
			else if(directoryIndex == 7){
				System.out.println("NOT IMPLEMENTED YET");
			}
			else if(directoryIndex == 8){
				System.out.println("NOT IMPLEMENTED YET");
			}
			else if(directoryIndex == 9){
				System.out.println("NOT IMPLEMENTED YET");
			}
			else if(directoryIndex == 10){
				System.out.println("Are you sure?");
				if (scan.nextLine().equalsIgnoreCase("Yes")){
				break;
				}
			}
			else{
				System.out.println("Please enter a correct value.");
			}
			
		}

	}

	/**
	 * 
	 */
	public static void addStudent() {
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
	public static void printIntro() {
		System.out.println("School System Database Directions".toUpperCase());
		System.out.println("\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/");
		System.out.println("Type  ( 1 ) to enter a new student.");
		System.out.println("Type  ( 2 ) to print out a single student.");
		System.out.println("Type  ( 3 ) to print out the entire directory of students.");
		System.out.println("Type  ( 4 ) to " + "DO NOTHING");
		System.out.println("Type  ( 5 ) to " + "DO NOTHING");
		System.out.println("Type  ( 6 ) to " + "DO NOTHING");
		System.out.println("Type  ( 7 ) to " + "DO NOTHING");
		System.out.println("Type  ( 8 ) to " + "DO NOTHING");
		System.out.println("Type  ( 9 ) to " + "DO NOTHING");
		System.out.println("Type ( 10 ) to quit program");
	}

	/**
	 * 
	 * @param i
	 */
	public static void printStudent(int i) {
		System.out.println(listOfStudents.get(i).getFirstName());
		System.out.println(listOfStudents.get(i).getLastName());
		System.out.println(listOfStudents.get(i).getBirthDate());
		System.out.println(listOfStudents.get(i).getCity());
		System.out.println(listOfStudents.get(i).getProvince());
		System.out.println(listOfStudents.get(i).getStreetAddress());
		System.out.println(listOfStudents.get(i).getPostalCode());
		System.out.println(listOfStudents.get(i).getPhoneNumber());
	}

}

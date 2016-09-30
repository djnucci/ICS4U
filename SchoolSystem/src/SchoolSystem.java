import java.util.ArrayList;
import java.util.Collections;
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
				System.out.println("WIP");
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
	 * Appends a student to the global array
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
	 * Prints the introduction to the user
	 */
	public static void printIntro() {
		System.out.println("School System Database Directions".toUpperCase());
		System.out.println("\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/");
		System.out.println("Type  ( 1 ) to enter a new student.");
		System.out.println("Type  ( 2 ) to print out a single student.");
		System.out.println("Type  ( 3 ) to print out the entire directory of students.");
		System.out.println("Type  ( 4 ) to delete a single student.");
		System.out.println("Type  ( 5 ) to " + "DO NOTHING");
		System.out.println("Type  ( 6 ) to " + "DO NOTHING");
		System.out.println("Type  ( 7 ) to " + "DO NOTHING");
		System.out.println("Type  ( 8 ) to " + "DO NOTHING");
		System.out.println("Type  ( 9 ) to " + "DO NOTHING");
		System.out.println("Type ( 10 ) to quit program");
	}

	/**
	 * This prints the student at an index
	 * 
	 * @param i
	 * 		int - index of arraylist
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
	
	/**
	 * This method calls the corresponding method to the number enter by the user
	 * 
	 * @param list
	 * 		ArrayList - the list of students
	 * @param identity
	 * 		int - the sort method you want to call e.g. (1 = first name, 2 = last name, 3 = street address, 4 = city, 5 = provincial , 6 = postal code, 7 = phone number, 8 = birthdate)
	 */
	public static void sortArrayList(ArrayList<?> list, int identity){
		if (identity == 1){
			sortByFirstName(list);
		}
		else if (identity == 2){
			sortByLastName(list);
		}
		else if (identity == 3){
			sortByStreetAddress(list);
		}
		else if (identity == 4){
			sortByCity(list);
		}
		else if (identity == 5){
			sortByProvince(list);
		}
		else if (identity == 6){
			sortByPostalCode(list);
		}
		else if (identity == 7){
			sortByPhoneNumber(list);
		}
		else if (identity == 8){
			sortByBirthDate(list);
		}
		else {
			return;
		}
	}
	
	public static void sortByFirstName(ArrayList<?> list){
		
	}
	public static void sortByLastName(ArrayList<?> list){
		
	}
	public static void sortByStreetAddress(ArrayList<?> list){
		
	}
	public static void sortByCity(ArrayList<?> list){
		
	}
	public static void sortByProvince(ArrayList<?> list){
		
	}
	public static void sortByPostalCode(ArrayList<?> list){
		
	}
	public static void sortByPhoneNumber(ArrayList<?> list){
		
	}
	public static void sortByBirthDate(ArrayList<?> list){
		
	}
	
	public static int binarySearch(ArrayList<?> list){
	
		return -1;
	}

}

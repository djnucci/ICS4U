import java.util.ArrayList;
import java.util.Scanner;

public class SchoolSystem {

	public static ArrayList<Student> listOfStudents = new ArrayList<Student>();

	public static void main(String[] args) {
		@SuppressWarnings("resource")
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
			}
			else if (directoryIndex == 2) {
				System.out.println("What student do you want to print? (number)");
				while (true) {
					try {
						studentNumber = Integer.parseInt(scan.nextLine()) - 1;
						break;
					} catch (NumberFormatException ie) {
						System.out.println("Try an int next time");
					}

				}
				if (listOfStudents.size() > studentNumber && studentNumber != -1) {
					printStudent(studentNumber);
				}
				else {
					System.out.println("Invalid");
				}
			}
			else if (directoryIndex == 3) {
				listOfStudents.trimToSize();

				for (int i = 0; i < listOfStudents.size(); i++) {
					printStudent(i);
					System.out.println("___________________________________");
				}
			}
			else if (directoryIndex == 4) {
				System.out.println("What student do you want to delete? (number)");
				while (true) {
					try {
						studentNumber = Integer.parseInt(scan.nextLine()) - 1;
						break;
					} catch (NumberFormatException ie) {
						System.out.println("Try an int next time");
					}
				}
				if (listOfStudents.size() > studentNumber && studentNumber != -1) {
					printStudent(studentNumber);
					System.out.println("Are you sure you want to delete?");
					if (scan.nextLine().equalsIgnoreCase("Yes")) {
						deleteStudent(studentNumber);
					}
				}
				else {
					System.out.println("Invalid");
				}
			}
			else if (directoryIndex == 5) {
				System.out.println("NOT IMPLEMENTED YET");
			}
			else if (directoryIndex == 6) {
				System.out.println("NOT IMPLEMENTED YET");
			}
			else if (directoryIndex == 7) {
				System.out.println("NOT IMPLEMENTED YET");
			}
			else if (directoryIndex == 8) {
				System.out.println("NOT IMPLEMENTED YET");
			}
			else if (directoryIndex == 9) {
				System.out.println("NOT IMPLEMENTED YET");
			}
			else if (directoryIndex == 10) {
				System.out.println("Are you sure?");
				if (scan.nextLine().equalsIgnoreCase("Yes")) {
					break;
				}
			}
			else {
				System.out.println("Please enter a correct value.");
			}

		}

	}

	/**
	 * Appends a student to the global array
	 */
	public static void addStudent() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		String userInput = "";

		listOfStudents.trimToSize();
		listOfStudents.add(new Student());

		System.out.println("Please enter your first name: ");
		listOfStudents.get(listOfStudents.size() - 1).setFirstName(scan.nextLine());

		System.out.println("Please enter your last name: ");
		listOfStudents.get(listOfStudents.size() - 1).setLastName(scan.nextLine());

		System.out.println("Please enter your birth date (mm/dd/yyyy): ");
		userInput = scan.nextLine();
		if (listOfStudents.get(listOfStudents.size() - 1).varifyBirthDate(userInput)) {
			listOfStudents.get(listOfStudents.size() - 1).setBirthDate(userInput);
		}
		else {
			listOfStudents.remove(listOfStudents.size() - 1);
			System.out.println("Invalid input, please try again.");
			return;
		}

		System.out.println("Please enter the city you live in: ");
		listOfStudents.get(listOfStudents.size() - 1).setCity(scan.nextLine());

		System.out.println("Please enter the province you live in: ");
		listOfStudents.get(listOfStudents.size() - 1).setProvince(scan.nextLine());

		System.out.println("Please enter your current street address: ");
		userInput = scan.nextLine();
		if (listOfStudents.get(listOfStudents.size() - 1).varifyStreetAddress(userInput)) {
			listOfStudents.get(listOfStudents.size() - 1).setStreetAddress(userInput);
		}
		else {
			listOfStudents.remove(listOfStudents.size() - 1);
			System.out.println("Invalid input, please try again.");
			return;
		}

		System.out.println("Please enter your postal code (X1X 1X1): ");
		userInput = scan.nextLine();
		if (listOfStudents.get(listOfStudents.size() - 1).varifyPostalCode(userInput)) {
			listOfStudents.get(listOfStudents.size() - 1).setPostalCode(userInput);
		}
		else {
			listOfStudents.remove(listOfStudents.size() - 1);
			System.out.println("Invalid input, please try again.");
			return;
		}
		System.out.println("Please enter your phone number ((xxx) - xxx - xxxx):");
		userInput = scan.nextLine();
		if (listOfStudents.get(listOfStudents.size() - 1).varifyPhoneNumber(userInput)) {
			listOfStudents.get(listOfStudents.size() - 1).setPhoneNumber(userInput);
		}
		else {
			listOfStudents.remove(listOfStudents.size() - 1);
			System.out.println("Invalid input, please try again.");
			return;
		}
	}

	/**
	 * Prints the introduction to the user
	 */
	private static void printIntro() {
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

	public static void deleteStudent(int index) {
		listOfStudents.remove(index);
	}

	/**
	 * This prints the student at an index
	 * 
	 * @param i
	 *           int - index of arraylist
	 */
	private static void printStudent(int i) {
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
	 *           ArrayList - the list of students
	 * @param identity
	 *           int - the sort method you want to call e.g. (1 = first name, 2 = last name, 3 = street address, 4 = city, 5 = provincial , 6 = postal code, 7 = phone number, 8 = birthdate)
	 */
	private static void sortArrayList(ArrayList<?> list, int identity) {
		if (identity == 1) {
			sortByFirstName(list);
		}
		else if (identity == 2) {
			sortByLastName(list);
		}
		else if (identity == 3) {
			sortByStreetAddress(list);
		}
		else if (identity == 4) {
			sortByCity(list);
		}
		else if (identity == 5) {
			sortByProvince(list);
		}
		else if (identity == 6) {
			sortByPostalCode(list);
		}
		else if (identity == 7) {
			sortByPhoneNumber(list);
		}
		else if (identity == 8) {
			sortByBirthDate(list);
		}
		else {
			return;
		}
	}

	private static void sortByFirstName(ArrayList<?> list) {

	}
	private static void sortByLastName(ArrayList<?> list) {

	}
	private static void sortByStreetAddress(ArrayList<?> list) {

	}
	private static void sortByCity(ArrayList<?> list) {

	}
	private static void sortByProvince(ArrayList<?> list) {

	}
	private static void sortByPostalCode(ArrayList<?> list) {

	}
	private static void sortByPhoneNumber(ArrayList<?> list) {

	}
	private static void sortByBirthDate(ArrayList<?> list) {

	}
	/**
	 * 
	 * @param keyWord
	 * @param list
	 * @param sortMethod
	 * @return
	 */
	private static int binarySearch(String keyWord, ArrayList<Student> studentID, int sortMethod) {
		sortArrayList(studentID, sortMethod);

		return -1;
	}

}

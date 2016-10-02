import java.util.ArrayList;
import java.util.Collections;
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
	private static void sortArrayList(ArrayList<Student> list, int identity) {
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

	/**
	 * this method sorts, by first name, the global arraylist for students
	 * 
	 * @param list
	 *           Arratlist<Student> - the global arraylist
	 */
	private static void sortByFirstName(ArrayList<Student> list) {
		if (list.size() >= 2) {
			for (int i = 0; i < list.size() - 1; i++) {
				for (int j = 0; j < list.size() - 1; j++) {
					if (!areWordsAlphabetised(list.get(j).getFirstName(), list.get(j + 1).getFirstName())) {
						Collections.swap(listOfStudents, j, j + 1);
					}
				}
			}
		}
		else {
			System.out.println("This array only has 1 value, therefore does not need to be sorted");
		}
	}

	/**
	 * this method sorts, by last name, the global arraylist for students
	 * 
	 * @param list
	 *           Arratlist<Student> - the global arraylist
	 */
	private static void sortByLastName(ArrayList<Student> list) {
		if (list.size() >= 2) {
			for (int i = 0; i < list.size() - 1; i++) {
				for (int j = 0; j < list.size() - 1; j++) {
					if (!areWordsAlphabetised(list.get(j).getLastName(), list.get(j + 1).getLastName())) {
						Collections.swap(listOfStudents, j, j + 1);
					}
				}
			}
		}
		else {
			System.out.println("This array only has 1 value, therefore does not need to be sorted");
		}
	}

	/**
	 * this method sorts, by street address, the global arraylist for students
	 * 
	 * @param list
	 *           Arratlist<Student> - the global arraylist
	 */
	private static void sortByStreetAddress(ArrayList<Student> list) {
		if (list.size() >= 2) {
			for (int i = 0; i < list.size() - 1; i++) {
				for (int j = 0; j < list.size() - 1; j++) {
					if (!areWordsAlphabetised(list.get(j).getStreetAddress(), list.get(j + 1).getStreetAddress())) {
						Collections.swap(listOfStudents, j, j + 1);
					}
				}
			}
		}
		else {
			System.out.println("This array only has 1 value, therefore does not need to be sorted");
		}
	}

	/**
	 * this method sorts, by city, the global arraylist for students
	 * 
	 * @param list
	 *           Arratlist<Student> - the global arraylist
	 */
	private static void sortByCity(ArrayList<Student> list) {
		if (list.size() >= 2) {
			for (int i = 0; i < list.size() - 1; i++) {
				for (int j = 0; j < list.size() - 1; j++) {
					if (!areWordsAlphabetised(list.get(j).getCity(), list.get(j + 1).getCity())) {
						Collections.swap(listOfStudents, j, j + 1);
					}
				}
			}
		}
		else {
			System.out.println("This array only has 1 value, therefore does not need to be sorted");
		}
	}

	/**
	 * this method sorts, by province, the global arraylist for students
	 * 
	 * @param list
	 *           Arratlist<Student> - the global arraylist
	 */
	private static void sortByProvince(ArrayList<Student> list) {
		if (list.size() >= 2) {
			for (int i = 0; i < list.size() - 1; i++) {
				for (int j = 0; j < list.size() - 1; j++) {
					if (!areWordsAlphabetised(list.get(j).getProvince(), list.get(j + 1).getProvince())) {
						Collections.swap(listOfStudents, j, j + 1);
					}
				}
			}
		}
		else {
			System.out.println("This array only has 1 value, therefore does not need to be sorted");
		}
	}

	/**
	 * this method sorts, by postal code, the global arraylist for students
	 * 
	 * @param list
	 *           Arratlist<Student> - the global arraylist
	 */
	private static void sortByPostalCode(ArrayList<Student> list) {
		if (list.size() >= 2) {
			for (int i = 0; i < list.size() - 1; i++) {
				for (int j = 0; j < list.size() - 1; j++) {
					if (!areWordsAlphabetised(list.get(j).getPostalCode(), list.get(j + 1).getPostalCode())) {
						Collections.swap(listOfStudents, j, j + 1);
					}
				}
			}
		}
		else {
			System.out.println("This array only has 1 value, therefore does not need to be sorted");
		}
	}

	/**
	 * this method sorts, by phone number, the global arraylist for students
	 * 
	 * @param list
	 *           Arratlist<Student> - the global arraylist
	 */
	private static void sortByPhoneNumber(ArrayList<Student> list) {

	}

	/**
	 * this method sorts, by birthdate, the global arraylist for students
	 * 
	 * @param list
	 *           Arratlist<Student> - the global arraylist
	 */
	private static void sortByBirthDate(ArrayList<Student> list) {

	}

	/**
	 * 
	 * @param keyWord
	 * @param list
	 * @param sortMethod
	 * @return
	 */
	private static int binarySearch(String keyWord, ArrayList<Student> list, int sortMethod) {
		sortArrayList(list, sortMethod);

		return -1;
	}

	/**
	 * This method returns if the first word comes before the second in alpabetical order
	 * 
	 * @param word1
	 *           String - the first word to compare
	 * @param word2
	 *           String - the second word to compare
	 * @return boolean - if the word1 should come before word2 (true if the two equal eachother)
	 */
	public static boolean areWordsAlphabetised(String word1, String word2) {
		char[] splitWord1 = word1.toCharArray();
		char[] splitWord2 = word2.toCharArray();

		if (splitWord1.length > splitWord2.length) {
			for (int i = 0; i < splitWord1.length; i++) {
				if (splitWord1[i] == splitWord2[i]) {
					if (i == splitWord1.length) {
						return true;
					}
					else {
						continue;
					}
				}
				else {
					if (isPrecursor(splitWord1[i], splitWord2[i])) {
						return true;
					}
					else {
						continue;
					}
				}
			}
		}
		else {
			for (int i = 0; i < splitWord2.length; i++) {
				if (splitWord1[i] == splitWord2[i]) {
					if (i == splitWord1.length) {
						return true;
					}
					else {
						continue;
					}
				}
				else {
					if (isPrecursor(splitWord1[i], splitWord2[i])) {
						return true;
					}
					else {
						continue;
					}
				}
			}
		}
		return false;
	}

	/**
	 * Determines if the first char comes before the second (alphanumerically)
	 * 
	 * @param char1
	 *           char - the first char
	 * @param char2
	 *           char - the second char
	 * @return boolean - if the first char comes before the second
	 */
	public static boolean isPrecursor(char c1, char c2) {
		if (c1 != c2) {
			if (c1 == ' ') {
				return true;
			}
			else if (c1 == '0' && (c2 == ' ')) {
				return false;
			}
			else if (c1 == 'z' || c1 == 'Z') {
				return false;
			}
			else if (c1 == '1' && (c2 == ' ' || c2 == '0')) {
				return false;
			}
			else if ((c1 == 'y' || c1 == 'Y') && ((c2 == 'z' || c2 == 'Z'))) {
				return true;
			}
			else if (c1 == '2' && (c2 == ' ' || c2 == '0' || c2 == '1')) {
				return false;
			}
			else if (c1 == '3' && (c2 == ' ' || c2 == '0' || c2 == '1' || c1 == '2')) {
				return false;
			}
			else if ((c1 == 'x' || c1 == 'X') && ((c2 == 'y' || c2 == 'Y') || (c2 == 'z' || c2 == 'Z'))) {
				return true;
			}
			else if (c1 == '4' && (c2 == ' ' || c2 == '0' || c2 == '1' || c2 == '2' || c2 == '3')) {
				return false;
			}
			else if (c1 == '5' && (c2 == ' ' || c2 == '0' || c2 == '1' || c2 == '2' || c2 == '3' || c2 == '4')) {
				return false;
			}
			else if ((c1 == 'w' || c1 == 'W') && ((c2 == 'x' || c2 == 'X') || (c2 == 'y' || c2 == 'Y') || (c2 == 'z' || c2 == 'Z'))) {
				return true;
			}
			else if (c1 == '6' && (c2 == ' ' || c2 == '0' || c2 == '1' || c2 == '2' || c2 == '3' || c2 == '4' || c2 == '5')) {
				return false;
			}
			else if (c1 == '7' && (c2 == ' ' || c2 == '0' || c2 == '1' || c2 == '2' || c2 == '3' || c2 == '4' || c2 == '5' || c2 == '6')) {
				return false;
			}
			else if ((c1 == 'v' || c1 == 'V') && ((c2 == 'w' || c2 == 'W') || (c2 == 'x' || c2 == 'X') || (c2 == 'y' || c2 == 'Y') || (c2 == 'z' || c2 == 'Z'))) {
				return true;
			}
			else if (c1 == '8' && (c2 == ' ' || c2 == '0' || c2 == '1' || c2 == '2' || c2 == '3' || c2 == '4' || c2 == '5' || c2 == '6' || c2 == '7')) {
				return false;
			}
			else if (c1 == '9' && (c2 == ' ' || c2 == '0' || c2 == '1' || c2 == '2' || c2 == '3' || c2 == '4' || c2 == '5' || c2 == '6' || c2 == '7' || c2 == '8')) {
				return false;
			}
			else if ((c1 == 'u' || c1 == 'U') && ((c2 == 'v' || c2 == 'V') || (c2 == 'w' || c2 == 'W') || (c2 == 'x' || c2 == 'X') || (c2 == 'y' || c2 == 'Y') || (c2 == 'z' || c2 == 'Z'))) {
				return true;
			}
			else if ((c1 == 't' || c1 == 'T') && ((c2 == 'u' || c2 == 'U') || (c2 == 'v' || c2 == 'V') || (c2 == 'w' || c2 == 'W') || (c2 == 'x' || c2 == 'X') || (c2 == 'y' || c2 == 'Y') || (c2 == 'z' || c2 == 'Z'))) {
				return true;
			}
			else if ((c1 == 's' || c1 == 'S') && ((c2 == 't' || c2 == 'T') || (c2 == 'u' || c2 == 'U') || (c2 == 'v' || c2 == 'V') || (c2 == 'w' || c2 == 'W') || (c2 == 'x' || c2 == 'X') || (c2 == 'y' || c2 == 'Y') || (c2 == 'z' || c2 == 'Z'))) {
				return true;
			}
			else if ((c1 == 'r' || c1 == 'R') && ((c2 == 's' || c2 == 'S') || (c2 == 't' || c2 == 'T') || (c2 == 'u' || c2 == 'U') || (c2 == 'v' || c2 == 'V') || (c2 == 'w' || c2 == 'W') || (c2 == 'x' || c2 == 'X') || (c2 == 'y' || c2 == 'Y') || (c2 == 'z' || c2 == 'Z'))) {
				return true;
			}
			else if ((c1 == 'q' || c1 == 'Q') && ((c2 == 'r' || c2 == 'R') || (c2 == 's' || c2 == 'S') || (c2 == 't' || c2 == 'T') || (c2 == 'u' || c2 == 'U') || (c2 == 'v' || c2 == 'V') || (c2 == 'w' || c2 == 'W') || (c2 == 'x' || c2 == 'X') || (c2 == 'y' || c2 == 'Y') || (c2 == 'z' || c2 == 'Z'))) {
				return true;
			}
			else if ((c1 == 'p' || c1 == 'P') && ((c2 == 'q' || c2 == 'Q') || (c2 == 'r' || c2 == 'R') || (c2 == 's' || c2 == 'S') || (c2 == 't' || c2 == 'T') || (c2 == 'u' || c2 == 'U') || (c2 == 'v' || c2 == 'V') || (c2 == 'w' || c2 == 'W') || (c2 == 'x' || c2 == 'X') || (c2 == 'y' || c2 == 'Y') || (c2 == 'z' || c2 == 'Z'))) {
				return true;
			}
			else if ((c1 == 'o' || c1 == 'O') && ((c2 == 'p' || c2 == 'P') || (c2 == 'q' || c2 == 'Q') || (c2 == 'r' || c2 == 'R') || (c2 == 's' || c2 == 'S') || (c2 == 't' || c2 == 'T') || (c2 == 'u' || c2 == 'U') || (c2 == 'v' || c2 == 'V') || (c2 == 'w' || c2 == 'W') || (c2 == 'x' || c2 == 'X') || (c2 == 'y' || c2 == 'Y') || (c2 == 'z' || c2 == 'Z'))) {
				return true;
			}
			else if ((c1 == 'n' || c1 == 'N') && ((c2 == 'o' || c2 == 'O') || (c2 == 'p' || c2 == 'P') || (c2 == 'q' || c2 == 'Q') || (c2 == 'r' || c2 == 'R') || (c2 == 's' || c2 == 'S') || (c2 == 't' || c2 == 'T') || (c2 == 'u' || c2 == 'U') || (c2 == 'v' || c2 == 'V') || (c2 == 'w' || c2 == 'W') || (c2 == 'x' || c2 == 'X') || (c2 == 'y' || c2 == 'Y') || (c2 == 'z' || c2 == 'Z'))) {
				return true;
			}
			else if ((c1 == 'm' || c1 == 'M') && ((c2 == 'n' || c2 == 'N') || (c2 == 'o' || c2 == 'O') || (c2 == 'p' || c2 == 'P') || (c2 == 'q' || c2 == 'Q') || (c2 == 'r' || c2 == 'R') || (c2 == 's' || c2 == 'S') || (c2 == 't' || c2 == 'T') || (c2 == 'u' || c2 == 'U') || (c2 == 'v' || c2 == 'V') || (c2 == 'w' || c2 == 'W') || (c2 == 'x' || c2 == 'X') || (c2 == 'y' || c2 == 'Y') || (c2 == 'z' || c2 == 'Z'))) {
				return true;
			}
			else if ((c1 == 'l' || c1 == 'L') && ((c2 == 'm' || c2 == 'M') || (c2 == 'n' || c2 == 'N') || (c2 == 'o' || c2 == 'O') || (c2 == 'p' || c2 == 'P') || (c2 == 'q' || c2 == 'Q') || (c2 == 'r' || c2 == 'R') || (c2 == 's' || c2 == 'S') || (c2 == 't' || c2 == 'T') || (c2 == 'u' || c2 == 'U') || (c2 == 'v' || c2 == 'V') || (c2 == 'w' || c2 == 'W') || (c2 == 'x' || c2 == 'X') || (c2 == 'y' || c2 == 'Y') || (c2 == 'z' || c2 == 'Z'))) {
				return true;
			}
			else if ((c1 == 'k' || c1 == 'K') && ((c2 == 'l' || c2 == 'L') || (c2 == 'm' || c2 == 'M') || (c2 == 'n' || c2 == 'N') || (c2 == 'o' || c2 == 'O') || (c2 == 'p' || c2 == 'P') || (c2 == 'q' || c2 == 'Q') || (c2 == 'r' || c2 == 'R') || (c2 == 's' || c2 == 'S') || (c2 == 't' || c2 == 'T') || (c2 == 'u' || c2 == 'U') || (c2 == 'v' || c2 == 'V') || (c2 == 'w' || c2 == 'W') || (c2 == 'x' || c2 == 'X') || (c2 == 'y' || c2 == 'Y') || (c2 == 'z' || c2 == 'Z'))) {
				return true;
			}
			else if ((c1 == 'j' || c1 == 'J') && ((c2 == 'k' || c2 == 'K') || (c2 == 'l' || c2 == 'L') || (c2 == 'm' || c2 == 'M') || (c2 == 'n' || c2 == 'N') || (c2 == 'o' || c2 == 'O') || (c2 == 'p' || c2 == 'P') || (c2 == 'q' || c2 == 'Q') || (c2 == 'r' || c2 == 'R') || (c2 == 's' || c2 == 'S') || (c2 == 't' || c2 == 'T') || (c2 == 'u' || c2 == 'U') || (c2 == 'v' || c2 == 'V') || (c2 == 'w' || c2 == 'W') || (c2 == 'x' || c2 == 'X') || (c2 == 'y' || c2 == 'Y') || (c2 == 'z' || c2 == 'Z'))) {
				return true;
			}
			else if ((c1 == 'i' || c1 == 'I') && ((c2 == 'j' || c2 == 'J') || (c2 == 'k' || c2 == 'K') || (c2 == 'l' || c2 == 'L') || (c2 == 'm' || c2 == 'M') || (c2 == 'n' || c2 == 'N') || (c2 == 'o' || c2 == 'O') || (c2 == 'p' || c2 == 'P') || (c2 == 'q' || c2 == 'Q') || (c2 == 'r' || c2 == 'R') || (c2 == 's' || c2 == 'S') || (c2 == 't' || c2 == 'T') || (c2 == 'u' || c2 == 'U') || (c2 == 'v' || c2 == 'V') || (c2 == 'w' || c2 == 'W') || (c2 == 'x' || c2 == 'X') || (c2 == 'y' || c2 == 'Y') || (c2 == 'z' || c2 == 'Z'))) {
				return true;
			}
			else if ((c1 == 'a' || c1 == 'A') && (c2 == ' ' || c2 == '0' || c2 == '1' || c2 == '2' || c2 == '3' || c2 == '4' || c2 == '5' || c2 == '6' || c2 == '7' || c2 == '8' || c2 == '9')) {
				return false;
			}
			else if ((c1 == 'b' || c1 == 'B') && (c2 == ' ' || c2 == '0' || c2 == '1' || c2 == '2' || c2 == '3' || c2 == '4' || c2 == '5' || c2 == '6' || c2 == '7' || c2 == '8' || c2 == '9' || (c2 == 'a' || c2 == 'A'))) {
				return false;
			}
			else if ((c1 == 'c' || c1 == 'C') && (c2 == ' ' || c2 == '0' || c2 == '1' || c2 == '2' || c2 == '3' || c2 == '4' || c2 == '5' || c2 == '6' || c2 == '7' || c2 == '8' || c2 == '9' || (c2 == 'a' || c2 == 'A') || (c2 == 'b' || c2 == 'B'))) {
				return false;
			}
			else if ((c1 == 'd' || c1 == 'D') && (c2 == ' ' || c2 == '0' || c2 == '1' || c2 == '2' || c2 == '3' || c2 == '4' || c2 == '5' || c2 == '6' || c2 == '7' || c2 == '8' || c2 == '9' || (c2 == 'a' || c2 == 'A') || (c2 == 'b' || c2 == 'B') || (c2 == 'c' || c2 == 'C'))) {
				return false;
			}
			else if ((c1 == 'e' || c1 == 'E') && (c2 == ' ' || c2 == '0' || c2 == '1' || c2 == '2' || c2 == '3' || c2 == '4' || c2 == '5' || c2 == '6' || c2 == '7' || c2 == '8' || c2 == '9' || (c2 == 'a' || c2 == 'A') || (c2 == 'b' || c2 == 'B') || (c2 == 'c' || c2 == 'C') || (c2 == 'd' || c2 == 'D'))) {
				return false;
			}
			else if ((c1 == 'f' || c1 == 'F') && (c2 == ' ' || c2 == '0' || c2 == '1' || c2 == '2' || c2 == '3' || c2 == '4' || c2 == '5' || c2 == '6' || c2 == '7' || c2 == '8' || c2 == '9' || (c2 == 'a' || c2 == 'A') || (c2 == 'b' || c2 == 'B') || (c2 == 'c' || c2 == 'C') || (c2 == 'd' || c2 == 'D') || (c2 == 'e' || c2 == 'E'))) {
				return false;
			}
			else if ((c1 == 'g' || c1 == 'G') && (c2 == ' ' || c2 == '0' || c2 == '1' || c2 == '2' || c2 == '3' || c2 == '4' || c2 == '5' || c2 == '6' || c2 == '7' || c2 == '8' || c2 == '9' || (c2 == 'a' || c2 == 'A') || (c2 == 'b' || c2 == 'B') || (c2 == 'c' || c2 == 'C') || (c2 == 'd' || c2 == 'D') || (c2 == 'e' || c2 == 'E') || (c2 == 'f' || c2 == 'F'))) {
				return false;
			}
			else if ((c1 == 'h' || c1 == 'H') && (c2 == ' ' || c2 == '0' || c2 == '1' || c2 == '2' || c2 == '3' || c2 == '4' || c2 == '5' || c2 == '6' || c2 == '7' || c2 == '8' || c2 == '9' || (c2 == 'a' || c2 == 'A') || (c2 == 'b' || c2 == 'B') || (c2 == 'c' || c2 == 'C') || (c2 == 'd' || c2 == 'D') || (c2 == 'e' || c2 == 'E') || (c2 == 'f' || c2 == 'F') || (c2 == 'g' || c2 == 'G'))) {
				return false;
			}
			else {
				return true;
			}
		}
		else {
			return false;
		}
	}

}

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * SchoolSystem.java
 * 
 * This class is the main for the SchoolSystem Java project; this program takes information on a student and inputs it into an ArrayList
 * 
 * @author Daniel Nucci
 * @version October 26th, 2016
 */

public class SchoolSystem {

	public static ArrayList<Student> listOfStudents = new ArrayList<Student>();

	public static File file = new File("src/students.txt");
	
	public static boolean firstRead = false;
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		int directoryIndex = 0;
		int studentNumber = 0;
		
		readFromFile();
		firstRead = true;
		while (true) {
			while (true) {
				
				try {
					printIntro();
					directoryIndex = Integer.parseInt(scan.nextLine().trim());
					break;
				} catch (NumberFormatException ie) {
					System.out.println("Please enter a correct value.");
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
						System.out.println("Please enter a correct value.");
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
				if (listOfStudents.size() < 1) {
					System.out.println("There are no students to print.");
				}
				printAllStudents();
			}
			else if (directoryIndex == 4) {
				System.out.println("What student do you want to delete? (number)");
				printAllStudents();
				while (true) {
					try {
						studentNumber = Integer.parseInt(scan.nextLine()) - 1;
						break;
					} catch (NumberFormatException ie) {
						System.out.println("Please enter a correct value.");
					}
				}
				if (listOfStudents.size() > studentNumber && studentNumber != -1) {
					printStudent(studentNumber);
					System.out.println("Are you sure you want to delete?");
					if (scan.nextLine().equalsIgnoreCase("Yes")) {
						System.out.println("Deleting...");
						deleteStudent(studentNumber);
					}
				}
				else {
					System.out.println("Please enter a correct value.");
				}
			}
			else if (directoryIndex == 5) {
				System.out.println("Sorting...");
				if (listOfStudents.size() >= 2) {
					for (int i = 0; i < listOfStudents.size() - 1; i++) {
						for (int j = 0; j < listOfStudents.size() - 1; j++) {
							if (listOfStudents.get(j).compareTo(listOfStudents.get(j + 1)) > 0) {
								Collections.swap(listOfStudents, j, j + 1);
							}
						}
					}
				}
				else {
					System.out.println("This array only has less than 2 values, therefore does not need to be sorted");
				}
			}
			else if (directoryIndex == 6) {
				System.out.println("Writing to file...");
				saveToFile();
			}
			else if (directoryIndex == 7) {
				System.out.println("Reading from file...");
				readFromFile();
			}
			/*
			 * else if (directoryIndex == 8) { System.out.println("NOT IMPLEMENTED YET"); } else if (directoryIndex == 9) { System.out.println("NOT IMPLEMENTED YET"); }
			 */
			else if (directoryIndex == 10) {
				System.out.println("Are you sure?");
				if (scan.nextLine().equalsIgnoreCase("Yes")) {
					saveToFile();
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

		while (true) {
			System.out.println("Please enter your birth date (mm dd yyyy): ");
			userInput = scan.nextLine();
			if (listOfStudents.get(listOfStudents.size() - 1).verifyBirthDate(userInput)) {
				try {
					listOfStudents.get(listOfStudents.size() - 1).setBirthDate(userInput);
					break;
				} catch (InvalidInputException e) {
				}
			}
			else {
				System.out.println("Invalid input, please try again.");
			}
		}

		System.out.println("Please enter the city you live in: ");
		listOfStudents.get(listOfStudents.size() - 1).setCity(scan.nextLine());

		while (true) {
			System.out.println("Please enter the province you live in: ");
			userInput = scan.nextLine();
			if (listOfStudents.get(listOfStudents.size() - 1).varifyProvince(makeProvince(userInput))) {
				try {
					listOfStudents.get(listOfStudents.size() - 1).setProvince(makeProvince(userInput));
					break;
				} catch (InvalidInputException e) {
				}
			}
			else {
				System.out.println("Invalid input, please try again.");
			}
		}

		while (true) {
			System.out.println("Please enter your current street address: ");
			userInput = scan.nextLine();
			if (listOfStudents.get(listOfStudents.size() - 1).verifyStreetAddress(userInput)) {
				try {
					listOfStudents.get(listOfStudents.size() - 1).setStreetAddress(userInput);
					break;
				} catch (InvalidInputException e) {
				}
			}
			else {
				System.out.println("Invalid input, please try again.");
			}
		}

		while (true) {
			System.out.println("Please enter your postal code (X1X 1X1): ");
			userInput = scan.nextLine();
			if (listOfStudents.get(listOfStudents.size() - 1).verifyPostalCode(userInput)) {
				try {
					listOfStudents.get(listOfStudents.size() - 1).setPostalCode(userInput);
					break;
				} catch (InvalidInputException e) {
				}
			}
			else {
				System.out.println("Invalid input, please try again.");
			}
		}

		while (true) {
			System.out.println("Please enter your phone number (### - ### - ####):");
			userInput = scan.nextLine();
			if (listOfStudents.get(listOfStudents.size() - 1).verifyPhoneNumber(userInput)) {
				try {
					listOfStudents.get(listOfStudents.size() - 1).setPhoneNumber(userInput);
					break;
				} catch (InvalidInputException e) {
				}
			}
			else {
				System.out.println("Invalid input, please try again.");
			}
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
		System.out.println("Type  ( 5 ) to sort the entire directory of students");
		System.out.println("Type  ( 6 ) to save all the students");
		System.out.println("Type  ( 7 ) to read from the saved file");
		/*
		 * System.out.println("Type  ( 8 ) to " + "DO NOTHING"); System.out.println("Type  ( 9 ) to " + "DO NOTHING");
		 */
		System.out.println("Type ( 10 ) to quit program");
	}

	/**
	 * Prints the entire array of students
	 */
	public static void printAllStudents() {
		for (int i = 0; i < listOfStudents.size(); i++) {
			System.out.println("Student index number: " + (i + 1));
			printStudent(i);
			if (listOfStudents.size() > 1) {
				System.out.println("___________________________________");
			}
		}
	}

	/**
	 * removes a student at the specified index
	 * 
	 * @param index
	 *           int - the index to delete
	 */
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
		listOfStudents.trimToSize();

		System.out.println("Student number: " + listOfStudents.get(i).getStudentNumber());
		System.out.println("First name: \t" + listOfStudents.get(i).getFirstName());
		System.out.println("Last name: \t" + listOfStudents.get(i).getLastName());
		System.out.println("Birthdate: \t" + listOfStudents.get(i).getBirthDate());
		System.out.println("City: \t\t" + listOfStudents.get(i).getCity());
		System.out.println("Province: \t" + listOfStudents.get(i).getProvince());
		System.out.println("Street address: " + listOfStudents.get(i).getStreetAddress());
		System.out.println("Postal code: \t" + listOfStudents.get(i).getPostalCode());
		System.out.println("Phone number: \t" + listOfStudents.get(i).getPhoneNumber());
	}

	/**
	 * save listOfStudents to a .txt file
	 */
	public static void saveToFile() {
		if (listOfStudents.size() > 0) {
			try {
				FileOutputStream fos = new FileOutputStream(file);
				long largestStudentNumber = -1;
				@SuppressWarnings("resource")
				PrintStream write = new PrintStream(fos);

				if (!file.exists()) {
					file.createNewFile();
				}

				for (int i = 0; i < listOfStudents.size(); i++){
					if (largestStudentNumber < listOfStudents.get(i).getStudentNumber()){
						largestStudentNumber = listOfStudents.get(i).getStudentNumber();
					}
				}
				
				write.println(listOfStudents.size() + ", " + largestStudentNumber);

				for (int i = 0; i < listOfStudents.size(); i++) {
					write.println(listOfStudents.get(i).toString());
				}

			} catch (IOException e) {
			}
		}
		else {
			System.out.println("You have no students to save.");
		}

	}

	/**
	 * makes a Province out of a string
	 * 
	 * @param input
	 *           String - the word to change into a Province
	 * @return Province - the province that corresponds with the string input
	 */
	public static Province makeProvince(String input) {
		switch (input.toLowerCase()) {
			case "ab" :
			case "alberta" :
				return Province.ALBERTA;
			case "bc" :
			case "british columbia" :
			case "britishcolumbia" :
				return Province.BRITISHCOLUMBIA;
			case "mb" :
			case "manitoba" :
				return Province.MANITOBA;
			case "nb" :
			case "new brunswick" :
			case "newbrunswick" :
				return Province.NEWBRUNSWICK;
			case "nl" :
			case "newfoundland and labrador" :
			case "newfoundlandandlabrador" :
				return Province.NEWFOUNDLANDANDLABRADOR;
			case "ns" :
			case "nova socia" :
			case "novascotia" :
				return Province.NOVASCOTIA;
			case "nt" :
			case "northwest territories" :
			case "northwestterritories" :
				return Province.NORTHWESTTERRITORIES;
			case "nu" :
			case "nunavut" :
				return Province.NUNAVUT;
			case "on" :
			case "ontario" :
				return Province.ONTARIO;
			case "pe" :
			case "pei" :
			case "prince edward island" :
			case "princeedwardisland" :
				return Province.PRINCEEDWARDISLAND;
			case "qu" :
			case "quebec" :
				return Province.QUEBEC;
			case "sk" :
			case "saskatchewan" :
				return Province.SASKATCHEWAN;
			case "yt" :
			case "yukon" :
				return Province.YUKON;
			default :
				try {
					throw new InvalidInputException("Invalid province.");
				} catch (InvalidInputException e) {
				}
				return null;
		}
	}

	/**
	 * read all students from the students.txt file
	 */
	public static void readFromFile() {
		ArrayList<Student> tempStudentList = null;

		try {
			@SuppressWarnings({"resource"})
			BufferedReader read = new BufferedReader(new FileReader(file));

			String lineOne = read.readLine();
			String[] splitFile = lineOne.split(", ");
			tempStudentList = new ArrayList<Student>();

			for (int i = 0; i < listOfStudents.size() - 1; i++) {
				listOfStudents.remove(i);
			}

			for (int i = 0; i < Integer.parseInt(splitFile[0]); i++) {
				String[] nextLine = read.readLine().split(", ");

				tempStudentList.add(new Student(nextLine[0], nextLine[1], nextLine[8], nextLine[4], nextLine[7], nextLine[6], makeProvince(nextLine[5]), nextLine[3]));

				tempStudentList.get(i).setStudentNumber(Long.parseLong(nextLine[2]));
			}

		} catch (IOException | InvalidInputException | NullPointerException e) {
		}
		listOfStudents = tempStudentList;

	}
}

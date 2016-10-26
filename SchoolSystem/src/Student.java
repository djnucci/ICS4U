import java.util.Calendar;
import java.util.regex.PatternSyntaxException;

/**
 * Student.java This class is the student class, it has fields for all variables that can be entered into it
 * 
 * @author Daniel Nucci
 * @version October 26th, 2016
 */

public class Student implements Comparable {
	public static final int thisYear = Calendar.getInstance().get(Calendar.YEAR);

	public static long studentConstant = 323000000;

	private String firstName, lastName, streetAddress, city, postalCode, phoneNumber, birthDate;
	private Province province;
	private long studentNumber = studentConstant;

	/**
	 * Default constructor (empty except for a student number)
	 */
	public Student() {
		try {
			setBirthDate("");
		} catch (InvalidInputException e) {
		}
		setCity("");
		setFirstName("");
		setLastName("");
		try {
			setPhoneNumber("");
		} catch (InvalidInputException e) {
		}
		try {
			setPostalCode("");
		} catch (InvalidInputException e) {
		}
		setProvince(Province.ALBERTA);
		try {
			setStreetAddress("");
		} catch (InvalidInputException e) {
		}
		setStudentNumber(++studentNumber);
	}

	/**
	 * Makes a new Student with a first name
	 * 
	 * @param firstName
	 *           String - the student's first name
	 */
	public Student(String firstName) {
		try {
			setBirthDate("");
		} catch (InvalidInputException e) {

		}
		setCity("");
		setFirstName(firstName);
		setLastName("");
		try {
			setPhoneNumber("");
		} catch (InvalidInputException e) {

		}
		try {
			setPostalCode("");
		} catch (InvalidInputException e) {

		}
		setProvince(Province.ALBERTA);
		try {
			setStreetAddress("");
		} catch (InvalidInputException e) {

		}
		setStudentNumber(++studentNumber);
	}

	/**
	 * Makes a new Student with a first name and a last name
	 * 
	 * @param firstName
	 *           String - the student's first name
	 * @param lastName
	 *           String - the student's last name
	 */
	public Student(String firstName, String lastName) {
		try {
			setBirthDate("");
		} catch (InvalidInputException e) {

		}
		setCity("");
		setFirstName(firstName);
		setLastName(lastName);
		try {
			setPhoneNumber("");
		} catch (InvalidInputException e) {

		}
		try {
			setPostalCode("");
		} catch (InvalidInputException e) {

		}
		setProvince(Province.ALBERTA);
		try {
			setStreetAddress("");
		} catch (InvalidInputException e) {

		}
		setStudentNumber(++studentNumber);
	}

	/**
	 * Makes a new Student with a first name, a last name and a birth date
	 * 
	 * @param firstName
	 *           String - the student's first name
	 * @param lastName
	 *           String - the student's last name
	 * @param birth
	 *           String - the student's birth date
	 * @throws InvalidInputException
	 */
	public Student(String firstName, String lastName, String birth) throws InvalidInputException {
		if (verifyBirthDate(birth)) {
			setBirthDate(birth);
		}
		setCity("");
		setFirstName(firstName);
		setLastName(lastName);
		try {
			setPhoneNumber("");
		} catch (InvalidInputException e) {

		}
		try {
			setPostalCode("");
		} catch (InvalidInputException e) {

		}
		setProvince(Province.ALBERTA);
		try {
			setStreetAddress("");
		} catch (InvalidInputException e) {

		}
		setStudentNumber(++studentNumber);
	}

	/**
	 * Makes a new Student with a first name, a last name, a birth date and a home city
	 * 
	 * @param firstName
	 *           String - the student's first name
	 * @param lastName
	 *           String - the student's last name
	 * @param birth
	 *           String - the student's birth date
	 * @param city
	 *           String - the student's home city
	 * @throws InvalidInputException
	 */
	public Student(String firstName, String lastName, String birth, String city) throws InvalidInputException {
		if (verifyBirthDate(birth)) {
			setBirthDate(birth);
		}
		setCity(city);
		setFirstName(firstName);
		setLastName(lastName);
		try {
			setPhoneNumber("");
		} catch (InvalidInputException e) {

		}
		try {
			setPostalCode("");
		} catch (InvalidInputException e) {

		}
		setProvince(Province.ALBERTA);
		try {
			setStreetAddress("");
		} catch (InvalidInputException e) {

		}
		setStudentNumber(++studentNumber);
	}

	/**
	 * Makes a new Student with a first name, a last name, a birth date, a home city and a phone number
	 * 
	 * @param firstName
	 *           String - the student's first name
	 * @param lastName
	 *           String - the student's last name
	 * @param birth
	 *           String - the student's birth date
	 * @param city
	 *           String - the student's home city
	 * @param phoneNumber
	 *           String - the student's phone number
	 * @throws InvalidInputException
	 */
	public Student(String firstName, String lastName, String birth, String city, String phoneNumber) throws InvalidInputException {
		if (verifyBirthDate(birth)) {
			setBirthDate(birth);
		}
		setCity(city);
		setFirstName(firstName);
		setLastName(lastName);
		if (verifyBirthDate(birth)) {
			setPhoneNumber(phoneNumber);
		}
		try {
			setPostalCode("");
		} catch (InvalidInputException e) {

		}
		setProvince(Province.ALBERTA);
		try {
			setStreetAddress("");
		} catch (InvalidInputException e) {

		}
		setStudentNumber(++studentNumber);
	}

	/**
	 * Makes a new Student with a first name, a last name, a birth date, a home city, a phone number and a postal code
	 * 
	 * @param firstName
	 *           String - the student's first name
	 * @param lastName
	 *           String - the student's last name
	 * @param birth
	 *           String - the student's birth date
	 * @param city
	 *           String - the student's home city
	 * @param phoneNumber
	 *           String - the student's phone number
	 * @param postalCode
	 *           String - the student's postal code
	 * @throws InvalidInputException
	 */
	public Student(String firstName, String lastName, String birth, String city, String phoneNumber, String postalCode) throws InvalidInputException {
		if (verifyBirthDate(birth)) {
			setBirthDate(birth);
		}
		setCity(city);
		setFirstName(firstName);
		setLastName(lastName);
		if (verifyBirthDate(birth)) {
			setPhoneNumber(phoneNumber);
		}
		try {
			setPostalCode(postalCode);
		} catch (InvalidInputException e) {

		}
		setProvince(Province.ALBERTA);
		try {
			setStreetAddress("");
		} catch (InvalidInputException e) {

		}
		setStudentNumber(++studentNumber);
	}

	/**
	 * Makes a new Student with a first name, a last name, a birth date, a home city, a phone number, a postal code and a province
	 * 
	 * @param firstName
	 *           String - the student's first name
	 * @param lastName
	 *           String - the student's last name
	 * @param birth
	 *           String - the student's birth date
	 * @param city
	 *           String - the student's home city
	 * @param phoneNumber
	 *           String - the student's phone number
	 * @param postalCode
	 *           String - the student's postal code
	 * @param province
	 *           String - the student's home province
	 * @throws InvalidInputException
	 */
	public Student(String firstName, String lastName, String birth, String city, String phoneNumber, String postalCode, Province province) throws InvalidInputException {
		if (verifyBirthDate(birth)) {
			setBirthDate(birth);
		}
		setCity(city);
		setFirstName(firstName);
		setLastName(lastName);
		if (verifyBirthDate(birth)) {
			setPhoneNumber(phoneNumber);
		}
		try {
			setPostalCode(postalCode);
		} catch (InvalidInputException e1) {
			e1.printStackTrace();
		}
		setProvince(province);
		try {
			setStreetAddress("");
		} catch (InvalidInputException e) {

		}
		setStudentNumber(++studentNumber);
	}

	/**
	 * Makes a new Student with a first name, a last name, a birth date, a home city, a phone number, a postal code, a province and street address
	 * 
	 * @param firstName
	 *           String - the student's first name
	 * @param lastName
	 *           String - the student's last name
	 * @param birth
	 *           String - the student's birth date
	 * @param city
	 *           String - the student's home city
	 * @param phoneNumber
	 *           String - the student's phone number
	 * @param postalCode
	 *           String - the student's postal code
	 * @param province
	 *           String - the student's home province
	 * @param streetAddress
	 *           String - the student's street address
	 * @throws InvalidInputException
	 */
	public Student(String firstName, String lastName, String birth, String city, String phoneNumber, String postalCode, Province province, String streetAddress) throws InvalidInputException {
		if (verifyBirthDate(birth)) {
			setBirthDate(birth);
		}
		setCity(city);
		setFirstName(firstName);
		setLastName(lastName);
		if (verifyPhoneNumber(phoneNumber)) {
			setPhoneNumber(phoneNumber);
		}
		if (verifyPostalCode(postalCode)) {
			setPostalCode(postalCode);
		}
		setPostalCode(postalCode);
		setProvince(province);
		if (verifyStreetAddress(streetAddress)) {
			setStreetAddress(streetAddress);
		}
		setStreetAddress(streetAddress);
		setStudentNumber(++studentNumber);
	}

	/**
	 * Gets the student's birth date
	 * 
	 * @return String - his/her birth date
	 */
	public String getBirthDate() {
		return birthDate;
	}

	/**
	 * Sets the student's birth date
	 * 
	 * @param birthDate
	 *           String - his/her birth date
	 * @throws InvalidInputException
	 */
	public void setBirthDate(String birthDate) throws InvalidInputException {
		if (!verifyBirthDate(birthDate)) {
			throw new InvalidInputException("Invalid Birth Date.");
		}
		this.birthDate = birthDate;
	}

	/**
	 * Makes sure the user inputed student's birth date is the correct formatting
	 * 
	 * @param birthDate
	 *           String - his/her potential birth date
	 * @return boolean - returns if valid
	 */
	public boolean verifyBirthDate(String birthDate) {
		int[] monthLengths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		String[] splitText;
		try {
			splitText = birthDate.split(" ");
		} catch (PatternSyntaxException ie) {
			return false;
		}
		int day, month, year;

		if (splitText.length != 3) {
			return false;
		}

		try {
			day = Integer.parseInt(splitText[1]);
			month = Integer.parseInt(splitText[0]);
			year = Integer.parseInt(splitText[2]);
		} catch (NumberFormatException ie) {
			return false;
		}

		if (year % 4 == 0 && year % 100 != 0 && year % 400 == 0) {
			monthLengths[1] = 29;
		}

		if ((thisYear - year) < 13 || (thisYear - year) > 18) {
			return false;
		}

		if (month > 12 || month <= 0) {
			return false;
		}

		if (monthLengths[month - 1] < day) {
			return false;
		}

		return true;
	}

	/**
	 * Gets the student's city
	 * 
	 * @return String - his/her city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the student's
	 * 
	 * @param city
	 *           String - his/her city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Gets the student's first name
	 * 
	 * @return String - his/her first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the student's first name
	 * 
	 * @param firstName
	 *           String - his/her first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the student's last name
	 * 
	 * @return String - his/her last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the student's last name
	 * 
	 * @param lastName
	 *           String - his/her last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the student's phone number
	 * 
	 * @return String - his/her phone number
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets the student's phone number
	 * 
	 * @param phoneNumber
	 *           String - his/her phone number
	 * @throws InvalidInputException
	 */
	public void setPhoneNumber(String phoneNumber) throws InvalidInputException {
		if (!verifyPhoneNumber(phoneNumber)) {
			throw new InvalidInputException("Invalid Phone Number.");
		}
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Makes sure the user inputed student's phone number is the correct formatting
	 * 
	 * @param phoneNumber
	 *           String - his/her potential phone number
	 * @return boolean - returns if valid
	 */
	public boolean verifyPhoneNumber(String phoneNumber) {
		String[] splitText;
		try {
			splitText = phoneNumber.split(" - ");
		} catch (PatternSyntaxException ie) {
			return false;
		}

		if (splitText.length != 3) {
			return false;
		}

		char[] firstPart = splitText[0].toCharArray();
		int secondPart, thirdPart;

		if (firstPart.length != 3) {
			return false;
		}

		if (!equalsNumber(firstPart[0]) || !equalsNumber(firstPart[1]) || !equalsNumber(firstPart[2])) {
			return false;
		}

		try {
			secondPart = Integer.parseInt(splitText[1]);
			thirdPart = Integer.parseInt(splitText[1]);
		} catch (NumberFormatException ie) {
			return false;
		}

		if (secondPart < 0 || secondPart > 999) {
			return false;
		}

		if (thirdPart < 0 || thirdPart > 9999) {
			return false;
		}

		return true;
	}

	/**
	 * Gets the student's postal code
	 * 
	 * @return String - his/her postal code
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * Sets the student's postal code
	 * 
	 * @param postalCode
	 *           String - his/her postal code
	 * @throws InvalidInputException
	 */
	public void setPostalCode(String postalCode) throws InvalidInputException {
		if (!verifyPostalCode(postalCode)) {
			throw new InvalidInputException("Invalid Postal Code.");
		}
		this.postalCode = postalCode;
	}

	/**
	 * Makes sure the user inputed student's postal code is the correct formatting
	 * 
	 * @param postalCode
	 *           String - his/her potential postal code
	 * @return boolean - returns if valid
	 */
	public boolean verifyPostalCode(String postalCode) {
		String[] splitText = new String[2];
		try {
			splitText = postalCode.split(" ");
		} catch (PatternSyntaxException ie) {
			return false;
		}
		char[] sideOne;
		char[] sideTwo;
		try {
			sideOne = splitText[0].toCharArray();
			sideTwo = splitText[1].toCharArray();
		} catch (ArrayIndexOutOfBoundsException ie) {
			return false;
		}
		if (sideOne.length != 3 || sideTwo.length != 3) {
			return false;
		}

		for (int i = 1; i < (sideOne.length - 1); i++) {
			if (i % 2 == 1) {
				if (!equalsUpperCaseLetter(sideOne[i - 1])) {
					return false;
				}
			}
			else {
				if (!equalsNumber(sideOne[i - 1])) {
					return false;
				}
			}
		}

		for (int i = 1; i < (sideTwo.length - 1); i++) {
			if (i % 2 == 0) {
				if (!equalsUpperCaseLetter(sideTwo[i - 1])) {
					return false;
				}
			}
			else {
				if (!equalsNumber(sideTwo[i - 1])) {
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * Gets the student's province
	 * 
	 * @return Province - his/her province
	 */
	public Province getProvince() {
		return province;
	}

	/**
	 * Sets the student's province
	 * 
	 * @param province
	 *           String - his/her province
	 */
	public void setProvince(Province province) {
		this.province = province;
	}

	/**
	 * Makes sure the user inputed student's street address is the correct formatting
	 * 
	 * @param province
	 * 			Province - his/her potential province
	 * @return boolean - returns if valid
	 */
	public boolean varifyProvince(Province province) {
		if (province.equals(Province.ALBERTA) || province.equals(Province.BRITISHCOLUMBIA) || province.equals(Province.MANITOBA) || province.equals(Province.NEWBRUNSWICK) || province.equals(Province.NEWFOUNDLANDANDLABRADOR) || province.equals(Province.NORTHWESTTERRITORIES) || province.equals(Province.NOVASCOTIA) || province.equals(Province.NUNAVUT) || province.equals(Province.ONTARIO) || province.equals(Province.PRINCEEDWARDISLAND) || province.equals(Province.QUEBEC) || province.equals(Province.SASKATCHEWAN) || province.equals(Province.YUKON)) {
			return true;
		}
		return false;
	}

	/**
	 * Gets the student's street address
	 * 
	 * @return String - his/her street address
	 */
	public String getStreetAddress() {
		return streetAddress;
	}

	/**
	 * Sets the student's street address
	 * 
	 * @param streetAddress
	 *           String - his/her street address
	 * @throws InvalidInputException
	 */
	public void setStreetAddress(String streetAddress) throws InvalidInputException {
		if (!verifyStreetAddress(streetAddress)) {
			throw new InvalidInputException("Invalid Street Address.");
		}
		this.streetAddress = streetAddress;
	}

	/**
	 * Makes sure the user inputed student's street address is the correct formatting
	 * 
	 * @param streetAddress
	 *           String - his/her potential street address
	 * @return boolean - returns if valid
	 */
	public boolean verifyStreetAddress(String streetAddress) {
		String[] splitText;
		try {
			splitText = streetAddress.split(" ");
		} catch (PatternSyntaxException ie) {
			return false;
		}
		if (splitText.length < 2) {
			return false;
		}
		try {
			Integer.parseInt(splitText[0]);
		} catch (NumberFormatException ie) {
			return false;
		}
		return true;
	}

	/**
	 * Sets the student's student number
	 * 
	 * @param studentNumber
	 *           long - the students number value
	 */
	public void setStudentNumber(long studentNumber) {
		this.studentNumber = studentNumber;
		studentConstant++;
	}

	/**
	 * Gets the student's student number
	 * 
	 * @return long - the student's number
	 */
	public long getStudentNumber() {
		return studentNumber;
	}

	/**
	 * This method check to see if a char equals an upper case letter
	 * 
	 * @param letter
	 *           char - the char in question
	 * @return boolean - true if a letter, false if not
	 */
	public static boolean equalsUpperCaseLetter(char letter) {
		if (letter == 'A' || letter == 'B' || letter == 'C' || letter == 'D' || letter == 'E' || letter == 'F' || letter == 'G' || letter == 'H' || letter == 'I' || letter == 'J' || letter == 'K' || letter == 'L' || letter == 'M' || letter == 'N' || letter == 'O' || letter == 'P' || letter == 'Q' || letter == 'R' || letter == 'S' || letter == 'T' || letter == 'U' || letter == 'V' || letter == 'W' || letter == 'X' || letter == 'Y' || letter == 'Z') {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * This method check to see if a char equals a number above zero
	 * 
	 * @param number
	 *           char - the char in question
	 * @return boolean - true if a letter, false if not
	 */
	public static boolean equalsNumber(char number) {
		if (number == '1' || number == '2' || number == '3' || number == '4' || number == '5' || number == '6' || number == '7' || number == '8' || number == '9') {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * returns all fields appended together
	 */
	public String toString() {
		return firstName + ", " + lastName + ", " + studentNumber + ", " + streetAddress + ", " + city + ", " + province + ", " + postalCode + ", " + phoneNumber;
	}

	/**
	 * Returns if the two student numbers are the same
	 * 
	 * @param tempStudent
	 *           Student - the student you want to compare to
	 * @return if the two numbers are equal
	 */
	public boolean equals(Student tempStudent) {
		return (this.getStudentNumber() == tempStudent.getStudentNumber());
	}

	@Override
	public int compareTo(Object temp) {
		Student tempStudent = (Student) temp;

		if (this.getLastName().compareToIgnoreCase(tempStudent.getLastName()) == 0) {
			if (this.getFirstName().compareToIgnoreCase(tempStudent.getFirstName()) == 0) {
				return 0;
			}
			else if (this.getFirstName().compareToIgnoreCase(tempStudent.getFirstName()) > 0) {
				return 1;
			}
			else {
				return -1;
			}
		}
		else if (this.getLastName().compareToIgnoreCase(tempStudent.getLastName()) > 0) {
			return 1;
		}
		else {
			return -1;
		}
	}

}

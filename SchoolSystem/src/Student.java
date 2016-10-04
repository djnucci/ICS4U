import java.util.regex.PatternSyntaxException;

public class Student {
	
	private String firstName, lastName, streetAddress, city, province, postalCode, phoneNumber, birthDate;
	
	/**
	 * Default constructor
	 */
	public Student(){
		setBirthDate("");
		setCity("");
		setFirstName("");
		setLastName("");
		setPhoneNumber("");
		setPostalCode("");
		setProvince("");
		setStreetAddress("");
	}
	
	/**
	 * Makes a new Student with only a first name
	 * 
	 * @param firstName
	 * 		String - the Student's first name
	 */
	public Student(String firstName){
		setBirthDate("");
		setCity("");
		setFirstName(firstName);
		setLastName("");
		setPhoneNumber("");
		setPostalCode("");
		setProvince("");
		setStreetAddress("");
	}
	
	//TODO comment the rest of the constructors
	public Student(String firstName, String lastName){
		setBirthDate("");
		setCity("");
		setFirstName(firstName);
		setLastName(lastName);
		setPhoneNumber("");
		setPostalCode("");
		setProvince("");
		setStreetAddress("");
	}
	
	public Student(String firstName, String lastName, String birth){
		if (verifyBirthDate(birth)) {
			setBirthDate(birth);
		}
		setCity("");
		setFirstName(firstName);
		setLastName(lastName);
		setPhoneNumber("");
		setPostalCode("");
		setProvince("");
		setStreetAddress("");
	}
	
	public Student(String firstName, String lastName, String birth, String city){
		if (verifyBirthDate(birth)) {
			setBirthDate(birth);
		}
		setCity(city);
		setFirstName(firstName);
		setLastName(lastName);
		setPhoneNumber("");
		setPostalCode("");
		setProvince("");
		setStreetAddress("");
	}
	
	public Student(String firstName, String lastName, String birth, String city, String phoneNumber){
		if (verifyBirthDate(birth)) {
			setBirthDate(birth);
		}
		setCity(city);
		setFirstName(firstName);
		setLastName(lastName);
		if (verifyBirthDate(birth)) {
			setPhoneNumber(phoneNumber);
		}
		setPostalCode("");
		setProvince("");
		setStreetAddress("");
	}
	
	public Student(String firstName, String lastName, String birth, String city, String phoneNumber, String postalCode){
		if (verifyBirthDate(birth)) {
			setBirthDate(birth);
		}
		setCity(city);
		setFirstName(firstName);
		setLastName(lastName);
		if (verifyBirthDate(birth)) {
			setPhoneNumber(phoneNumber);
		}
		setPostalCode(postalCode);
		setProvince("");
		setStreetAddress("");
	}
	
	public Student(String firstName, String lastName, String birth, String city, String phoneNumber, String postalCode, String province){
		if (verifyBirthDate(birth)) {
			setBirthDate(birth);
		}
		setCity(city);
		setFirstName(firstName);
		setLastName(lastName);
		if (verifyBirthDate(birth)) {
			setPhoneNumber(phoneNumber);
		}
		setPostalCode(postalCode);
		setProvince(province);
		setStreetAddress("");
	}
	
	public Student(String firstName, String lastName, String birth, String city, String phoneNumber, String postalCode, String province, String streetAddress){
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
	 */
	public void setBirthDate(String birthDate) {
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

		if ((2016 - year) < 13 || (2016 - year) > 18) {
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
	 */
	public void setPhoneNumber(String phoneNumber) {
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
	 */
	public void setPostalCode(String postalCode) {
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
	 * @return String - his/her province
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * Sets the student's province
	 * 
	 * @param province
	 *           String - his/her province
	 */
	public void setProvince(String province) {
		this.province = province;
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
	 */
	public void setStreetAddress(String streetAddress) {
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
	 * This method check to see if a char equals a letter
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

}

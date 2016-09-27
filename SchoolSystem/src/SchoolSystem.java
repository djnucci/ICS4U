import java.util.Scanner;

public class SchoolSystem {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Student student1 = new Student();
		
		System.out.println("Please enter your first name: ");
		student1.setFirstName(scan.nextLine());
		System.out.println("Please enter your last name: ");
		student1.setLastName(scan.nextLine());
		System.out.println("Please enter your birth date (mm/dd/yyyy): ");
		student1.setBirthDate(scan.nextLine());
		System.out.println("Please enter the city you live in: ");
		student1.setCity(scan.nextLine());
		System.out.println("Please enter the province you live in: ");
		student1.setProvince(scan.nextLine());
		System.out.println("Please enter your current street address: ");
		student1.setStreetAddress(scan.nextLine());
		System.out.println("Please enter your postal code (X0X 0X0): ");
		student1.setPostalCode(scan.nextLine());
		System.out.println("Please enter your phone number ((xxx) xxx - xxxx):");
		student1.setPhoneNumber(scan.nextLine());
	
		
		System.out.println(student1.getLastName() + ", " + student1.getFirstName());
		System.out.println(student1.getBirthDate());
		System.out.println(student1.getStreetAddress() + " " + student1.getCity() + ", " + student1.getProvince());
		System.out.println(student1.getPostalCode());
		System.out.println(student1.getPhoneNumber());
		
		
		
	}

}

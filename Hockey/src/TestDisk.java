import java.text.DecimalFormat;

/**
 * 	Main for Disk stuff
 * 	@author Daniel Nucci
 *	December 15th, 2016
 *	TestDisk.java
 */
public class TestDisk {

	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("0.00");
		
		Disk saucer = new Disk(10, 0.02);

		System.out.println("Disk radius " + df.format(saucer.getRadius()));
		System.out.println("Disk surface area " + df.format(saucer.area()));
		System.out.println("Disk volume " + df.format(saucer.calcVolume()));

		Disk plate1 = new Disk(12, 0.05);
		Disk plate2 = new Disk(12, 0.07);
		
		if(plate1.equals(plate2)){
			System.out.println("Objects are equal.");
		}
		else{
			System.out.println("Objects are not equal.");
		}
		
		System.out.println(plate1);
		System.out.println(plate2);
		
		System.out.println("_________________________________________");
		
		Puck p1 = new Puck(3, 1, 5.25);
		System.out.println(p1.toString());
		System.out.println("The puck division is " + p1.getDivision());
		
		Puck p2 = new Puck(3, 1, 4.25);
		System.out.println(p2.toString());
		System.out.println("The puck division is " + p2.getDivision());
		
		Puck p3 = new Puck(3, 1, 7);
		System.out.println(p3.toString());
		System.out.println("The puck division is " + p3.getDivision());
		
		Puck p4 = new Puck(2, 1, 5.25);
		System.out.println(p4.toString());
		System.out.println("The puck division is " + p4.getDivision());
		
	}

}

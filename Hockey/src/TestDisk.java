import java.text.DecimalFormat;

/**
 * 	Main for Disk stuff
 * 	@author Daniel Nucci
 *	December 14th, 2016
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
	}

}

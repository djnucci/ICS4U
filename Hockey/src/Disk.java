/**
 * Makes and does Disk things
 * @author Daniel Nucci 
 * December 14th, 2016 
 * Disk.Java
 */
public class Disk extends Circle {
	private double thickness;

	/**
	 * Makes a new Disk
	 * 
	 * @param radius
	 *            double - the radius
	 * @param thick
	 *            double - the thickness
	 */
	public Disk(double radius, double thick) {
		super(radius);
		thickness = thick;
	}

	/**
	 * Sets the thickness
	 * 
	 * @param newThickness
	 *            double - the thickness
	 */
	public void setThickness(double newThickness) {
		thickness = newThickness;
	}

	/**
	 * Gets the thickness
	 * 
	 * @return double - the thickness
	 */
	public double getThickness() {
		return this.thickness;
	}

	/**
	 * Calculates the volume
	 * 
	 * @return double - the volume
	 */
	public double calcVolume() {
		return (super.area() * getThickness());
	}

	/**
	 * if the first disk equals the second
	 * 
	 * @param d
	 *            Disk - the second disk
	 * @return boolean - if the disks are equal
	 */
	public boolean equals(Disk d) {
		return (d.getRadius() == super.getRadius() && d.getThickness() == getThickness());
	}

	/**
	 * @return String - the string of all the information of the disk
	 */
	public String toString() {
		return "The disk radius is " + super.getRadius() + " and the disk thickness is " + getThickness();
	}
}

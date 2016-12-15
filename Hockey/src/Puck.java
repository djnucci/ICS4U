/**
 * 	This class makes a new puck
 * 	@author Daniel Nucci
 *	December 15th, 2016
 *	Puck.java
 */
public class Puck extends Disk{
	private double weight;
	private boolean standard;
	private boolean youth;
	
	/**
	 * Constructor for a puck
	 * 
	 * @param radius
	 * 			double - the radius
	 * @param thick
	 * 			double - the thickness
	 * @param weight
	 * 			double - the weight
	 */
	public Puck(double radius, double thick, double weight) {
		super(radius, thick);
		this.weight = weight;
		determineType(weight);
	}

	/**
	 * Determines if the puck is a youth or standard puck weight
	 * 
	 * @param w
	 * 			double - the weight
	 */
	private void determineType(double w) {
		if ((w >= 4 && w <= 4.5) && ifOffical()){
			this.youth = true;
		}
		else if ((w >= 5 && w <= 5.5) && ifOffical()){
			this.standard = true;
		}
	}
	
	/**
	 * Determines if the puck is of offical size
	 * 
	 * @return
	 * 			boolean - if the puck is offical
	 */
	private boolean ifOffical(){
		return (super.getRadius() == 3 && super.getThickness() == 1);
	}
	
	/**
	 * Get the weight of the puck
	 * 
	 * @return
	 * 			double - the weight
	 */
	public double getWeight(){
		return this.weight;
	}
	
	/**
	 * Gets the division
	 * 
	 * @return
	 * 			String - the division
	 */
	public String getDivision(){
		if (standard){
			return "Standard";
		}
		else if (youth){
			return "Youth";
		}
		else{
			return "Not Offical";
		}
	}
	
	/**
	 * if the first puck equals the second
	 * 
	 * @param p
	 *          Puck - the second puck
	 * @return 
	 * 			boolean - if the pucks are equal
	 */
	public boolean equals(Puck p){
		return (p.getRadius() == super.getRadius() && p.getThickness() == getThickness() && p.getWeight() == getWeight());
	}
	
	/**
	 * @return String - the string of all the information of the puck
	 */
	public String toString(){
		return "The puck radius is "  + super.getRadius() + ", the puck thickness is " + getThickness() + " and the puck weight is " + getWeight();
	}
}

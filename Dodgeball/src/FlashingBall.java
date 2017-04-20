import java.awt.Color;
import java.awt.Graphics;

/**
 * This class implements a flashing ball. Feel free to change this, implement a
 * new object, change the animation, etc. <br>
 * 
 * @version November 2015
 * @author Christina Kemp adapted from Sam Scott
 * 
 */
public class FlashingBall extends MovingObject {
	/**
	 * The radius of the ball.
	 */
	private int radius;
	/**
	 * Counts the frames between flash on/off.
	 */
	private int counter;
	/**
	 * The number of frames to wait before toggling the flash.
	 */
	private int flashSpeed;
	/**
	 * Controls the flash - true if the ball is filled in, false if it is an
	 * outline.
	 */
	private boolean filledIn;

	/**
	 * Calls the superclass constructor, plus sets radius, and flash parameters.
	 * 
	 * @param x
	 *            The x location.
	 * @param y
	 *            The y location.
	 * @param left
	 *            The left edge.
	 * @param right
	 *            The right edge.
	 * @param top
	 *            The top edge.
	 * @param bottom
	 *            The bottom edge.
	 */
	public FlashingBall(double x, double y, int left, int right, int top, int bottom) {
		super(x, y, left + 10, right - 10, top + 10, bottom - 10);
		// numbers above must match the radius
		radius = 10;
		counter = 0;
		flashSpeed = (int) (Math.random() * 5 + 5);
		filledIn = true;
	}
	/**
	 * Calls the superclass constructor, plus sets radius, and flash parameters.
	 * 
	 * @param x
	 *            The x location.
	 * @param y
	 *            The y location.
	 * @param left
	 *            The left edge.
	 * @param right
	 *            The right edge.
	 * @param top
	 *            The top edge.
	 * @param bottom
	 *            The bottom edge.
	 * @param radius
	 * 			  The radius.
	 */
	public FlashingBall(double x, double y, int left, int right, int top, int bottom, int radius) {
		super(x, y, left + radius, right - radius, top + 10, bottom - 10);
		// numbers above must match the radius
		this.radius = radius;
		counter = 0;
		flashSpeed = (int) (Math.random() * 5 + 5);
		filledIn = true;
	}

	/**
	 * Controls the animation parameters. (Called once every time the ball
	 * position is updated.)
	 */
	public void animateOneStep() {
		counter++;
		if (counter == flashSpeed) {
			counter = 0;
			filledIn = !filledIn;
		}
	}

	/**
	 * Draws the ball
	 * 
	 * @param g
	 *            The graphics context.
	 */
	public void draw(Graphics g) {
		int drawX = (int) getX() - radius;
		int drawY = (int) getY() - radius;

		g.setColor(color);
		g.fillOval(drawX, drawY, radius * 2, radius * 2);
		if (!filledIn) {
			g.setColor(Color.WHITE);
			g.fillOval(drawX + radius / 2, drawY + radius / 2, radius, radius);
		}

	}
	
	/**
	 * Returns true if the ball is filled in.
	 * 
	 * @return true if the ball is filled in, false otherwise.
	 */
	public boolean isFilled(){
		return filledIn;
	}
	
	/**
	 * Fills the circle.
	 */
	public void fillCircle(){
		filledIn = true;
	}
	
	/**
	 * Gives the radius of the ball.
	 * 
	 * @return the radius of the ball.
	 */
	public int getRadius(){
		return this.radius;
	}
}
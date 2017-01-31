import java.awt.Color;
import java.awt.Graphics;

public abstract class MovingObject implements Runnable {

	/**
	 * The x location of the object.
	 */
	private double x;
	/**
	 * The y location of the object.
	 */
	private double y;
	/**
	 * The x speed of the object.
	 */
	private double xSpeed;
	/**
	 * The y speed of the object.
	 */
	private double ySpeed;
	/**
	 * The left edge for bouncing.
	 */
	private int left;
	/**
	 * The right edge for bouncing.
	 */
	private int right;
	/**
	 * The top edge for bouncing.
	 */
	private int top;
	/**
	 * The bottom edge for bouncing.
	 */
	private int bottom;
	/**
	 * Length of pause between position updates. Related to speed of object.
	 * (Defaults to 10).
	 */
	private int pauseDuration;
	/**
	 * Object color (defaults to black)
	 */
	protected Color color;
	/**
	 * Set to false to stop the thread.
	 */
	private boolean moving;

	/**
	 * Sets default color and pauseDuration values. Sets speed to 0. Starts
	 * thread. Every subclass of MovingObject must use this constructor.
	 * 
	 * @param x
	 *            Initial x position.
	 * @param y
	 *            Initial y position.
	 * @param left
	 *            Left edge for bouncing.
	 * @param right
	 *            Right edge for bouncing.
	 * @param top
	 *            Top edge for bouncing.
	 * @param bottom
	 *            Bottom edge for bouncing.
	 */
	public MovingObject(double x, double y, int left, int right, int top,
			int bottom) {
		this.pauseDuration = 40;
		this.xSpeed = 0;
		this.ySpeed = 0;
		this.color = Color.black;
		this.x = x;
		this.y = y;
		this.left = left;
		this.right = right;
		this.top = top;
		this.bottom = bottom;
		startThread();
	}

	/**
	 * Starts the movement thread.
	 */
	public void startThread() {
		moving = true;
		Thread t = new Thread(this);
		t.start();
	}

	/**
	 * Stops the movement thread by terminating the main loop in run().
	 */
	public void stopThread() {
		moving = false;
	}

	/**
	 * Updates the x and y values in an infinite loop. If object hits an edge, x
	 * or y speed is reversed as appropriate.
	 */
	public void run() {
		while (moving) {
			animateOneStep();
			x += xSpeed;
			y += ySpeed;
			if (x >= right){
				if(xSpeed>0){
					xSpeed *=-1;
				}
			}
			if(x <= left){
				if(xSpeed<0){
					xSpeed *=-1;
				}
			}
			if (y >= bottom){
				if(ySpeed>0){
					ySpeed *=-1;
				}
			}
			if(y <= top){
				if(ySpeed<0){
					ySpeed *=-1;
				}
			}
			try {
				Thread.sleep(pauseDuration);
			} catch (InterruptedException e) {
			}
		}	
	}

	/**
	 * Draws the object.
	 * 
	 * @param g
	 *            The graphics context
	 */
	abstract public void draw(Graphics g);

	/**
	 * Performs one step of animation.
	 */
	abstract public void animateOneStep();
	
	/**
	 * Returns the x location.
	 * 
	 * @return
	 *            the current x position.
	 */
	public double getX() {
		return x;
	}

	/**
	 * Returns the y location.
	 * 
	 * @return
	 *            the current y position
	 */
	public double getY() {
		return y;
	}
	
	/**
	 * Returns the left boundary.
	 * 
	 * @return
	 * 			  the left boundary.
	 */
	public int getLeft(){
		return left;
	}
	/**
	 * Returns the right boundary.
	 * 
	 * @return
	 * 			  the right boundary.
	 */
	public int getRight(){
		return right;
	}
	/**
	 * Returns the top boundary.
	 * 
	 * @return
	 * 			  the top boundary.
	 */
	public int getTop(){
		return top;
	}
	/**
	 * Returns the bottom boundary.
	 * 
	 * @return
	 * 			  the bottom boundary.
	 */
	public int getBottom(){
		return bottom;
	}
	
	
	/**
	 * Sets the x speed.
	 * 
	 * @param xSpeed
	 *            New x speed.
	 */
	public void setXSpeed(double xSpeed) {
		this.xSpeed = xSpeed;
	}

	/**
	 * Sets the y speed.
	 * 
	 * @param ySpeed
	 *            New y speed.
	 */
	public void setYSpeed(double ySpeed) {
		this.ySpeed = ySpeed;
	}

	/**
	 * Sets the x location.
	 * 
	 * @param x
	 *            New x location.
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Sets the y location.
	 * 
	 * @param y
	 *            New y location.
	 */
	public void setY(int y) {
		this.y = y;
	}


	/**
	 * Sets color of object.
	 * 
	 * @param color
	 *            New color.
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	
	/**
	 * Moves the object to a specific x and y coordinate
	 * 
	 * @param x
	 * 			The x coordinate.
	 * @param y
	 * 			The y coordinate.
	 */
	public void move(double x, double y){
		this.x = x;
		this.y = y;
	}
}
import java.awt.Graphics;

public class Player extends MovingObject{
	private int length;
	
	/**
	 * Calls the superclass constructor, plus sets Shape, and length/diameter parameters
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
	 * @param shape
	 * 			  The shape.
	 * @param length
	 * 			  The length/diameter.
	 */
	public Player(double x, double y, int left, int right, int top, int bottom, int length) {
		super(x, y, left, right, top, bottom);
		this.length = length;
		
	}

	@Override
	public void draw(Graphics g) {
		int radius = length/2;
		int drawX = (int) getX() - radius;
		int drawY = (int) getY() - radius;

		g.setColor(color);
		g.fillOval(drawX, drawY, length, length);
	}

	@Override
	public void animateOneStep() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Finds if the cursor is out of it's boundaries.
	 * 
	 * @return true if the cursor is outside it's boundaries, false otherwise.
	 */
	public boolean outOfBounds(){
		return getX()>=getRight()+30||getX()<=getLeft()-30||getY()<=getTop()-30||getY()>=getBottom()+30;
	}
	
	/**
	 * Gives the length/diameter.
	 * 
	 * @return the length/diameter.
	 */
	public int getLength(){
		return this.length;
	}
	

}
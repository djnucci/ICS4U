package dodgeball;

import java.awt.Color;
import java.awt.Graphics;

public class PlayerMovable extends MovingObject {

	private int radius;

	public void movePlayer(int xSpeed, int ySpeed) {
		super.setXSpeed(xSpeed);
		super.setYSpeed(ySpeed);
	}

	public PlayerMovable(double x, double y, int left, int right, int top, int bottom) {
		super(x, y, left + 10, right - 10, top + 10, bottom - 10);
		radius = 10;
	}

	public PlayerMovable(int radius, double x, double y, int left, int right, int top, int bottom) {
		super(x, y, left + radius, right - radius, top + radius, bottom - radius);

		this.radius = radius;

	}

	@Override
	public void draw(Graphics g) {

		int drawX = (int) getX();
		int drawY = (int) getY();

		g.setColor(color);
		g.fillRect(drawX, drawY, radius, radius);
	}

	public double getYSpeed(){
		return super.ySpeed;
	}
	public double getXSpeed(){
		return super.xSpeed;
	}
	
	@Override
	public void animateOneStep() {
	}

}
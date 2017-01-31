/**
 * Dodgeball program
 * Use arrow keys to dodge balls
 * @author Daniel Nucci
 * @version Dec 28, 2016
 */

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Dodge extends JPanel implements Runnable, KeyListener {

	private boolean gameOver = false;
	
	long levelStartTime = 0;
	
	int level = 0;
	
	int width = 1900;
	int height = 970;
	int key = 0;

	int numBalls = 10;

	final int pauseDuration = 30;

	ArrayList<FlashingBall> ball = new ArrayList<FlashingBall>();
	Calendar cal;

	Player cursor = new Player(50, 50, 0, width, 0, height, 10);

	public static void main(String[] args) {

		JFrame frame = new JFrame("Dodgeball");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(2000, 1100));
		frame.setAutoRequestFocus(false);
		frame.setVisible(true);
		Container c = frame.getContentPane();
		c.add(new Dodge());
		frame.pack();
		

	}

	public Dodge(){
		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(Color.WHITE);
		cursor.setXSpeed(0);
		cursor.setYSpeed(0);
		cursor.setColor(Color.BLUE);
		
		for (int i = 0; i < numBalls; i++){
			ball.add(new FlashingBall((int) (Math.random()*1100+500), (int) (Math.random()*700+100), 0, width, 0, height, 100));
		}
		for (int i = 0; i < numBalls; i++) {
			ball.get(i).setXSpeed(Math.random() * 12-6);
			ball.get(i).setYSpeed(Math.random() * 12-6);
			ball.get(i).setColor(new Color((int) (Math.random() * 256), 
					(int) (Math.random() * 256), (int) (Math.random() * 256)));
		}
		
		addKeyListener(this);
		
		levelStartTime = System.currentTimeMillis();
		
		Thread gameThread = new Thread(this);
		gameThread.start();

	}

	/**
	 * Repaints the frame periodically.
	 */
	public void run() {
		while (true) {
			if(!gameOver){
				this.requestFocus();
				if(key==38){
					cursor.setYSpeed(-7);
					cursor.setXSpeed(0);
				}
				else if(key==40){
					cursor.setYSpeed(7);
					cursor.setXSpeed(0);
				}
				else if(key==37){
					cursor.setXSpeed(-7);
					cursor.setYSpeed(0);
				}
				else if(key==39){
					cursor.setXSpeed(7);
					cursor.setYSpeed(0);
				}
				for(int i=0; i<numBalls; i++){
					if(didCursorCollide(cursor, ball.get(i))){
						gameOver();
					}
				}
				if(cursor.outOfBounds()){
					gameOver();
				}
				if(System.currentTimeMillis() - levelStartTime > 20*1000){//20 seconds * 1000 milliseconds per second
					levelStartTime = System.currentTimeMillis();
					nextLevel();
				}
			}
			else{
				if(key==82){
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
					}
					resetGame();
				}
			}
			if(key==67){
				System.exit(0);
			}
			repaint();
			try {
				Thread.sleep(pauseDuration);
			} catch (InterruptedException e) {
			}
		}
	}
	
	/**
	 * Progresses the game to the next level by addding a new FlashingBall.
	 */
	private void nextLevel() {
		numBalls++;
		level++;
		do{
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
			}
			ball.add(new FlashingBall((int) (Math.random() * 1100 + 500), (int) (Math.random()*700+100), 0, width, 0, height, 100));
			ball.get(ball.size()-1).setXSpeed(Math.random() * 12-6);
			ball.get(ball.size()-1).setYSpeed(Math.random() * 12-6);
			ball.get(ball.size()-1).setColor(new Color((int) (Math.random() * 256), 
					(int) (Math.random() * 256), (int) (Math.random() * 256)));
		}while(didNewBallCollide());
	}
	
	/**
	 * Checks if the newly created ball spawned on top of the cursor and deletes it if it has.
	 * 
	 * @return True if the new ball spawned on top of the cursor, false otherwise.
	 */
	private boolean didNewBallCollide(){
		if(didCursorCollide(cursor, ball.get(ball.size()-1))){
			ball.remove(ball.size()-1);
			return true;
		}
		return false;
	}

	/**
	 * Resets the game to the beginning.
	 */
	private void resetGame() {
		gameOver = false;
		this.setBackground(Color.WHITE);
		cursor.move(50, 50);
		for (int i = 0; i < numBalls; i++) {
			ball.get(i).move(Math.random()*1100+500, Math.random()*700+100);
			ball.get(i).setXSpeed(Math.random() * 12-6);
			ball.get(i).setYSpeed(Math.random() * 12-6);
			ball.get(i).setColor(new Color((int) (Math.random() * 256), 
					(int) (Math.random() * 256), (int) (Math.random() * 256)));
			ball.get(i).startThread();
		}
		key = 0;
		cursor.startThread();
	}

	/**
	 * Clears the screen and paints the balls.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < numBalls; i++) {
			ball.get(i).draw(g);
		}
		cursor.draw(g);

	}
	
	/**
	 * Finds if the player cursor is inside one of the FlashingBalls.
	 * 
	 * @param cursor
	 * 			The cursor being used by the player.
	 * @param ball
	 * 			The FlashingBall to check
	 * @return
	 * 			True if the cursor is inside the FlashingBall
	 */
	public boolean didCursorCollide(Player cursor, FlashingBall ball){
		int radius = ball.getRadius() + (cursor.getLength()/2);
		double xTotal = cursor.getX() - ball.getX();
		double yTotal = cursor.getY() - ball.getY();
		double dist = Math.sqrt(Math.pow(xTotal, 2) + Math.pow(yTotal, 2));
		return radius >= dist;
	}
	
	/**
	 * Stops all the balls and turns their colour pink.
	 */
	public void gameOver(){
		gameOver = true;
		cursor.move(-10, -10);
		this.setBackground(Color.YELLOW);
		for(int i=0; i<numBalls; i++){
			ball.get(i).stopThread();
			ball.get(i).setColor(Color.PINK);
			ball.get(i).fillCircle();
		}
		cursor.stopThread();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		key = e.getKeyCode();
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		key = 0;
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}
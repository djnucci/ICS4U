package dodgeball;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This is the beginning of a simple game. You should expand it into a dodgeball game, where the user controls an object with the mouse or keyboard, and tries to avoid the balls flying around the screen. If they get hit, it's game over. If they survive for 20 seconds (or some other fixed time), they go on to the next level. <br>
 * <br>
 * Should be run at around 500x300 pixels.<br>
 * <br>
 * 
 * @version Nov. 2015
 * 
 * @author Christina Kemp adapted from Sam Scott
 * @param <HumanInterfaceDevice>
 */
@SuppressWarnings("serial")
public class GamePanel<HumanInterfaceDevice> extends JPanel implements Runnable, KeyListener {
	final int playerRadius = 30;

	final int sixtyFps = 60;
	final int thirtyFps = 30;

	int key = 0;

	final static int width = 1000;
	final static int height = 700;

	final int ballRadius = 75;

	final int numPlayers = 1;

	/**
	 * The number of balls on the screen.
	 */
	final int numBalls = 9;
	/**
	 * The pause between repainting (should be set for about 30 frames per second).
	 */
	final int pauseDuration = (int) (1 / sixtyFps) * 1000;
	/**
	 * An array of balls.
	 */
	// FlashingBall[] ball = new FlashingBall[numBalls];
	ArrayList<FlashingBall> balls = new ArrayList<FlashingBall>();

	ArrayList<PlayerMovable> players = new ArrayList<PlayerMovable>();

	KeyListenerDemo kl = new KeyListenerDemo();

	/** main program (entry point) */
	public static void main(String[] args) {

		// Set up main window (using Swing's Jframe)
		JFrame frame = new JFrame("Dodgeball");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(500, 300));
		frame.setAutoRequestFocus(false);
		frame.setVisible(true);
		Container c = frame.getContentPane();
		c.add(new GamePanel());
		frame.pack();
		frame.setFocusable(true);

	}

	public GamePanel() {
		// Start the ball bouncing (in its own thread)
		this.setBackground(new Color(209, 16, 42));
		this.setPreferredSize(new Dimension(width, height));

		for (int i = 0; i < numPlayers; i++) {
			players.add(new PlayerMovable(playerRadius, 50, 50, -25, width - 25, -25, height));
		}
		for (int i = 0; i < numPlayers; i++) {
			players.get(i).setColor(Color.white);
			players.get(i).setXSpeed(0);
			players.get(i).setYSpeed(0);
		}

		for (int i = 0; i < numBalls; i++) {
			balls.add(new FlashingBall(ballRadius, ThreadLocalRandom.current().nextInt(ballRadius, (width - ballRadius) + 1), ThreadLocalRandom.current().nextInt(ballRadius, (height - ballRadius) + 1), 0, width, 0, height));
		}

		for (int i = 0; i < numBalls; i++) {
			balls.get(i).setXSpeed(Math.random() * 9 + 5);
			balls.get(i).setYSpeed(Math.random() * 9 + 5);
			balls.get(i).setColor(new Color(22, 141, 188));
		}

		Thread gameThread = new Thread(this);
		gameThread.start();

	}

	/**
	 * Repaints the frame periodically.
	 */
	public void run() {
		addKeyListener(this);
		while (true) {
			repaint();
			this.requestFocus();
			cardinalDirections(key, players.get(0));
			try {
				Thread.sleep(pauseDuration);
			} catch (InterruptedException e) {
			}
		}
	}

	/**
	 * Clears the screen and paints the balls.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < numBalls; i++) {
			balls.get(i).draw(g);
		}
		for (int i = 0; i < numPlayers; i++) {
			players.get(i).draw(g);
		}

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

	public static void cardinalDirections(int key, PlayerMovable player) {
		int xSpeed = (int) player.getXSpeed(), ySpeed = (int) player.getYSpeed();
		if (key == 37 && player.getX() >= 0) {
			xSpeed = -15;
			ySpeed = 0;
		}
		else if (key == 38 && player.getY() >= 0) {
			ySpeed = -15;
			xSpeed = 0;
		}
		else if (key == 39 && player.getX() <= width) {
			xSpeed = 15;
			ySpeed = 0;
		}
		else if (key == 40 && player.getY() <= height) {
			ySpeed = 15;
			xSpeed = 0;
		}
		player.movePlayer(xSpeed, ySpeed);
	}

}

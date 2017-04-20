package dodgeball;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class demonstrates how to use the KeyListener interface in an Applet
 * Novembeer 28, 2007.
 * @author Sam Scott
 **/
public class KeyListenerDemo extends Applet implements KeyListener
{
    /**
    *thelastkey pressed by the user
    **/
    char key = ' ';

    /**
     * Activate the key listener
     **/
    public void init ()
    {
	addKeyListener (this);
    }


    /**
     * Display basic information from mouse listeners
     * @param g The graphics context
     **/
    public void paint (Graphics g)
    {
	 g.drawString ("Key: " + key, 50, 110);
    }

    // METHODS REQUIRED FOR KEY LISTENER INTERFACE
    // You must always have these methods in any class that implements
    // KeyListener

    /**
    * called when a key is pushed down
    * @param e Thekeyboard event
    **/
    public void keyPressed (KeyEvent e)
    {
	key = e.getKeyChar ();
	repaint ();
    }


    /**
    * called when a key is released
    * @param e Thekeyboard event
    **/
    public void keyReleased (KeyEvent e)
    {
	key = ' ';
	repaint ();
    }


    /**
    * called when a character is entered (could be multiple key presses
    * @param e Thekeyboard event
    **/public void keyTyped (KeyEvent e)
    {
	// this space intentionally left blank
    }
} // EventListenerDemo class

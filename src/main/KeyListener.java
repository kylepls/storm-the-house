package main;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.HashSet;
import java.util.Set;

import windows.Play;
import windows.random.Shooter;

 
/**
 * Created by Kyle at Sep 13, 2014
 */
public class KeyListener implements MouseListener, MouseMotionListener, java.awt.event.KeyListener {

	public static boolean click = false;
	public static Point mouse = new Point(0, 0);
	public static Set<Character> keys = new HashSet<>();
	
	public void click(Point p) {
		Button.click(p);
		if (Main.getWindow() instanceof Play) {
			Shooter.shoot();
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (!click) {
			click(e.getLocationOnScreen());
		}
		click = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		click = false;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		mouse = e.getPoint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouse = e.getPoint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys.add(Character.toLowerCase(e.getKeyChar()));
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys.remove(Character.toLowerCase(e.getKeyChar()));
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}

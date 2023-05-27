package main;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Shape;
import java.util.ArrayList;
import java.util.List;

 
/**
 * Created by Kyle at Sep 13, 2014
 */
public class Button {
	
	public static List<Button> buttons = new ArrayList<>();
	
	private boolean hover = false;
	private ButtonRunnable runnable;
	private Shape shape;
	
	public Button(ButtonRunnable runnable, Shape bounds) {
		this.runnable = runnable;
		this.shape = bounds;
	}

	public boolean isHover() {
		return hover;
	}

	public void setHover(boolean hover) {
		this.hover = hover;
		if (hover) {
			runnable.hoverOn();
		} else {
			runnable.hoverOff();
		}
	}

	public ButtonRunnable getRunnable() {
		return runnable;
	}

	public void setRunnable(ButtonRunnable runnable) {
		this.runnable = runnable;
	}


	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}

	public void destroy() {
		buttons.remove(this);
	}
	
	public static void tick() {
		Point mousePos = KeyListener.mouse;
		for (Button b : buttons) {
			if (b.getShape().contains(mousePos)) {
				if (!b.isHover()) {
					b.setHover(true);
				}
			} else {
				if (b.isHover()) {
					b.setHover(false);
				}
			}
		}
	}
	
	public static void click(Point p) {
		for (int i = 0; i < buttons.size(); i++) {
			Button b = buttons.get(i);
			if (b.getShape().contains(p)) {
				b.getRunnable().click();
			}
		}
	}
	
	public static void paint(Graphics g, int w, int h) {
		for (Button b : buttons) {
			b.getRunnable().paint(g, w, h);
		}
	}
	
	
	public interface ButtonRunnable {
		public void hoverOn();
		public void hoverOff();
		public void click();
		public void paint(Graphics g, int w, int h);
	}
}

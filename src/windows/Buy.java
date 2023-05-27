package windows;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import main.Button;
import main.Button.ButtonRunnable;
import main.Main;
import windows.util.TextTools;
import windows.util.Window;
 
/**
 * Created by Kyle at Sep 13, 2014
 */
public class Buy implements Window {
	
	Button start;
	
	@Override
	public void init() {
		Rectangle bounds = new Rectangle(400, 400, 200, 50);
		start = new Button(new ButtonRunnable() {
			Color c = Color.GREEN;
			@Override
			public void paint(Graphics g, int w, int h) {
				g.setColor(c);
				g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
				Font f = new Font("Impact", Font.BOLD, 50);
				g.setColor(Color.BLACK);
				g.setFont(f);
				int x = TextTools.findXCenter("Start", f, g.getFontMetrics(), 200)+400;
				int y = TextTools.findYCenter("Start", f, g.getFontMetrics(), 50)+400;
				g.drawString("Start", x, y);
			}
			
			@Override
			public void hoverOn() {
				c = Color.CYAN;
			}
			
			@Override
			public void hoverOff() {
				c = Color.GREEN;
			}
			
			@Override
			public void click() {
				Main.setWindow(new Play());
			}
		}, bounds);
		Button.buttons.add(start);
	}

	@Override
	public void tick() {
	}

	@Override
	public void draw(Graphics g, int w, int h) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, w, h);
	}

	@Override
	public void destroy() {
		Button.buttons.remove(start);
	}
}

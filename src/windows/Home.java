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
public class Home implements Window {

	Button play;
	
	@Override
	public void init() {
		Rectangle playBounds = new Rectangle(50, 50, 200, 50);
		play = new Button(new ButtonRunnable() {
			Color c = Color.RED;
			@Override
			public void paint(Graphics g, int w, int h) {
				g.setColor(c);
				g.fillRect(playBounds.x, playBounds.y, 200, 50);
				
				Font f = new Font("Terminal", Font.BOLD, 20);
				int x = TextTools.findXCenter("Play", f, g.getFontMetrics(), 200)+50;
				int y = TextTools.findYCenter("Play", f, g.getFontMetrics(), 50)+50;
				g.setFont(f);
				g.setColor(Color.BLACK);
				g.drawString("Play", x, y);
				
			}
			
			@Override
			public void hoverOn() {
				c = Color.GREEN;
			}
			
			@Override
			public void hoverOff() {
				c = Color.RED;
			}
			
			@Override
			public void click() {
				Main.setWindow(new Buy());
			}
		}, playBounds);
		Button.buttons.add(play);
	}

	@Override
	public void tick() {
	}

	@Override
	public void draw(Graphics g, int w, int h) {
		g.fillRect(0, 0, w, h);
	}

	@Override
	public void destroy() {
		Button.buttons.remove(play);
	}
}

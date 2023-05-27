package windows.random;

import java.awt.Color;
import java.awt.Graphics;

import main.KeyListener;
 
/**
 * Created by Kyle at Sep 13, 2014
 */
public class Cursor {
	public static void paint(Graphics g) {
		g.setColor(Color.RED);
		
		int x = KeyListener.mouse.x;
		int y = KeyListener.mouse.y;
		
		int size = 17;
		
		g.drawRect(x, y, 1, 1);
		
		g.drawRoundRect(x-size/2, y-size/2, size, size, size-1, size-1);
		g.drawLine(x, y-9, x, y-12);
		g.drawLine(x, y+9, x, y+12);
		g.drawLine(x-9, y, x-12, y);
		g.drawLine(x+9, y, x+12, y);
	}
}

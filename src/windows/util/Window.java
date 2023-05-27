package windows.util;

import java.awt.Graphics;
 
/**
 * Created by Kyle at Sep 13, 2014
 */
public interface Window {
	public void init();
	public void tick();
	public void draw(Graphics g, int w, int h);
	public void destroy();
}

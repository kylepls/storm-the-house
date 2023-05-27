package windows.util;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.HashSet;
import java.util.Set;
 
/**
 * Created by Kyle at Sep 13, 2014
 */
public class Animation {
	private static Set<Animation> animations = new HashSet<Animation>();
	
	private Point to, from;
	private Rectangle s;
	private int speed;
	
	public Animation(Point to, Rectangle s, int speed) {
		from = s.getBounds().getLocation();
		this.to = to;
		this.s = s;
		this.speed = speed;
		animations.add(this);
	}

	public Point getTo() {
		return to;
	}
	
	public Point getFrom() {
		return from;
	}
	
	public void setTo(Point to) {
		this.to = to;
	}

	public Rectangle getS() {
		return s;
	}

	public void setS(Rectangle s) {
		this.s = s;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public static void tick() {
		for (Animation a : animations) {
			System.out.println("tick: " + animations.size());
			int x = (int) a.getFrom().getX(), y = (int) a.getFrom().getY();
			int xTo = (int) a.getTo().getX();
			int yTo = (int) a.getTo().getY();
			
			if (x != xTo || y != yTo) {
				
				if (x != xTo) {
					if (xTo > x) {
						x+=a.getSpeed();
					} else {
						x=x-a.getSpeed();
					}
				}
				
				if (y != yTo) {
					if (yTo > y) {
						y+=a.getSpeed();
					} else {
						y=y-a.getSpeed();
					}
				}
			}
			
			Rectangle r = new Rectangle(a.getS());
			r.setLocation(x, y);
			a.setS(r);
		}
	}
}

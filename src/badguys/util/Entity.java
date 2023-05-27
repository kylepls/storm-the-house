package badguys.util;

import game.Stats;

import java.awt.Graphics;
import java.awt.Shape;
 
/**
 * Created by Kyle at Sep 13, 2014
 */
public abstract class Entity {
	public abstract void tick();
	public abstract void paint(Graphics g, int w, int h);
	public abstract void hit(int damage);
	public abstract Shape getBounds();
	public abstract int getPoints();
	
	public void destroy(Entity e) {
		Stats.set("money", ((int) Stats.get("money"))+e.getPoints());
		EntityManager.removeEntity(e);
	}
}

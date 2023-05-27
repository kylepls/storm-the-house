package badguys.util;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Shape;
import java.util.ArrayList;
import java.util.List;
 
/**
 * Created by Kyle at Sep 13, 2014
 */
public class EntityManager {
	private static List<Entity> entities = new ArrayList<>();
	
	public static void addEntity(Entity e) {
		entities.add(e);
	}
	
	public static void removeEntity(Entity e) {
		entities.remove(e);
	}
	
	public static void tick() {
		for (int i = 0; i < entities.size(); i++) {
			Entity e = entities.get(i);
			e.tick();
		}
	}
	
	public static void shoot(Point p, int damage) {
		for (int i = 0; i < entities.size(); i++) {
			Entity e = entities.get(i);
			Shape bounds = e.getBounds();
			if (bounds != null && bounds.contains(p)) {
				e.hit(damage);
			}
		}
	}
	
	public static void paint(Graphics g, int w, int h) {
		for (Entity e : entities) {
			e.paint(g, w, h);
		}
	}
}

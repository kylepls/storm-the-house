package badguys.util;

import game.Stats;

import java.util.Random;

import main.Main;
import badguys.Guy;
 
/**
 * Created by Kyle at Sep 13, 2014
 */
public class EntitySpawner {
	
	private static Random r = new Random();
	
	public static void tick() {
		if ((boolean) Stats.get("running")) {
			if (r.nextInt(1000) < 5+((int)Stats.get("round"))) {
				int h = Main.h;
				int min = (int) (h*0.55);
				int max = h-15;
				Entity guy = new Guy(0, r.nextInt(max-min)+min);
				EntityManager.addEntity(guy);
			}
		}
	}
}

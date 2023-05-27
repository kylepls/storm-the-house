package windows.random;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;

import main.KeyListener;
import windows.util.TextTools;
import badguys.BulletHit;
import badguys.util.EntityManager;
 
/**
 * Created by Kyle at Sep 13, 2014
 */
public class Shooter {
	
	public static File soundsDir = new File("sounds");
	
	private static Gun gun = Gun.PISTOL;
	
	private static int shotsLeft = Gun.PISTOL.getClipSize();
	
	public static boolean reloading = false;
	public static int i = 10;
	
	
	public static void setGun(Gun g) {
		Shooter.gun = g;
	}
	
	public static void tick() {
		if (reloading) {
			i++;
			if (i % 10 == 0) {
				if (shotsLeft < gun.getClipSize()) {
					shotsLeft++;
					//gun.playSound("reload");
				} else {
					reloading = false;
					rack();
				}
			}
		} else {
			if (KeyListener.keys.contains(' ')) {
				reload();
			}
		}
	}
	
	public static boolean shoot() {
		if (!reloading) {
			if (shotsLeft > 0) {
				gun.playSound("shoot");
				EntityManager.shoot(KeyListener.mouse, gun.getDamage());
				BulletHit hit = new BulletHit(KeyListener.mouse);
				EntityManager.addEntity(hit);
				shotsLeft--;
				return true;
			} else {
				reload();
				return false;
			}
		}
		return false;
	}
	
	public static void reload() {
		//empty();
		reloading = true;
	}
	
	public static void empty() {
		gun.playSound("empty");
	}
	
	public static void rack() {
		gun.playSound("rack");
	}
	
	public static void draw(Graphics g) {
		g.setColor(Color.BLACK);
		int s = 45;
		g.drawRect(49, s-1, 101, 21);
		g.setColor(Color.GREEN);
		int w = (int) ((shotsLeft*1.0/gun.getClipSize())*100);
		
		g.fillRect(50, s, w, 20);
		
		g.setColor(Color.BLACK);
		String string = shotsLeft + "/" + gun.getClipSize();
		Font f = new Font("Impact", Font.PLAIN, 23);
		g.setFont(f);
		g.drawString(string, TextTools.findXCenter(string, f, g.getFontMetrics(), 100)+50, 64);
	}
}

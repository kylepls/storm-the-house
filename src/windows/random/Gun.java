package windows.random;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.nio.file.Path;

/**
 * Created by Kyle at Sep 13, 2014
 */
public enum Gun {

	PISTOL(0, "pistol", 700, 50, 7);

	private int price;
	private String soundFolder;
	private long cooldown;
	private int damage;
	private int clipSize;

	Gun(int price, String soundsFolder, long cooldown, int damage, int clipSize) {
		this.price = price;
		this.soundFolder = soundsFolder;
		this.cooldown = cooldown;
		this.damage = damage;
		this.clipSize = clipSize;
	}

	public int getClipSize() {
		return clipSize;
	}

	public void setClipSize(int clipSize) {
		this.clipSize = clipSize;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public long getCooldown() {
		return cooldown;
	}

	public void setCooldown(long cooldown) {
		this.cooldown = cooldown;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void playSound(String name) {
		try {
			URL url = Gun.class.getResource(String.format("/sounds/%s/%s.mp3", soundFolder, name));
	        MP3 mp3 = new MP3(url);
	        mp3.play();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

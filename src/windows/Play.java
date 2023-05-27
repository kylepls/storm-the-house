package windows;

import game.Stats;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.nio.file.Path;
import java.util.Objects;

import javax.swing.ImageIcon;

import main.Main;
import windows.random.Shooter;
import windows.util.TextTools;
import windows.util.Window;

/**
 * Created by Kyle at Sep 13, 2014
 */
public class Play implements Window {

	private Image background;
	@Override
	public void init() {
		background = new ImageIcon(Objects.requireNonNull(Main.class.getResource("/images/background.png"))).getImage();
		Stats.set("running", true);
		Stats.set("remaining", 20+((int) Stats.get("round")));
	}

	@Override
	public void tick() {
	}

	@Override
	public void draw(Graphics g, int w, int h) {
		/*
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, w, h);

		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(25, 25, w-w/3, h);
		*/

		g.drawImage(background, 0, 0, null);

		g.setColor(Color.BLACK);
		Font f = new Font("Impact", Font.PLAIN, 25);
		String score = "Money: $" + Stats.get("money");

		int xs = w-((w-w/3)+50);
		int x = TextTools.findXCenter(score, f, g.getFontMetrics(), xs)+(w-xs-25);
		g.setFont(f);
		g.drawString(score, x, 65);

		Shooter.draw(g);
	}

	@Override
	public void destroy() {
	}
}

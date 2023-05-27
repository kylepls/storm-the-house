package main;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;

import javax.swing.*;

import badguys.util.EntityManager;
import badguys.util.EntitySpawner;
import game.Stats;
import windows.Play;
import windows.random.Hit;
import windows.random.Shooter;
import windows.util.Animation;
import windows.util.Window;


/**
 * Created by Kyle at Sep 13, 2014
 */
public class Main extends JPanel {

	private static final long serialVersionUID = 1L;

	private static Thread t;
	public static Component panel, frame;
	private static Window window = new Play();

	public static int w, h;

	public static void setWindow(Window w) {
		window.destroy();
		window = w;
		window.init();
	}

	public static Window getWindow() {
		return window;
	}

	public static void main(String[] args) throws URISyntaxException {
		init();
		t = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					tick();
					((JPanel) panel).repaint();
					try {
						Thread.sleep(50);
					} catch (Exception e) {
					}
				}
			}
		});
		t.run();
	}

	public static void init() {
		JFrame frame = new JFrame();
		frame.setSize(1000, 650);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Main panel = new Main();
		panel.setVisible(true);
		frame.add(panel);
		Main.frame = frame;
		Main.panel = panel;

		KeyListener listener = new KeyListener();
		panel.addMouseListener(listener);
		panel.addMouseMotionListener(listener);
		frame.addKeyListener(listener);

		Stats.set("money", 0);
		Stats.set("round", 0);
		Stats.set("running", false);

		BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
		Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blank cursor");
		frame.getContentPane().setCursor(blankCursor);

		window.init();
	}

	public static void tick() {
		Animation.tick();
		window.tick();
		Button.tick();
		Shooter.tick();

		EntityManager.tick();
		Hit.tick();
		EntitySpawner.tick();
	}

	public static void paint(Graphics g, int w, int h) {
		Main.w = w;
		Main.h = h;
		g.fillRect(0, 0, w, h);
		window.draw(g, w, h);
		Button.paint(g, w, h);

		EntityManager.paint(g, w, h);
		windows.random.Cursor.paint(g);
	}

	@Override
	public void paintComponent(Graphics g) {
		Main.paint(g, getWidth(), getHeight());
	}
}

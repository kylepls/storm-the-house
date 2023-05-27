package windows.random;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

/**
 * Created by Kyle at Sep 13, 2014
 */
public class SpriteSheet {

	private BufferedImage image;
	private int sx, sy;

	public SpriteSheet(InputStream inputStream, int sizex, int sizey) {
		try {
			image = ImageIO.read(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sx = sizex;
		sy = sizey;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public int getSx() {
		return sx;
	}

	public void setSx(int sx) {
		this.sx = sx;
	}

	public int getSy() {
		return sy;
	}

	public void setSy(int sy) {
		this.sy = sy;
	}

	public Image getImage(int x, int y) {
		return image.getSubimage(x*sx, y*sy, sx, sy);
	}
}

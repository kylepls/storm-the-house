package badguys;

import badguys.util.Entity;
import windows.random.SpriteSheet;

import java.awt.*;

/**
 * Created by Kyle at Sep 14, 2014
 */
public class BulletHit extends Entity {

    public static final SpriteSheet sheet = new SpriteSheet(
            BulletHit.class.getResourceAsStream("/images/smokesheet.png"),
            128,
            128
    );

    private Point point;
    private int x = 0, y = 0;
    private boolean back = false;

    public BulletHit(Point point) {
        this.point = point;
    }

    @Override
    public void tick() {
        if (back) {
            x--;
            if (x < 0) {
                destroy(this);
            }
        } else {
            x++;
            if (x > 2) {
                back = true;
            }
        }
    }

    @Override
    public void paint(Graphics g, int w, int h) {
        g.drawImage(sheet.getImage(x, y), point.x - 64, point.y - 96, null);
    }

    @Override
    public void hit(int damage) {
    }

    @Override
    public Shape getBounds() {
        return null;
    }

    @Override
    public int getPoints() {
        return 0;
    }
}

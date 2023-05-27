package badguys;

import badguys.util.Entity;
import windows.random.Hit;
import windows.random.SpriteSheet;

import java.awt.*;

/**
 * Created by Kyle at Sep 13, 2014
 */
public class Guy extends Entity {

    public static SpriteSheet sheet = new SpriteSheet(
            Guy.class.getResourceAsStream("/images/spritesheet.png"),
            32,
            52
    );

    private static final int MOVE_SPEED = 1;

    private int x, y, health, i, move = 0;

    public Guy(int x, int y) {
        this.x = x;
        this.y = y;
        this.health = 100;
    }

    @Override
    public void paint(Graphics g, int w, int h) {
        //g.setColor(Color.DARK_GRAY);
        //g.fillRect(x, y, 10, 10);

        // health bar
        g.drawImage(sheet.getImage(4, 0), x, y, null);

        int xx = sheet.getSx() / 4;
        g.setColor(Color.BLACK);
        g.drawRect(x - 1 + xx, y - 5, 11, 3);
        g.setColor(Color.RED);
        int f = health / 10;
        g.fillRect(x + xx, y - 4, f, 2);

        ((Graphics2D) g).draw(Hit.line);
    }

    @Override
    public void tick() {

        if (Hit.line.contains(x, y)) {
            return;// hit
        }

        x += MOVE_SPEED;
        i++;
        if (i % 10 == 0) {
            move++;
            if (move > 8) {
                move = 1;
            }
        }
    }

    @Override
    public void hit(int damage) {
        health -= damage;
        if (health <= 0) {
            destroy(this);
        }
    }

    @Override
    public Shape getBounds() {
        return new Rectangle(x, y, sheet.getSx(), sheet.getSy());
    }

    @Override
    public int getPoints() {
        return 10;
    }
}

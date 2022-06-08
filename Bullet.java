
package mission.of.aeroplane;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet {
    private int x;
    private int y;
    private int Speed;

    public Bullet(int x, int y) {
        this.x = x;
        this.y = y;
        Speed=10;
    }
    public void Change()
    {
       y-=Speed;
    }
    public void Drawing(Graphics GP)
    {
        GP.setColor(Color.RED);
        GP.fillRect(x, y, 6, 10);
    }
     public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
}

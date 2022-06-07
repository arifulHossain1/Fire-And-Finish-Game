
package mission.of.aeroplane;

import java.awt.Color;
import java.awt.Graphics;

public class Enemy {
    private int x;
    private int y;

    public Enemy(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public void Change()
    {
      y+=1;
    }
    public void Drawing(Graphics GP)
    {
        
        GP.setColor(Color.ORANGE);
        GP.fillOval(x, y, 40, 40);
    }
}

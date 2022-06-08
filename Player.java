
package mission.of.aeroplane;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player implements KeyListener {
    private int x;
    private int y;
    private boolean left,right;
    private boolean fire;
    private long Current;
    private long Delay;
    private int Health;
    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }
      public void ShowIt()
    {
        Display.frame.addKeyListener(this);
        Current=System.nanoTime();
        Delay=100;
        Health=3;
    }
    public void Change()
    {
        if(!(Health<=0)){
           if(left)
        {
            if(x>=75){
                 x-=1.5;
            }
        }
        if(right)
        {
            if(x<=575-50){
            x+=1.5;
            }
        }
        if(fire)
        {
            long breaks=(System.nanoTime()-Current)/1000000;
            if(breaks>Delay){
            G_Control.bullet.add(new Bullet(x+25,y));
            }
            Current=System.nanoTime();
        }
    }
    }
    public void Drawing(Graphics GP)
    {
        if(!(Health<=0)){
           //GP.drawImage(Add_Image.player, x, y, 50, 50, null);
        GP.setColor(Color.black);
        GP.fillRect(x, y, 50, 50);
       }
    }
        public void keyTyped(KeyEvent e) {
        
    }
    public void keyPressed(KeyEvent e) {
         int source=e.getKeyCode();
        if(source==KeyEvent.VK_LEFT)
        {
            left=true;
        }
        if(source==KeyEvent.VK_RIGHT)
        {
            right=true;
        }
         if(source==KeyEvent.VK_F)
         {
             fire=true;
         }
    }
    public void keyReleased(KeyEvent e) {
         int source=e.getKeyCode();
        if(source==KeyEvent.VK_LEFT)
        {
            left=false;
        }
        if(source==KeyEvent.VK_RIGHT)
        {
            right=false;
        }
        if(source==KeyEvent.VK_F)
       {
           fire=false;
       }
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public int getHealth()
    {
        return Health;
    }
    public void setHealth(int health){
        this.Health=health;
    }
}

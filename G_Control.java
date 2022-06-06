
package mission.of.aeroplane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class G_Control implements KeyListener {
    private Player player;
    public static ArrayList<Bullet> bullet;
    private ArrayList<Enemy> Enemies;
    private long Current;
    private long Delay;
    private int Health;
    private int Score;
    private boolean start;
    public G_Control() {
        
    }
    public void ShowIt()
    {
        Display.frame.addKeyListener(this);
        player=new Player((GameSetUp.G_Width/2)+50,(GameSetUp.G_Height-50)+100);
        player.ShowIt();
        bullet=new ArrayList<Bullet>();
        Enemies=new ArrayList<Enemy>();
        Current=System.nanoTime();
        Delay=1200;
        Health=player.getHealth();
        Score=0;
    }
    public void Change()
    {
        if(start){       
            player.Change();
        
        //Bullet
        for(int i=0;i<bullet.size();i++)
        {
            bullet.get(i).Change();
        }
        //Enemies
        long breaks=(System.nanoTime()-Current)/1000000;
           if(breaks>Delay){
        for(int i=0;i<2 ;i++)
        {
            Random R=new Random();
            int Rx=R.nextInt(450);
            int Ry=R.nextInt(450);
            if(Health>0){
            Enemies.add(new Enemy(Rx,-Ry));
         }
        }
           Current=System.nanoTime();
           }
        for(int i=0;i<Enemies.size();i++)
        {
            Enemies.get(i).Change();
        }
    }
    }
    public void Drawing(Graphics GP)
    {
        if(start){
        player.Drawing(GP);
        //Bullets
         for(int i=0;i<bullet.size();i++)
        {
            bullet.get(i).Drawing(GP);
        }
      for(int i=0;i<bullet.size();i++)
      {
          if(bullet.get(i).getY()<=100)
          {
              bullet.remove(i);
              i--;
          }
    }
    //Enemies
    for(int i=0;i<Enemies.size();i++)
      {
          if(!(Enemies.get(i).getX()<=75 || Enemies.get(i).getX()>=575-40 || Enemies.get(i).getY()>=600-40)){
              if(Enemies.get(i).getY()>=100){
          Enemies.get(i).Drawing(GP);
      }
          }
    }       
     //Bullet and Enemies Conllision
     for(int i=0;i<Enemies.size();i++)
     {
         int ex=Enemies.get(i).getX();
         int ey=Enemies.get(i).getY();
         int px=player.getX();
         int py=player.getY();
          //Formula collected from google
          if(px<ex+40 && px+50 >ex &&
                  py < ey + 40 && py +50> ey)
          {
              Enemies.remove(i);
              i--;
              Health--;
              System.out.println(Health);
              if(Health<=0)
              {
                  Enemies.removeAll(Enemies);
                  player.setHealth(0);
                  start=false;
              }
          }
         
         for(int j=0;j<bullet.size();j++)
         {
             int bx=bullet.get(j).getX();
             int by=bullet.get(j).getY();
             //Formula collected from google
             if(ex < bx + 6 && ex + 40 > bx && ey < by +6
                   && ey + 40 > by)
             {
                 Enemies.remove(i);
                 i--;
                 bullet.remove(j);
                 j--;
                 Score=Score+5;
             }
         }
         GP.setColor(Color.GREEN);
         GP.setFont(new Font("calibri",Font.BOLD,42));
         GP.drawString("Score: "+Score, 75, 660);
         
         GP.setColor(Color.GREEN);
         GP.setFont(new Font("calibri",Font.BOLD,35));
         GP.drawString("Health: "+Health, 300, 660);
         
     }
}
        else
        {
         GP.setColor(Color.BLACK);
         GP.setFont(new Font("arial",Font.PLAIN,42));
         GP.drawString("Press Enter To Start", 150,(GameSetUp.G_Height/2)+100);
        }
}
    public void keyTyped(KeyEvent ke) {
        
    }

    public void keyPressed(KeyEvent e) {
        int source= e.getKeyCode();
        if(source==KeyEvent.VK_ENTER){
            start=true;
            ShowIt();
        }
    }
    
    public void keyReleased(KeyEvent ke) {
        
    }
}

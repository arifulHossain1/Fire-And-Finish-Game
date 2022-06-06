
package mission.of.aeroplane;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.paint.Color;

public class GameSetUp implements Runnable{
    private String Title;
    private int Width;
    private int Height;
    private Thread thread;
    private boolean running;
    private Display display;
    private BufferStrategy buffer;
    private Graphics GP;
    private int D;
    private G_Control control;
    public static final int G_Width=500;
    public static final int G_Height=500;

    public GameSetUp(String Title, int Width, int Height) {
        this.Title = Title;
        this.Width = Width;
        this.Height = Height;
    }
    public void ShowIt()
    {
       display =new Display(Title,Width,Height);
       control=new G_Control();
       control.ShowIt();
    }
    public synchronized void start()
    {
        if(running)
            return;
        running=true;
        if(thread==null){
        thread= new Thread(this);
        thread.start();
        }
    }
    public synchronized void stop()
    {
        if(!(running))
            return;
        running=false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void Change()
    {
        control.Change();
        
    }
    public void Drawing()
    {
        buffer= display.getCanvas().getBufferStrategy();
        if(buffer == null)
        {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        GP=buffer.getDrawGraphics();
        GP.clearRect(0, 0, Width, Height);
        //Draw
             
            //GP.drawImage(Add_Image.image, 75, 100, G_Width, G_Height, null);
             GP.setColor(java.awt.Color.WHITE);
             GP.fillRect(75, 100, G_Width, G_Height);
             control.Drawing(GP);
        //End Of Draw
        buffer.show();
        GP.dispose();
    }
    public void run() {
       ShowIt();
       
       int fps= 55;
       double timePerTick= 1000000000/fps;
       double delta=0;
       long current=System.nanoTime();
       
       
       while(running){
           
           delta= delta+(System.nanoTime()-current)/timePerTick;
           current=System.nanoTime();
           if(delta>=1)
           {
       Change();
       Drawing();
       delta--;
      }
    }
}
}

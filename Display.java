
package mission.of.aeroplane;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Display {
    private String Title;
    private int Width;
    private int Height;
    public static JFrame frame;
    private Canvas canvas;

    public Display(String Title, int Width, int Height) {
        this.Title = Title;
        this.Width = Width;
        this.Height = Height;
        displayAll();
    }
  public void displayAll()
  {
      frame =new JFrame(Title);
      frame.setSize(Width,Height);
      frame.setVisible(true);
      frame.setLocationRelativeTo(null);
      frame.setResizable(false);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      canvas=new Canvas();
      canvas.setPreferredSize(new Dimension(Width,Height));
      canvas.setBackground(Color.DARK_GRAY);
      canvas.setFocusable(false);
      frame.add(canvas);
      frame.pack();
  }
  public Canvas getCanvas()
  {
      return canvas;
  }
  
    
}

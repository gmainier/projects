import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



@SuppressWarnings("removal")
public class SnakeGame extends Applet implements Runnable, KeyListener {

  Graphics gp; 
  Image image;
  Thread thread; 
  Snake snake;

  public void init(){
    this.resize(600, 600);
    image = createImage(600, 600); 
    gp = image.getGraphics();
    snake = new Snake();
    thread = new Thread(this);

  }

  public void paint(Graphics g){
    gp.setColor(Color.BLUE);
    gp.fillRect(0, 0, 600, 600);
    snake.draw(gp);
    g.drawImage(image, 0, 0, null);

  }

  public void repaint(Graphics g) {

  }
  public void run() {
    for(;;) {


      this.repaint();
      try {
        Thread.sleep(400);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }

  public void keyTyped(KeyEvent e) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
  }

  public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_UP) {

    }
    if (e.getKeyCode() == KeyEvent.VK_DOWN) {
      
    }
    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
      
    }
    if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
      
    }
  }

  public void keyReleased(KeyEvent e) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
  }
  
}

/*
<applet code="SnakeGame" width=600 height=600>
</applet>
*/
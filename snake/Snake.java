import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Snake {
  List<Point> snakePoints; 
  //a List of Point ojectes
  int xDir; 
  int yDir; 
  //note: (0,0) is the top right corner 
  /*  x = +1, move to the right 
      x = -1, move to the left 
      y = +1, move down
      y = -1, move up 
      x, y = 0, not moving in that direction*/

  boolean isMoving, longer; 
  //is moving makes sure that the snakes goes in any of the other three directions that its not currently facing! 
  //longer checks that it needs to get longer (target was hit)

  final int STARTSIZE = 40, STARTX = 250, STARTY = 250; 
  //starting length, starting position 

  public void Snake() {
    snakePoints = new ArrayList<Point>(); 
    xDir = 0; 
    yDir = 0; 
    isMoving = false; 
    longer = false;
    snakePoints.add(new Point(STARTX, STARTY)); 
    //create the rest of the snake
    for (int i = 0; i < STARTSIZE; i++) {
      snakePoints.add(new Point(STARTX - i*8, STARTY));
      /*each point is a 8x8 square so we offset all the points by 8 in the x directions. y stays the same as we want the
      snake tail to be on the left */
      
    }

  }

  public void draw(Graphics g) {
    g.setColor(Color.GREEN);
    //draw each point of the snake:
    for (Point p : snakePoints) {
      //get the COORDINATES of each point
      g.fillRect(p.getX(), p.getY(), 8, 8);
    }
  }

  public int getxDir() {
    return xDir;
  }

  public int getyDir() {
    return yDir;
  }

  public void setxDir(int xDir) {
    this.xDir = xDir;
  }

  public void setyDir(int yDir) {
    this.yDir = yDir;
  }

  //get coordinates of the 'head' of the snake
  public int getHX() {
    return snakePoints.get(0).getX();
    //getters from class points 
  }

  public int getHY() {
    return snakePoints.get(0).getY(); 
  }


}

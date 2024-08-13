//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P04 Carrot Patch Rabbit Class
// Course: CS 300 Spring 2021
//
// Author: Orion Meng
// Email: dmeng8@wisc.edu
// Lecturer: Mouna Kacem
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: NONE
// Online Sources: NONE
//
///////////////////////////////////////////////////////////////////////////////

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import processing.core.PApplet;
import processing.core.PImage;

public class Rabbit extends Animal {

  private static final String RABBIT = "images" + File.separator + "rabbit.png";
  private static final String TYPE = "R"; // A String that represents the rabbit type
  private static int hopStep = 70; // one hop step
  private static int scanRange = 175; // scan range to watch out for threats
  private static int nextID = 1; // class variable that represents the identifier
  // of the next rabbit to be created
  private final int ID; // positive number that represents the order of this rabbit

  /**
   * Creates a new rabbit object located at a random position of the display window
   */
  public Rabbit() {
    // Set rabbit drawing parameters
    super(RABBIT);
    // Set rabbit identification fields
    ID = nextID;
    this.label = TYPE + ID; // String that identifies the current rabbit
    nextID++;
  }

  // getter of Rabbit.scanRange static field
  public static int getScanRange() {
    return scanRange;
  }

  // getter of Rabbit.hopStep static field
  public static int getHopStep() {
    return hopStep;
  }

  /**
   * Gets the first carrot in the patch. If the carrot is in the Rabbit hopStep range, the rabbit
   * eats it. It sets its position to the (x,y) position of the carrot and the carrot will be
   * removed from the Carrot Patch. Otherwise, the rabbit moves one hopStep towards that carrot. If
   * no carrot found (meaning Carrots.getFirstCarrot() returns false), the rabbit does nothing.
   */
  public void hopTowardsCarrot() {
    // get the first carrot
    int[] carrot = Carrots.getFirstCarrot();
    if (carrot != null) {
      int carrotIndex = carrot[0];
      int carrotX = carrot[1];
      int carrotY = carrot[2];

      int oldX = 0;
      oldX = this.getX();
      int oldY = 0;
      oldY = this.getY();

      int dx = 0;
      dx = carrotX - oldX;
      int dy = 0;
      dy = carrotY - oldY;

      int distance = 0;
      distance = (int) Math.sqrt((dx * dx) + (dy * dy));

      int newX = 0;
      newX = oldX + (hopStep * dx / distance);
      int newY = 0;
      newY = oldY + (hopStep * dy / distance);

      if (Math.abs(dx) <= hopStep && Math.abs(dy) <= hopStep) {
        this.setX(carrotX);
        this.setY(carrotY);
        Carrots.remove(carrotIndex);
      } else {
        this.setX(newX);
        this.setY(newY);
      }

    }
  }

  /**
   * Callback method called each time the mouse is pressed. Rabbit hops when mouse is pressed.
   */
  @Override
  public void mousePressed() {
    super.mousePressed();
    hopTowardsCarrot();
  }

  /**
   * This method watches out for wolves. Checks if there is a wolf in the Rabbit.scanRange of this
   * Rabbit.
   *
   * @return true if the current rabbit is close to at least one wolf
   */
  public boolean watchOutForWolf() {
    // TODO complete the implementation of this method
    // Traverse the processing.objects arraylist checking
    // whether there is a wolf which is close by Rabbit.scanRange
    // of this rabbit.
    for (int j = 0; j < processing.objects.size(); ++j) {
      if (processing.objects.get(j) instanceof Wolf) {
        if (this.isClose((Wolf) processing.objects.get(j), scanRange)) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Watches out for a wolf and display a Warning message "WOLF!" if there is any wolf in its
   * neighborhood.
   */
  @Override
  public void action() {
    if (watchOutForWolf()) {
      // this.setScaredImage();
      processing.fill(0); // specify font color: black
      processing.text("WOLF!", this.getX(), this.getY() - this.image.height / 2 - 6);
    }
  }

}

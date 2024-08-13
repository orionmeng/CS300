//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P04 Carrot Patch Wolf Class
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

public class Wolf extends Animal {

  // path to the wolf image file
  private static final String WOLF = "images" + File.separator + "wolf.png";
  private static int scanRange = 120; // scanning range to look for a rabbit
  // in the neighborhood
  private static int nextID = 1; // identifier of the next Wolf to be created
  private static final String TYPE = "W"; // A String that represents the Wolf type
  private final int ID; // positive number that represents the order of this Wolf
  private int rabbitEatenCount; // Number of rabbits that the current Wolf has eaten so far

  /**
   * Creates a new Wolf object at a random position of the display window
   *
   * @param processing CarrotPatch object which represents the display window
   */
  public Wolf() {
    // Set wolf drawing parameters
    super(WOLF);
    // Set wolf identification fields
    ID = nextID;
    this.label = TYPE + ID; // String that identifies the current wolf
    nextID++;
    rabbitEatenCount = 0;
  }

  // gets rabbitEatenCount instance field
  public int getRabbitEatenCount() {
    return rabbitEatenCount;
  }

  // gets the scanRange of a Wolf
  public static int getScanRange() {
    return scanRange;
  }

  /**
   * Moves to the position of the specified rabbit passed as input, and eats it. The eaten rabbit
   * will be removed from the patch and he number of eaten rabbits by this wolf is incremented by
   * one.
   * 
   * @param rabbit rabbit to eat by this wolf
   */
  public void eatRabbit(Rabbit rabbit) {

    if (isMouseOver()) {
      this.mouseReleased();
    }

    int rabbitX = 0;
    rabbitX = rabbit.getX();
    int rabbitY = 0;
    rabbitY = rabbit.getY();

    this.setX(rabbitX);
    this.setY(rabbitY);

    processing.objects.remove(rabbit);

    ++rabbitEatenCount;

  }

  /**
   * Defines the action of this wolf in the carrot patch. This wolf lookup for rabbits in its
   * neighborhood (Wolf.scanRange) and eats the first found rabbit only. This method also displays
   * the number of rabbit eaten by this wolf if any.
   */
  @Override
  public void action() {

    if (rabbitEatenCount > 0) {
      displayrabbitEatenCount(); // display rabbitEatenCount
    }

    for (int j = 0; j < processing.objects.size(); ++j) {
      if (processing.objects.get(j) instanceof Rabbit) {
        if (this.isClose((Rabbit) processing.objects.get(j), scanRange)) {
          eatRabbit((Rabbit) processing.objects.get(j));
        }
      }
    }

  }

  /**
   * Displays the number of eaten rabbits if any on the top of the Wolf image
   */
  public void displayrabbitEatenCount() {
    processing.fill(0); // specify font color: black
    // display rabbitEatenCount on the top of the Wolf's image
    processing.text(rabbitEatenCount, this.getX(), this.getY() - this.image.height / 2 - 6);
  }

}

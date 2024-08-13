//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P04 Carrot Patch
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

public class CarrotPatch extends PApplet {

  private PImage backgroundImage;
  protected ArrayList<GUIListener> objects;

  /**
   * This is the main method.
   */
  public static void main(String[] args) {
    PApplet.main("CarrotPatch");
  }

  /**
   * Defines the initial environment properties such as screen size and to load background images
   * and fonts as the program starts. It also initializes the backgroundImage, the data fields, and
   * sets the display window for the different graphic objects which will be drawn in this
   * application
   */
  @Override
  public void setup() {

    carrotPatchSettings();
    objects = new ArrayList<GUIListener>();
    backgroundImage = this.loadImage("images" + File.separator + "background.png");

    Carrots.settings(this);
    Button.setProcessing(this);
    Animal.setProcessing(this);

    PlantCarrotsButton PlantCarrotsButton = new PlantCarrotsButton(43, 16);
    objects.add(PlantCarrotsButton);
    AddRabbitButton AddRabbitButton = new AddRabbitButton(129, 16);
    objects.add(AddRabbitButton);
    AddWolfButton AddWolfButton = new AddWolfButton(215, 16);
    objects.add(AddWolfButton);
    RestartButton RestartButton = new RestartButton(301, 16);
    objects.add(RestartButton);

  }

  /**
   * Sets the display window title, text allignment, image mode, rectangle mode, and activates this
   * PApplet object to listen to the mouse events and user inputs
   */
  private void carrotPatchSettings() {
    this.getSurface().setTitle("Carrot Patch"); // Displays text in the title of the display window
    this.textAlign(PApplet.CENTER, PApplet.CENTER); // Sets the current alignment for drawing text
                                                    // to CENTER
    this.imageMode(PApplet.CENTER); // Sets the location from which images are drawn to CENTER
    this.rectMode(PApplet.CORNERS); // Sets the location from which rectangles are drawn.
    // rectMode(CORNERS) interprets the first two parameters of rect() method as the location of one
    // corner, and the third and fourth parameters as the location of the opposite corner.
    // rect() method draws a rectangle to the display window
    this.focused = true; // Confirms that our Processing program is "focused," meaning that it is
                         // active and will accept mouse or keyboard input.
  }

  /**
   * Sets the size of the application display window
   */
  @Override
  public void settings() {
    size(800, 600); // sets the size of the display window to 800 x 600 pixels
  }

  /**
   * Callback method called in an infinite loop. It draws the Jungle Park's window display
   */
  @Override
  public void draw() {

    this.image(backgroundImage, this.width / 2, this.height / 2);
    Carrots.draw();
    for (int i = 0; i < objects.size(); ++i) {
      objects.get(i).draw();
    }

  }

  /**
   * Callback method called each time the mouse is pressed
   */
  @Override
  public void mousePressed() {
    System.out.println("carrot patch mouse pressed called");
    for (int i = 0; i < objects.size(); ++i) {
      if (objects.get(i).isMouseOver()) {
        objects.get(i).mousePressed();
        break;
      }
    }

  }

  /**
   * Callback method called each time the mouse is released
   */
  @Override
  public void mouseReleased() {
    System.out.println("carrot patch mouse released called");
    for (int i = 0; i < objects.size(); ++i) {
      objects.get(i).mouseReleased();
    }

  }

  /**
   * Callback method called each time the user presses a key
   */
  @Override
  public void keyPressed() {

    switch (Character.toUpperCase(this.key)) {
      case 'R':
        objects.add(new Rabbit());
        break;

      case 'W':
        objects.add(new Wolf());
        break;

      case 'D':
        for (int i = 0; i < objects.size(); ++i) {
          if (objects.get(i).isMouseOver() && objects.get(i) instanceof Animal) {
            objects.remove(i);
            break;
          }
        }
    }

  }

  /**
   * Removes all the animals and planted carrots from this carrot patch
   */
  public void removeAll() {
    Carrots.removeAll();
    for (int i = 0; i < objects.size(); ++i) {
      if (objects.get(i) instanceof Animal) {
        objects.remove(i);
        --i;
      }
    }

  }

}

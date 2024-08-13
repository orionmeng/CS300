//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P04 Carrot Patch Plant Carrots Button
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

class PlantCarrotsButton extends Button {

  /**
   * This is the button to plant carrots.
   */
  public PlantCarrotsButton(float x, float y) {
    super("Plant Carrots", x, y);
  }

  /**
   * Callback method called each time the mouse is pressed. Plants carrots when mouse is pressed.
   */
  public void mousePressed() {
    if (isMouseOver()) {
      // System.out.println("Plant Carrots Button Pressed");
      Carrots.plant();
    }
  }

}

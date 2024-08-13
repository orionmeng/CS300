//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P04 Carrot Patch Restart Button
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

class RestartButton extends Button {

  /**
   * This is the button to restart the game.
   */
  public RestartButton(float x, float y) {
    super("Restart", x, y);
  }

  /**
   * Callback method called each time the mouse is pressed. Restarts game when mouse is pressed.
   */
  public void mousePressed() {
    if (isMouseOver()) {
      // System.out.println("Restart Button Pressed");
      processing.removeAll();
    }
  }

}

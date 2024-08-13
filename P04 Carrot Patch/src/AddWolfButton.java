//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P04 Carrot Patch Add Wolf Button
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

class AddWolfButton extends Button {

  /**
   * This is the button to add a wolf.
   */
  public AddWolfButton(float x, float y) {
    super("Add Wolf", x, y);
  }

  /**
   * Callback method called each time the mouse is pressed. Adds wolf when mouse is pressed.
   */
  public void mousePressed() {
    if (isMouseOver()) {
      // System.out.println("Add Wolf Button Pressed");
      processing.objects.add(new Wolf());
    }
  }

}

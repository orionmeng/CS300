//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P04 Carrot Patch Add Rabbit Button
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

class AddRabbitButton extends Button {

  /**
   * This is the button to add a rabbit.
   */
  public AddRabbitButton(float x, float y) {
    super("Add Rabbit", x, y);
  }

  /**
   * Callback method called each time the mouse is pressed. Adds rabbit when mouse is pressed.
   */
  public void mousePressed() {
    if (isMouseOver()) {
      // System.out.println("Add Rabbit Button Pressed");
      processing.objects.add(new Rabbit());
    }
  }

}

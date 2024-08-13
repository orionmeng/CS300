//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P07 Inventory Storage System
// Course:   CS 300 Spring 2021
//
// Author:   Orion Meng
// Email:    dmeng8@wisc.edu
// Lecturer: Mouna Kacem
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         NONE
// Online Sources:  NONE
//
///////////////////////////////////////////////////////////////////////////////

/*
 * This class models a LinkedBox used for inventory.
 */
public class LinkedBox {
  
  private Box box; // data carried by this linked box node
  private LinkedBox next; // data carried by next linkedBox
  
  /*
   * Creates a new LinkedBox with a specified box and null as next field.
   * 
   * @param box specified box
   */
  public LinkedBox(Box box) {
    this.box = box;
    this.next = null;
  }
  
  /*
   * Creates a new LinkedBox with given box and next fields.
   * 
   * @param box given box
   * @param next given next
   */
  public LinkedBox(Box box, LinkedBox next) {
    this.box = box;
    this.next = next;
  }
  
  /*
   * Returns the data field box.
   * 
   * @return the data field box
   */
  public Box getBox() {
    return this.box;
  }
  
  /*
   * Returns the next linked box node.
   * 
   * @return the next linked box node
   */
  public LinkedBox getNext() {
    return this.next;
  }
  
  /*
   * Sets the link to the next linked box node.
   * 
   * @param next given next linked box node
   */
  public void setNext(LinkedBox next) {
    this.next = next;
  }
  
  /*
   * Returns a String representation of this Linked box.
   * 
   * @return a String representation of this Linked box
   */
  @Override
  public String toString() {
    if (next != null) {
      return box.toString() + " -> ";
    }
    return box.toString() + " -> END";
  }
  
}

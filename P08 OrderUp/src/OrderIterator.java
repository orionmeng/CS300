//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P08 Order Up
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

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * This class creates an iterator system.
 */
public class OrderIterator implements Iterator<Order> {
  
  private LinkedOrder current; // the LinkedOrder that is being used
  
  /*
   * Initializes current.
   * 
   * @param start the LinkedOrder current is initialized to
   */
  public OrderIterator(LinkedOrder start) {
    current = start;
  }
  
  /*
   * Returns true if and only if the iteration has more orders.
   * 
   * @return true if and only if the iteration has more orders
   */
  public boolean hasNext() {
    if (current != null) {
      return true;
    }
    return false;
  }
  
  /*
   * Returns the next Order and updates the current field appropriately.
   * 
   * @return the next Order and updates the current field appropriately
   * @throws NoSuchElementException
   */
  public Order next() throws NoSuchElementException {
    if (!hasNext()) {
      throw new NoSuchElementException("No more orders.");
    }
    Order order = current.getOrder();
    current = current.getNext();
    return order;
  }
  
}

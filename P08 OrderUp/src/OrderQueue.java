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
 * This class creates a queue system.
 */
public class OrderQueue implements QueueADT<Order>, Iterable<Order> {
  
  private LinkedOrder front; // reference to the LinkedOrder at the front of the queue
  private LinkedOrder back; // reference to the LinkedOrder at the back of the queue
  private int size; // tracks the number of Orders currently in queue
  
  /*
   * Creates an iterator using the LinkedOrder at the front of the queue.
   * 
   * @return iterator
   */
  @Override
  public Iterator<Order> iterator() {
    Iterator<Order> iterator = new OrderIterator(front);
    return iterator;
  }
  
  /*
   * Adds a new LinkedOrder containing the given Order to the back of the queue.
   * Updates back reference.
   * Updates size variable.
   * 
   * @param newElement the Order to be added
   */
  public void enqueue(Order newElement) {
    if (size == 0) {
      LinkedOrder addNew = new LinkedOrder(newElement);
      front = addNew;
      back = addNew;
      size = 1;
    }
    else {
      LinkedOrder addNew = new LinkedOrder(newElement);
      back.setNext(addNew);
      back = addNew;
      ++size;
    }
  }
  
  /*
   * Removes the next LinkedOrder from the front of the queue.
   * Updates front reference.
   * Updates size variable.
   * 
   * @return the Order removed
   * @throws NoSuchElementException
   */
  public Order dequeue() throws NoSuchElementException {
    if (isEmpty()) {
      throw new NoSuchElementException("Queue is empty.");
    }
    if (size == 1) {
      Order remove = front.getOrder();
      front = null;
      back = null;
      size = 0;
      return remove;
    }
    else {
      Order remove = front.getOrder();
      front = front.getNext();
      --size;
      return remove;
    }
  }
  
  /*
   * Returns the Order from the LinkedOrder at the front of the queue.
   * 
   * @return the Order from the LinkedOrder at the front of the queue
   * @throws NoSuchElementException
   */
  public Order peek() throws NoSuchElementException {
    if (isEmpty()) {
      throw new NoSuchElementException("Queue is empty.");
    }
    return front.getOrder();
  }
  
  /*
   * Returns true if and only if the queue is empty.
   * 
   * @return true if and only if the queue is empty
   */
  public boolean isEmpty() {
    if (size == 0) {
      return true;
    }
    return false;
  }
  
  /*
   * Creates and returns a String representation of this OrderQueue using an enhanced-for loop.
   * Example: 1001: fries (2) -> 1002: shake (1) -> 1003: burger (3) -> END
   * 
   * @return a String representation of the queue
   */
  public String toString() {
    if (this.size == 0) return "";
    String qString = "";
    for (Order o : this) {
      qString += o.toString();
      qString += " -> ";
    }
    qString += "END";
    return qString;
  }
}

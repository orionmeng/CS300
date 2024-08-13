//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P08 Order Up Tester
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
 * This class tests the functionality of an iterator system and a queue system.
 */
public class OrderQueueTester {
  
  /*
   * Tests the iterator of OrderIterator.
   * 
   * @return false if bug
   */
  public static boolean testIterator() {
    LinkedOrder link1 = new LinkedOrder(new Order("one", 1));
    LinkedOrder link2 = new LinkedOrder(new Order("two", 2));
    LinkedOrder link3 = new LinkedOrder(new Order("three", 3));
    link1.setNext(link2);
    link2.setNext(link3);
    OrderIterator links1 = new OrderIterator(link1);
    Iterator<Order> iterator1 = links1;
    String compare = "";
    while (iterator1.hasNext()) {
      compare += iterator1.next().toString() + "\n";
    }
    // test 1: iterator test
    if (!compare.equals("1001: one (1)\n1002: two (2)\n1003: three (3)\n")) {
      System.out.println("testIterator() 1 failed.");
      return false;
    }
    OrderIterator links2 = new OrderIterator(link1);
    Iterator<Order> iterator2 = links2;
    iterator2.next();
    iterator2.next();
    iterator2.next();
    // test 2: exception test
    try {
      System.out.println("Error message after this line...");
      iterator2.next();
    } catch (NoSuchElementException e) {
      System.out.println(e.getMessage());
    } catch (Exception e) {
      System.out.println("testIterator() 2 failed.");
      return false;
    }
    return true;
  }
  
  /*
   * Tests the enqueue and dequeue methods of OrderQueue.
   * 
   * @return false if bug
   */
  public static boolean testEnqueueDequeue() {
    LinkedOrder link1 = new LinkedOrder(new Order("one", 1));
    LinkedOrder link2 = new LinkedOrder(new Order("two", 2));
    LinkedOrder link3 = new LinkedOrder(new Order("three", 3));
    OrderQueue queue = new OrderQueue();
    queue.enqueue(link1.getOrder());
    // test 1: enqueue to queue that is empty
    if (!queue.toString().equals("1004: one (1) -> END")) {
      System.out.println("testEnqueueDequeue() 1 failed.");
      return false;
    }
    queue.enqueue(link2.getOrder());
    queue.enqueue(link3.getOrder());
    // test 2: enqueue to queue that is not empty
    if (!queue.toString().equals("1004: one (1) -> 1005: two (2) -> 1006: three (3) -> END")) {
      System.out.println("testEnqueueDequeue() 2 failed.");
      return false;
    }
    queue.dequeue();
    queue.dequeue();
    // test 3: dequeue from queue that is not empty
    if (!queue.toString().equals("1006: three (3) -> END")) {
      System.out.println("testEnqueueDequeue() 3 failed.");
      return false;
    }
    queue.dequeue();
    // test 4: dequeue from queue to result in queue that is empty
    if (!queue.toString().equals("")) {
      System.out.println("testEnqueueDequeue() 4 failed.");
      return false;
    }
    // test 5: dequeue from queue that is empty
    try {
      System.out.println("Error message after this line...");
      queue.dequeue();
    } catch (NoSuchElementException e) {
      System.out.println(e.getMessage());
    } catch (Exception e) {
      System.out.println("testEnqueueDequeue() 5 failed.");
      return false;
    }
    return true;
  }
  
  /*
   * Tests the peek method of OrderQueue.
   * 
   * @return false if bug
   */
  public static boolean testPeek() {
    LinkedOrder link1 = new LinkedOrder(new Order("one", 1));
    LinkedOrder link2 = new LinkedOrder(new Order("two", 2));
    LinkedOrder link3 = new LinkedOrder(new Order("three", 3));
    OrderQueue queue = new OrderQueue();
    // test 1: see if peek correctly handles a queue that is empty
    try {
      System.out.println("Error message after this line...");
      queue.peek();
    } catch (NoSuchElementException e) {
      System.out.println(e.getMessage());
    } catch (Exception e) {
      System.out.println("testPeek() 1 failed.");
      return false;
    }
    queue.enqueue(link1.getOrder());
    // test 2: see if peek returns the correct value
    if (!queue.peek().toString().equals("1007: one (1)")) {
      System.out.println("testPeek() 2 failed.");
      return false;
    }
    queue.enqueue(link2.getOrder());
    queue.enqueue(link3.getOrder());
    // test 3: see if peek removes any value
    if (!queue.peek().toString().equals("1007: one (1)")) {
      System.out.println("testPeek() 3 failed.");
      return false;
    }
    return true;
  }
  
  /*
   * Tests the isEmpty method of OrderQueue.
   * 
   * @return false if bug
   */
  public static boolean testIsEmpty() {
    LinkedOrder link = new LinkedOrder(new Order("order", 99));
    OrderQueue queue = new OrderQueue();
    // test 1: see if queue that is empty is empty
    if (!queue.isEmpty()) {
      System.out.println("testIsEmpty() 1 failed.");
      return false;
    }
    // test 2: see if queue that is not empty is empty
    queue.enqueue(link.getOrder());
    if (queue.isEmpty()) {
      System.out.println("testIsEmpty() 2 failed.");
      return false;
    }
    return true;
  }
  
  /*
   * Runs all test methods.
   * 
   * @return false if bug
   */
  public static boolean runAllTests() {
    if (!testIterator()) {
      System.out.println("testIterator(): " + testIterator());
      return false;
    }
    if (!testEnqueueDequeue()) {
      System.out.println("testEnqueueDequeue(): " + testEnqueueDequeue());
      return false;
    }
    if (!testPeek()) {
      System.out.println("testPeek(): " + testPeek());
      return false;
    }
    if (!testIsEmpty()) {
      System.out.println("testIsEmpty(): " + testIsEmpty());
      return false;
    }
    return true;
  }
  
  /*
   * This is the main method.
   */
  public static void main(String[] args) {
    System.out.println("runAllTests(): " + runAllTests());
  }
  
}

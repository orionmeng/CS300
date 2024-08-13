import java.util.NoSuchElementException;

////////////////FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
//Title:    P10 Order Up Again Tester
//Course:   CS 300 Spring 2021
//
//Author:   Orion Meng
//Email:    dmeng8@wisc.edu
//Lecturer: Mouna Kacem
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
//Persons:         NONE
//Online Sources:  NONE
//
///////////////////////////////////////////////////////////////////////////////

/**
 * This class checks the correctness of the implementation of the methods defined in the class
 * OrderPriorityQueue.
 * 
 * You MAY add additional public static boolean methods to this class if you like, and any private
 * static helper methods you need.
 */
public class OrderPriorityQueueTester {
  
  /**
   * Checks the correctness of the isEmpty method of OrderPriorityQueue.
   * 
   * You should, at least:
   * (1) create a new OrderPriorityQueue and verify that it is empty
   * (2) add a new Order to the queue and verify that it is NOT empty
   * (3) remove that Order from the queue and verify that it is empty again
   * 
   * @return true if and only if ALL tests pass
   */
  public static boolean testIsEmpty() {
    Order.resetIDGenerator();
    OrderPriorityQueue prioQ = new OrderPriorityQueue(4);
    // test 1: empty
    if (!prioQ.isEmpty()) {
      System.out.println("testIsEmpty() 1 failed.");
      return false;
    }
    prioQ.insert(new Order("first", 1));
    // test 2: not empty since added
    if (prioQ.isEmpty()) {
      System.out.println("testIsEmpty() 2 failed.");
      return false;
    }
    prioQ.removeBest();
    // test 3: empty since removed
    if (!prioQ.isEmpty()) {
      System.out.println("testIsEmpty() 3 failed.");
      return false;
    }
    return true;
  }
  
  /**
   * Checks the correctness of the insert method of OrderPriorityQueue.
   * 
   * You should, at least:
   * (1) create a new OrderPriorityQueue and add a single order with a large prepTime to it
   * (2) use the OrderPriorityQueue toString method to verify that the queue's internal structure
   *     is a valid heap
   * (3) add at least three more orders with DECREASING prepTimes to the queue and repeat step 2.
   * 
   * @return true if and only if ALL tests pass
   */
  public static boolean testInsertBasic() {
    Order.resetIDGenerator();
    OrderPriorityQueue prioQ = new OrderPriorityQueue(4);
    prioQ.insert(new Order("large", 10));
    // test 1: just one
    if (!prioQ.toString().equals("1001(10)")) {
      System.out.println("testInsertBasic() 1 failed.");
      return false;
    }
    prioQ.insert(new Order("medium", 7));
    prioQ.insert(new Order("small", 4));
    prioQ.insert(new Order("tiny", 1));
    // test 2: added more
    if (!prioQ.toString().equals("1001(10), 1002(7), 1003(4), 1004(1)")) {
      System.out.println("testInsertBasic() 2 failed.");
      return false;
    }
    return true;
  }
  
  /**
   * Checks the correctness of the insert method of OrderPriorityQueue.
   * 
   * You should, at least:
   * (1) create an array of at least four Orders that represents a valid heap
   * (2) add a fifth order at the next available index that is NOT in a valid heap position
   * (3) pass this array to OrderPriorityQueue.percolateUp()
   * (4) verify that the resulting array is a valid heap
   * 
   * @return true if and only if ALL tests pass
   */
  public static boolean testPercolateUp() {
    Order.resetIDGenerator();
    Order[] array = new Order[6];
    array[0] = new Order("zero", 8);
    array[1] = new Order("one", 6);
    array[2] = new Order("two", 4);
    array[3] = new Order("three", 5);
    array[4] = new Order("four", 1);
    array[5] = new Order("five", 7);
    OrderPriorityQueue.percolateUp(array, 5);
    // test 1: check 0 and 1 not changed
    if (array[0].getPrepTime() != 8 || array[1].getPrepTime() != 6) {
      System.out.println("testPercolateUp() 1 failed.");
      return false;
    }
    // test 2: check 3 and 4 not changed
    if (array[3].getPrepTime() != 5 || array[4].getPrepTime() != 1) {
      System.out.println("testPercolateUp() 2 failed.");
      return false;
    }
    // test 3: check 2 and 5 switched
    if (array[2].getPrepTime() != 7 || array[5].getPrepTime() != 4) {
      System.out.println("testPercolateUp() 3 failed.");
      return false;
    }
    return true;
  }
  
  /**
   * Checks the correctness of the insert method of OrderPriorityQueue.
   * 
   * You should, at least:
   * (1) create a new OrderPriorityQueue with at least 6 orders of varying prepTimes, adding them
   *     to the queue OUT of order
   * (2) use the OrderPriorityQueue toString method to verify that the queue's internal structure
   *     is a valid heap
   * 
   * @return true if and only if ALL tests pass
   */
  public static boolean testInsertAdvanced() {
    Order.resetIDGenerator();
    OrderPriorityQueue prioQ = new OrderPriorityQueue(6);
    Order zero = new Order("zero", 8);
    Order one = new Order("one", 6);
    Order two = new Order("two", 7);
    Order three = new Order("three", 5);
    Order four = new Order("four", 1);
    Order five = new Order("five", 4);
    prioQ.insert(two);
    // test 1: insert one
    if (!prioQ.toString().equals("1003(7)")) {
      System.out.println("testInsertAdvanced() 1 failed.");
      return false;
    }
    // test 2: insert one more
    prioQ.insert(three);
    if (!prioQ.toString().equals("1003(7), 1004(5)")) {
      System.out.println("testInsertAdvanced() 2 failed.");
      return false;
    }
    // test 3: insert one more
    prioQ.insert(one);
    if (!prioQ.toString().equals("1003(7), 1004(5), 1002(6)")) {
      System.out.println("testInsertAdvanced() 3 failed.");
      return false;
    }
    // test 4: insert one more
    prioQ.insert(four);
    if (!prioQ.toString().equals("1003(7), 1004(5), 1002(6), 1005(1)")) {
      System.out.println("testInsertAdvanced() 4 failed.");
      return false;
    }
    // test 5: insert one more
    prioQ.insert(five);
    if (!prioQ.toString().equals("1003(7), 1004(5), 1002(6), 1005(1), 1006(4)")) {
      System.out.println("testInsertAdvanced() 5 failed.");
      return false;
    }
    // test 6: insert one more
    prioQ.insert(zero);
    if (!prioQ.toString().equals("1001(8), 1004(5), 1003(7), 1005(1), 1006(4), 1002(6)")) {
      System.out.println("testInsertAdvanced() 6 failed.");
      return false;
    }
    return true;
  }
  
  /**
   * Checks the correctness of the insert method of OrderPriorityQueue.
   * 
   * You should, at least:
   * (1) create an array of at least five Orders where the Order at index 0 is NOT in valid heap
   *     position
   * (2) pass this array to OrderPriorityQueue.percolateDown()
   * (3) verify that the resulting array is a valid heap
   * 
   * @return true if and only if ALL tests pass
   */
  public static boolean testPercolateDown() {
    Order.resetIDGenerator();
    Order[] array = new Order[6];
    array[0] = new Order("zero", 2);
    array[1] = new Order("one", 15);
    array[2] = new Order("two", 8);
    array[3] = new Order("three", 12);
    array[4] = new Order("four", 4);
    array[5] = new Order("five", 5);
    OrderPriorityQueue.percolateDown(array, 0, 6);
    // test 1: check for correct values
    if (array[0].getPrepTime() != 15 || array[1].getPrepTime() != 12) {
      System.out.println("testPercolateDown() 1 failed.");
      return false;
    }
    // test 2: check for correct values
    if (array[2].getPrepTime() != 8 || array[3].getPrepTime() != 2) {
      System.out.println("testPercolateDown() 2 failed.");
      return false;
    }
    // test 3: check for correct values
    if (array[4].getPrepTime() != 4 || array[5].getPrepTime() != 5) {
      System.out.println("testPercolateDown() 3 failed.");
      return false;
    }
    return true;
  }
  
  /**
   * Checks the correctness of the removeBest and peekBest methods of OrderPriorityQueue.
   * 
   * You should, at least:
   * (1) create a new OrderPriorityQueue with at least 6 orders of varying prepTimes, adding them
   *     to the queue in whatever order you like
   * (2) remove all but one of the orders, verifying that each order has a SHORTER prepTime than
   *     the previously-removed order
   * (3) peek to see that the only order left is the one with the SHORTEST prepTime
   * (4) check isEmpty to verify that the queue has NOT been emptied
   * (5) remove the last order and check isEmpty to verify that the queue HAS been emptied
   * 
   * @return true if and only if ALL tests pass
   */
  public static boolean testPeekRemove() {
    Order.resetIDGenerator();
    OrderPriorityQueue prioQ = new OrderPriorityQueue(6);
    prioQ.insert(new Order("zero", 8));
    prioQ.insert(new Order("one", 6));
    prioQ.insert(new Order("two", 1));
    prioQ.insert(new Order("three", 5));
    prioQ.insert(new Order("four", 1));
    prioQ.insert(new Order("five", 4));
    Order removed;
    Order peeked;
    prioQ.peekBest();
    // test 01: check peek size unchanged
    if (prioQ.size() != 6) {
      System.out.println("testPeekRemove() 01 failed.");
      return false;
    }
    // test 02: check peek root unchanged
    if (prioQ.peekBest().getPrepTime() != 8) {
      System.out.println("testPeekRemove() 02 failed.");
      return false;
    }
    removed = prioQ.removeBest();
    peeked = prioQ.peekBest();
    // test 03: check removed and peeked values
    if (removed.compareTo(peeked) < 0) {
      System.out.println("testPeekRemove() 03 failed.");
      return false;
    }
    removed = prioQ.removeBest();
    peeked = prioQ.peekBest();
    // test 04: check removed and peeked values again
    if (removed.compareTo(peeked) < 0) {
      System.out.println("testPeekRemove() 04 failed.");
      return false;
    }
    removed = prioQ.removeBest();
    peeked = prioQ.peekBest();
    // test 05: check removed and peeked values again
    if (removed.compareTo(peeked) < 0) {
      System.out.println("testPeekRemove() 05 failed.");
      return false;
    }
    removed = prioQ.removeBest();
    peeked = prioQ.peekBest();
    // test 06: check removed and peeked values again
    if (removed.compareTo(peeked) < 0) {
      System.out.println("testPeekRemove() 06 failed.");
      return false;
    }
    removed = prioQ.removeBest();
    peeked = prioQ.peekBest();
    // test 07: check removed and peeked values again
    if (removed.compareTo(peeked) < 0) {
      System.out.println("testPeekRemove() 07 failed.");
      return false;
    }
    // test 08: check final order time
    if (peeked.getPrepTime() != 1) {
      System.out.println("testPeekRemove() 08 failed.");
      return false;
    }
    // test 09: check queue is not empty
    if (prioQ.isEmpty()) {
      System.out.println("testPeekRemove() 09 failed.");
      return false;
    }
    prioQ.removeBest();
    // test 10: check queue is empty
    if (!prioQ.isEmpty()) {
      System.out.println("testPeekRemove() 10 failed.");
      return false;
    }
    return true;
  }
  
  /**
   * Checks the correctness of the removeBest and peekBest methods, as well as the constructor of 
   * the OrderPriorityQueue class for erroneous inputs and/or states
   * 
   * You should, at least:
   * (1) create a new OrderPriorityQueue with an invalid capacity argument, and verify that the 
   *     correct exception is thrown
   * (2) call peekBest() on an OrderPriorityQueue with an invalid state for peeking, and verify that
   *     the correct exception is thrown
   * (3) call removeBest() on an OrderPriorityQueue with an invalid state for removing, and verify
   *     that the correct exception is thrown
   * 
   * @return true if and only if ALL tests pass
   */
  public static boolean testErrors() {
    Order.resetIDGenerator();
    // test 1: illegal argument with zero capacity
    try {
      OrderPriorityQueue prioQ = new OrderPriorityQueue(0);
    } catch (IllegalArgumentException e) {
      // test passed
    } catch (Exception e) {
      System.out.println("testErrors() 01 failed.");
      return false;
    }
    // test 2: illegal argument with negative capacity
    try {
      OrderPriorityQueue prioQ = new OrderPriorityQueue(-1);
    } catch (IllegalArgumentException e) {
      // test passed
    } catch (Exception e) {
      System.out.println("testErrors() 02 failed.");
      return false;
    }
    OrderPriorityQueue prioQ = new OrderPriorityQueue(1);
    // test 1: no such element with peeking from empty queue
    try {
      prioQ.peekBest();
    } catch (NoSuchElementException e) {
      // test passed
    } catch (Exception e) {
      System.out.println("testErrors() 03 failed.");
      return false;
    }
    // test 1: no such element with removing from empty queue
    try {
      prioQ.removeBest();
    } catch (NoSuchElementException e) {
      // test passed
    } catch (Exception e) {
      System.out.println("testErrors() 04 failed.");
      return false;
    }
    return true;
  }
  
  /**
   * Calls the test methods individually and displays their output
   * @param args
   */
  public static void main(String[] args) {
    System.out.println("isEmpty: "+testIsEmpty());
    System.out.println("insert basic: "+testInsertBasic());
    System.out.println("percolate UP: "+testPercolateUp());
    System.out.println("insert advanced: "+testInsertAdvanced());
    System.out.println("percolate DOWN: "+testPercolateDown());
    System.out.println("peek/remove valid: "+testPeekRemove());
    System.out.println("error: "+testErrors());
  }

}

//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P07 Inventory Storage System Tester
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

import java.util.NoSuchElementException;

/*
 * This class tests the inventory system.
 */
public class InventorySystemTester {
  
  /*
   * Checks for the correctness of the LinkedBox() constructor.
   */
  public static boolean testLinkedBox() {
    Box.restartNextInventoryNumber();
    LinkedBox linkedBox = new LinkedBox(new Box(Color.BLUE));
    // test 1: new LinkedBox(Box box) color and number check
    if (linkedBox.getBox().getColor() != Color.BLUE
        || linkedBox.getBox().getInventoryNumber() != 1) {
      Box.restartNextInventoryNumber();
      System.out.println("testLinkedBox() 1 failed.");
      return false;
    }
    LinkedBox linkedNext = new LinkedBox(new Box(Color.BROWN), linkedBox);
    // test 2: new LinkedBox(Box box, LinkedBox next) color and number check
    if (linkedNext.getBox().getColor() != Color.BROWN
        || linkedNext.getBox().getInventoryNumber() != 2) {
      Box.restartNextInventoryNumber();
      System.out.println("testLinkedBox() 2 failed.");
      return false;
    }
    // test 3: new LinkedBox(Box box, LinkedBox next) next check
    if (linkedNext.getNext() != linkedBox) {
      Box.restartNextInventoryNumber();
      System.out.println("testLinkedBox() 3 failed.");
      return false;
    }
    Box.restartNextInventoryNumber();
    return true;
  }
  
  /*
   * Checks for the correctness of the InventoryList.clear() method.
   */
  public static boolean testClear() {
    Box.restartNextInventoryNumber();
    InventoryList list = new InventoryList();
    list.addBlue(new Box(Color.BLUE));
    list.addBlue(new Box(Color.BLUE));
    list.addBlue(new Box(Color.BLUE));
    if (!list.toString().equals("BLUE 3 -> BLUE 2 -> BLUE 1 -> END")) {
      Box.restartNextInventoryNumber();
      System.out.println("Unable to continue testClear() since addCOLOR() is not functional.");
      return false;
    }
    if (list.getBlueCount() != 3) {
      Box.restartNextInventoryNumber();
      System.out.println("Unable to continue testClear() since addCOLOR() is not functional.");
      return false;
    }
    list.clear();
    // test 1: list string check
    if (list.toString() != "") {
      Box.restartNextInventoryNumber();
      System.out.println("testClear() 1 failed.");
      return false;
    }
    // test 2: list count check
    if (list.getBlueCount() != 0) {
      Box.restartNextInventoryNumber();
      System.out.println("testClear() 2 failed.");
      return false;
    }
    Box.restartNextInventoryNumber();
    return true;
  }
  
  /*
   * Checks for the correctness of the InventoryList.addYellow(),
   * InventoryList.addBlue(), and InventoryList.addBrown() methods.
   */
  public static boolean testAddBoxes() {
    Box.restartNextInventoryNumber();
    InventoryList list = new InventoryList();
    // test 01: no such element exception check
    try {
      System.out.println("An error message should appear after this line:");
      list.addBlue(new Box(Color.BROWN));
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      Box.restartNextInventoryNumber();
    } catch (Exception e) {
      System.out.println("testAddBoxes() 01 failed.");
      Box.restartNextInventoryNumber();
      return false;
    }
    list.addBlue(new Box(Color.BLUE));
    list.addBrown(new Box(Color.BROWN));
    list.addBrown(new Box(Color.BROWN));
    list.addYellow(new Box(Color.YELLOW));
    list.addYellow(new Box(Color.YELLOW));
    list.addYellow(new Box(Color.YELLOW));
    list.addBlue(new Box(Color.BLUE));
    list.addBrown(new Box(Color.BROWN));
    list.addBrown(new Box(Color.BROWN));
    // test 02: list string check
    if (!list.toString().equals("YELLOW 6 -> YELLOW 5 -> YELLOW 4"
        + " -> BLUE 7 -> BLUE 1"
        + " -> BROWN 2 -> BROWN 3 -> BROWN 8 -> BROWN 9 -> END")) {
      System.out.println("testAddBoxes() 02 failed.");
      Box.restartNextInventoryNumber();
      return false;
    }
    // test 03: addBlue() check
    if (list.getBlueCount() != 2) {
      System.out.println("testAddBoxes() 03 failed.");
      Box.restartNextInventoryNumber();
      return false;
    }
    // test 04: addBrown() check
    if (list.getBrownCount() != 4) {
      System.out.println("testAddBoxes() 04 failed.");
      Box.restartNextInventoryNumber();
      return false;
    }
    // test 05: addYellow() check
    if (list.getYellowCount() != 3) {
      System.out.println("testAddBoxes() 05 failed.");
      Box.restartNextInventoryNumber();
      return false;
    }
    list.clear();
    Box.restartNextInventoryNumber();
    list.addBlue(new Box(Color.BLUE));
    // test 06: addBlue() to empty list string check
    if (!list.toString().equals("BLUE 1 -> END")) {
      System.out.println("testAddBoxes() 06 failed.");
      Box.restartNextInventoryNumber();
      return false;
    }
    // test 07: addBlue() to empty list count check
    if (list.getBlueCount() != 1) {
      System.out.println("testAddBoxes() 07 failed.");
      Box.restartNextInventoryNumber();
      return false;
    }
    list.clear();
    Box.restartNextInventoryNumber();
    list.addBrown(new Box(Color.BROWN));
    // test 08: addBrown() to empty list count check
    if (!list.toString().equals("BROWN 1 -> END")) {
      System.out.println("testAddBoxes() 08 failed.");
      Box.restartNextInventoryNumber();
      return false;
    }
    // test 09: addBrown() to empty list count check
    if (list.getBrownCount() != 1) {
      System.out.println("testAddBoxes() 09 failed.");
      Box.restartNextInventoryNumber();
      return false;
    }
    list.clear();
    Box.restartNextInventoryNumber();
    list.addYellow(new Box(Color.YELLOW));
    // test 10: addYellow() to empty list count check
    if (!list.toString().equals("YELLOW 1 -> END")) {
      System.out.println("testAddBoxes() 10 failed.");
      Box.restartNextInventoryNumber();
      return false;
    }
    // test 11: addYellow() to empty list count check
    if (list.getYellowCount() != 1) {
      System.out.println("testAddBoxes() 11 failed.");
      Box.restartNextInventoryNumber();
      return false;
    }
    // test 12: addBlue() null check
    try {
      System.out.println("An error message should appear after this line:");
      list.addBlue(null);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      Box.restartNextInventoryNumber();
    } catch (Exception e) {
      System.out.println("testAddBoxes() 12 failed.");
      Box.restartNextInventoryNumber();
      return false;
    }
    // test 13: addBrown() null check
    try {
      System.out.println("An error message should appear after this line:");
      list.addBrown(null);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      Box.restartNextInventoryNumber();
    } catch (Exception e) {
      System.out.println("testAddBoxes() 13 failed.");
      Box.restartNextInventoryNumber();
      return false;
    }
    // test 14: addYellow() null check
    try {
      System.out.println("An error message should appear after this line:");
      list.addYellow(null);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      Box.restartNextInventoryNumber();
    } catch (Exception e) {
      System.out.println("testAddBoxes() 14 failed.");
      Box.restartNextInventoryNumber();
      return false;
    }
    Box.restartNextInventoryNumber();
    return true;
  }
  
  /*
   * Checks for the correctness of the InventoryList.removeBox(),
   * InventoryList.removeYellow(), and InventoryList.remove Brown()
   * methods.
   */
  public static boolean testRemoveBoxes() {
    Box.restartNextInventoryNumber();
    InventoryList list = new InventoryList();
    list.addBlue(new Box(Color.BLUE));
    list.addBrown(new Box(Color.BROWN));
    list.addBrown(new Box(Color.BROWN));
    list.addYellow(new Box(Color.YELLOW));
    list.addYellow(new Box(Color.YELLOW));
    list.addYellow(new Box(Color.YELLOW));
    list.addBlue(new Box(Color.BLUE));
    list.addBrown(new Box(Color.BROWN));
    list.addBrown(new Box(Color.BROWN));
    // test 1: list string check
    if (!list.toString().equals("YELLOW 6 -> YELLOW 5 -> YELLOW 4"
        + " -> BLUE 7 -> BLUE 1"
        + " -> BROWN 2 -> BROWN 3 -> BROWN 8 -> BROWN 9 -> END")) {
      System.out.println("testRemoveBoxes() 1 failed.");
      Box.restartNextInventoryNumber();
      return false;
    }
    list.removeBox(7);
    // test 2: removeBox string check
    if (!list.toString().equals("YELLOW 6 -> YELLOW 5 -> YELLOW 4"
        + " -> BLUE 1"
        + " -> BROWN 2 -> BROWN 3 -> BROWN 8 -> BROWN 9 -> END")) {
      System.out.println("testRemoveBoxes() 2 failed.");
      Box.restartNextInventoryNumber();
      return false;
    }
    // test 3: removeBox count check
    if (list.getBlueCount() != 1) {
      System.out.println("testRemoveBoxes() 3 failed.");
      Box.restartNextInventoryNumber();
      return false;
    }
    list.removeBrown();
    // test 4: removeBrown string check
    if (!list.toString().equals("YELLOW 6 -> YELLOW 5 -> YELLOW 4"
        + " -> BLUE 1"
        + " -> BROWN 2 -> BROWN 3 -> BROWN 8 -> END")) {
      System.out.println("testRemoveBoxes() 4 failed.");
      Box.restartNextInventoryNumber();
      return false;
    }
    // test 5: removeBrown count check
    if (list.getBrownCount() != 3) {
      System.out.println("testRemoveBoxes() 5 failed.");
      Box.restartNextInventoryNumber();
      return false;
    }
    list.removeYellow();
    // test 6: removeYellow string check
    if (!list.toString().equals("YELLOW 5 -> YELLOW 4"
        + " -> BLUE 1"
        + " -> BROWN 2 -> BROWN 3 -> BROWN 8 -> END")) {
      System.out.println("testRemoveBoxes() 6 failed.");
      Box.restartNextInventoryNumber();
      return false;
    }
    // test 7: removeYellow count check
    if (list.getYellowCount() != 2) {
      System.out.println("testRemoveBoxes() 7 failed.");
      Box.restartNextInventoryNumber();
      return false;
    }
    Box.restartNextInventoryNumber();
    return true;
  }
  
  /*
   * Checks for the correctness of the InventoryList.get() method.
   */
  public static boolean testGetBoxes() {
    InventoryList list = new InventoryList();
    list.addBlue(new Box(Color.BLUE));
    // test 1: get invalid index
    try {
      System.out.println("An error message should appear after this line:");
      list.get(1);
    } catch (IndexOutOfBoundsException e) {
      System.out.println(e.getMessage());
    } catch (Exception e) {
      System.out.println("testGetBoxes() 1 failed.");
      Box.restartNextInventoryNumber();
      return false;
    }
    // test 2: get valid index
    if (!list.get(0).toString().equals("BLUE 1")) {
      System.out.println("testGetBoxes() 2 failed.");
      Box.restartNextInventoryNumber();
      return false;
    }
    return true;
  }
  
  /*
   * Runs all test methods.
   */
  public static boolean runAllTests() {
    if (!testLinkedBox()) {
      return false;
    }
    if (!testClear()) {
      return false;
    }
    if (!testAddBoxes()) {
      return false;
    }
    if (!testRemoveBoxes()) {
      return false;
    }
    if (!testGetBoxes()) {
      return false;
    }
    return true;
  }
  
  /*
   * The main method; calls test methods.
   */
  public static void main(String[] args) {
    runAllTests();
    Box.restartNextInventoryNumber();
    demo();
  }
  
  /*
   * Helper method to display the size and the count of different boxes stored in a list of boxes.
   * @param list a reference to an InventoryList object
   * @throws NullPointerException if list is null
   */
  private static void displaySizeCounts(InventoryList list) {
    System.out.println(" Size: " + list.size() +
        ", yellowCount: " + list.getYellowCount() +
        ", blueCount: " + list.getBlueCount() +
        ", brownCount: " + list.getBrownCount());
  }
  
  /*
   * Demo method showing how to use the implemented classes in P07 Inventory Storage System.
   * 
   * @param args input arguments
   */
  public static void demo() {
    // Create a new empty InventoryList object
    InventoryList list = new InventoryList();
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    // Add a blue box to an empty list
    list.addBlue(new Box(Color.BLUE)); // adds BLUE 1
    System.out.println(list); // prints list's content
    list.addYellow(new Box(Color.YELLOW)); // adds YELLOW 2 at the head of the list
    System.out.println(list); // prints list's content
    list.addBlue(new Box(Color.BLUE)); // adds BLUE 3
    System.out.println(list); // prints list's content
    list.addYellow(new Box(Color.YELLOW)); // adds YELLOW 4
    System.out.println(list); // prints list's content
    list.addYellow(new Box(Color.YELLOW)); // adds YELLOW 5 at the head of the list
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    // Add more boxes to list and display its contents
    list.addBrown(new Box(Color.BROWN)); // adds BROWN 6 at the end of the list
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    list.addBrown(new Box(Color.BROWN)); // adds BROWN 7 at the end of the list
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    list.removeBrown(); // removes BROWN 7 from the list
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    list.addBlue(new Box(Color.BLUE)); // adds BLUE 8
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    list.removeBrown(); // removes BROWN 6 from the list
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    list.removeYellow(); // removes YELLOW 5
    System.out.println(list); // prints list's content
    list.removeBox(3); // removes BLUE 3 from the list
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    try {
      list.removeBox(25); // tries to remove box #25
    }
    catch(NoSuchElementException e) {
      System.out.println(e.getMessage());
    }
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    // remove all yellow boxes
    while(list.getYellowCount() != 0) {
      list.removeYellow();
    }
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    list.removeBox(1); // removes BLUE 1 from the list -> empty list
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    list.addBrown(new Box(Color.BROWN)); // adds BROWN 9 to the list
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    list.removeBox(8); // removes BLUE 8 from the list
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    list.removeBrown(); // removes BROWN 9 from the list
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    list.addYellow(new Box(Color.YELLOW)); // adds YELLOW 10 to the list
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
    list.removeBox(10); // removes YELLOW 10 from the list
    System.out.println(list); // prints list's content
    displaySizeCounts(list); // displays list's size and counts
  }
  
}

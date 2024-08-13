//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P01 Self Checkout Kiosk Tester
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

import java.util.Arrays;

/**
 * This class contains tests for a self checkout kiosk.
 *
 * @author Mouna Kacem
 * @author Orion Meng
 */
public class SelfCheckoutKioskTester {

  /**
   * Checks the correctness of SelfCheckoutKiosk.getItemName() method
   * Checks the correctness of SelfCheckoutKiosk.getItemPrice() method
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetItemNameAndPriceMethods() {
    
    for (int i = 0; i < SelfCheckoutKiosk.GROCERY_ITEMS.length; i++) {
      // check the correctness of the getItemName(i) method
      if (!SelfCheckoutKiosk.getItemName(i).equals(SelfCheckoutKiosk.GROCERY_ITEMS[i][0])) {
        System.out.println("Problem detected: Called your getItemName() method with "
            + "input value " + i + ". But it did not return the expected output.");
        return false;
      }
      // check the correctness of the getItemPrice(i) method
      double expectedPriceOutput =
          Double.valueOf(SelfCheckoutKiosk.GROCERY_ITEMS[i][1].substring(1).trim());
      if (Math.abs((SelfCheckoutKiosk.getItemPrice(i) - expectedPriceOutput)) > 0.001) {
        System.out.println("Problem detected: Actual price output does not match the expected.");
        return false;
      }
    }
    return true; // No defect detected -> The implementation passes this test
  }

  /**
   * Checks the correctness of SelfCheckoutKiosk.addItemToBaggingArea() method
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddItemToBaggingArea() {
    // Create an empty bagging area
    String[] items = new String[10];
    String[] check = new String[10];
    int size = 0;

    // (1) Add one item to an empty bagging area
    size = SelfCheckoutKiosk.addItemToBaggingArea(0, items, size);
    if (size != 1) {
      System.out.println("Problem detected: Tried to add one item to an empty "
          + "bagging area. The returned size must be 1. But your addItemToBaggingArea "
          + "method returned a different output.");
      return false;
    }
    if (!items[0].equals(SelfCheckoutKiosk.getItemName(0))) {
      System.out.println("Problem detected: Tried to add only one item to an empty "
          + "bagging area. But that item was not appropriately added to the contents "
          + "of the items array.");
      return false;
    }

    // (2) Consider a non-empty bagging area
    items = new String[] {"Milk", "Chocolate", "Onion", null, null, null, null};
    size = 3;
    size = SelfCheckoutKiosk.addItemToBaggingArea(10, items, size);
    if (size != 4) {
      System.out.println("Problem detected: Tried to add only one item to an non-empty, "
          + "bagging area. The size must be incremented after the method returns. But "
          + "it was not the case.");
      return false;
    }
    if (!items[3].equals(SelfCheckoutKiosk.getItemName(10))) {
      System.out.println("Problem detected: Tried to add one item to an non-empty, "
          + "bagging area. But that item was not appropriately added to the contents "
          + "of the items array.");
      return false;
    }

    // (3) Consider adding an item to a full bagging are
    items = new String[] {"Pizza", "Eggs", "Apple"};
    check = new String[] {"Pizza", "Eggs", "Apple"};
    size = 3;
    size = SelfCheckoutKiosk.addItemToBaggingArea(2, items, size);
    if (size != 3) {
      System.out.println("Problem detected: Tried to add only one item to a full/filled, "
          + "bagging area. The size must remain unchanged after the method returns. But "
          + "it was not the case.");
      return false;
    }
    if (!Arrays.equals(items, check)) {
      System.out.println("Problem detected: Tried to add only one item to a full/filled, "
          + "bagging area. The contents of the items array should remain unchanged. But "
          + "it was not the case.");
      return false;
    }
    
    return true; // No defects detected by this unit test
  }

  /**
   * Checks the correctness of SelfCheckoutKiosk.count() method
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testCount() {
    // initiating variables to be used for testing
    String item = null;
    String[] items = new String[10];
    int size = 0;
    int occurrences = 0;
    // (1) check for 0 occurrences
    item = "banana";
    items = new String[] {"Pizza", "Eggs", "Apple"};
    size = 3;
    occurrences = SelfCheckoutKiosk.count(item, items, size);
    if (occurrences != 0) {
      System.out.println("Problem detected: The number or occurrences should be 0.");
      return false;
    }
    // (2) check for 1 occurrence
    item = "banana";
    items = new String[] {"Pizza", "Eggs", "Apple", "Banana", "Apple"};
    size = 5;
    occurrences = SelfCheckoutKiosk.count(item, items, size);
    if (occurrences != 1) {
      System.out.println("Problem detected: The number or occurrences should be 1.");
      return false;
    }
    // (3) check for 2 occurrences
    item = "banana";
    items = new String[] {"Pizza", "Eggs", "Apple", "Banana", "Grape", "Eggs", "Banana"};
    size = 7;
    occurrences = SelfCheckoutKiosk.count(item, items, size);
    if (occurrences != 2) {
      System.out.println("Problem detected: The number or occurrences should be 2.");
      return false;
    }
    
    return true; // No defects detected by this unit test
  }

  /**
   * Checks the correctness of SelfCheckoutKiosk.indexOf() method
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testIndexOf() {
    // initiating variables to be used for testing
    String item = null;
    String[] items = new String[10];
    int size = 7;
    int foundIndex = 0;
    // (1) check for if none of the item in bag
    foundIndex = -1;
    item = "chicken";
    items = new String[] {"Pizza", "Eggs", "Apple", "Banana", "Grape", "Eggs", "Banana"};
    foundIndex = SelfCheckoutKiosk.indexOf(item, items, size);
    if (foundIndex != -1) {
      System.out.println("Problem detected: There should be no found index; should return -1.");
      return false;
    }
    // (2) check for if one of the item in bag
    foundIndex = -1;
    item = "pizza";
    items = new String[] {"Pizza", "Eggs", "Apple", "Banana", "Grape", "Eggs", "Banana"};
    foundIndex = SelfCheckoutKiosk.indexOf(item, items, size);
    if (foundIndex != 0) {
      System.out.println("Problem detected: There is a pizza at index 0; should return 0.");
      return false;
    }
    // (3) check for if multiple of the item in bag
    foundIndex = -1;
    item = "banana";
    items = new String[] {"Pizza", "Eggs", "Apple", "Banana", "Grape", "Eggs", "Banana"};
    foundIndex = SelfCheckoutKiosk.indexOf(item, items, size);
    if (foundIndex != 3) {
      System.out.println("Problem detected: There is a banana at index 3 and 6; should return 3.");
      return false;
    }
    
    return true; // No defects detected by this unit test
  }

  /**
   * Checks the correctness of SelfCheckoutKiosk.remove() method
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testRemove() {
    // initiating variables to be used for testing
    String item = null;
    String[] items = new String[10];
    int size = 0;
    // (1) check for if the item being removed does not exist in the bag
    size = 7;
    item = "chicken";
    items = new String[] {"Pizza", "Eggs", "Apple", "Banana", "Grape", "Eggs", "Banana"};
    size = SelfCheckoutKiosk.remove(item, items, size);
    if (size != 7) {
      System.out.println("Problem detected: There should be no found item; size should remain 7.");
      return false;
    }
    // (2) check for if the bag is empty
    size = 0;
    item = "pizza";
    items = new String[] {};
    size = SelfCheckoutKiosk.remove(item, items, size);
    if (size != 0) {
      System.out.println("Problem detected: There should be an empty bag; size should remain 0.");
      return false;
    }
    // (3) check for if only one of the item is removed
    size = 7;
    item = "banana";
    items = new String[] {"Pizza", "Eggs", "Apple", "Banana", "Grape", "Eggs", "Banana"};
    size = SelfCheckoutKiosk.remove(item, items, size);
    if (size != 6) {
      System.out.println("Problem detected: There should be a banana removed; size should be 6.");
      return false;
    }
    // (4) check for if the item is removed
    size = 7;
    item = "grape";
    items = new String[] {"Pizza", "Eggs", "Apple", "Banana", "Grape", "Eggs", "Banana"};
    size = SelfCheckoutKiosk.remove(item, items, size);
    if (size != 6) {
      System.out.println("Problem detected: There should be a grape removed; size should be 6.");
      return false;
    }
    
    return true; // No defects detected by this unit test
  }

  /**
   * Checks the correctness of SelfCheckoutKiosk.getSubTotalPrice() method
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetSubTotalPrice() {
    // initiating variables to be used for testing
    String item = null;
    String[] items = new String[10];
    int size = 0;
    double totalPrice = 0.0;
    // (1) check for if the addition is correct
    size = 7;
    item = "chicken";
    items = new String[] {"Pizza", "Eggs", "Apple", "Banana", "Grape", "Eggs", "Banana"};
    totalPrice = SelfCheckoutKiosk.getSubTotalPrice(items, size);
    if (Math.abs(totalPrice - 22.54) > 0.001) {
      System.out.println("Problem detected: The total price should be $22.54 but it was not.");
      return false;
    }
    
    return true; // No defects detected by this unit test
  }

  /**
   * Checks the correctness of SelfCheckoutKiosk.getUniqueCheckedOutItems() method
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetUniqueCheckedOutItems() {
    // initiating variables to be used for testing
    String[] items = new String[10];
    String[] itemsSet = new String[10];
    int inSize = 0;
    int outSize = 0;
    // (1) check for if the number of unique items is correct
    inSize = 7;
    items = new String[] {"Pizza", "Eggs", "Apple", "Banana", "Grape", "Eggs", "Banana"};
    outSize = SelfCheckoutKiosk.getUniqueCheckedOutItems(items, inSize, itemsSet);
    if (outSize != 5) {
      System.out.println("Problem detected: There should be 5 unique items; should return 5.");
      return false;
    }
    
    return true; // No defects detected by this unit test
  }

  /**
   * main method used to call the unit tests
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    System.out.println("testGetItemNameAndPriceMethods(): " + testGetItemNameAndPriceMethods());
    System.out.println("testAddItemToBaggingArea(): "       + testAddItemToBaggingArea());
    System.out.println("testCount(): "                      + testCount());
    System.out.println("testIndexOf(): "                    + testIndexOf());
    System.out.println("testRemove(): "                     + testRemove());
    System.out.println("testGetSubTotalPrice(): "           + testGetSubTotalPrice());
    System.out.println("testGetUniqueCheckedOutItems(): "   + testGetUniqueCheckedOutItems());
    
  }
}
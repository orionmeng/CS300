//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P01 Self Checkout Kiosk
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

/**
 * This class contains a self checkout kiosk.
 *
 * @author Mouna Kacem
 * @author Orion Meng
 */
class SelfCheckoutKiosk {

  public static final double TAX_RATE = 0.05; // sales tax

  /**
   * a perfect-size two-dimensional array that stores the available items in the grocery store
   * GROCERY_ITEMS[i][0] refers to a String that represents the name of the item identified by index
   * i GROCERY_ITEMS[i][1] refers to a String that represents the unit price of the item identified
   * by index i in dollars.
   */
  public static final String[][] GROCERY_ITEMS = new String[][] {{"Apple", "$1.59"},
      {"Avocado", "$0.59"}, {"Banana", "$0.49"}, {"Beef", "$3.79"}, {"Blueberry", "$6.89"},
      {"Broccoli", "$1.79"}, {"Butter", "$4.59"}, {"Carrot", "$1.19"}, {"Cereal", "$3.69"},
      {"Cheese", "$3.49"}, {"Chicken", "$5.09"}, {"Chocolate", "$3.19"}, {"Cookie", "$9.5"},
      {"Cucumber", "$0.79"}, {"Eggs", "$3.09"}, {"Grape", "$2.29"}, {"Ice Cream", "$5.39"},
      {"Milk", "$2.09"}, {"Mushroom", "$1.79"}, {"Onion", "$0.79"}, {"Pepper", "$1.99"},
      {"Pizza", "$11.5"}, {"Potato", "$0.69"}, {"Spinach", "$3.09"}, {"Tomato", "$1.79"}};

  /**
   * Returns the item's name given its index.
   *
   * @param index - unique identifier of an item
   * @return the item name
   */
  public static String getItemName(int index) {

    String itemName = null;
    itemName = GROCERY_ITEMS[index][0];
    return itemName;

  }

  /**
   * Returns the price of an item given its index (unique identifier).
   *
   * @param index - unique identifier of an item
   * @return the item price
   */
  public static double getItemPrice(int index) {

    String priceString = null;
    priceString = GROCERY_ITEMS[index][1];

    int stringLength = 0;
    stringLength = priceString.length();

    String cutString = null;
    cutString = priceString.substring(1, stringLength);

    double itemPrice = 0.0;
    itemPrice = Double.parseDouble(cutString);

    return itemPrice;

  }

  /**
   * Prints the Catalog of the grocery store (item identifiers, names, and prices).
   */
  public static void printCatalog() {

    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
    System.out.println("Item id \tName \t Price");
    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
    for (int i = 0; i < GROCERY_ITEMS.length; i++) {
      System.out.println(i + "\t\t" + GROCERY_ITEMS[i][0] + " \t " + GROCERY_ITEMS[i][1]);
    }
    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");

  }

  /**
   * Adds the name of a grocery item given its identifier at the end of (the bagging area) the
   * oversize array defined by the items array and its size. If the items array reaches its
   * capacity, the following message: "Error! No additional item can be scanned. Please wait for
   * assistance." will be displayed and the method returns without making any change to the contents
   * of the items array.
   *
   * @param index - unique identifier of an item
   * @param id    - identifier of the item to be added to the bagging area
   * @param items - array storing the names of the items checked out and placed in the bagging area
   * @param size  - number of elements stored in items before trying to add a new item
   * @return number of elements stored in bagging area after the item is added
   */
  public static int addItemToBaggingArea(int id, String[] items, int size) {

    int itemsCapacity = 0;
    itemsCapacity = items.length;
    if (itemsCapacity == size) {
      System.out.println("Error! No additional item can be scanned. Please wait for assistance.");
      return size;
    } else {
      String itemName = null;
      itemName = GROCERY_ITEMS[id][0];
      items[size] = itemName;
      size += 1;
      return size;
    }

  }

  /**
   * Returns the number of occurrences of a given item in an oversize array of strings. The
   * comparison to find the occurrences of item is case insensitive.
   *
   * @param item  - item to count its occurrences
   * @param items - a bag of string items
   * @param size  - number of items stored in items
   * @return the number of occurrences of a given item in an oversize array of strings
   */
  public static int count(String item, String[] items, int size) {

    int totalCount = 0;
    for (int i = 0; i < size; ++i) {
      if (item.equalsIgnoreCase(items[i])) {
        totalCount += 1;
      }
    }
    return totalCount;

  }

  /**
   * Returns the index of the first occurrence of item in items if found, and -1 if the item not
   * found.
   *
   * @param item  - element to search for
   * @param items - an array of string elements
   * @param size  - number of elements stored in items
   * @return the index of the first occurrence of item in items if found (-1 if not found)
   */
  public static int indexOf(String item, String[] items, int size) {

    int foundIndex = -1;
    for (int i = 0; i < size; ++i) {
      if (item.equalsIgnoreCase(items[i])) {
        foundIndex = i;
        break;
      }
    }
    return foundIndex;

  }

  /**
   * Removes the first occurrence of itemToRemove from the bagging area defined by the array items
   * and its size. If no match with itemToRemove is found, the method displays the following error
   * message "WARNING: item not found." without making any change to the items array. This method
   * compacts the contents of the items array after removing the itemToRemove so there are no empty
   * spaces in the middle of the array.
   *
   * @param itemToRemove - item to remove from the bagging area
   * @param items        - a bag of items
   * @param size         - number of elements stored in the bag of items
   * @return the number of items present in the cart after the itemToRemove is removed
   */
  public static int remove(String itemToRemove, String[] items, int size) {

    int foundIndex = -1;
    for (int i = 0; i < size; ++i) {
      if (itemToRemove.equalsIgnoreCase(items[i])) {
        foundIndex = i;
        break;
      }
    }

    if (foundIndex == -1) {
      System.out.println("WARNING: item not found");
      return size;
    } else {
      items[foundIndex] = items[size - 1];
      items[size - 1] = null;
      size -= 1;
      return size;
    }

  }

  /**
   * Gets a copy of the items array without duplicates. Adds every unique item stored within the
   * items array to the itemsSet array. The itemsSet array is initially empty. Recall that a set is
   * a collection which does not contain duplicate items). On the other hand, this method does not
   * make any change to the contents of the items array.
   *
   * @param items    - list of items added to the bagging area
   * @param size     - number of elements stored in items
   * @param itemsSet - reference to an empty array which will contain the set of items checked out
   * @return the number of elements in items without accounting duplicates
   */
  public static int getUniqueCheckedOutItems(String[] items, int size, String[] itemsSet) {

    int nextIndex = 0;
    boolean addItem = false;
    addItem = true;
    for (int i = 0; i < size; ++i) {
      for (int j = 0; j < size; ++j) {
        if (i != j) {
          if (items[i] == itemsSet[j]) {
            addItem = false;
            break;
          } else {
            continue;
          }
        }
      }
      if (addItem) {
        itemsSet[nextIndex] = items[i];
        nextIndex += 1;
      }
      addItem = true;
    }
    return nextIndex;

  }

  /**
   * Returns the total value (price) of the scanned items at checkout without tax in $ (double).
   *
   * @param items - an array which stores the items checked out
   * @param items - an array of string elements
   * @param size  - number of elements stored in the items array
   * @return the total value (price) of the scanned items at checkout without tax in $
   */
  public static double getSubTotalPrice(String[] items, int size) {

    double totalPrice = 0.0;
    double itemPrice = 0.0;
    for (int i = 0; i < size; ++i) {
      for (int j = 0; j < GROCERY_ITEMS.length; ++j) {
        if (items[i].equalsIgnoreCase(GROCERY_ITEMS[j][0])) {
          itemPrice = getItemPrice(j);
          totalPrice += itemPrice;
          break;
        }
      }
    }
    return totalPrice;

  }

}

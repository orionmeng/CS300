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

import java.util.NoSuchElementException;

/*
 * This class takes inventory of boxes.
 */
public class InventoryList {
  
  private LinkedBox head = null; // head of this list
  private LinkedBox tail = null; // tail of this list
  private int size = 0; // total number of boxes stored in this list
  private int blueCount = 0; // total number of blue boxes stored in this list
  private int brownCount = 0; // total number of brown boxes stored in this list
  private int yellowCount = 0; // total number of yellow boxes stored in this list
  
  /*
   * Constructor for InventoryList.
   */
  public InventoryList() {
    
  }
  
  /*
   * Adds a new blue box at the top of blue boxes if the list contains any blue box.
   * 
   * @param blueBox new blue box to be added
   * @throws IllegalArgumentException
   */
  public void addBlue(Box blueBox) {
    LinkedBox blue = new LinkedBox(blueBox);
    if (blueBox == null) {
      throw new IllegalArgumentException("ERROR: the box is null.");
    }
    if (blueBox.getColor() != Color.BLUE) {
      throw new IllegalArgumentException("ERROR: the color of this box is not blue.");
    }
    if (head == null && tail == null) {
      head = blue;
      tail = blue;
    }
    else {
      LinkedBox currentBox = head;
      if (yellowCount == 0) {
        blue.setNext(head);
        head = blue;
      }
      else if (size == 1) {
        head.setNext(blue);
        tail = blue;
      }
      else {
        for (int i = 0; i < yellowCount; ++i) {
          currentBox = currentBox.getNext();
        }
        if (size == yellowCount) {
          tail = blue;
        }
        else {
          blue.setNext(currentBox);
        }
        currentBox = head;
        for (int i = 0; i < yellowCount - 1; ++i) {
          currentBox = currentBox.getNext();
        }
        currentBox.setNext(blue);
      }
    }
    ++blueCount;
    ++size;
  }
  
  /*
   * Adds a brown box at the end of this inventory list.
   * 
   * @param brownBox new brown box to be added
   * @throws IllegalArgumentException
   */
  public void addBrown(Box brownBox) {
    if (brownBox == null) {
      throw new IllegalArgumentException("ERROR: the box is null.");
    }
    if (brownBox.getColor() != Color.BROWN) {
      throw new IllegalArgumentException("ERROR: the color of this box is not brown.");
    }
    LinkedBox brown = new LinkedBox(brownBox);
    if (head == null && tail == null) {
      head = brown;
      tail = brown;
    }
    else {
      tail.setNext(brown);
      tail = brown;
    }
    ++brownCount;
    ++size;
  }
  
  /*
   * Adds a new yellow box at the head of this list.
   * 
   * @param yellowBox new yellow box to be added
   * @throws IllegalArgumentException
   */
  public void addYellow(Box yellowBox) {
    if (yellowBox == null) {
      throw new IllegalArgumentException("ERROR: the box is null.");
    }
    if (yellowBox.getColor() != Color.YELLOW) {
      throw new IllegalArgumentException("ERROR: the color of this box is not yellow.");
    }
    LinkedBox yellow = new LinkedBox(yellowBox);
    if (head == null && tail == null) {
      head = yellow;
      tail = yellow;
    }
    else {
      yellow.setNext(head);
      head = yellow;
    }
    ++yellowCount;
    ++size;
  }
  
  /*
   * Removes all of the elements from this list.
   */
  public void clear() {
    head = null;
    tail = null;
    size = 0;
    blueCount = 0;
    brownCount = 0;
    yellowCount = 0;
  }
  
  /*
   * Returns the element stored at position index of this list without removing it.
   * 
   * @param index index of element to be returned
   * @return element at specified index
   * @throws IndexOutOfBoundsException
   */
  public Box get(int index) {
    if (index < 0 || index >= size()) {
      throw new IndexOutOfBoundsException("ERROR: invalid index.");
    }
    else {
      LinkedBox currentBox = head;
      for (int i = 0; i < index; ++i) {
        currentBox = currentBox.getNext();
      }
      return currentBox.getBox();
    }
  }
  
  /*
   * Returns the number of blue boxes stored in this list.
   * 
   * @return the number of blue boxes stored in this list
   */
  public int getBlueCount() {
    return blueCount;
  }
  
  /*
   * Returns the number of brown boxes stored in this list.
   * 
   * @return the number of brown boxes stored in this list
   */
  public int getBrownCount() {
    return brownCount;
  }
  
  /*
   * Returns the number of yellow boxes stored in this list.
   * 
   * @return the number of yellow boxes stored in this list
   */
  public int getYellowCount() {
    return yellowCount;
  }
  
  /*
   * Checks whether this LinkedBoxList is empty.
   * 
   * @return true if LinkedBoxList is empty
   */
  public boolean isEmpty() {
    if (head == null && tail == null) {
      return true;
    }
    return false;
  }
  
  /*
   * Removes and returns a box given its inventory number from this list.
   * 
   * @param inventoryNumber location of box in list
   * @return removed box from list
   * @throws NoSuchElementException
   */
  public Box removeBox(int inventoryNumber) {
    if (inventoryNumber < 0) {
      throw new NoSuchElementException("ERROR: invalid inventory number.");
    }
    LinkedBox currentBox = head;
    if (size == 1) {
      clear();
      return currentBox.getBox();
    }
    currentBox = tail;
    if (currentBox.getBox().getInventoryNumber() == inventoryNumber) {
      LinkedBox previousHead = head;
      for (int i = 0; i < size - 2; ++i) {
        previousHead = previousHead.getNext();
      }
      previousHead.setNext(null);
      if (currentBox.getBox().getColor() == Color.BLUE) {
        --blueCount;
      }
      if (currentBox.getBox().getColor() == Color.BROWN) {
        --brownCount;
      }
      if (currentBox.getBox().getColor() == Color.YELLOW) {
        --yellowCount;
      }
      --size;
      tail = previousHead;
      return currentBox.getBox();
    }
    currentBox = head;
    if (currentBox.getBox().getInventoryNumber() == inventoryNumber) {
      head = head.getNext();
    }
    else {
      int currentIndex = 0;
      for (int i = 0; i < size; ++i) {
        if (currentBox.getBox().getInventoryNumber() != inventoryNumber) {
          currentBox = currentBox.getNext();
          ++currentIndex;
        }
        else {
          break;
        }
      }
      if (currentBox.getBox().getInventoryNumber() != inventoryNumber) {
        throw new NoSuchElementException("Error: Box #" + inventoryNumber + " not found.");
      }
      LinkedBox previousBox = head;
      for (int i = 0; i < currentIndex - 1; ++i) {
        previousBox = previousBox.getNext();
      }
      previousBox.setNext(currentBox.getNext());
    }
    if (currentBox.getBox().getColor() == Color.BLUE) {
      --blueCount;
    }
    if (currentBox.getBox().getColor() == Color.BROWN) {
      --brownCount;
    }
    if (currentBox.getBox().getColor() == Color.YELLOW) {
      --yellowCount;
    }
    --size;
    return currentBox.getBox();
  }
  
  /*
   * Removes and returns the element at the tail of this list if it has a brown color.
   * 
   * @return removed box from list
   * @throws NoSuchElementException
   */
  public Box removeBrown() {
    if (brownCount == 0) {
      throw new NoSuchElementException("ERROR: no brown box.");
    }
    else {
      if (head.getNext() != null) {
        LinkedBox currentBox = head;
        for (int i = 0; i < size - 1; ++i) {
          currentBox = currentBox.getNext();
        }
        LinkedBox removeTail = tail;
        currentBox.setNext(null);
        tail = currentBox;
        --brownCount;
        --size;
        return removeTail.getBox();
      }
      else {
        throw new NoSuchElementException("ERROR: no brown box.");
      }
    }
  }
  
  /*
   * Removes and returns the box at the head of this list if its color is yellow.
   * 
   * @return removed box from list
   * @throws NoSuchElementException
   */
  public Box removeYellow() {
    if (yellowCount == 0) {
      throw new NoSuchElementException("ERROR: no yellow box.");
    }
    else {
      if (head.getNext() != null) {
        LinkedBox removeHead = head;
        head = head.getNext();
        head.setNext(head.getNext());
        --yellowCount;
        --size;
        return removeHead.getBox();
      }
      else {
        throw new NoSuchElementException("ERROR: no yellow box.");
      }
      
    }
  }
  
  /*
   * Returns the size of this list.
   * 
   * @return the size of this list
   */
  public int size() {
    return size;
  }
  
  /*
   * Returns a String representation of the contents of this list.
   * 
   * @return a String representation of the contents of this list
   */
  @Override
  public String toString() {
    String list = "";
    LinkedBox currentBox = head;
    if (size == 0) {
      return "";
    }
    if (size == 1) {
      return currentBox.getBox().toString() + " -> END";
    }
    for (int i = 0; i < size - 1; ++i) {
      list += currentBox.getBox().toString() + " -> ";
      currentBox = currentBox.getNext();
    }
    list += currentBox.getBox().toString() + " -> END";
    return list;
  }
  
}

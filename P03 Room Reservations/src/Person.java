//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P03 Room Reservations
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

/**
 * This class contains functions for a room reservation program. It specifically sets up Person(s).
 * 
 * @author Orion Meng
 */
class Person {

  private String name; // name of Person
  private boolean isWaiting; // status of Person

  /**
   * Initializes the instance variables for the Person.
   * 
   * @param name - name of Person
   */
  public Person(String name) {
    this.name = name;
    isWaiting = true;
  }

  /**
   * Returns the name of the Person.
   * 
   * @return name of Person
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the status of the Person.
   * 
   * @return true if Person is not in a Room
   */
  public boolean isWaiting() {
    return isWaiting;
  }

  /**
   * Changes the status of the Person when called.
   */
  public void toggleWaiting() {
    isWaiting = (!isWaiting != false);
  }

  /**
   * Does something weird.
   * 
   * @return boolean value of true or false
   */
  public boolean equals(Object o) {
    if (o instanceof Person) {
      return this.name.equals(((Person) o).name);
    }
    return false;
  }

}

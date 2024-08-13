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

import java.util.ArrayList;

/**
 * This class contains functions for a room reservation program. It specifically sets up Room(s).
 * 
 * @author Orion Meng
 */
class Room {

  private static ArrayList<String> names = new ArrayList<String>(10); // Room name identifiers
  private String name; // Room name
  private Person[] occupants; // names of Persons in Room
  private static int currentOccupancy; // number of Persons in Room

  /**
   * Returns the list of names of Rooms.
   * 
   * @return array of names of Rooms in the order they were created
   */
  public static String[] getNames() {
    String[] namesArray = new String[names.size()];
    for (int i = 0; i < names.size(); ++i) {
      namesArray[i] = names.get(i);
    }
    return namesArray;
  }

  /**
   * Initializes the instance variables for the Room.
   * 
   * @param name     - the name of the Room
   * @param capacity - the capacity of the Room
   */
  public Room(String name, int capacity) {
    this.name = name;
    if (capacity <= 0) {
      throw new IllegalArgumentException("Capacity less than or equal to 0.");
    } else {
      occupants = new Person[capacity];
      boolean addName = true;
      for (int i = 0; i < names.size(); ++i) {
        if (name == names.get(i)) {
          addName = false;
          throw new IllegalArgumentException("Name is already in use.");
        }
      }
      if (addName) {
        Room.names.add(name);
      }
    }
  }

  /**
   * Returns the name of the Room.
   * 
   * @return name of Room
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the current number of Persons in the Room.
   * 
   * @return number of Persons in Room
   */
  public int getOccupancy() {
    return currentOccupancy;
  }

  /**
   * Returns the capacity of Room if social distancing laws are being followed.
   * 
   * @return the COVID capacity of Room
   */
  public int getCOVIDCapacity() {
    return (occupants.length + 1) / 2;
  }

  /**
   * Returns the capacity of Room.
   * 
   * @return capacity of Room.
   */
  public int getCapacity() {
    return occupants.length;
  }

  /**
   * Checks if the Person is in the Room.
   * 
   * @param p - the Person to be checked
   * @return true if provided Person is in Room array
   */
  public boolean contains(Person p) {
    for (int i = 0; i < occupants.length; ++i) {
      if (p == occupants[i]) {
        return true;
      }
    }
    return false;
  }

  /**
   * Checks the Person into the Room.
   * 
   * @throws IllegalArgumentException       if the Person is null or already present
   * @throws ArrayIndexOutOfBoundsException if there is an error in the code
   * @param in - the Person to be checked in
   * @return true if provided Person is successfully checked in
   */
  public boolean checkIn(Person in) {
    if (in == null) {
      throw new IllegalArgumentException("Person is null.");
    } else if (currentOccupancy == (occupants.length + 1) / 2) {
      return false;
    } else {
      for (int i = 0; i < occupants.length; ++i) {
        if (in.equals(occupants[i]) && in != null) {
          throw new IllegalArgumentException("Person already exists.");
        }
      }
      try {
        for (int j = 0; j < (occupants.length + 1) / 2; ++j) {
          if (occupants[2 * j] == null) {
            occupants[2 * j] = in;
            ++currentOccupancy;
            in.toggleWaiting();
            return true;
          }
        }
      } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("Something is wrong with the checkIn code.");
        return false;
      }
      return false;
    }
  }

  /**
   * Checks the Person out of the Room.
   * 
   * @throws IllegalArgumentException if the Person is null
   * @param out - the Person to be checked out
   * @return true if provided Person is successfully checked out
   */
  public boolean checkOut(Person out) {
    if (out == null) {
      throw new IllegalArgumentException("Person is null.");
    }
    boolean doesContain = false;
    doesContain = contains(out);
    if (doesContain) {
      for (int i = 0; i < occupants.length; ++i) {
        if (occupants[i] == out) {
          occupants[i] = null;
          --currentOccupancy;
          out.toggleWaiting();
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Writes the room out in a String.
   * 
   * @return a String of the Room
   */
  public String toString() {
    String strRoom = "";
    strRoom += name;
    strRoom += "\n===\n";
    for (int i = 0; i < occupants.length; ++i) {
      if (occupants[i] == null) {
        strRoom += "-\n";
      } else {
        strRoom += occupants[i].getName();
        strRoom += "\n";
      }
    }
    return strRoom;
  }

}

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
 * This class contains tests for a room reservations program.
 * 
 * @author Orion Meng
 */
public class OccupancyTester {

  /**
   * Checks the correctness of Person class.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testPerson() {
    boolean testPassed = true;
    Person person1 = new Person("name1");
    // (1) testing a single instance of Person
    if (!person1.getName().equals("name1")) {
      System.out.println("testPerson() failed; name1 failed.");
      testPassed = false;
      return false;
    }
    Person person2 = new Person("name2");
    // (2) testing a second instance of Person
    if (!person2.getName().equals("name2")) {
      System.out.println("testPerson() failed; name2 failed.");
      testPassed = false;
      return false;
    }
    // (x) making a third instance of Person
    Person person3 = new Person("name2");
    boolean isWaiting1;
    boolean isWaiting2;
    person1.toggleWaiting();
    isWaiting1 = person1.isWaiting();
    person1.toggleWaiting();
    isWaiting2 = person1.isWaiting();
    // (3) testing isWaiting()
    if (isWaiting1 == isWaiting2) {
      System.out.println("testPerson() failed; isWaiting failed.");
      testPassed = false;
      return false;
    }
    // (4) testing if different names are not equal
    if (person1 == person2) {
      System.out.println("testPerson() failed; person1 should not equal person2.");
      testPassed = false;
      return false;
    }
    // (5) testing if same names are equal
    if (person3 != person2) {
      System.out.println("testPerson() failed; person3 should equal person2.");
      testPassed = false;
      return false;
    }
    // (p) runs if all tests pass
    if (testPassed) {
      System.out.println("testPerson() passed.");
    }
    return true;
  }

  /**
   * Checks the correctness of constructors in Room class.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testRoomConstructor() {
    boolean testPassed = true;
    Room room1 = new Room("roomName1", 3);
    // (1) testing if a room was created
    if (!room1.getName().equals("roomName1")) {
      System.out.println("testRoomConstructor() failed; a room was not created.");
      testPassed = false;
      return false;
    }
    Room room2 = new Room("roomName2", 7);
    // (2) testing if a room with the same name is caught
    try {
      Room room3 = new Room("roomName2", 5);
    } catch (IllegalArgumentException e) {
      System.out.println("AN ERROR MESSAGE SHOULD APPEAR AFTER THIS LINE");
      e.getMessage();
    }
    // (3) testing if a second room was created
    if (!room2.getName().equals("roomName2")) {
      System.out.println("testRoomConstructor() failed; a second room was not created.");
      testPassed = false;
      return false;
    }
    // (p) runs if all tests pass
    if (testPassed) {
      System.out.println("testRoomConstructor() passed.");
    }
    return true;
  }

  /**
   * Checks the correctness of accessors in Room class.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testRoomAccessors() {
    boolean testPassed = true;
    Room room1 = new Room("roomName1", 3);
    // (1) testing if getName() returns a name
    if (!room1.getName().equals("roomName1")) {
      System.out.println("testRoomAccessors() failed; getName() is not working.");
      testPassed = false;
      return false;
    }
    Room room2 = new Room("roomName2", 7);
    // (2) testing if getName() returns correct name
    if (!room2.getName().equals("roomName2")) {
      System.out.println("testRoomAccessors() failed; room2 does not have correct name.");
      testPassed = false;
      return false;
    }
    // (3) testing if getOccupancy() returns 0
    if (room1.getOccupancy() != 0 || room2.getOccupancy() != 0) {
      System.out.println("testRoomAccessors() failed; getOccupancy() should return 0.");
      testPassed = false;
      return false;
    }
    // (4) testing if getCOVIDCapacity() works correctly for room1
    if (room1.getCOVIDCapacity() != 2) {
      System.out.println("testRoomAccessors() failed; the COVIDCapacity for room1 should be 2");
      testPassed = false;
      return false;
    }
    // (5) testing if getCOVIDCapacity() works correctly for room2
    if (room2.getCOVIDCapacity() != 4) {
      System.out.println("testRoomAccessors() failed; the COVIDCapacity for room2 should be 4");
      testPassed = false;
      return false;
    }
    // (6) testing if getCapacity() works correctly for room1
    if (room1.getCapacity() != 3) {
      System.out.println("testRoomAccessors() failed; the capacity for room1 should be 3");
      testPassed = false;
      return false;
    }
    // (7) testing if getCapacity() works correctly for room2
    if (room2.getCapacity() != 7) {
      System.out.println("testRoomAccessors() failed; the capacity for room2 should be 7");
      testPassed = false;
      return false;
    }
    // (p) runs if all tests pass
    if (testPassed) {
      System.out.println("testRoomAccessors() passed.");
    }
    return true;
  }

  /**
   * Checks the correctness of checkIn() in Room class.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testRoomCheckIn() {
    boolean testPassed = true;
    Room room = new Room("roomName1", 3);
    Person person1 = new Person("person1");
    Person person2 = new Person("person1");
    Person person3 = new Person("person3");
    Person person4 = new Person("person4");
    room.checkIn(person1);
    // (1) testing if a person can be added to the room
    if (!room.toString().equals("room\n===\nperson1\n-\n-\n")) {
      System.out.println("testRoomCheckIn() failed; failed to correctly add one person.");
      System.out.println("Here is what the room looks like:" + room.toString());
      testPassed = false;
      return false;
    }
    // (2) testing if person1 is not waiting
    if (person1.isWaiting() != false) {
      System.out.println("testRoomCheckIn() failed; person1 should not be waiting.");
      testPassed = false;
    }
    room.checkIn(person2);
    // (3) testing if a person with a name that already exists does not get added
    if (!room.toString().equals("room\n===\nperson1\n-\n-\n")) {
      System.out.println("testRoomCheckIn() failed; no person should have been added.");
      System.out.println("Here is what the room looks like:" + room.toString());
      testPassed = false;
      return false;
    }
    // (4) testing if person2 is waiting
    if (person2.isWaiting() != true) {
      System.out.println("testRoomCheckIn() failed; person2 should be waiting.");
      testPassed = false;
    }
    room.checkIn(person3);
    // (5) testing if a second person can be added to the room
    room.toString();
    if (!room.toString().equals("room\n===\nperson1\n-\nperson3\n")) {
      System.out.println("testRoomCheckIn() failed; failed to correctly add another person.");
      System.out.println("Here is what the room looks like:" + room.toString());
      testPassed = false;
      return false;
    }
    // (6) testing if person3 is not waiting
    if (person3.isWaiting() != false) {
      System.out.println("testRoomCheckIn() failed; person3 should not be waiting.");
      testPassed = false;
    }
    // (7) testing if a person being added to a full room does not get added
    room.checkIn(person4);
    room.toString();
    if (!room.toString().equals("room\n===\nperson1\n-\nperson3\n")) {
      System.out.println("testRoomCheckIn() failed; room should be too full to add any person.");
      System.out.println("Here is what the room looks like:" + room.toString());
      testPassed = false;
      return false;
    }
    // (8) testing if person4 is waiting
    if (person4.isWaiting() != true) {
      System.out.println("testRoomCheckIn() failed; person4 should be waiting.");
      testPassed = false;
    }
    // (p) runs if all tests pass
    if (testPassed) {
      System.out.println("testRoomCheckIn() passed.");
    }
    return true;
  }

  /**
   * Checks the correctness of checkOut() in Room class.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testRoomCheckOut() {
    boolean testPassed = true;
    Room room = new Room("roomName1", 3);
    Person person1 = new Person("person1");
    room.checkIn(person1);
    room.checkOut(person1);
    // (1) testing if person1 is removed from room
    if (!room.toString().equals("room\n===\n-\n-\n-\n")) {
      System.out.println("testRoomCheckOut() failed; person1 should have been removed from room.");
      System.out.println("Here is what the room looks like:" + room.toString());
      testPassed = false;
    }
    // (1) testing if person1 is back to waiting
    if (person1.isWaiting() != true) {
      System.out.println("testRoomCheckIn() failed; person1 should be waiting.");
      testPassed = false;
    }
    // (p) runs if all tests pass
    if (testPassed) {
      System.out.println("testRoomCheckIn() passed.");
    }
    return true;
  }

  /**
   * Checks the correctness of toString() in Room class.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testRoomToString() {
    boolean testPassed = true;
    Room room = new Room("roomName1", 3);
    Person person1 = new Person("person1");
    room.checkIn(person1);
    // (1) testing if person1 is in room
    if (!room.toString().equals("room\n===\nperson1\n-\n-\n")) {
      System.out.println("testRoomCheckOut() failed; person1 should be in room.");
      System.out.println("Here is what the room looks like:" + room.toString());
      testPassed = false;
    }
    room.checkOut(person1);
    // (2) testing if person1 is no longer in room
    if (!room.toString().equals("room\n===\n-\n-\n-\n")) {
      System.out.println("testRoomCheckOut() failed; person1 should no longer be in room.");
      System.out.println("Here is what the room looks like:" + room.toString());
      testPassed = false;
    }
    // (p) runs if all tests pass
    if (testPassed) {
      System.out.println("testRoomToString() passed.");
    }
    return true;
  }

  /**
   * main method used to call the unit tests
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    try {
      System.out.println("testPerson(): " + testPerson());
    } catch (Exception e) {
      System.out.println("exception found in testPerson()");
    }
    try {
      System.out.println("testRoomConstructor(): " + testRoomConstructor());
    } catch (Exception e) {
      System.out.println("exception found in testRoomConstructor()");
    }
    try {
      System.out.println("testRoomAccessors(): " + testRoomAccessors());
    } catch (Exception e) {
      System.out.println("exception found in testRoomAccessors()");
    }
    try {
      System.out.println("testRoomCheckIn(): " + testRoomCheckIn());
    } catch (Exception e) {
      System.out.println("exception found in testRoomCheckIn()");
    }
    try {
      System.out.println("testRoomCheckOut(): " + testRoomCheckOut());
    } catch (Exception e) {
      System.out.println("exception found in testRoomCheckOut()");
    }
    try {
      System.out.println("testRoomToString(): " + testRoomToString());
    } catch (Exception e) {
      System.out.println("exception found in testRoomToString()");
    }
  }

}

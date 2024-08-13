//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P06 Palindromes Tester
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

/*
 * This class tests the Palindrome class.
 */
class PalindromeTester {
  
  /*
   * Tests for mirrorA() without step.
   */
  public static boolean testMirrorA() {
    // (1) single letter test
    if (!Palindrome.mirrorA('A').equals("A")) {
      System.out.println("test 1 for mirrorA() failed: single letter tested.");
      return false;
    }
    // (2) multiple letters test
    if (!Palindrome.mirrorA('C').equals("C B A B C")) {
      System.out.println("test 2 for mirrorA() failed: multiple letters tested.");
      return false;
    }
    // (3) entire alphabet test
    if (!Palindrome.mirrorA('Z').equals("Z Y X W V U T S R Q P O "
                                    + "N M L K J I H G F E D C B "
                                    + "A B C D E F G H I J K L M "
                                    + "N O P Q R S T U V W X Y Z")) {
      System.out.println("test 3 for mirrorA() failed: entire alphabet tested.");
      return false;
    }
    // (4) lowercase letter test
    try {
      Palindrome.mirrorA('a');
      System.out.println("test 4 for mirrorA() failed: lowercase letter tested (not caught).");
      return false;
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("Input must be a capital letter.")) {
        System.out.println("test 4 for mirrorA() failed: lowercase letter tested (caught).");
        return false;
      }
    }
    // (5) invalid character test
    try {
      Palindrome.mirrorA('1');
      System.out.println("test 5 for mirrorA() failed: invalid character tested (not caught).");
      return false;
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("Input must be a capital letter.")) {
        System.out.println("test 5 for mirrorA() failed: invalid character tested (caught).");
        return false;
      }
    }
    return true;
  }
  
  /*
   * Tests for mirrorA() with step.
   */
  public static boolean testMirrorAStep() {
    // (1) single letter test
    if (!Palindrome.mirrorA('A', 1).equals("A")) {
      System.out.println("test 1 for mirrorAS() failed: single letter tested.");
      return false;
    }
    // (2) multiple letters test with an odd number of characters expected
    if (!Palindrome.mirrorA('C', 2).equals("C A C")) {
      System.out.println("test 2 for mirrorAS() failed: multiple letters tested (odd chars #).");
      return false;
    }
    // (3) multiple letters test with an even number of characters expected
    if (!Palindrome.mirrorA('D', 2).equals("D B B D")) {
      System.out.println("test 3 for mirrorAS() failed: multiple letters tested (even chars #).");
      return false;
    }
    // (4) entire alphabet test with step size 2
    if (!Palindrome.mirrorA('Z', 2).equals("Z X V T R P N L J H F D B B D F H J L N P R T V X Z")) {
      System.out.println("test 4 for mirrorAS() failed: entire alphabet tested (step size 2).");
      return false;
    }
    // (5) entire alphabet test with step size 12
    if (!Palindrome.mirrorA('Z', 12).equals("Z N B B N Z")) {
      System.out.println("test 5 for mirrorAS() failed: entire alphabet tested (step size 12).");
      return false;
    }
    // (6) lowercase letter test
    try {
      Palindrome.mirrorA('a', 1);
      System.out.println("test 6 for mirrorAS() failed: lowercase letter tested (not caught).");
      return false;
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("Input must be a capital letter.")) {
        System.out.println("test 6 for mirrorAS() failed: lowercase letter tested (caught).");
        return false;
      }
    }
    // (7) invalid character test
    try {
      Palindrome.mirrorA('1', 1);
      System.out.println("test 7 for mirrorAS() failed: invalid character tested (not caught).");
      return false;
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("Input must be a capital letter.")) {
        System.out.println("test 7 for mirrorAS() failed: invalid character tested (caught).");
        return false;
      }
    }
    // (8) negative number test
    try {
      Palindrome.mirrorA('A', -1);
      System.out.println("test 8 for mirrorAS() failed: negative value tested (not caught).");
      return false;
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("Step size must be positive.")) {
        System.out.println("test 8 for mirrorAS() failed: negative value tested (caught).");
        return false;
      }
    }
    // (9) zero test
    try {
      Palindrome.mirrorA('A', 0);
      System.out.println("test 9 for mirrorAS() failed: zero tested (not caught).");
      return false;
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("Step size must be positive.")) {
        System.out.println("test 9 for mirrorAS() failed: zero tested (caught).");
        return false;
      }
    }
    // (10) invalid inputs test
    try {
      Palindrome.mirrorA('a', -1);
      System.out.println("test 10 for mirrorAS() failed: invalid inputs tested (not caught).");
      return false;
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("Input must be capital letter with positive number.")) {
        System.out.println("test 10 for mirrorAS() failed: invalid inputs tested (caught).");
        return false;
      }
    }
    return true;
  }
  
  /*
   * Tests for mirrorZ() without step.
   */
  public static boolean testMirrorZ() {
    // (1) single letter test
    if (!Palindrome.mirrorZ('Z').equals("Z")) {
      System.out.println("test 1 for mirrorZ() failed: single letter tested.");
      return false;
    }
    // (2) multiple letters test
    if (!Palindrome.mirrorZ('X').equals("X Y Z Y X")) {
      System.out.println("test 2 for mirrorZ() failed: multiple letters tested.");
      return false;
    }
    // (3) entire alphabet test
    if (!Palindrome.mirrorZ('A').equals("A B C D E F G H I J K L "
                                    + "M N O P Q R S T U V W X Y "
                                    + "Z Y X W V U T S R Q P O N "
                                    + "M L K J I H G F E D C B A")) {
      System.out.println("test 3 for mirrorZ() failed: entire alphabet tested.");
      return false;
    }
    // (4) lowercase letter test
    try {
      Palindrome.mirrorZ('a');
      System.out.println("test 4 for mirrorZ() failed: lowercase letter tested (not caught).");
      return false;
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("Input must be a capital letter.")) {
        System.out.println("test 4 for mirrorZ() failed: lowercase letter tested (caught).");
        return false;
      }
    }
    // (5) invalid character test
    try {
      Palindrome.mirrorZ('1');
      System.out.println("test 5 for mirrorZ() failed: invalid character tested (not caught).");
      return false;
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("Input must be a capital letter.")) {
        System.out.println("test 5 for mirrorZ() failed: invalid character tested (caught).");
        return false;
      }
    }
    return true;
    
  }
  
  /*
   * Tests for mirrorZ() with step.
   */
  public static boolean testMirrorZStep() {
    // (1) single letter test
    if (!Palindrome.mirrorZ('Z', 1).equals("Z")) {
      System.out.println("test 1 for mirrorZS() failed: single letter tested.");
      return false;
    }
    // (2) multiple letters test with an odd number of characters expected
    if (!Palindrome.mirrorZ('X', 2).equals("X Z X")) {
      System.out.println("test 2 for mirrorZS() failed: multiple letters tested (odd chars #).");
      return false;
    }
    // (3) multiple letters test with an even number of characters expected
    if (!Palindrome.mirrorZ('W', 2).equals("W Y Y W")) {
      System.out.println("test 3 for mirrorZS() failed: multiple letters tested (even chars #).");
      return false;
    }
    // (4) entire alphabet test with step size 2
    if (!Palindrome.mirrorZ('A', 2).equals("A C E G I K M O Q S U W Y Y W U S Q O M K I G E C A")) {
      System.out.println("test 4 for mirrorZS() failed: entire alphabet tested (step size 2).");
      return false;
    }
    // (5) entire alphabet test with step size 12
    if (!Palindrome.mirrorZ('A', 12).equals("A M Y Y M A")) {
      System.out.println("test 5 for mirrorZS() failed: entire alphabet tested (step size 12).");
      return false;
    }
    // (6) lowercase letter test
    try {
      Palindrome.mirrorZ('a', 1);
      System.out.println("test 6 for mirrorZS() failed: lowercase letter tested (not caught).");
      return false;
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("Input must be a capital letter.")) {
        System.out.println("test 6 for mirrorZS() failed: lowercase letter tested (caught).");
        return false;
      }
    }
    // (7) invalid character test
    try {
      Palindrome.mirrorZ('1', 1);
      System.out.println("test 7 for mirrorZS() failed: invalid character tested (not caught).");
      return false;
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("Input must be a capital letter.")) {
        System.out.println("test 7 for mirrorZS() failed: invalid character tested (caught).");
        return false;
      }
    }
    // (8) negative number test
    try {
      Palindrome.mirrorZ('A', -1);
      System.out.println("test 8 for mirrorZS() failed: negative value tested (not caught).");
      return false;
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("Step size must be positive.")) {
        System.out.println("test 8 for mirrorZS() failed: negative value tested (caught).");
        return false;
      }
    }
    // (9) zero test
    try {
      Palindrome.mirrorZ('A', 0);
      System.out.println("test 9 for mirrorZS() failed: zero tested (not caught).");
      return false;
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("Step size must be positive.")) {
        System.out.println("test 9 for mirrorZS() failed: zero tested (caught).");
        return false;
      }
    }
    // (10) invalid inputs test
    try {
      Palindrome.mirrorZ('a', -1);
      System.out.println("test 10 for mirrorZS() failed: invalid inputs tested (not caught).");
      return false;
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("Input must be capital letter with positive number.")) {
        System.out.println("test 10 for mirrorZS() failed: invalid inputs tested (caught).");
        return false;
      }
    }
    return true;
  }
  
  public static boolean runAllTests() {
    if (!testMirrorA()) {
      return false;
    }
    if (!testMirrorAStep()) {
      return false;
    }
    if (!testMirrorZ()) {
      return false;
    }
    if (!testMirrorZStep()) {
      return false;
    }
    return true;
  }
  
  public static void main(String[] args) {
    runAllTests();
  }
  
  
}

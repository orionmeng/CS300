//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P06 Palindromes
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
 * This class makes palindromes.
 */
public class Palindrome {

  /*
   * Recursively creates a simple alphabet pattern, starting at the provided character, moving
   * backward to the beginning of the alphabet, and then forward again to the provided letter. Each
   * letter is separated by a space.
   * 
   * @param start letter to be added
   * 
   * @return strLetters a palindrome of letters
   */
  public static String mirrorA(char start) throws IllegalArgumentException {
    if (start == 'A') {
      return "A";
    } else if (start >= 'B' && start <= 'Z') {
      String strLetters = "";
      char nextLetter = (char) (start - 1);
      strLetters = start + " " + mirrorA(nextLetter) + " " + start;
      return strLetters;
    } else {
      throw new IllegalArgumentException("Input must be a capital letter.");
    }
  }

  /*
   * Recursively creates an alphabet pattern, starting at the provided character, and moving back
   * and forth to the beginning of the alphabet by the given step size. Each letter is separated by
   * a space.
   * 
   * @param start the letter to be added
   * 
   * @param step the number of letters skipped plus one
   * 
   * @return strLetters a palindrome of letters
   */
  public static String mirrorA(char start, int step) throws IllegalArgumentException {
    if ((Character.compare(start, 'A') < 0 || Character.compare(start, 'Z') > 0) && step < 1) {
      throw new IllegalArgumentException("Input must be capital letter with positive number.");
    } else if (Character.compare(start, 'A') < 0 || Character.compare(start, 'Z') > 0) {
      throw new IllegalArgumentException("Input must be a capital letter.");
    } else if (step < 1) {
      throw new IllegalArgumentException("Step size must be positive.");
    } else if (start == 'A') {
      return "A";
    } else if (start >= 'B' && start <= 'Z') {
      String strLetters = "";
      char nextLetter = (char) (start - step);
      if (nextLetter >= 'A') {
        strLetters = start + " " + mirrorA(nextLetter, step) + " " + start;
      } else {
        strLetters = start + " " + start;
      }
      return strLetters;
    } else {
      throw new IllegalArgumentException("Program error.");
    }
  }

  /*
   * Recursively creates a simple alphabet pattern, starting at the provided character, moving
   * forward to the end of the alphabet, and then backward again to the provided letter. Each letter
   * is separated by a space.
   * 
   * @param start letter to be added
   * 
   * @return strLetters a palindrome of letters
   */
  public static String mirrorZ(char start) throws IllegalArgumentException {
    if (start == 'Z') {
      return "Z";
    } else if (start >= 'A' && start <= 'Y') {
      String strLetters = "";
      char nextLetter = (char) (start + 1);
      strLetters = start + " " + mirrorZ(nextLetter) + " " + start;
      return strLetters;
    } else {
      throw new IllegalArgumentException("Input must be a capital letter.");
    }
  }

  /*
   * Recursively creates an alphabet pattern, starting at the provided character, and moving forward
   * and back to the end of the alphabet by the given step size. Each letter is separated by a
   * space.
   * 
   * @param start the letter to be added
   * 
   * @param step the number of letters skipped plus one
   * 
   * @return strLetters a palindrome of letters
   */
  public static String mirrorZ(char start, int step) throws IllegalArgumentException {
    if ((Character.compare(start, 'A') < 0 || Character.compare(start, 'Z') > 0) && step < 1) {
      throw new IllegalArgumentException("Input must be capital letter with positive number.");
    } else if (Character.compare(start, 'A') < 0 || Character.compare(start, 'Z') > 0) {
      throw new IllegalArgumentException("Input must be a capital letter.");
    } else if (step < 1) {
      throw new IllegalArgumentException("Step size must be positive.");
    } else if (start == 'Z') {
      return "Z";
    } else if (start >= 'A' && start <= 'Y') {
      String strLetters = "";
      char nextLetter = (char) (start + step);
      if (nextLetter <= 'Z') {
        strLetters = start + " " + mirrorZ(nextLetter, step) + " " + start;
      } else {
        strLetters = start + " " + start;
      }
      return strLetters;
    } else {
      throw new IllegalArgumentException("Program error.");
    }
  }

}

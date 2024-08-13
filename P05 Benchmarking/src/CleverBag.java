//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P05 Benchmarking Clever Bag
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

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

/*
 * This class reads a file, saves its content, and randomly removes saved content.
 */
public class CleverBag extends SimpleBag {

  private int size; // the current number of initialized strings in data

  /*
   * Complexity: O(1)
   * Calls super class constructor and sets size to 0.
   * 
   * @param seed used to call super class constructor and initialize random
   */
  public CleverBag(int seed) {
    super(seed);
    size = 0;
  }

  /*
   * Complexity: O(N)
   * Reads a file and saves its contents into an array, word by word.
   * 
   * @param f the file being read
   */
  @Override
  public void loadData(File f) {
    Scanner fileReader;
    try {
      File file = f;
      fileReader = new Scanner(file);
      size = fileReader.nextInt();
      for (int i = 0; i < size; ++i) {
        data[i] = fileReader.next();
      }
    } catch (Exception e) {
      System.out.println("exception");
      e.printStackTrace();
    }
  }

  /*
   * Complexity: O(1)
   * Removes a random string from the array of words.
   * 
   * @return the string that was removed
   */
  @Override
  public String removeRandom() {
    if (data[0] == null || size == 0) {
      return null;
    }
    int randomIndex = 0;
    randomIndex = random.nextInt(size);
    String removeString = "";
    removeString = data[randomIndex];
    data[randomIndex] = data[size - 1];
    data[size - 1] = null;
    --size;
    return removeString;
  }

}

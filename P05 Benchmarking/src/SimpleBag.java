//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P05 Benchmarking Simple Bag
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
public class SimpleBag {

  protected String[] data; // array of strings
  protected Random random; // random object

  /*
   * Complexity: O(1)
   * Initializes data and random.
   * 
   * @param seed used to initialize random
   */
  public SimpleBag(int seed) {
    data = new String[80000];
    random = new Random(seed);
  }

  /*
   * Complexity: O(N^2)
   * Reads a file and saves its contents into an array, word by word.
   * 
   * @param f the file being read
   */
  public void loadData(File f) {
    Scanner fileReader;
    try {
      File file = f;
      fileReader = new Scanner(file);
      int firstNumber = 0;
      firstNumber = fileReader.nextInt();
      while (fileReader.hasNext()) {
        for (int i = 79998; i >= 0; --i) {
          data[i + 1] = data[i];
        }
        data[0] = fileReader.next();
      }
    } catch (Exception e) {
      System.out.println("exception");
      e.printStackTrace();
    }
  }

  /*
   * Complexity: O(N)
   * Removes a random string from the array of words.
   * 
   * @return the string that was removed
   */
  public String removeRandom() {
    if (data[0] == null) {
      return null;
    }
    int notNullCount = 0;
    for (int i = 0; i < 80000; ++i) {
      if (data[i] != null) {
        ++notNullCount;
      }
    }
    int randomIndex = 0;
    randomIndex = random.nextInt(notNullCount);
    String removeString = "";
    removeString = data[randomIndex];
    for (int i = randomIndex; i < 79999; ++i) {
      data[i] = data[i + 1];
    }
    data[79999] = null;
    return removeString;
  }

}

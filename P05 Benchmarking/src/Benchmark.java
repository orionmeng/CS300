//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P05 Benchmarking Benchmark
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
 * This class compares the speed of the SimpleBag class to the speed of the CleverBag class.
 */
public class Benchmark {

  /*
   * Runs and tracks the time spent to complete loadData() of each bag class.
   * 
   * @param f the file that will be ran by both loadData() methods
   * 
   * @param s an object of type SimpleBag
   * 
   * @param c an object of type CleverBag
   * 
   * @return a string with the elapsed times of each bag type
   */
  public static String compareLoadData(File f, SimpleBag s, CleverBag c) {
    long timeSBefore = 0;
    long timeSAfter = 0;
    timeSBefore = System.currentTimeMillis();
    s.loadData(f);
    timeSAfter = System.currentTimeMillis();
    long timeCBefore = 0;
    long timeCAfter = 0;
    timeCBefore = System.currentTimeMillis();
    c.loadData(f);
    timeCAfter = System.currentTimeMillis();
    long simpleBagLoadTime = timeSAfter - timeSBefore;
    long cleverBagLoadTime = timeCAfter - timeCBefore;
    String returnCompare = "";
    returnCompare = "load:\t" + simpleBagLoadTime + "\t" + cleverBagLoadTime + "\n";
    return returnCompare;
  }

  /*
   * Runs and tracks the time spent to complete removeRandom() of each bag class n times.
   * 
   * @param n the number of times removeRandom() is called for each bag class
   * 
   * @param s an object of type SimpleBag
   * 
   * @param c an object of type CleverBag
   * 
   * @return a string with the elapsed times of each bag type
   */
  public static String compareRemove(int n, SimpleBag s, CleverBag c) {
    long timeSBefore = 0;
    long timeSAfter = 0;
    timeSBefore = System.currentTimeMillis();
    for (int i = 0; i < n; ++i) {
      s.removeRandom();
    }
    timeSAfter = System.currentTimeMillis();
    long timeCBefore = 0;
    long timeCAfter = 0;
    timeCBefore = System.currentTimeMillis();
    for (int i = 0; i < n; ++i) {
      c.removeRandom();
    }
    timeCAfter = System.currentTimeMillis();
    long simpleBagLoadTime = timeSAfter - timeSBefore;
    long cleverBagLoadTime = timeCAfter - timeCBefore;
    String returnCompare = "";
    returnCompare = n + "\t" + simpleBagLoadTime + "\t" + cleverBagLoadTime + "\n";
    return returnCompare;
  }

  /*
   * Creates an instance of SimpleBag and an instance of CleverBag. Calls compareLoadData() and
   * compareRemove() and handles any exception.
   * 
   * @param in the file being read
   * 
   * @param out the output file with the elapsed times of each bag type
   * 
   * @param nValues an array of integers
   */
  public static void createResultsFile(File in, File out, int[] nValues) {
    SimpleBag simpleObject = new SimpleBag(0);
    CleverBag cleverObject = new CleverBag(0);
    try {
      FileWriter fileWriter = new FileWriter(out);
      fileWriter.write(compareLoadData(in, simpleObject, cleverObject));
      for (int i = 0; i < nValues.length; ++i) {
        fileWriter.write(compareRemove(nValues[i], simpleObject, cleverObject));
      }
      fileWriter.close();
    } catch (Exception e) {
      System.out.println("exception");
      e.printStackTrace();
    }
  }

  /*
   * This is the main method.
   */
  public static void main(String[] args) {
    int[] nValues = {10, 100, 1000, 10000};
    File in = new File("ten.txt");
    File out = new File("out.txt");
    createResultsFile(in, out, nValues);
    File frankIn = new File("frank.txt");
    File frankOut = new File("shout.txt");
    createResultsFile(frankIn, frankOut, nValues);
  }

}

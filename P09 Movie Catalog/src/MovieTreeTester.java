//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P09 Movie Catalog Tester
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

// Add javadoc style class header here
// File Header comes here
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * This class checks the correctness of the implementation of the methods defined in the class
 * MovieTree.
 *
 */

public class MovieTreeTester {

  /**
   * Checks the correctness of the implementation of both addMovie() and toString() methods
   * implemented in the MovieTree class. This unit test considers at least the following scenarios.
   * (1) Create a new empty MovieTree, and check that its size is 0, it is empty, and that its
   * string representation is an empty string "". (2) try adding one movie and then check that the
   * addMovie() method call returns true, the tree is not empty, its size is 1, and the .toString()
   * called on the tree returns the expected output. (3) Try adding another movie which is smaller
   * that the movie at the root, (4) Try adding a third movie which is greater than the one at the
   * root, (5) Try adding at least two further movies such that one must be added at the left
   * subtree, and the other at the right subtree. For all the above scenarios, and more, double
   * check each time that size() method returns the expected value, the add method call returns
   * true, and that the .toString() method returns the expected string representation of the
   * contents of the binary search tree in an increasing order from the smallest to the greatest
   * movie with respect to year, rating, and then name. (6) Try adding a movie already stored in the
   * tree. Make sure that the addMovie() method call returned false, and that the size of the tree
   * did not change.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddMovieToStringSize() {
    // create new MovieTree
    MovieTree tree = new MovieTree();
    // test 01: check size with empty tree
    if (tree.size() != 0) {
      System.out.println("testAddMovieToStringSize() 01 failed.");
      return false;
    }
    // test 02: check if empty with empty tree
    if (!tree.isEmpty()) {
      System.out.println("testAddMovieToStringSize() 02 failed.");
      return false;
    }
    // test 03: check string with empty tree
    if (!tree.toString().equals("")) {
      System.out.println("testAddMovieToStringSize() 03 failed.");
      return false;
    }
    // test 04: check addMovie() method call
    if (!tree.addMovie(new Movie(2020, 6.9, "Yikes"))) {
      System.out.println("testAddMovieToStringSize() 04 failed.");
      return false;
    }
    // test 05: check size with one movie
    if (tree.size() != 1) {
      System.out.println("testAddMovieToStringSize() 05 failed.");
      return false;
    }
    // test 06: check if empty with one movie
    if (tree.isEmpty()) {
      System.out.println("testAddMovieToStringSize() 06 failed.");
      return false;
    }
    // test 07: check string with one movie
    if (!tree.toString().equals("[(Year: 2020) (Rate: 6.9) (Name: Yikes)]\n")) {
      System.out.println("testAddMovieToStringSize() 07 failed.");
      return false;
    }
    // test 08: check addMovie() method call after adding smaller movie
    if (!tree.addMovie(new Movie(2019, 6.9, "Smaller"))) {
      System.out.println("testAddMovieToStringSize() 08 failed.");
      return false;
    }
    // test 09: check size again
    if (tree.size() != 2) {
      System.out.println("testAddMovieToStringSize() 09 failed.");
      return false;
    }
    // test 10: check string again
    if (!tree.toString().equals("[(Year: 2019) (Rate: 6.9) (Name: Smaller)]\n"
                              + "[(Year: 2020) (Rate: 6.9) (Name: Yikes)]\n")) {
      System.out.println("testAddMovieToStringSize() 10 failed.");
      return false;
    }
    // test 11: check addMovie() method call after adding larger movie
    if (!tree.addMovie(new Movie(2021, 6.9, "Larger"))) {
      System.out.println("testAddMovieToStringSize() 11 failed.");
      return false;
    }
    // test 12: check size again
    if (tree.size() != 3) {
      System.out.println("testAddMovieToStringSize() 12 failed.");
      return false;
    }
    // test 13: check string again
    if (!tree.toString().equals("[(Year: 2019) (Rate: 6.9) (Name: Smaller)]\n"
                              + "[(Year: 2020) (Rate: 6.9) (Name: Yikes)]\n"
                              + "[(Year: 2021) (Rate: 6.9) (Name: Larger)]\n")) {
      System.out.println("testAddMovieToStringSize() 13 failed.");
      return false;
    }
    // test 14: check addMovie() method call after adding smallest movie
    if (!tree.addMovie(new Movie(2019, 6.1, "Smallest"))) {
      System.out.println("testAddMovieToStringSize() 14 failed.");
      return false;
    }
    // test 15: check size again
    if (tree.size() != 4) {
      System.out.println("testAddMovieToStringSize() 15 failed.");
      return false;
    }
    // test 16: check string again
    if (!tree.toString().equals("[(Year: 2019) (Rate: 6.1) (Name: Smallest)]\n"
                              + "[(Year: 2019) (Rate: 6.9) (Name: Smaller)]\n"
                              + "[(Year: 2020) (Rate: 6.9) (Name: Yikes)]\n"
                              + "[(Year: 2021) (Rate: 6.9) (Name: Larger)]\n")) {
      System.out.println("testAddMovieToStringSize() 16 failed.");
      return false;
    }
    // test 17: check addMovie() method call after adding largest movie
    if (!tree.addMovie(new Movie(2019, 6.1, "Largest"))) {
      System.out.println("testAddMovieToStringSize() 17 failed.");
      return false;
    }
    // test 18: check size again
    if (tree.size() != 5) {
      System.out.println("testAddMovieToStringSize() 18 failed.");
      return false;
    }
    // test 19: check string again
    if (!tree.toString().equals("[(Year: 2019) (Rate: 6.1) (Name: Largest)]\n"
        + "[(Year: 2019) (Rate: 6.1) (Name: Smallest)]\n"
        + "[(Year: 2019) (Rate: 6.9) (Name: Smaller)]\n"
        + "[(Year: 2020) (Rate: 6.9) (Name: Yikes)]\n"
        + "[(Year: 2021) (Rate: 6.9) (Name: Larger)]\n")) {
      System.out.println("testAddMovieToStringSize() 19 failed.");
      return false;
    }
    // test 20: check addMovie() method call after adding a movie that already exists
    if (tree.addMovie(new Movie(2020, 6.9, "Yikes"))) {
      System.out.println("testAddMovieToStringSize() 20 failed.");
      return false;
    }
    // test 21: check if size changed
    if (tree.size() != 5) {
      System.out.println("testAddMovieToStringSize() 21 failed.");
      return false;
    }
    return true;
  }

  /**
   * This method checks mainly for the correctness of the MovieTree.contains() method. It must
   * consider at least the following test scenarios. (1) Create a new MovieTree. Then, check that
   * calling the contains() method on an empty MovieTree returns false. (2) Consider a MovieTree of
   * height 3 which contains at least 5 movies. Then, try to call contains() method to search for the
   * movie having a match at the root of the tree. (3) Then, search for a movie at the right and
   * left subtrees at different levels considering successful and unsuccessful search operations.
   * Make sure that the contains() method returns the expected output for every method call.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testContains() {
    // create new MovieTree
    MovieTree tree = new MovieTree();
    // test 01: check contains() with empty tree
    if (tree.contains(2020, 6.9, "Yikes")) {
      System.out.println("testContains() 01 failed.");
      return false;
    }
    // add some movies
    tree.addMovie(new Movie(2003, 4.5, "san"));
    tree.addMovie(new Movie(2001, 0.1, "yi"));
    tree.addMovie(new Movie(2002, 2.3, "er"));
    tree.addMovie(new Movie(2004, 6.7, "si"));
    tree.addMovie(new Movie(2005, 8.9, "wu"));
    // test 02: check contains() with new tree
    if (tree.contains(2020, 6.9, "Yikes")) {
      System.out.println("testContains() 02 failed.");
      return false;
    }
    // test 03: check contains() again
    if (!tree.contains(2003, 4.5, "san")) {
      System.out.println("testContains() 03 failed.");
      return false;
    }
    // test 04: check contains() again
    if (!tree.contains(2001, 0.1, "yi")) {
      System.out.println("testContains() 04 failed.");
      return false;
    }
    // test 05: check contains() again
    if (!tree.contains(2002, 2.3, "er")) {
      System.out.println("testContains() 05 failed.");
      return false;
    }
    // test 06: check contains() again
    if (!tree.contains(2004, 6.7, "si")) {
      System.out.println("testContains() 06 failed.");
      return false;
    }
    // test 07: check contains() again
    if (!tree.contains(2005, 8.9, "wu")) {
      System.out.println("testContains() 07 failed.");
      return false;
    }
    // test 08: check contains() again
    if (tree.contains(2003, 0.0, "san")) {
      System.out.println("testContains() 08 failed.");
      return false;
    }
    // test 09: check contains() again
    if (tree.contains(2000, 0.1, "yi")) {
      System.out.println("testContains() 09 failed.");
      return false;
    }
    // test 10: check contains() again
    if (tree.contains(2002, 2.3, "liu")) {
      System.out.println("testContains() 10 failed.");
      return false;
    }
    // test 11: check contains() again
    if (tree.contains(2004, 0.0, "qi")) {
      System.out.println("testContains() 11 failed.");
      return false;
    }
    // test 12: check contains() again
    if (tree.contains(2000, 0.0, "ba")) {
      System.out.println("testContains() 12 failed.");
      return false;
    }
    return true;
  }

  /**
   * Checks for the correctness of MovieTree.height() method. This test must consider several
   * scenarios such as, (1) ensures that the height of an empty movie tree is zero. (2) ensures that
   * the height of a tree which consists of only one node is 1. (3) ensures that the height of a
   * MovieTree with the following structure for instance, is 4. 
   *       (*)
   *     /    \
   *  (*)      (*)
   *    \     /  \
   *    (*) (*)  (*)
   *             /
   *           (*)
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testHeight() {
    // create new MovieTree
    MovieTree tree = new MovieTree();
    // test 01: check height of empty tree
    if (tree.height() != 0) {
      System.out.println("testHeight() 01 failed.");
      return false;
    }
    // add root
    tree.addMovie(new Movie(2005, 5.0, "root"));
    // test 02: check height of tree with only root
    if (tree.height() != 1) {
      System.out.println("testHeight() 02 failed.");
      return false;
    }
    // add more
    tree.addMovie(new Movie(2005, 1.0, "nodeL"));
    tree.addMovie(new Movie(2005, 3.0, "nodeLR"));
    tree.addMovie(new Movie(2007, 5.0, "nodeR"));
    tree.addMovie(new Movie(2007, 3.0, "nodeRL"));
    tree.addMovie(new Movie(2009, 0.0, "nodeRR"));
    tree.addMovie(new Movie(2008, 0.0, "nodeRRL"));
    // test 03: check height of tree with many movies
    if (tree.height() != 4) {
      System.out.println("testHeight() 03 failed.");
      return false;
    }
    return true;
  }

  /**
   * Checks for the correctness of MovieTree.getBestMovie() method.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetBestMovie() {
    // create new MovieTree
    MovieTree tree = new MovieTree();
    // test 01: check best movie with empty tree
    try {
      if (tree.getBestMovie() != null) {
        System.out.println("testGetBestMovie() 01 failed.");
        return false;
      }
    } catch (Exception e) {
      return false;
    }
    // make tree
    Movie rootMovie = new Movie(2005, 5.0, "root");
    tree.addMovie(rootMovie);
    // test 02: check best movie with only root
    try {
      if (tree.getBestMovie() != rootMovie) {
        System.out.println("testGetBestMovie() 02 failed.");
        return false;
      }
    } catch (Exception e) {
      return false;
    }
    // add more
    tree.addMovie(new Movie(2005, 1.0, "nodeL"));
    tree.addMovie(new Movie(2005, 3.0, "nodeLR"));
    tree.addMovie(new Movie(2007, 5.0, "nodeR"));
    tree.addMovie(new Movie(2007, 3.0, "nodeRL"));
    Movie bestMovie = new Movie(2009, 0.0, "nodeRR");
    tree.addMovie(bestMovie);
    tree.addMovie(new Movie(2008, 0.0, "nodeRRL"));
    // test 03: check best movie with sample tree
    try {
      if (tree.getBestMovie() != bestMovie) {
        System.out.println("testGetBestMovie() 03 failed.");
        return false;
      }
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  /**
   * Checks for the correctness of MovieTree.lookup() method. This test must consider at least 3
   * test scenarios. (1) Ensures that the MovieTree.lookup() method throws a NoSuchElementException
   * when called on an empty tree. (2) Ensures that the MovieTree.lookup() method returns an array
   * list which contains all the movies satisfying the search criteria of year and rating, when called
   * on a non empty movie tree with one match, and two matches and more. Vary your search criteria
   * such that the lookup() method must check in left and right subtrees. (3) Ensures that the
   * MovieTree.lookup() method throws a NoSuchElementException when called on a non-empty movie tree
   * with no search results found.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testLookup() {
    // create new MovieTree
    MovieTree tree = new MovieTree();
    // test 01: check lookup() with empty tree
    try {
      System.out.println("Error message after this line...");
      tree.lookup(2000, 0.0);
    } catch (NoSuchElementException e) {
      System.out.println(e.getMessage());
    } catch (Exception e) {
      System.out.println("testLookup() 01 failed.");
      return false;
    }
    // make tree
    Movie rootMovie = new Movie(2005, 5.0, "root");
    Movie movieL = new Movie(2005, 1.0, "nodeL");
    Movie movieLR = new Movie(2005, 3.0, "nodeLR");
    tree.addMovie(rootMovie);
    tree.addMovie(movieL);
    tree.addMovie(movieLR);
    Movie movieR = new Movie(2007, 5.0, "nodeR");
    Movie movieRL = new Movie(2007, 3.0, "nodeRL");
    tree.addMovie(movieR);
    tree.addMovie(movieRL);
    tree.addMovie(new Movie(2009, 0.0, "nodeRR"));
    tree.addMovie(new Movie(2008, 0.0, "nodeRRL"));
    // make array
    ArrayList<Movie> array1 = new ArrayList<Movie>();
    array1.add(rootMovie);
    // test 02: check lookup() with sample tree
    if (!array1.equals(tree.lookup(2005, 4.0))) {
      System.out.println("testLookup() 02 failed.");
      return false;
    }
    // make array
    ArrayList<Movie> array2 = new ArrayList<Movie>();
    array2.add(movieL);
    array2.add(movieLR);
    array2.add(rootMovie);
    // test 03: check lookup() with left of sample tree
    if (!array2.equals(tree.lookup(2005, 0.0))) {
      System.out.println("testLookup() 03 failed.");
      return false;
    }
    // make array
    ArrayList<Movie> array3 = new ArrayList<Movie>();
    array3.add(movieRL);
    array3.add(movieR);
    // test 04: check lookup() with right of sample tree
    if (!array3.equals(tree.lookup(2007, 0.0))) {
      System.out.println("testLookup() 04 failed.");
      return false;
    }
    // test 05: check lookup() for no search results
    try {
      System.out.println("Error message after this line...");
      tree.lookup(2004, 0.0);
    } catch (NoSuchElementException e) {
      System.out.println(e.getMessage());
    } catch (Exception e) {
      System.out.println("testLookup() 05 failed.");
      return false;
    }
    return true;
  }
  
  /*
   * Demo method.
   */
  public static void demo() {
    MovieTree bst = new MovieTree();
    System.out.println("Size: " + bst.size() + " Height: " + bst.height() + "\nCatalog:");
    System.out.println(bst);
    bst.addMovie(new Movie(2018, 6.5, "Airplanes"));
    bst.addMovie(new Movie(1988, 9.5, "Best"));
    System.out.println("==============================================================");
    System.out.println("Size: " + bst.size() + " Height: " + bst.height() + "\nCatalog:");
    System.out.println(bst);
    bst.addMovie(new Movie(2018, 8.5, "Cats"));
    bst.addMovie(new Movie(2018, 6.0, "Yes"));
    bst.addMovie(new Movie(2017, 5.5, "Dogs"));
    bst.addMovie(new Movie(2018, 7.5, "Earth"));
    bst.addMovie(new Movie(2018, 6.0, "Flights"));
    bst.addMovie(new Movie(2015, 8.5, "Grand Parents"));
    System.out.println("==============================================================");
    System.out.println("Size: " + bst.size() + " Height: " + bst.height() + "\nCatalog:");
    System.out.println(bst);
    try {
      System.out.println("This catalog contains (2018, 7.5, Earth): " + bst.contains(2018, 7.5, "Earth"));
      System.out.println("This catalog contains (2016, 8.4, Flowers): " + bst.contains(2018, 7.5, "Flowers"));
      System.out.println();
      System.out.println("Best movie: " + bst.getBestMovie());
      System.out.println();
      System.out.println("Lookup query: search for the movies of 2018 rated 6.5 and higher");
      System.out.println(bst.lookup(2018, 6.5));
      System.out.println();
      System.out.println("Lookup query: search for the movies of 2018 with rated 8.0 and higher");
      System.out.println(bst.lookup(2018, 8.0));
      System.out.println();
      System.out.println("Lookup query: search for the movies of 2015 with rated 9.0 and higher");
      System.out.println(bst.lookup(2015, 9.0));
    } catch (NoSuchElementException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Calls the test methods
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    System.out.println("testAddMovieToStringSize(): " + testAddMovieToStringSize());
    System.out.println("testContains(): " + testContains());
    System.out.println("testHeight(): " + testHeight());
    System.out.println("testGetBestMovie(): " + testGetBestMovie());
    System.out.println("testLookup(): " + testLookup());
    //demo();
  }

}
//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P09 Movie Catalog
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

import java.util.ArrayList;
import java.util.NoSuchElementException;

/*
 * This class produces a tree of movies.
 */
public class MovieTree {

  private BSTNode<Movie> root; // root of this movie BST
  private int size; // size of this movie tree

  /**
   * Checks whether this binary search tree (BST) is empty
   * 
   * @return true if this MovieTree is empty, false otherwise
   */
  public boolean isEmpty() {
    if (size == 0) {
      return true;
    }
    return false;
  }

  /**
   * Returns the number of movies stored in this BST.
   * 
   * @return the size of this MovieTree
   */
  public int size() {
    return size;
  }

  /**
   * Adds a new movie to this MovieTree
   * 
   * @param newMovie a new movie to add to this BST.
   * @return true if the newMovie was successfully added to this BST, and returns false if there is
   *         a match with this movie already stored in this BST.
   */
  public boolean addMovie(Movie newMovie) {
    if (isEmpty()) { // Add newMovie to an empty MovieTree
      root = new BSTNode<Movie>(newMovie);
      ++size;

    } else { // Add newMovie to an non-empty MovieTree
      if (!addMovieHelper(newMovie, root)) {
        return false;
      } else {
        addMovieHelper(newMovie, root);
        ++size;
      }
    }
    return true; // Remove this statement. Added to let this code compile.
  }

  /**
   * Recursive helper method to add a new movie to a MovieTree rooted at current.
   * 
   * @param current  The "root" of the subtree we are inserting new movie into.
   * @param newMovie The movie to be added to a BST rooted at current.
   * @return true if the newMovie was successfully added to this MovieTree, false otherwise
   */
  protected static boolean addMovieHelper(Movie newMovie, BSTNode<Movie> current) {
    if (newMovie.getYear() == current.getData().getYear()) {
      if (newMovie.getRating() == current.getData().getRating()) {
        if (newMovie.getName().equals(current.getData().getName())) {
          return false;
        }
        else if (newMovie.getName().compareTo(current.getData().getName()) < 0) {
          if (current.getLeft() != null) {
            addMovieHelper(newMovie, current.getLeft());
          }
          else { // base case 1
            current.setLeft(new BSTNode<Movie>(newMovie));
          }
        }
        else if (newMovie.getName().compareTo(current.getData().getName()) > 0) {
          if (current.getRight() != null) {
            addMovieHelper(newMovie, current.getRight());
          }
          else { // base case 2
            current.setRight(new BSTNode<Movie>(newMovie));
          }
        }
      }
      else if (newMovie.getRating() < current.getData().getRating()) {
        if (current.getLeft() != null) {
          addMovieHelper(newMovie, current.getLeft());
        }
        else { // base case 1
          current.setLeft(new BSTNode<Movie>(newMovie));
        }
      }
      else if (newMovie.getRating() > current.getData().getRating()) {
        if (current.getRight() != null) {
          addMovieHelper(newMovie, current.getRight());
        }
        else { // base case 2
          current.setRight(new BSTNode<Movie>(newMovie));
        }
      }
    }
    else if (newMovie.getYear() < current.getData().getYear()) {
      if (current.getLeft() != null) {
        addMovieHelper(newMovie, current.getLeft());
      }
      else { // base case 1
        current.setLeft(new BSTNode<Movie>(newMovie));
      }
    }
    else if (newMovie.getYear() > current.getData().getYear()) {
      if (current.getRight() != null) {
        addMovieHelper(newMovie, current.getRight());
      }
      else { // base case 2
        current.setRight(new BSTNode<Movie>(newMovie));
      }
    }
    return true;
  }

  /**
   * Returns a String representation of all the movies stored within this BST in the increasing
   * order, separating by a newline "\n". For instance
   * 
   * "[(Year: 1988) (Rate: 7.0) (Name: Light Years)]" + "\n" + 
   * "[(Year: 2015) (Rate: 6.5) (Name: Cinderella)]" + "\n"
   * 
   * @return a String representation of all the movies stored within this BST sorted in an
   *         increasing order with respect to the result of Movie.compareTo() method (year, rating,
   *         name). Returns an empty string "" if this BST is empty.
   */
  @Override
  public String toString() {
    return toStringHelper(root);
  }

  /**
   * Recursive helper method which returns a String representation of the BST rooted at current. An
   * example of the String representation of the contents of a MovieTree is provided in the
   * description of the above toString() method.
   * 
   * @param current reference to the current movie within this BST (root of a subtree)
   * @return a String representation of all the movies stored in the sub-tree rooted at current in
   *         increasing order with respect to the result of Movie.compareTo() method (year, rating,
   *         name). Returns an empty String "" if current is null.
   */
  protected static String toStringHelper(BSTNode<Movie> current) {
    String helper = "";
    if (current == null) {
      return helper;
    }
    if (current.getLeft() != null) {
      helper += toStringHelper(current.getLeft());
    }
    helper += "[(Year: " + current.getData().getYear()
           + ") (Rate: " + current.getData().getRating()
           + ") (Name: " + current.getData().getName()
           + ")]\n";
    if (current.getRight() != null) {
      helper += toStringHelper(current.getRight());
    }
    return helper;
  }

  /**
   * Computes and returns the height of this BST, counting the number of NODES from root to the
   * deepest leaf.
   * 
   * @return the height of this Binary Search Tree
   */
  public int height() {
    return heightHelper(root);
  }

  /**
   * Recursive helper method that computes the height of the subtree rooted at current counting the
   * number of nodes and NOT the number of edges from current to the deepest leaf
   * 
   * @param current pointer to the current BSTNode within a MovieTree (root of a subtree)
   * @return height of the subtree rooted at current
   */
  protected static int heightHelper(BSTNode<Movie> current) {
    int heightLeft = 1;
    int heightRight = 1;
    if (current == null) {
      return 0;
    }
    if (current.getLeft() != null) {
      heightLeft += heightHelper(current.getLeft());
    }
    if (current.getRight() != null) {
      heightRight += heightHelper(current.getRight());
    }
    if (heightLeft > heightRight) {
      return heightLeft;
    }
    return heightRight;
  }

  /**
   * Checks whether this MovieTree contains a movie given its name, production year, and rating.
   * 
   * @param year   year of production of the movie to search
   * @param rating rating of the movie to search
   * @param name   name of the movie to search
   * @return true if there is a match with this movie in this BST, and false otherwise
   */
  public boolean contains(int year, double rating, String name) {
    Movie target = new Movie(year, rating, name);
    if (size == 0) {
      return false;
    }
    if (containsHelper(target, root)) {
      return true;
    }
    return false;
  }

  /**
   * Recursive helper method to search whether there is a match with a given movie in the subtree
   * rooted at current
   * 
   * @param target  a reference to a movie we are searching for a match in the BST rooted at
   *                current.
   * @param current "root" of the subtree we are checking whether it contains a match to target.
   * @return true if match found and false otherwise
   */
  protected boolean containsHelper(Movie target, BSTNode<Movie> current) {
    boolean containsLeft = false;
    boolean containsRight = false;
    if (current.getData().getYear() == (target.getYear())) {
      if (current.getData().getRating() == (target.getRating())) {
        if (current.getData().getName().equals(target.getName())) {
          return true;
        }
      }
    }
    if (current.getLeft() != null) {
      containsLeft = containsHelper(target, current.getLeft());
    }
    if (current.getRight() != null) {
      containsRight = containsHelper(target, current.getRight());
    }
    if (containsLeft || containsRight) {
      return true;
    }
    return false;
  }

  /**
   * Gets the best (maximum) movie in this BST
   * 
   * @return the best (largest) movie (the most recent, highest rated, and having the largest name)
   *         in this MovieTree, and null if this tree is empty.
   */
  public Movie getBestMovie() {
    if (root == null || size == 0) {
      return null;
    }
    BSTNode<Movie> current = root;
    while (current.getRight() != null) {
      current = current.getRight();
    }
    return current.getData();
  }

  /**
   * Search for movies given the year and minimum rating as lookup key.
   * 
   * @param year   production year of a movie
   * @param rating rating value of a movie
   * @return a list of movies whose year equals our lookup year key and having a rating greater or
   *         equal to a given rating.
   * @throws a NoSuchElementException with a descriptive error message if there is no Movie found in
   *           this BST having the provided year and a rating greater or equal to the provided
   *           rating
   */
  public ArrayList<Movie> lookup(int year, double rating) {
    ArrayList<Movie> list = new ArrayList<Movie>();
    lookupHelper(year, rating, root, list);
    if (list.size() == 0) {
      throw new NoSuchElementException("No search results.");
    }
    return list;
  }

  /**
   * Recursive helper method to lookup the list of movies given their year of production and a
   * minimum value of rating
   * 
   * @param year      the year we would like to search for a movie
   * @param rating    the minimum rating we would like to search for a movie
   * @param movieList an arraylist which stores the list of movies matching our search criteria
   *                  (exact year of production and having at least the provided rating) within the
   *                  subtree rooted at current
   * @param current   "root" of the subtree we are looking for a match to find within it.
   */
  protected void lookupHelper(int year, double rating, BSTNode<Movie> current,
      ArrayList<Movie> movieList) {
    if (current == null) {
      return;
    }
    if (current.getLeft() != null) {
      lookupHelper(year, rating, current.getLeft(), movieList);
    }
    if (current != null) {
      if (current.getData().getYear() == year) {
        if (current.getData().getRating() >= rating) {
          movieList.add(current.getData());
        }
      }
    }
    if (current.getRight() != null) {
      lookupHelper(year, rating, current.getRight(), movieList);
    }
  }
}
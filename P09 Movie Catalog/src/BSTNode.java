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

/**
 * Generic class implementing a Binary Node of a Binary Search Tree (BST)
 *
 * @param <T> type of the data carried by this binary node
 * @author Sulong
 */
public class BSTNode<T extends Comparable<T>> {
  // Note: DO NOT MAKE ANY CHANGE TO THIS CLASS AND DO NOT SUBMIT IT TO GRADESCOPE
  private T data; // data in the node field
  private BSTNode<T> left; // reference to the left child
  private BSTNode<T> right; // reference to the right child

  /**
   * Creates a BSTNode with a given data value
   * 
   * @param data data carried by this binary node
   */
  public BSTNode(T data) {
    this.data = data;
  }

  /**
   * Creates a BSTNode with given data value, a reference to a left child (left subtree) and a
   * reference to a right child (right sub-tree)
   * 
   * @param data  element held by this binary node
   * @param left  reference to the left child
   * @param right reference to the right child
   */
  public BSTNode(T data, BSTNode<T> left, BSTNode<T> right) {
    this.data = data;
    this.left = left;
    this.right = right;
  }

  /**
   * Getter of left child
   * 
   * @return the left
   */
  public BSTNode<T> getLeft() {
    return left;
  }

  /**
   * Setter for left child
   * 
   * @param left the left to set
   */
  public void setLeft(BSTNode<T> left) {
    this.left = left;
  }

  /**
   * Getter of the right child
   * 
   * @return the right child of this binary node
   */
  public BSTNode<T> getRight() {
    return right;
  }

  /**
   * Setter for the right child
   * 
   * @param right the right to set
   */
  public void setRight(BSTNode<T> right) {
    this.right = right;
  }

  /**
   * Getter of data field
   * 
   * @return the data held by this node
   */
  public T getData() {
    return data;
  }

}
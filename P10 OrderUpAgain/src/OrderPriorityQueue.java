import java.util.Arrays;
import java.util.NoSuchElementException;

////////////////FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
//Title:    P10 Order Up Again
//Course:   CS 300 Spring 2021
//
//Author:   Orion Meng
//Email:    dmeng8@wisc.edu
//Lecturer: Mouna Kacem
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
//Persons:         NONE
//Online Sources:  NONE
//
///////////////////////////////////////////////////////////////////////////////

/**
 * A max-heap implementation of a priority queue for Orders, where the Order with the LONGEST prep 
 * time is returned first instead of the strict first-in-first-out queue as in P08.
 */
public class OrderPriorityQueue implements PriorityQueueADT<Order> {

  // Data fields; do not modify
  private Order[] queueHeap;
  private int size;
  
  /**
   * Constructs a PriorityQueue for Orders with the given capacity
   * 
   * @param capacity the initial capacity for the queue
   * @throws IllegalArgumentException if the given capacity is 0 or negative
   */
  public OrderPriorityQueue(int capacity) {
    if (capacity <= 0) {
      throw new IllegalArgumentException("Capacity must be positive.");
    }
    queueHeap = new Order[capacity];
    size = 0;
  }
  
  /**
   * Inserts a new Order into the queue in the appropriate position using a heap's add logic.
   * 
   * @param newOrder the Order to be added to the queue
   */
  @Override
  public void insert(Order newOrder) {
    if (size == 0) {
      queueHeap[0] = newOrder;
      ++size;
    }
    else {
      if (queueHeap[size - 1] != null) {
        Order[] copy = Arrays.copyOf(queueHeap, queueHeap.length * 2);
        queueHeap = copy;
      }
      queueHeap[size] = newOrder;
      ++size;
      int index = size - 1;
      percolateUp(queueHeap, index);
    }
  }
  
  /**
   * A utility method to percolate Order values UP through the heap; see figure 13.3.1 in zyBooks
   * for a pseudocode algorithm.
   * 
   * @param heap an array containing the Order values to be percolated into a valid heap
   * @param orderIndex the index of the Order to be percolated up
   */
  protected static void percolateUp(Order[] heap, int orderIndex) {
    int index = orderIndex;
    while (index > 0) {
      int parentIndex = (index - 1) / 2;
      if (heap[index].compareTo(heap[parentIndex]) <= 0) {
        return;
      }
      else {
        Order temp = heap[index];
        heap[index] = heap[parentIndex];
        heap[parentIndex] = temp;
        index = parentIndex;
      }
    }
  }
  
  /**
   * Return the Order with the longest prep time from the queue and adjust the queue accordingly
   * 
   * @return the Order with the current longest prep time from the queue
   * @throws NoSuchElementException if the queue is empty
   */
  @Override
  public Order removeBest() {
    if (size == 0) {
      throw new NoSuchElementException("Queue is empty.");
    }
    Order removed = queueHeap[0];
    queueHeap[0] = queueHeap[size - 1];
    queueHeap[size - 1] = null;
    --size;
    percolateDown(queueHeap, 0, size);
    return removed;
  }
  
  /**
   * A utility method to percolate Order values DOWN through the heap; see figure 13.3.2 in zyBooks
   * for a pseudocode algorithm.
   * 
   * @param heap an array containing the Order values to be percolated into a valid heap
   * @param orderIndex the index of the Order to be percolated down
   * @param size the number of initialized elements in the heap
   */
  protected static void percolateDown(Order[] heap, int orderIndex, int size) {
    int childIndex = 2 * orderIndex + 1;
    Order current = heap[orderIndex];
    while (childIndex < size) {
      Order maximum = current;
      int maxIndex = -1;
      for (int i = 0; i < 2 && i + childIndex < size; ++i) {
        if (heap[i + childIndex].compareTo(maximum) > 0) {
          maximum = heap[i + childIndex];
          maxIndex = i + childIndex;
        }
      }
      if (maximum.compareTo(current) == 0) {
        return;
      }
      else {
        Order temp = heap[orderIndex];
        heap[orderIndex] = heap[maxIndex];
        heap[maxIndex] = temp;
        orderIndex = maxIndex;
        childIndex = 2 * orderIndex + 1;
      }
    }
  }
  
  /**
   * Return the Order with the highest prep time from the queue without altering the queue
   * @return the Order with the current longest prep time from the queue
   * @throws NoSuchElementException if the queue is empty
   */
  @Override
  public Order peekBest() {
    if (size == 0) {
      throw new NoSuchElementException("Queue is empty.");
    }
    return this.queueHeap[0];
  }
  
  /**
   * Returns true if the queue contains no Orders, false otherwise
   * @return true if the queue contains no Orders, false otherwise
   */
  @Override
  public boolean isEmpty() {
    if (size == 0) {
      return true;
    }
    return false;
  }
  
  /**
   * Returns the number of elements currently in the queue
   * @return the number of elements currently in the queue
   */
  public int size() {
    return size;
  }
  
  /**
   * Creates a String representation of this PriorityQueue. Do not modify this implementation; this
   * is the version that will be used by all provided OrderPriorityQueue implementations that your
   * tester code will be run against.
   * 
   * @return the String representation of this PriorityQueue, primarily for testing purposes
   */
  public String toString() {
    String toReturn = "";
    for (int i=0; i < this.size; i++) {
      toReturn += queueHeap[i].getID()+"("+queueHeap[i].getPrepTime()+")";
      if (i < this.size-1) toReturn += ", ";
    }
    return toReturn;
  }
}

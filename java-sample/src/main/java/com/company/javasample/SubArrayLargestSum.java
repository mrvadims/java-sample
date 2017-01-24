package com.company.javasample;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;

public class SubArrayLargestSum {

  private static final Logger logger = (Logger) LoggerFactory.getLogger(SubArrayLargestSum.class);
  
  public SubArrayLargestSum() {
    
    logger.setLevel(Level.INFO);
  }
  
  public ArraySum calculate(int [] array) {
    
//    ArraySum largest = new ArraySum(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    return findLargestSum(array, 0, array.length-1);
  }
  
  private ArraySum findLargestSum(int [] array, int start, int end) {
    
    if (array == null) {
      
      throw new IllegalArgumentException("Array cannot be null");
    }
    
    if (start < 0 || end < 0 || start > end || start > (array.length - 1) || end > (array.length - 1)) {
      
      throw new ArrayIndexOutOfBoundsException("start or end array index is out of bounds.  array.length=" + array.length);
    }
    
    // If only one element
    if (start == end) {
      
      return new ArraySum(start, end, array[start]);
    }
    
    ArraySum largest = findLargestSum(array, start, end - 1);
    logger.debug(String.format("Calculating argest [%s, %s]; Previous largest: %s", start, end, largest));

    
    int currentSum = sum(array, largest.getStart(), end);
    logger.debug(String.format("Current sum [%s, %s] = %s", largest.getStart(), end, currentSum));
    if (currentSum > largest.getSum()) {
      largest = new ArraySum(largest.getStart(), end, currentSum);
      logger.debug("Extending region to include end: " + largest);
    }

    if (largest.getSum() <= array[end]) {
      largest = new ArraySum(end, end, array[end]);
      logger.debug("Largest is now the end: " + largest);
    }
    
    logger.debug("New Largest : " + largest);
    return largest;
  }
  
  private int sum(int [] array, int start, int end) {
    
    int sum = 0;
    for (int i = start; i<=end; i++) {
      sum += array[i];
    }
    return sum;
  }
  
  public class ArraySum {
    
    private int start;
    private int end;
    private int sum;
    
    public ArraySum(int start, int end, int sum) {
      
      this.start = start;
      this.end = end;
      this.sum = sum;
    }

    public ArraySum(ArraySum arraySum) {
      
      this.start = arraySum.getStart();
      this.end = arraySum.getEnd();
      this.sum = arraySum.getSum();
    }

    public String toString() {
      
      return String.format("[%s, %s] = %s", start, end, sum);
    }

    public int getStart() {
      
      return start;
    }

    
    public int getEnd() {
    
      return end;
    }

    
    public int getSum() {
    
      return sum;
    }

    public boolean isLessThan(ArraySum arraySum) {

      if (sum < arraySum.getSum()) {
        return true;
      }
      return false;
    }

  }
}

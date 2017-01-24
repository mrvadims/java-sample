package com.company.javasample;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;


public class SubArrayLargestSumTest {
  
  int [][] testData = {
      {0, 1, 2, 3},
      {3, 2, 1, 0},
      {0, 0, 1, 0},
      {-1, 1, 2, 3},
      {-1, 1, 2, -2},
      {-100, 100, -50, 50},
      {-100, 100, -50, 50, 1},
      {-1, 2, -3, 4, -5, 6}
  };

//  int [][] testData = {
//      {-100, 100, -50, 50}
//  };

  @Test
  public void testCalculate() {

    SubArrayLargestSum subArrayLargestSum = new SubArrayLargestSum();
    for (int [] array : testData) {
      System.out.println(Arrays.toString(array) + " : " + subArrayLargestSum.calculate(array));
    }
  }

}

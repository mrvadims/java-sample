package com.company.javasample;

import java.util.HashMap;

public class RandomGenerator {

  public int rand3() {
    
    return (int) (Math.random() * 3 + 1);
  }
  
  public int rand8() {

    int random = 3*(rand3()-1) + rand3();
    while (random < 0 || random > 8) {
      random = 3*(rand3()-1) + rand3();
    }
    return random;
  }
  
  
  public static void main(String[] args) {

    int MAX = 100000;
    RandomGenerator randomGenerator = new RandomGenerator();
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    
    // initialize map
    for (int i=1; i<9; i++) {
      map.put(i, 0);
    }
    
    for (int i=0; i<MAX; i++) {
      int randomNumber = randomGenerator.rand8();
      if (randomNumber < 1 || randomNumber > 8) {
        System.err.println("ERROR, random number has to be between 1 and 8: " + randomNumber);
        break;
      }
      map.put(randomNumber, map.get(randomNumber) + 1);
    }
    
    System.out.println(map);
  }
}

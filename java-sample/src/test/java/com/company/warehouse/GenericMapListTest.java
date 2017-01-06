package com.company.warehouse;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class GenericMapListTest {

  @Test
  public void testPut() {

    GenericMapList map = new GenericMapList();
    assertEquals("Map is empty", map.size(), 0);

    map.put(Integer.class, Integer.valueOf(1));
    assertEquals("Map is empty", map.size(), 1);
    System.out.println(map.toString());

    map.put(Integer.class, Integer.valueOf(2));
    map.put(Integer.class, Integer.valueOf(3));
    System.out.println(map.toString());
    assertEquals("Map is empty", map.size(), 1);

    map.put(String.class, "abc");
    map.put(String.class, "def");
    System.out.println(map.toString());
    assertEquals("Map is empty", map.size(), 2);
}

  @Test
  public void testGet() {

    GenericMapList map = new GenericMapList();
    map.put(Integer.class, Integer.valueOf(1));
    map.put(Integer.class, Integer.valueOf(2));
    map.put(Integer.class, Integer.valueOf(3));
    map.put(String.class, "abc");
    map.put(String.class, "def");
    System.out.println(map.toString());

    assertEquals("Integer list", map.get(Integer.class).size(), 3);
    assertEquals("String list", map.get(String.class).size(), 2);
  }


  @Test
  public void testGetAndRemoveFirst() {

    GenericMapList map = new GenericMapList();
    map.put(Integer.class, Integer.valueOf(1));
    map.put(Integer.class, Integer.valueOf(2));
    map.put(Integer.class, Integer.valueOf(3));
    map.put(String.class, "abc");
    map.put(String.class, "def");
    System.out.println(map.toString());

    assertEquals("Integer list", map.get(Integer.class).size(), 3);
    assertEquals("String list", map.get(String.class).size(), 2);
    
    assertEquals("First Integer element", map.getRemoveFirst(Integer.class), Integer.valueOf(1));
    assertEquals("First String element", map.getRemoveFirst(String.class), "abc");
    assertEquals("Integer list", map.get(Integer.class).size(), 2);
    assertEquals("String list", map.get(String.class).size(), 1);
    System.out.println(map.toString());
  }

}

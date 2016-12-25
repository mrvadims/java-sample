package com.company.javasample;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.company.javasample.ISingleLinkedLinkList;
import com.company.javasample.SingleLinkedLinkList;


public class SingleLinkedLinkListTest {
  
  private ISingleLinkedLinkList<String> emptyLinkedList;
  private ISingleLinkedLinkList<String> oneElementLinkedList;
  private ISingleLinkedLinkList<String> multiElementLinkedList;
  private int count = 10;

  
  @Before
  public void populateTestData() {
    
    emptyLinkedList = new SingleLinkedLinkList<String>();
    oneElementLinkedList = new SingleLinkedLinkList<String>();
    oneElementLinkedList.addTail(String.valueOf(0));
    multiElementLinkedList = new SingleLinkedLinkList<String>();
    for (int i=0; i<count; i++) {
      multiElementLinkedList.addTail(String.valueOf(i));
    }
  }
  
  @Test
  public void testIsEmpty() {

    assertEquals("Empty list is empty", emptyLinkedList.count(), 0);
    assertNotEquals("One element list is not empty", oneElementLinkedList.count(), 0);
    assertNotEquals("Multi element list is not empty", multiElementLinkedList.count(), 0);
  }

  @Test
  public void testAddHead() {

    assertEquals("Empty list is empty", emptyLinkedList.count(), 0);
    System.out.println(emptyLinkedList.toString());
    emptyLinkedList.addHead("new value");
    assertEquals("Empty list has 1 element", emptyLinkedList.count(), 1);
    System.out.println(emptyLinkedList.toString());
    
    assertEquals("Multy element list has " + count + " elements", multiElementLinkedList.count(), count);
    System.out.println(multiElementLinkedList.toString());
    multiElementLinkedList.addHead("new value");
    assertEquals("Multy element list has " + count+1 + " elements", multiElementLinkedList.count(), count+1);
    System.out.println(multiElementLinkedList.toString());
  }

  @Test
  public void testAddTail() {

    assertEquals("Empty list is empty", emptyLinkedList.count(), 0);
    System.out.println(emptyLinkedList.toString());
    emptyLinkedList.addTail("new value");
    assertEquals("Empty list has 1 element", emptyLinkedList.count(), 1);
    System.out.println(emptyLinkedList.toString());
    
    assertEquals("Multy element list has " + count + " elements", multiElementLinkedList.count(), count);
    System.out.println(multiElementLinkedList.toString());
    multiElementLinkedList.addTail("new value");
    assertEquals("Multy element list has " + count+1 + " elements", multiElementLinkedList.count(), count+1);
    System.out.println(multiElementLinkedList.toString());
  }

  @Test
  public void testExists() {

    assertFalse("Element does not exist in empty list", emptyLinkedList.exists("new value"));
    assertFalse("Element does not exist in one element list", oneElementLinkedList.exists("new value"));
    System.out.println(oneElementLinkedList.toString());
    assertTrue("Element exists in one element list", oneElementLinkedList.exists(String.valueOf(0)));
    assertFalse("Element does not exist in multi element list", multiElementLinkedList.exists("new value"));
    System.out.println(multiElementLinkedList.toString());
    assertTrue("Element exists in multi element list", multiElementLinkedList.exists(String.valueOf(5)));
  }

  @Test
  public void testRemove() {

    fail("Not yet implemented");
  }

  @Test
  public void testToString() {

    System.out.println(emptyLinkedList.toString());
    System.out.println(oneElementLinkedList.toString());
    System.out.println(multiElementLinkedList.toString());
  }

  @Test
  public void testCount() {

    assertEquals("Empty list has 0 elements", emptyLinkedList.count(), 0);
    assertEquals("One element list has 1 elements", oneElementLinkedList.count(), 1);
    assertEquals("Multy element list has " + count + " elements", multiElementLinkedList.count(), count);
  }

  @Test
  public void testReverseInPlace() {
    
    System.out.println(multiElementLinkedList.toString());
    multiElementLinkedList.reverseInPlace();
    System.out.println(multiElementLinkedList.toString());
  }
}

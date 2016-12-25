package com.company.javabase;

public class SingleLinkedLinkList<T> implements ISingleLinkedLinkList<T> {

  ListElement<T> head = null;
    
  public boolean isEmpty() {
    
    if (head == null) {
      return true;
    }
    return false;
  }
  
  public void addHead(T value) {
    
    ListElement<T> listElement = new ListElement<T>(value);
    
    if (this.isEmpty()) {
      head = listElement;
      return;
    }
    
    listElement.next = head;
    head = listElement;
  }
  

  public void addTail(T value) {

    ListElement<T> listElement = new ListElement<T>(value);
    
    if (this.isEmpty()) {
      head = listElement;
      return;
    }
    
    ListElement<T> lastElement = findLast(head);
    lastElement.setNext(listElement);
  }

  public boolean exists(T value) {
    
    if(this.isEmpty()) {
      return false;
    }

    if (find(head, value) == null) {
      return false;
    }
    return true;
  }

  
  public void remove(T value) {

  }

  public String toString() {
    
    if (this.isEmpty()) {
      return "List is empty";
    }

    return toString(head, 0);
  }
  
  public int count() {

    if (this.isEmpty()) {
      return 0;
    }
 
    return count(head);
  }


  public void reverseInPlace() {
    
    if (isEmpty()) {
      
      return;
    }
    
    ListElement<T> previousElement = null;
    ListElement<T> currentElement = head;
    ListElement<T> nextElement = currentElement;
    
    while (nextElement != null) {

      nextElement = currentElement.getNext();
      currentElement.setNext(previousElement);
      previousElement = currentElement;
      currentElement = nextElement;
    }
    
    head = previousElement;
  }
  
  private int count(ListElement<T> listElement) {
    
    if (listElement.hasNext()) {
      return count(listElement.getNext()) + 1;
    }
    
    return 1;  
  }
  
  private ListElement<T> findLast(ListElement<T> listElement) {
    
    if (listElement == null) {
      throw new RuntimeException("list element cannot be null");
    }
    
    if (listElement.hasNext()) {
      return findLast(listElement.getNext());
    }
    
//    System.out.println("findLast - Last element: " + listElement);
    return listElement;
  }

  
  private ListElement<T> find(ListElement<T> listElement, T value) {
    
    if (listElement == null) {
      return null;
    }

    if (listElement.equals(value)) {
      return listElement;
    }
    
    return find(listElement.next, value);
  }

  
  private String toString(ListElement<T> listElement, int index) {
    
    StringBuffer sb = new StringBuffer();
    sb.append("[" + index + "]=" + listElement.toString() + "; ");
    
    if (listElement.hasNext()) {
      sb.append(toString(listElement.getNext(), index+1));
    }
    
    return sb.toString();
  }
}

package com.company.javabase;


public class ListElement<T> {
  
  ListElement<T> next;
  T value;
  
  public ListElement(T value) {
    
    this.value = value;
    this.next = null;
  }
  
  public ListElement<T> getNext() {
  
    return next;
  }
  
  public void setNext(ListElement<T> next) {
  
    this.next = next;
  }
  
  public T getValue() {
  
    return value;
  }
  
  public void setValue(T value) {
  
    this.value = value;
  }
  
  public boolean hasNext() {
    
    if (next == null) {
      return false;
    }
    return true;
  }
  
  public String toString() {
    
    return value.toString();
  }
  
  public boolean equals(Object value) {
    
    if (this.value == null && value == null) {
      return true;
    }
    
    if (this.value == null) {
      return false;
    }
    
    return this.value.equals(value);
  }
}

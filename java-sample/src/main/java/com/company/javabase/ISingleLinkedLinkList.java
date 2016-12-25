package com.company.javabase;


public interface ISingleLinkedLinkList<T> {

  public void addHead(T value);
  
  public void addTail(T value);

  public boolean exists(T value);
  
  public void remove(T value);
  
  public String toString();
  
  public int count();
  
  public void reverseInPlace();
}

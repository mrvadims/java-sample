package com.company.warehouse;


public interface Consumer<T> {

  public String getName();
  public void consume(T widget);
}

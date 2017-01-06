package com.company.warehouse;


public interface Supplier<T> {

  public String getName();
  public T produce();
}

package com.company.warehouse;

public abstract class BaseConsumer<T> implements Consumer<T> {
  
  private String name;

  public BaseConsumer(String name) {
    this.name = this.getClass().getSimpleName() + name;
  }

  public String getName() {
    return name;
  }

}

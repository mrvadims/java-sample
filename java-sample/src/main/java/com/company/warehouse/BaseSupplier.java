package com.company.warehouse;

import java.security.SecureRandom;

public abstract class BaseSupplier<T> implements Supplier<T> {

  private String name;
  private SecureRandom random = new SecureRandom();

  public BaseSupplier(String name) {
    this.name = this.getClass().getSimpleName() + name;
  }

  public String getName() {

    return name;
  }

  protected Double random() {
    
    return random.nextDouble();
  }
}
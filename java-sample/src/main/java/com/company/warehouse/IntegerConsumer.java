package com.company.warehouse;


public class IntegerConsumer extends BaseConsumer<Integer> {

  public IntegerConsumer(String name) {
    super(name);
  }

  public void consume(Integer widget) {

    if (widget == null) {
      System.out.println(this.getClass().getSimpleName() + "[" + getName() + "] NOTHING to consume");
      return;       
    }

    System.out.println(this.getClass().getSimpleName() + "[" + getName() + "] consumed: " + widget);
  }

}

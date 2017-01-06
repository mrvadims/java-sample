package com.company.warehouse;


public class StringConsumer extends BaseConsumer<String> {

  public StringConsumer(String name) {
    super(name);
  }

  public void consume(String widget) {

    if (widget == null) {
      System.out.println(this.getClass().getSimpleName() + "[" + getName() + "] NOTHING to consume");
      return;       
    }
    System.out.println(this.getClass().getSimpleName() + "[" + getName() + "] consumed: " + widget);
  }

}

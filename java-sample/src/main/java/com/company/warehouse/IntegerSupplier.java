/**
 * 
 */
package com.company.warehouse;

/**
 * @author vadim.shteynberg
 *
 */
public class IntegerSupplier extends BaseSupplier<Integer> {

  public IntegerSupplier(String name) {
    super(name);
  }

  public Integer produce() {

    Integer widget = (int) (random() * 100000000);
    System.out.println(this.getClass().getSimpleName() + "[" + getName() + "] produced: " + widget);
    return widget;
  }

}

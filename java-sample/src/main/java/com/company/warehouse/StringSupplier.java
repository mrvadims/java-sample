package com.company.warehouse;

public class StringSupplier extends BaseSupplier<String> {

  private static final String letters = "abcdefghjkmnpqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ23456789+@";
  private static final int WIDGET_LENGTH = 10;
  
  public StringSupplier(String name) {
    super(name);
  }
  
  public String produce() {

    StringBuilder sb = new StringBuilder();
    for (int i=0; i<WIDGET_LENGTH; i++) {
      int index = (int) (random()*letters.length());
      sb.append(letters.substring(index, index+1));
    }

    String widget = sb.toString();
    System.out.println(this.getClass().getSimpleName() + "[" + getName() + "] produced: " + widget);
    return widget;
//    String widget = new String(random().toByteArray(), Charset.forName("UTF-8"));
////    String widget = random().toString(64);
//    System.out.println(this.getClass().getSimpleName() + "[" + getName() + "] produced: " + widget);
//    return widget;
  }

}

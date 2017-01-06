package com.company.warehouse;


public interface Warehouse {

  public <T> void addSupplier(Supplier<T> supplier);
  
  public <T> void addConsumer(Consumer<T> consumer);
  
  public <T> void store(T widget);

  public <T> T fetchNextWidget(Class<T> widgetClass);
  
  public String toString();
}


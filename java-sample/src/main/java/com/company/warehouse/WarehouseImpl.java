/**
 * 
 */
package com.company.warehouse;


/**
 * @author vadim.shteynberg
 *
 */
public class WarehouseImpl implements Warehouse {
  
  private GenericMapList consumerMap = new GenericMapList();
  private GenericMapList supplierMap = new GenericMapList();
  private GenericMapList widgetMap = new GenericMapList();


  /* (non-Javadoc)
   * @see com.company.warehouse.Warehouse#addSupplier(com.company.warehouse.Supplier)
   */
  public <T> void addSupplier(Supplier<T> supplier) {

    supplierMap.put((Class<Supplier<T>>)supplier.getClass(), supplier);
  }

  /* (non-Javadoc)
   * @see com.company.warehouse.Warehouse#addConsumer(com.company.warehouse.Consumer)
   */
  public <T> void addConsumer(Consumer<T> consumer) {

    consumerMap.put((Class<Consumer<T>>)consumer.getClass(), consumer);
  }

  /* (non-Javadoc)
   * @see com.company.warehouse.Warehouse#store(java.lang.Object)
   */
  public <T> void store(T widget) {

    widgetMap.put((Class<T>)widget.getClass(), widget);
  }

  /* (non-Javadoc)
   * @see com.company.warehouse.Warehouse#fetch(java.lang.Object)
   */
  public <T> T fetchNextWidget(Class<T> widgetClass) {

    return widgetMap.getRemoveFirst(widgetClass);
  }

  public String toString() {
    
    StringBuilder sb = new StringBuilder();
    sb.append("Suppliers: " + supplierMap.toString());
    sb.append("Consumers: " + consumerMap.toString());
    sb.append("Widgets: " + widgetMap.toString());
    return sb.toString();
  }
}

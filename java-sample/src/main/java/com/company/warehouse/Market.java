package com.company.warehouse;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Market {

  // private Warehouse warehouse = new WarehouseImpl();
  private static final int SUPPLIER_NUMBER = 3;
  private static final int CONSUMER_NUMBER = 3;
  private static final int STRING_SUPPLIER_COUNT = 2;
  private static final int INTEGER_SUPPLIER_COUNT = 2;
  private static final int STRING_CONSUMER_COUNT = 2;
  private static final int INTEGER_CONSUMER_COUNT = 2;
  private static final int SUPPLIER_FREQUENCY = 3000;
  private static final int CONSUMER_FREQUENCY = 2000;

  // public Market() {
  // for (int i=0; i<STRING_SUPPLIER_COUNT; i++) {
  // warehouse.addSupplier(new StringSupplier(String.valueOf(i)));
  // }
  // for (int i=0; i<INTEGER_SUPPLIER_COUNT; i++) {
  // warehouse.addSupplier(new IntegerSupplier(String.valueOf(i)));
  // }
  // for (int i=0; i<STRING_CONSUMER_COUNT; i++) {
  // warehouse.addConsumer(new StringConsumer(String.valueOf(i)));
  // }
  // for (int i=0; i<INTEGER_CONSUMER_COUNT; i++) {
  // warehouse.addConsumer(new IntegerConsumer(String.valueOf(i)));
  // }
  //
  // }

  public static void main(String[] args) {

    ScheduledExecutorService supplierExecutorService = new ScheduledThreadPoolExecutor(SUPPLIER_NUMBER);
    ScheduledExecutorService consumerExecutorService = new ScheduledThreadPoolExecutor(CONSUMER_NUMBER);
    final Warehouse warehouse = new WarehouseImpl();

    for (int i = 0; i < STRING_SUPPLIER_COUNT; i++) {
      final Supplier<String> supplier = new StringSupplier(String.valueOf(i));
      warehouse.addSupplier(supplier);

      Runnable task = new Runnable() {
        public void run() {
          String widget = supplier.produce();
          warehouse.store(widget);
        }
      };
      
      supplierExecutorService.scheduleAtFixedRate(task, 0, SUPPLIER_FREQUENCY, TimeUnit.MILLISECONDS);
    }

    for (int i = 0; i < INTEGER_SUPPLIER_COUNT; i++) {
      final Supplier<Integer> supplier = new IntegerSupplier(String.valueOf(i));
      warehouse.addSupplier(supplier);

      Runnable task = new Runnable() {
        public void run() {
          Integer widget = supplier.produce();
          warehouse.store(widget);
        }
      };
      
      supplierExecutorService.scheduleAtFixedRate(task, 0, SUPPLIER_FREQUENCY, TimeUnit.MILLISECONDS);
    }

   
    for (int i = 0; i < STRING_CONSUMER_COUNT; i++) {
      final Consumer<String> consumer = new StringConsumer(String.valueOf(i));
      warehouse.addConsumer(consumer);

      Runnable task = new Runnable() {
        public void run() {
          String widget = warehouse.fetchNextWidget(String.class);
          consumer.consume(widget);
        }
      };
      
      consumerExecutorService.scheduleAtFixedRate(task, 0, CONSUMER_FREQUENCY, TimeUnit.MILLISECONDS);
    }
    for (int i = 0; i < INTEGER_CONSUMER_COUNT; i++) {
      final Consumer<Integer> consumer = new IntegerConsumer(String.valueOf(i));
      warehouse.addConsumer(consumer);

      Runnable task = new Runnable() {
        public void run() {
          Integer widget = warehouse.fetchNextWidget(Integer.class);
          consumer.consume(widget);
        }
      };
      
      consumerExecutorService.scheduleAtFixedRate(task, 0, CONSUMER_FREQUENCY, TimeUnit.MILLISECONDS);
    }

    supplierExecutorService.scheduleAtFixedRate(new Runnable() {
      public void run() {
        System.out.println(warehouse);
      }
    }, 0, 10000, TimeUnit.MILLISECONDS);

  }

}

package com.company.semaphore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SemaphoreTest {
  
  private static final Logger logger = LoggerFactory.getLogger(SemaphoreTest.class);
  
  @Test
  public void testSemaphore() {
    
    Semaphore semaphore = new Semaphore();
    assertEquals("By default only 1 permit is available", semaphore.availablePermits(), 1);
    assertEquals("There are no pending threads", semaphore.getQueueLength(), 0);
    assertEquals("Size of pending thread list is 0", semaphore.getQueuedThreads().size(), 0);
    assertEquals("There are no acuired threads", semaphore.getAcquiredThreads(), 0);
  }

  @Test
  public void testSemaphoreInt() {

    Semaphore semaphore = new Semaphore(10);
    assertEquals("By default only 1 permit is available", semaphore.availablePermits(), 10);
    assertEquals("There are no pending threads", semaphore.getQueueLength(), 0);
    assertEquals("Size of pending thread list is 0", semaphore.getQueuedThreads().size(), 0);
    assertEquals("There are no acuired threads", semaphore.getAcquiredThreads(), 0);
  }

  @Test
  public void testAcquire() throws InterruptedException {

    Semaphore semaphore = new Semaphore(1);
    int availablePermits = semaphore.availablePermits();
    assertEquals("By default only 1 permit is available", availablePermits, 1);
    assertEquals("There are no pending threads", semaphore.getQueueLength(), 0);
    assertEquals("Size of pending thread list is 0", semaphore.getQueuedThreads().size(), 0);

//    // Acquire semaphore in the main thread
//    semaphore.acquire();
//    assertEquals("One less permit is available", semaphore.availablePermits(), availablePermits - 1);
//    assertEquals("There are no pending threads", semaphore.getQueueLength(), 0);
//    assertEquals("Size of pending thread list is 0", semaphore.getQueuedThreads().size(), 0);
//    assertEquals("There is 1 acuired threads", semaphore.getAcquiredThreads().size(), 1);
//    assertEquals("1 acuired thread is myself", semaphore.getAcquiredThreads().iterator().next(), Thread.currentThread().getName());
    
    System.out.println("Semaphore: " + semaphore.toString());

    // Acquire semaphore in a new thread
    ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
    executor.execute(new SemaphoreExecutor(semaphore));

    
    // Acquire semaphore in the second thread
    executor = new ScheduledThreadPoolExecutor(1);
    executor.execute(new SemaphoreExecutor(semaphore));

    // Acquire semaphore in the third thread
    executor = new ScheduledThreadPoolExecutor(1);
    executor.execute(new SemaphoreExecutor(semaphore));

    executor.awaitTermination(20, TimeUnit.SECONDS);
    
//    assertEquals("One less permit is available", semaphore.availablePermits(), availablePermits - 1);
//    assertEquals("There are no pending threads", semaphore.getQueueLength(), 0);
//    assertEquals("Size of pending thread list is 0", semaphore.getQueuedThreads().size(), 0);
//    assertEquals("There is 1 acuired threads", semaphore.getAcquiredThreads().size(), 1);
//    assertEquals("1 acuired thread is myself", semaphore.getAcquiredThreads().iterator().next(), Thread.currentThread().getName());
    
    System.out.println("Semaphore: " + semaphore.toString());
  }

  @Test
  public void testAcquireTwoPermits() throws InterruptedException {

    Semaphore semaphore = new Semaphore(2);
    int availablePermits = semaphore.availablePermits();
    assertEquals("2 permits are available", availablePermits, 2);
    assertEquals("There are no pending threads", semaphore.getQueueLength(), 0);
    assertEquals("Size of pending thread list is 0", semaphore.getQueuedThreads().size(), 0);

    System.out.println("Semaphore: " + semaphore.toString());

    // Acquire semaphore in a new thread
    ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
    executor.execute(new SemaphoreExecutor(semaphore));

    
    // Acquire semaphore in the second thread
    executor = new ScheduledThreadPoolExecutor(1);
    executor.execute(new SemaphoreExecutor(semaphore));

    // Acquire semaphore in the third thread
    executor = new ScheduledThreadPoolExecutor(1);
    executor.execute(new SemaphoreExecutor(semaphore));

    executor.awaitTermination(20, TimeUnit.SECONDS);
    
    assertEquals("2 permits are available", availablePermits, 2);
    assertEquals("There are no pending threads", semaphore.getQueueLength(), 0);
    assertEquals("Size of pending thread list is 0", semaphore.getQueuedThreads().size(), 0);
    System.out.println("Semaphore: " + semaphore.toString());
  }

  @Test
  public void testRelease() {

    fail("Not yet implemented");
  }

  @Test
  public void testAvailablePermits() {

    fail("Not yet implemented");
  }

  @Test
  public void testGetQueueLength() {

    fail("Not yet implemented");
  }

  @Test
  public void testGetQueuedThreads() {

    fail("Not yet implemented");
  }

  @Test
  public void testTryAcquire() {

    fail("Not yet implemented");
  }

  private class SemaphoreExecutor implements Runnable {
    
    private final Logger logger = LoggerFactory.getLogger(SemaphoreExecutor.class);
    private Semaphore semaphore;
    public SemaphoreExecutor(Semaphore semaphore) {
      this.semaphore = semaphore;
    }

    public void run() {

      logger.info("acquiring semaphore");
      try {
        semaphore.acquire();
        logger.info("doing work");
        assertTrue("This thread is on the list", semaphore.getAcquiredThreads().contains(Thread.currentThread().getName()));
        Thread.sleep(5000);
      }
      catch (InterruptedException e) {
        e.printStackTrace();
      }
      logger.info("releasing semaphore");
      semaphore.release();
      logger.info("Semaphore state: {}", semaphore.toString());
    }
  }
}

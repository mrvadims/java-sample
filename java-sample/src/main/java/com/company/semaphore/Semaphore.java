package com.company.semaphore;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Semaphore {

  private static final Logger logger = LoggerFactory.getLogger(Semaphore.class.getSimpleName());

  private LinkedHashSet<String> pendingThreadSet = new LinkedHashSet<String>();

  private LinkedList<String> permitThreadList = new LinkedList<String>();

  private int maxPermits = 0;

  private Integer permitCounter = 0;

  public Semaphore() {

    this.maxPermits = 1;
  }

  public Semaphore(int permits) {

    if (permits > 0) {
      this.maxPermits = permits;
    }
  }

  // if there are available permits
  // - increase the permit counter
  // - add the acquiring thread to permitThreadList
  // else
  // - add the acquiring thread to pendingThreadSet
  // - block the acquiring thread
  public synchronized void acquire() throws InterruptedException {

    String currentThreadName = new String(Thread.currentThread().getName());
    logger.info("Acquiring a permit: {}", toString());

    if (permitCounter >= maxPermits) {
      pendingThreadSet.add(currentThreadName);
      while (permitCounter >= maxPermits && getQueuedThreads().contains(currentThreadName)) {
        logger.info("Waiting for a permit: {}", toString());
        this.wait();
      }
      logger.info("Re-acquiring a permit: {}", toString());
    }

    permitThreadList.add(currentThreadName);
    permitCounter += 1;
    logger.info("Acquired a permit: {}", toString());
  }

  /**
   * decrement permit counter remove the releasing thread from the permitThreadList if there are threads on pendingThreadSet - notify the first blocking thread
   * and - remove it from the pendingThreadSet
   */
  public synchronized void release() {

    logger.info("Releasing a permit: {}", toString());
    permitCounter -= 1;
    String currentThreadName = new String(Thread.currentThread().getName());
    permitThreadList.remove(currentThreadName);

    if (pendingThreadSet.size() > 0) {
      Iterator<String> it = pendingThreadSet.iterator();
      String nextThreadName = it.next();
      it.remove();

      logger.info("Notifying thread: {}", nextThreadName);
      this.notifyAll();
    }
  }

  public int availablePermits() {

    return (maxPermits - permitCounter);
  }

  public int getQueueLength() {

    return pendingThreadSet.size();
  }

  public Collection<String> getQueuedThreads() {

    return pendingThreadSet;
  }

  public Collection<String> getAcquiredThreads() {

    return permitThreadList;
  }

  public boolean tryAcquire() {

    // TODO Auto-generated method stub
    return false;
  }

  public String toString() {

    return String.format("Permits: max=%s; available=%s; Queued threads=%s; Acquired threads=%s", maxPermits, availablePermits(), getQueuedThreads(),
        getAcquiredThreads());
  }
}

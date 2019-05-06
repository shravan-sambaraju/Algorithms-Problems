package tobeorganized.objectorienteddesign;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/** */
class DeferredCallBackExecutorDemonstration {
  public static void main(String args[]) throws InterruptedException {
    DeferredCallbackExecutor.runLateThenEarlyCallback();
  }
}

class DeferredCallbackExecutor {

  private static Random random = new Random(System.currentTimeMillis());

  PriorityQueue<CallBack> q =
      new PriorityQueue<CallBack>(
          new Comparator<CallBack>() {
            public int compare(CallBack o1, CallBack o2) {
              return (int) (o1.executeAt - o2.executeAt);
            }
          });
  ReentrantLock lock = new ReentrantLock();
  Condition newCallbackArrived = lock.newCondition();

  public static void runLateThenEarlyCallback() throws InterruptedException {
    final DeferredCallbackExecutor deferredCallbackExecutor = new DeferredCallbackExecutor();

    Thread service =
        new Thread(
            new Runnable() {
              public void run() {
                try {
                  deferredCallbackExecutor.start();
                } catch (InterruptedException ie) {
                }
              }
            });

    service.start();

    Thread lateThread =
        new Thread(
            new Runnable() {
              public void run() {
                CallBack cb = new CallBack(8, "Hello this is late thread");
                deferredCallbackExecutor.registerCallback(cb);
              }
            });
    lateThread.start();

    Thread.sleep(3000);

    Thread earlyThread =
        new Thread(
            new Runnable() {
              public void run() {
                CallBack cb = new CallBack(1, "Hello this is early thread");
                deferredCallbackExecutor.registerCallback(cb);
              }
            });
    earlyThread.start();

    lateThread.join();
    earlyThread.join();
  }

  public void start() throws InterruptedException {
    long sleepFor = 0;
    int lastSeenQSize = 0;

    while (true) {

      lock.lock();

      while (q.size() == 0) {
        newCallbackArrived.await();
      }

      if (lastSeenQSize == q.size()) {
        newCallbackArrived.await(sleepFor, TimeUnit.MILLISECONDS);
      }

      long currentTime = System.currentTimeMillis();
      while (q.size() != 0 && currentTime >= q.peek().executeAt) {
        CallBack cb = q.poll();
        System.out.println(
            "Executed at "
                + System.currentTimeMillis() / 1000
                + " required at "
                + cb.executeAt / 1000
                + ": message:"
                + cb.message);
      }
      sleepFor = q.size() == 0 ? 0 : q.peek().executeAt - currentTime;

      lastSeenQSize = q.size();
      lock.unlock();
    }
  }

  public void registerCallback(CallBack callBack) {
    lock.lock();
    q.add(callBack);
    newCallbackArrived.signal();
    lock.unlock();
  }

  static class CallBack {
    long executeAt;
    String message;

    public CallBack(long executeAfter, String message) {
      this.executeAt = System.currentTimeMillis() + executeAfter * 1000;
      this.message = message;
    }
  }
}

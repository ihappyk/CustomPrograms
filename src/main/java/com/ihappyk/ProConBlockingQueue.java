package com.ihappyk;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

class Produce extends Thread {
    private BlockingQueue queue = null;
    Produce(String name,BlockingQueue queue)
    {
        super(name);
        queue = this.queue;
    }

    /**
     * If this thread was constructed using a separate
     * <code>Runnable</code> run object, then that
     * <code>Runnable</code> object's <code>run</code> method is called;
     * otherwise, this method does nothing and returns.
     * <p>
     * Subclasses of <code>Thread</code> should override this method.
     *
     * @see #start()
     * @see #stop()
     * @see #Thread(ThreadGroup, Runnable, String)
     */
    @Override public void run ()
    {
       for(int i =0; i<50;i++) {
            try {
                queue.put(i);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
       }
    }
}


class Consume extends Thread {
    private BlockingQueue queue = null ;

    Consume(String name,BlockingQueue queue) {
        super(name);
        queue = this.queue;
    }

    /**
     * If this thread was constructed using a separate
     * <code>Runnable</code> run object, then that
     * <code>Runnable</code> object's <code>run</code> method is called;
     * otherwise, this method does nothing and returns.
     * <p>
     * Subclasses of <code>Thread</code> should override this method.
     *
     * @see #start()
     * @see #stop()
     * @see #Thread(ThreadGroup, Runnable, String)
     */
    @Override public void run ()
    {
        while(true) {
            try {
                System.out.println("Queue "+ queue.take());
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ProConBlockingQueue
{
    public static void main(String args[]) {
        BlockingQueue queue = new ArrayBlockingQueue(10);
        Produce produce = new Produce("Producer",queue);
        Consume consume = new Consume("Consumer",queue);
       new Thread().start();
       new Thread().start();
    }
}

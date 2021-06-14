package com.ihappyk.dp;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

class Consumer extends Thread {
    private Queue<Integer> buffer;
    private int MAX_SIZE = 0;

    /**
     * Allocates a new {@code Thread} object. This constructor has the same
     * effect as {@linkplain #Thread(ThreadGroup, Runnable, String) Thread}
     * {@code (null, null, name)}.
     *
     * @param name the name of the new thread
     */
    public Consumer (String name,int MAX_SIZE, Queue<Integer> buffer)
    {
        super(name);
        this.buffer = buffer;
        this.MAX_SIZE = MAX_SIZE;
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
    @Override
    public void run ()
    {
        while (true) {
            synchronized(buffer){
                while (buffer.isEmpty()) {
                    System.out.println("Queue is Empty");
                    try {
                        buffer.wait();
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int n = buffer.remove();
                System.out.println("Consumed Element:"+ n);
                buffer.notifyAll();
            }
        }
    }
}

class Producer extends Thread {
    private Queue<Integer> buffer;
    private int MAX_SIZE = 0;

    /**
     * Allocates a new {@code Thread} object. This constructor has the same
     * effect as {@linkplain #Thread(ThreadGroup, Runnable, String) Thread}
     * {@code (null, null, name)}.
     *
     * @param name the name of the new thread
     */
    public Producer (String name,int MAX_SIZE, Queue<Integer> buffer)
    {
        super(name);
        this.buffer = buffer;
        this.MAX_SIZE = MAX_SIZE;
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
    @Override
    public void run ()
    {
        while (true) {
            synchronized(buffer){
                while (buffer.size() == MAX_SIZE) {
                    System.out.println("Queue is Full");
                    try {
                        buffer.wait();
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int n = new Random().nextInt();
                System.out.println("Added Element:"+ n);
                buffer.add(n);

                buffer.notifyAll();
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class Practice1
{
    public static void main (String args[]) {
        Queue<Integer> buffer = new LinkedList<>();
        int maxSize = 10;

        Thread producer = new Producer("PRODUCER", 10, buffer);
        Thread consumer = new Consumer("CONSUMER", 10, buffer);
        producer.start();
        consumer.start();
    }
}

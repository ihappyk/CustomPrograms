package com.ihappyk.concepts;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

class Producer extends Thread {
    private Queue<Integer> queue;
    private int MAX_SIZE =0;

    Producer (Queue<Integer> integerQueue, int MAX_SIZE, String name)
    {
        super(name);
        this.MAX_SIZE = MAX_SIZE;
        this.queue = integerQueue;
    }
    @Override
    public void run()
    {
        while(true) {
            synchronized(queue) {
                while(queue.size() == MAX_SIZE) {
                    try{
                        System.out.println("Queue is Full");
                        queue.wait();
                    }
                    catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }

                Random random = new Random();
                int i  = random.nextInt();
                System.out.println("Producing value : " + i);
                queue.add(i);
                queue.notifyAll();
            }
        }
    }
}



class Consumer extends Thread {
    private Queue<Integer> queue;
    private int MAX_SIZE =0;

    Consumer (Queue<Integer> integerQueue, int MAX_SIZE, String name)
    {
        super(name);
        this.MAX_SIZE = MAX_SIZE;
        this.queue = integerQueue;
    }

    @Override
    public void run ()
    {
        while (true) {
            synchronized(queue) {
                while(queue.isEmpty()) {
                    try{
                        System.out.println("Queue is empty," +
                            "Consumer thread is waiting" +
                            " for producer thread to put something in queue");
                        queue.wait();
                    }
                    catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                System.out.println("Consumed:" + queue.remove());
                queue.notifyAll();
            }
        }
    }
}

public class ConProProblem
{
    public static void main(String args[]) {
        Queue<Integer> buffer = new LinkedList<>();
        int maxSize = 10;

        Thread producer = new Producer(buffer, maxSize, "PRODUCER");
        Thread consumer = new Consumer(buffer, maxSize, "CONSUMER");

        producer.start();
        consumer.start();
    }


}

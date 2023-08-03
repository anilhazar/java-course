package arrayblockingqueue;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProducerConsumer {

    Random random = new Random();

    BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

    public void produce() {

        while (true) {
            try {
                Thread.sleep(1000); // Bekleme sürelerini deðiþtirerek davranýþlarý kontrol edebilirsini.
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            try {
                Integer value = random.nextInt(100);

                queue.put(value);

                System.out.println("Producer producing : " + value);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        }

    }

    public void consume() {

        while (true) {
            try {
                Thread.sleep(3000); // Bekleme sürelerini deðiþtirerek davranýþlarý kontrol edebilirsin.
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            try {
                Integer value = queue.take();
                System.out.println("Consumer consuming : " + value);

                System.out.println("Queue Size: " + queue.size());

            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        }
    }

    public synchronized void printer() {
        while (true) {
            try {
                Thread.sleep(1000); // Bekleme sürelerini deðiþtirerek davranýþlarý kontrol edebilirsin.
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            try {
                Integer[] queueArray = queue.toArray(new Integer[0]);

                for (Integer element : queueArray) {
                    System.out.print(element + " ");
                }
                System.out.println("");
                

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }

    }

}

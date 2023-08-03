package arrayblockingqueue;


import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
    public static void main(String[] args) {
          ProducerConsumer pc = new ProducerConsumer();
    
    Thread producer = new Thread(new Runnable() {
        @Override
        public void run() {
            pc.produce();
        }
    });
    Thread consumer = new Thread(new Runnable() {
        @Override
        public void run() {
            pc.consume();
        }
    });
    
    Thread printer = new Thread(new Runnable() {
              @Override
              public void run() {
               pc.printer();
              }
    });

    producer.start();
    consumer.start();
    printer.start();
    
        try {
            producer.join();
            consumer.join();
            printer.join();
        } catch (InterruptedException ex) {
          ex.printStackTrace();
        }
    
    
    }
    
  
}

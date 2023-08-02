package threadingmethods;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Threads {
      private int count = 0;
    public synchronized void artir(){
        
        count++;
    }
    public void threadleriCalistir(){
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0 ;  i < 5000 ; i++) {
                    artir();
                    
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0 ;  i < 5000 ; i++) {
                    artir();
                }
            }
        });
        
        thread1.start();
          try {
              thread1.join();
          } catch (InterruptedException ex) {
              ex.printStackTrace();
          }
        thread2.start();
          try {
              thread2.join();
          } catch (InterruptedException ex) {
              ex.printStackTrace();
          }
        
        
      
        
        
        System.out.println("Count deðiþkenin deðeri : " + count);
        
    }    

    public static void main(String[] args) {
        
        Threads threads = new Threads();
        threads.threadleriCalistir();

        /* Extend printer1 = new Extend("Printer1");
    Extend printer2 = new Extend("Printer2"); 
        Thread printer1 = new Thread(new Implement("printer1"));
        Thread printer2 = new Thread(new Implement("printer2"));

        printer1.start();
        printer2.start();
   */

    }

}



package threadingmethods;

import java.util.logging.Level;
import java.util.logging.Logger;

class Extend extends Thread{
    
    private String name;
    
    public Extend(String name){
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " baslatiliyor.");
        for (int i = 0; i < 10; i++) {
            try {
                
                System.out.println( name + "'in thread i çalýþýyor Adim = "  + i);
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
   
    
}

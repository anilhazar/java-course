package reentrantlockawaitsignal;


import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;




public class ReentrantLockExample {
    
  
    private int say = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    
    public void artir(){
        for (int i = 0 ;  i < 10000 ; i++) {
            
            say++;
        }
        
        
    }
    public void thread1Fonksiyonu(){
        
        lock.lock();
        System.out.println("Thread 1 haz�r...");
        System.out.println("Thread 1 Sinyalin Ula�mas�n� Bekliyor....");
        
        try {
            condition.await();
        } catch (InterruptedException ex) {
            Logger.getLogger(ReentrantLock.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Thread 1 e sinyal ula�t� ve i�lemine devam ediyor....");
        artir();
       
        
        lock.unlock();
        
        
        
    }
    public void thread2Fonksiyonu(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ReentrantLock.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scanner scanner = new Scanner(System.in);
        
        
        lock.lock();
        System.out.println("Thread 2 haz�rlan�yor....");
        
        artir();
        System.out.println("Devam etmek i�in herhangi bir tu�a bas�n...");
        scanner.nextLine();
        condition.signal();
        System.out.println("Thread 1'e sinyal g�nderildi...");
       
        lock.unlock();
        
        
        
        
        
    }
    public void threadOver(){
        System.out.println("Say : " + say);
        
        
    }
}

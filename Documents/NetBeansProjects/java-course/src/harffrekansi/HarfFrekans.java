
package harffrekansi;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class HarfFrekans {

   
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    Map<Character,Integer> map = new TreeMap<>();
    
        System.out.println("Frekansini bulmak istediginiz cumleyi giriniz.");
    String cumle = scanner.nextLine();
    
    for(char c: cumle.toCharArray()){
        if(map.containsKey(c)) {
            map.replace(c,map.get(c)+1);
        }
        else
            map.put(c, 1);
        } 
    
    for(Map.Entry<Character,Integer> pair: map.entrySet()){
        System.out.println("Cumlede " + pair.getValue() + " tane " + pair.getKey() + " bulunuyor.");
        
    }
    
    
    }
    
}

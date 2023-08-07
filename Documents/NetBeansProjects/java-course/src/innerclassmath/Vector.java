package innerclassmath;

import java.util.Scanner;
public class Vector {
    private int i;
    private int j;
    private int k;
    private String name;

public Vector (String name){
    this.name=name;
    Scanner scanner = new Scanner(System.in);
    System.out.println("Please type the value of i dimennsion of the " + name);
    this.i=scanner.nextInt();
    scanner.nextLine();
    System.out.println("Please type the value of j dimennsion of the " + name);
    this.j=scanner.nextInt();
    scanner.nextLine();
    System.out.println("Please type the value of k dimennsion of the" + name);
    this.k=scanner.nextInt();
    scanner.nextLine();
    
    
}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }


}

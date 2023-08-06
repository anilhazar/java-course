
package companymanagementsystem;


public class Manager extends Employee{
    private int meeting_capacity;
    
    public Manager(String name, String surname, int id, int meeting_capacity){
        super(name, surname, id);
        this.meeting_capacity = meeting_capacity;
    }
    
    public void raiseDemand(int amount){
        System.out.println("Request for  " + amount + " amount of salary increase is rejected");
    }

    @Override
    public void infoShowcase() {
        super.infoShowcase(); 
        System.out.println("The Possible Meeting Number Per day is : " + meeting_capacity);
    }
    
}

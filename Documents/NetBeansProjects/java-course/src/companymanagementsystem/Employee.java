
package companymanagementsystem;

public class Employee {
    private String Name;
    private String Surname;
    private int id;

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String Surname) {
        this.Surname = Surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee(String Name, String Surname, int id) {
        this.Name = Name;
        this.Surname = Surname;
        this.id = id;
    }
    public void infoShowcase() {
        System.out.println("Employee Infos Displaying...");
        System.out.println("Name : " + Name);
        System.out.println("Surname : " + Surname);
        System.out.println("Id : " + id);
        
    }
    
}

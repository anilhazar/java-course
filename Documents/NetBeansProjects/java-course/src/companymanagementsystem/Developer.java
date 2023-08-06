
package companymanagementsystem;


public class Developer extends Employee{
    private int competence;
    
    public Developer(String name, String surname, int id, int competence){
        super(name,surname,id);
        this.competence = competence;
    }
    
    public void formatPC(){
        System.out.println("Format process done.");
    }
    
    public void complain(){
        System.out.println("Complaining about non-remote offers...");
        System.out.println("Taking too long...");
    }
    
    
    
    public void infoShowcase(){
        super.infoShowcase();
        System.out.println("Years of Competence : " + competence);
    }
}

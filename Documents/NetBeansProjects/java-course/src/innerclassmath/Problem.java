package innerclassmath;


public class Problem {
    public static class Matematik{
    
     public static void ucgenCevre(int kenar1, int kenar2, int kenar3){
         System.out.println("Perimeter of the Triangle : " + (kenar1 + kenar2 + kenar3));
     }
     
     public static void daireAlan (int yaricap){
         System.out.println("Area of the Circle : " + (yaricap * Math.PI * yaricap ));
     }
}
    
    public static class Fizik{
        public static void icCarpim(Vector vec1, Vector vec2){
         int carpim = vec1.getI()*vec2.getI() + vec1.getJ()*vec2.getJ() + vec1.getK()*vec2.getK();
            System.out.println(" Inner Product of " + vec1.getName() + " and " + vec2.getName() + " is : " + carpim);
        }
    }
}

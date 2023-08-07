package innerclassmath;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to the Math and Physics Problems Program");

        String operations = "Choose the Opearitons You Want to Access...\n"
                + "Click 1 to Calcule Circumference the circle\n"
                + "Click 2 to Calculate Perimeter of The Triangle\n"
                + "Click 3 to Calculate Inner Product of the Vector\n"
                + "Click q to quit the Program";

        while (true) {
            System.out.println(operations);
            String operation = scan.nextLine();
            if (operation.equals("q")) {
                System.out.println("Quitting the Program");
                break;

            } else if (operation.equals("1")) {
                System.out.print("Radius of the Circle : ");
                int radius = scan.nextInt();
                scan.nextLine();
                Problem.Matematik.daireAlan(radius);
            } else if (operation.equals("2")) {
                System.out.println("Enter Side Lengths of the Triangle");
                System.out.print("Length 1 : ");
                int length1 = scan.nextInt();
                System.out.print("Length 2 : ");
                int length2 = scan.nextInt();
                System.out.print("Length 3 : ");
                int length3 = scan.nextInt();
                scan.nextLine();

                Problem.Matematik.ucgenCevre(length1, length2, length3);

            } else if (operation.equals("3")) {
                Vector vector1 = new Vector("vector1");
                Vector vector2 = new Vector("vector2");

                Problem.Fizik.icCarpim(vector1, vector2);

            } else {
                System.out.println("Invalid Key");
            }

        }
    }

}

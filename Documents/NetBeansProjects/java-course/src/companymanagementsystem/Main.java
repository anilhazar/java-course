package companymanagementsystem;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to the Management System");
        System.out.println("<------------------------------->");

        String operations = "Process...\n"
                + "Click 1 to Access Developer Operations\n"
                + "Click 2 to Access Manager Operations\n"
                + "Click q to Quit The Program";

        System.out.println(operations);

        boolean keepRunningg = true;

        while (keepRunningg) {
            boolean keepRunning = true;
            System.out.println("Choose the Operation ");
            String operation = scan.nextLine();

            switch (operation) {
                case "1":
                    Developer dev = new Developer("Anil", "Hazar", 01, 4);
                    String dev_operations = "Developer Management Program is in Process...\n"
                            + "Click 1 to Format the PC\n"
                            + "Click 2 to Complain About Non-Remote\n"
                            + "Click 3 to Receive Developer Infos \n"
                            + "Click q to Quit The Program";
                    System.out.println(dev_operations);
                    while (keepRunning) {
                        System.out.println("Choose The Operations");
                        String dev_operation = scan.nextLine();
                        switch (dev_operation) {
                            case "1":
                                dev.formatPC();
                                break;
                            case "2":
                                dev.complain();
                                break;
                            case "3":
                                dev.infoShowcase();
                                break;
                            case "q":
                                System.out.println("Quitting Developer System");
                                keepRunning = false;
                                break;
                            default:
                                System.out.println("Invalid Key");
                        }
                        if (dev_operation.equals("q")) {
                            break;
                        } else {
                            continue;
                        }
                    }
                    break;

                case "2":
                    Manager manager = new Manager("Andrew", "Tate", 777, 1);
                    String manager_operations = "Manager Management System is on Process...\n"
                            + "Click 1 to Receive A Raise Demand \n"
                            + "Click 2 to Receive Manager Infos \n"
                            + "Click q to Quit the Management Program";
                    System.out.println(manager_operations);
                    while (keepRunning) {
                        String manager_operation = scan.nextLine();
                        switch (manager_operation) {
                            case "1":
                                manager.raiseDemand(1000);
                                break;
                            case "2":
                                manager.infoShowcase();
                                break;
                            case "q":
                                System.out.println("Quitting Manager System");
                                keepRunning = false;
                                break;
                            default:
                                System.out.println("Invalid Key");
                                break;
                        }
                        if (manager_operation.equals("q")) {
                            break;
                        }
                    }
                    break;

                case "q":
                    System.out.println("Quitting The Management System");
                    keepRunningg = false;
                    break;

                default:
                    System.out.println("Invalid Key");
            }
        }
    }
}

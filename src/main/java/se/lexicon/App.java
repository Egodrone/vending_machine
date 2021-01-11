package se.lexicon;



import se.lexicon.data.VendingMachine;
import se.lexicon.data.VendingMachineImpl;

import java.util.Scanner;
import java.lang.Math.*;



public class App {

    public static void main(String[] args) {
        System.out.println(" ##### Vending Machine ##### ");
        VendingMachine vm = new VendingMachineImpl();
        Scanner scanner = new Scanner(System.in);

        System.out.println(" Enter a valid operation: ");
        String operationType = "";

        while(true) {
            System.out.println(" Type e to exit ");
            operationType = scanner.nextLine();
            System.out.println(operationType);

            switch (operationType) {
                case "1":
                    // todo:
                    System.out.printf("a");
                    break;
                case "2":
                    // todo:
                    System.out.printf("b");
                    break;
                case "3":
                    // todo:
                    System.out.printf("c");
                    break;
                case "4":
                    // todo:
                    System.out.printf("d");
                    break;
                case "e":
                    // todo: call exist method or stop application
                    System.exit(0);
                    break;
                default:
                    System.out.println(" operation is not valid ");
            }
        }
    }


}

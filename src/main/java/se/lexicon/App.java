package se.lexicon;



import se.lexicon.data.VendingMachine;
import se.lexicon.data.VendingMachineImpl;

import java.util.Scanner;
import java.lang.Math.*;



public class App {

    public static void main(String[] args) {
        System.out.println("Vending Machine");
        VendingMachine vm = new VendingMachineImpl();
        Scanner scanner = new Scanner(System.in);
        int user = 0;
        int answer = 0;

        while(true) {
            System.out.println("Generate");

            user = scanner.nextInt();
            System.out.println(answer);
        }
    }


}

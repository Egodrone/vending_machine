package se.lexicon;



import se.lexicon.data.VendingMachine;
import se.lexicon.data.VendingMachineImpl;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math.*;



public class App {



    public static void main(String[] args) {
        System.out.println(" ##### Vending Machine ##### ");
        boolean checkBol = false;
        int moneyToAdd = 0;
        int changeBack = 0;
        String description = "";
        String operationType = "";
        VendingMachine vm = new VendingMachineImpl();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            vm.display_menu();
            operationType = scanner.nextLine();

            switch (operationType) {
                case "1":
                    // Add money
                    System.out.printf(" How much do you want to add: \n ");
                    operationType = scanner.nextLine();
                    try {
                        Integer.parseInt(operationType);
                        checkBol = true;
                    } catch(NumberFormatException e) {
                        System.out.println(" Not a valid number ");
                    } catch(NullPointerException e) {
                        System.out.println(" Please write a number ");
                    }
                    if (checkBol == true) {
                        moneyToAdd = Integer.parseInt(operationType);
                        System.out.println(" Adding " + moneyToAdd +
                                " to the Vending Machine ");
                        vm.addCurrency(moneyToAdd);
                        checkBol = false;
                    }
                    break;

                case "2":
                    // Display current balance
                    if (vm.getBalance() != 0) {
                        System.out.println(" Your balance: " + vm.getBalance());
                    } else {
                        System.out.println(" You don't have any money,\n " +
                                "Please add by typing in 1 and amount ");
                    }
                    break;

                case "3":
                    System.out.printf(" Please type in a number for the description \n ");
                    if (vm.getProducts().length > 0) {
                        System.out.println(" Available values are from : ");
                        System.out.print(" 0 to ");
                        System.out.print(vm.getProducts().length - 1 + " \n ");

                        operationType = scanner.nextLine();
                        description = vm.getDescription(Integer.parseInt(operationType));
                        System.out.println(description);
                    } else {
                        System.out.println(" There are no products left to display. ");
                    }
                    break;

                case "4":
                    System.out.printf(" Type in product number: \n ");
                    operationType = scanner.nextLine();
                    vm.request(Integer.parseInt(operationType));
                    break;

                case "5":
                    // todo: Use a product
                    System.out.printf(" Use a product: \n ");
                    break;

                case "6":
                    if (vm.getProducts().length > 0) {
                        String[] info = vm.getProducts();
                        //System.out.println(Arrays.toString(info));
                        for (String names : info) {
                            System.out.println(names);
                        }
                    } else {
                        System.out.println(" All products are sold out. ");
                    }
                    break;

                case "7":
                    changeBack = vm.endSession();
                    System.out.println(" Change back: " + changeBack);
                    break;

                case "e":
                    System.out.println(" Thanks for using this Vending Machine! \n");
                    System.exit(0);
                    break;

                default:
                    System.out.println(" \n Operation is not valid! \n ");
            }

        }

    }



}

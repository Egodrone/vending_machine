package se.lexicon;



import se.lexicon.data.VendingMachine;
import se.lexicon.data.VendingMachineImpl;
import se.lexicon.model.Product;
import java.util.Scanner;




public class App {



    public static void main(String[] args) {
        System.out.println(" ##### Vending Machine ##### ");
        boolean checkBol = false;
        int countProducts = 0;
        int moneyToAdd;
        int changeBack;
        String description;
        String operationType;

        VendingMachine vm = new VendingMachineImpl();
        Scanner scanner = new Scanner(System.in);
        Product[] boughtProducts = new Product[vm.getProducts().length];


        while(true) {
            vm.display_menu();
            operationType = scanner.nextLine();

            switch (operationType) {
                case "1":
                    System.out.println(" How much do you want to add: ");
                    operationType = scanner.nextLine();
                    try {
                        Integer.parseInt(operationType);
                        checkBol = true;
                    } catch(NumberFormatException e) {
                        System.out.println(" Not a valid number ");
                    } catch(NullPointerException e) {
                        System.out.println(" Please write a number ");
                    }
                    if (checkBol) {
                        moneyToAdd = Integer.parseInt(operationType);
                        System.out.println(" Adding " + moneyToAdd +
                                " to the Vending Machine ");
                        vm.addCurrency(moneyToAdd);
                        checkBol = false;
                    }
                    break;

                case "2":
                    if (vm.getBalance() != 0) {
                        System.out.println(" Your balance: " + vm.getBalance());
                    } else {
                        System.out.println(" You don't have any money,\n " +
                                "Please add by typing in 1 and amount ");
                    }
                    break;

                case "3":
                    System.out.println(" Please type in a number for the description \n ");
                    if (vm.getProducts().length > 0) {
                        vm.displayAvaliableId();
                        operationType = scanner.nextLine();
                        if (Integer.parseInt(operationType) <= vm.getProducts().length && Integer.parseInt(operationType) !=0) {
                            description = vm.getDescription(Integer.parseInt(operationType));
                            System.out.println(description);
                        } else {
                            System.out.println(" Please type in number in the given range ");
                        }
                    } else {
                        System.out.println(" There are no products left to display. ");
                    }
                    break;

                case "4":
                    if (vm.getProducts().length > 0) {
                        System.out.println(" You can choose from: ");
                        for (int i = 0; i < vm.getProducts().length; i++) {
                            System.out.print(vm.getProducts()[i] + " \n ");
                        }
                        System.out.println(" Type in product number: ");
                        operationType = scanner.nextLine();
                        boughtProducts[countProducts] = vm.request(Integer.parseInt(operationType));
                        if (boughtProducts[countProducts] != null) {
                            countProducts++;
                        }
                    } else {
                        System.out.println(" All products are sold out! ");
                    }
                    break;

                case "5":
                    if (boughtProducts.length > 0) {
                        System.out.println(" Products you bought: \n ");
                        for (int i = 0; i < boughtProducts.length; i++) {
                            if (boughtProducts[i] != null) {
                                checkBol = true;
                                System.out.println(boughtProducts[i].getName() +
                                        " number: " + boughtProducts[i].getProductNumber());
                            }
                        }
                        if (checkBol) {
                            System.out.println(" Type in a product number that you want to use: ");
                            operationType = scanner.nextLine();
                            for (int i = 0; i < boughtProducts.length; i++) {
                                if (boughtProducts[i] != null) {
                                    if (boughtProducts[i].getProductNumber() == Integer.parseInt(operationType)) {
                                        String usage = boughtProducts[i].use();
                                        System.out.println(usage);
                                        boughtProducts[i] = null;
                                    }
                                }
                            }
                            checkBol = false;
                        } else {
                            System.out.println(" You need to buy something before you can use it.");
                        }
                    } else {
                        System.out.println(" You need to buy something before you can use it. ");
                    }
                    break;

                case "6":
                    if (vm.getProducts().length > 0) {
                        String[] info = vm.getProducts();
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

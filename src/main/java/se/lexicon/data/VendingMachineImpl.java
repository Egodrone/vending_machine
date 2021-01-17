package se.lexicon.data;



import se.lexicon.model.Drink;
import se.lexicon.model.Food;
import se.lexicon.model.Product;
import se.lexicon.model.Snack;



public class VendingMachineImpl implements VendingMachine {

    private final int[] denominations = new int[]{1, 2, 5, 10, 20, 50, 100, 200, 500, 1000};
    private Product[] products;
    int moneyPool;



    public VendingMachineImpl(Product[] products) {
        this.products = products;
    }



    public VendingMachineImpl() {
        products = new Product[3];
        products[0] = new Drink("Coke", 50, "50cl");
        products[1] = new Food("Pepperoni Pizza", 20, 250);
        products[2] = new Snack("Cookie", 20, 90);
    }



    @Override
    public void display_menu() {
        String menu = " 1) Add money to the Vending Machine \n" +
                " 2) Show current balance \n" +
                " 3) Display description of the products \n" +
                " 4) Purchase a product \n" +
                " 5) Use the product \n" +
                " 6) Show products name and number \n" +
                " 7) End session \n" +
                " e) Exit the program \n";
        System.out.println(menu);
    }



    @Override
    public int getBalance() {
        return moneyPool;
    }



    @Override
    public void addCurrency(int amount) {
        boolean evaluate = false;

        for (int num : denominations) {
            if (amount == num) {
                evaluate = true;
                if (moneyPool == 0) {
                    moneyPool = amount;
                } else {
                    moneyPool = moneyPool + amount;
                }
            }
        }

        if (!evaluate) {
            System.out.println(" Vending Machine can only accept: ");
            for (int num : denominations) {
                System.out.print(num + " ");
            }
            System.out.println("  ");
        }

    }



    public String use_product(int productNumber) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductNumber() == productNumber) {
                return products[i].use();
            }
        }
        return "Invalid product number";
    }



    @Override
    public Product request(int productNumber) {
        int tmp = 0;
        boolean check = false;
        Product[] tmpProduct = new Product[1];

        for (Product pd : products) {
            if (pd.getProductNumber() == productNumber) {
                if (pd.getPrice() <= moneyPool) {
                    tmp = productNumber;
                    check = true;
                    moneyPool = moneyPool - pd.getPrice();
                } else {
                    System.out.println(" You don't have enough money to purchase the product ");
                }
                break;
            }
        }

        if (check) {
            Product[] tmpArr = new Product[products.length - 1];
            for (int i = 0, j = 0; i < products.length; i++) {
                if (products[i].getProductNumber() == tmp) {
                    System.out.println(" You just bought a " + products[i].getName());
                    tmpProduct[0] = products[i];
                    continue;
                }
                System.out.println(i);
                tmpArr[j++] = products[i];
            }

            products = tmpArr;
            return tmpProduct[0];
        }

        return null;
    }



    @Override
    public int endSession() {
        int change = 0;

        if (getBalance() > 0) {
            change = getBalance();
        }

        moneyPool = 0;
        return change;
    }



    @Override
    public String getDescription(int productNumber) {
        return products[productNumber - 1].examine();
    }



    @Override
    public String[] getProducts() {
        String[] productNamesNumber = new String[products.length];

        for (int i = 0; i < products.length; i++) {
            productNamesNumber[i] = " Name: " + products[i].getName() + ", Number: " + products[i].getProductNumber();
        }

        return productNamesNumber;
    }



    @Override
    public void displayAvaliableId() {
        System.out.println(" Available values are from: ");

        for (Product pd : products) {
            System.out.print(pd.getProductNumber() + " ");
        }
    }



}

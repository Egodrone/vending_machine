package se.lexicon.data;


import se.lexicon.model.Product;

public interface VendingMachine {

    boolean addMoney(int money);

    Product buy(int money, int prodNum);

    int returnChange();

    void presentProducts();

    int getBalance();



    /*
    default void addCurrency(int amount){

    }*/
}

package se.lexicon.data;



import se.lexicon.model.Product;



public interface VendingMachine {

    int getBalance();



    void addCurrency(int amount);



    Product request(int productNumber);



    int endSession();



    String getDescription(int productNumber);



    String[] getProducts();


    void displayAvaliableId();



    void display_menu();



    String use_product(int productNumber);



}

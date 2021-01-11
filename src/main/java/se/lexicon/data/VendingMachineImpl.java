package se.lexicon.data;



import se.lexicon.model.Product;



public class VendingMachineImpl implements VendingMachine {


    @Override
    public boolean addMoney(int money) {
        return false;
    }

    @Override
    public Product buy(int money, int prodNum) {
        return null;
    }

    @Override
    public int returnChange() {
        return 0;
    }

    @Override
    public void presentProducts() {

    }

    @Override
    public int getBalance() {
        return 0;
    }
}

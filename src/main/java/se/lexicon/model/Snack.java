package se.lexicon.model;



public class Snack extends Product {

    private int sugarPercent;



    public Snack(int sugarPercent) {
        this.sugarPercent = sugarPercent;
    }



    public Snack(String name, int price, int sugarPercent) {
        super(name, price);
        this.sugarPercent = sugarPercent;
    }



    public int getSugarPercent() {
        return sugarPercent;
    }



    public void setSugarPercent(int sugarPercent) {
        this.sugarPercent = sugarPercent;
    }



    public String examine() {
        return getName() + " " + getPrice() + " " + getSugarPercent();
    }



    @Override
    public String use() {
        return " You just ate a snack: " + getName();
    }



}

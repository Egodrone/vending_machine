package se.lexicon.model;



public class Food extends Product {

    private int calories;



    public Food(int calories) {
        this.calories = calories;
    }



    public Food(String name, int price, int calories) {
        super(name, price);
        this.calories = calories;
    }



    public int getCalories() {
        return calories;
    }



    public void setCalories(int calories) {
        this.calories = calories;
    }



    public String examine() {
        return getName() + " " + getPrice();
    }



    @Override
    public void use() {
        System.out.println(" Have a nice meal eating " + getName());
    }



}

package se.lexicon.model;



public class Drink extends Product {

    private String volume;



    public Drink(String name, int price, String volume) {
        super(name, price);
        this.volume = volume;
    }



    public String getVolume() {
        return volume;
    }



    public void setVolume(String volume) {
        this.volume = volume;
    }



    public String examine() {
        return getName() + " " + getPrice() + " " + getVolume();
    }



    @Override
    public void use() {
        System.out.println(" You decided to drink: " + getName() + ". Enjoy! ");
    }



}

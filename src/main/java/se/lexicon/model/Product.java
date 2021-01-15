package se.lexicon.model;



import java.util.Objects;
import se.lexicon.model.Sequencer;


public abstract class Product {

    private int productNumber;
    private String name;
    private int price;



    public Product() {
        productNumber = Sequencer.nextProductId();
    }



    public Product(String name, int price) {
        this.productNumber = Sequencer.nextProductId();
        this.name = name;
        this.price = price;
    }



    public String examine() {
        return "Product information: ";
    }


    public abstract String use();



    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }



    public int getPrice() {
        return price;
    }



    public void setPrice(int price) {
        this.price = price;
    }



    public int getProductNumber() {
        return productNumber;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price && Objects.equals(name, product.name);
    }



    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }



    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }



}

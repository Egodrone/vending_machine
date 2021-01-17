package se.lexicon.model;



public class Sequencer {

    private static int productId = 0;



    public static int nextProductId() {
        return ++productId;
    }



    public static int resetId(){
        productId = 0;
        return productId;
    }



}

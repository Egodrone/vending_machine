package se.lexicon.model;



import org.junit.Test;
import static org.junit.Assert.*;



public class DrinkTest {

    @Test
    public void test_volume() {
        Drink drink = new Drink("Milk", 29, "200 cl");
        String expected = "200 cl";
        assertEquals(expected, drink.getVolume());
    }



    @Test
    public void test_price() {
        Drink drink2 = new Drink("Coca Cola", 30, "100 cl");
        assertEquals(30, drink2.getPrice());
    }



    @Test
    public void test_name() {
        Drink drink3 = new Drink("Coca Cola", 30, "100 cl");
        assertEquals("Coca Cola", drink3.getName());
    }



    @Test
    public void test_use() {
        Drink drink4 = new Drink("Fanta", 30, "100 cl");
        String expected = " You decided to drink: " + "Fanta" + ". Enjoy! ";
        assertEquals(expected, drink4.use());
    }



    @Test
    public void test_examine() {
        Drink drink5 = new Drink("Water", 30, "100 cl");
        String expected = "Water" + " " + 30 + " " + "100 cl";
        assertEquals(expected, drink5.examine());
    }



}

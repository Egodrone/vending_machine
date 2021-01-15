package se.lexicon.model;



import org.junit.Test;
import static org.junit.Assert.*;



public class SnackTest {



    @Test
    public void test_name() {
        Snack snack = new Snack("Cookie", 90, 60);
        String expected = "Cookie";
        assertEquals(expected, snack.getName());
    }



    @Test
    public void test_price() {
        Snack snack2 = new Snack("Chocolate", 40, 60);
        int expected = 40;
        assertEquals(expected, snack2.getPrice());
    }



    @Test
    public void test_sugarPercent() {
        Snack snack3 = new Snack("Chocolate Zero", 40, 80);
        int expected = 80;
        assertEquals(expected, snack3.getSugarPercent());
    }



    @Test
    public void test_use() {
        Snack snack4 = new Snack("Light Chocolate", 50, 80);
        String expected = " You just ate a snack: " + "Light Chocolate";
        assertEquals(expected, snack4.use());
    }



    @Test
    public void test_examine() {
        Snack snack5 = new Snack("Dark Chocolate", 60, 30);
        String expected = "Dark Chocolate" + " " + 60 + " " + 30;
        assertEquals(expected, snack5.examine());
    }



}

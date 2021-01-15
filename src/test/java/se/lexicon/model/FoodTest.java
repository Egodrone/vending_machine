package se.lexicon.model;



import org.junit.Test;
import static org.junit.Assert.*;



public class FoodTest {

    @Test
    public void test_name() {
        Food food = new Food("Chicken", 50, 400);
        String expected = "Chicken";
        assertEquals(expected, food.getName());
    }



    @Test
    public void test_price() {
        Food food2 = new Food("Chicken", 50, 400);
        int expected = 50;
        assertEquals(expected, food2.getPrice());
    }


    @Test
    public void test_calories() {
        Food food3 = new Food("Chicken", 50, 400);
        int expected = 50;
        assertEquals(expected, food3.getPrice());
    }



    @Test
    public void test_use() {
        Food food4 = new Food("Chicken", 50, 400);
        String expected = " Have a nice meal eating " + "Chicken";
        assertEquals(expected, food4.use());
    }



    @Test
    public void test_examine() {
        Food food5 = new Food("Chicken", 50, 400);
        String expected = "Chicken" + " " + 50;
        assertEquals(expected, food5.examine());
    }



}

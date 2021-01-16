package se.lexicon.data;



import org.junit.Before;
import org.junit.Test;
import se.lexicon.model.Drink;
import se.lexicon.model.Food;
import se.lexicon.model.Product;

import static org.junit.Assert.*;



public class VendingMachineImplTest {



    @Before
    public void setup() {
    }



    @Test
    public void test_moneyPool_before_adding_currency() {
        VendingMachineImpl vm = new VendingMachineImpl();
        int expected = 0;
        assertEquals(expected, vm.moneyPool);
    }



    @Test
    public void test_moneyPool_after_adding_currency() {
        VendingMachineImpl vm = new VendingMachineImpl();
        int expected = 100;
        vm.addCurrency(100);
        assertEquals(expected, vm.getBalance());
    }



    @Test
    public void test_moneyPool_adding_restriction() {
        System.out.println(" Adding currency restriction test: ");
        VendingMachineImpl vm = new VendingMachineImpl();
        int expected = 0;
        vm.addCurrency(110);
        assertEquals(expected, vm.getBalance());
    }



    @Test
    public void test_description() {
        VendingMachineImpl vm = new VendingMachineImpl();
        String expected = "Coke 50 50cl";
        String actual = vm.getDescription(1);
        assertEquals(expected, actual);
    }



    @Test
    public void test_getProducts() {
        VendingMachineImpl vm = new VendingMachineImpl();
        int expected = 3;
        assertEquals(expected, vm.getProducts().length);
    }



    @Test
    public void test_name_number() {
        Product[] productTest = new Product[2];
        productTest[0] = new Drink("Coke", 50, "50cl");
        productTest[1] = new Drink("Energy Drink", 50, "50cl");
        VendingMachineImpl vz = new VendingMachineImpl(productTest);
        String expected = " Name: Energy Drink, Number: 11";
        assertEquals(expected, vz.getProducts()[1]);
    }



    @Test
    public void test_use_product2() {
        Product[] productTest2 = new Product[2];
        productTest2[0] = new Drink("Coke", 50, "50cl");
        productTest2[1] = new Food("Pepperoni Pizza", 20, 250);
        VendingMachineImpl vy = new VendingMachineImpl(productTest2);
        String expected = " Name: Pepperoni Pizza, Number: 21";
        assertEquals(expected, vy.getProducts()[1]);
    }



    @Test
    public void test_endSession() {
        Product[] productTest2 = new Product[2];
        productTest2[0] = new Drink("Coke", 50, "50cl");
        productTest2[1] = new Food("Pepperoni Pizza", 20, 250);
        VendingMachineImpl vm = new VendingMachineImpl(productTest2);
        Product[] boughtProducts = new Product[3];
        int expectedChange = 985;
        vm.addCurrency(1000);
        vm.addCurrency(5);
        for (int i =0; i < vm.getProducts().length; i++) {
            System.out.println(vm.getProducts()[i]);
        }
        boughtProducts[0] = vm.request(16);
        int actualChange = vm.endSession();
        assertEquals(expectedChange, actualChange);
    }



}

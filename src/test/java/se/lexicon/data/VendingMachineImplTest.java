package se.lexicon.data;


import org.junit.Before;
import org.junit.Test;
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
    public void test_use_product() {
        VendingMachineImpl vm = new VendingMachineImpl();
        String expected = " Have a nice meal eating " + "Pepperoni Pizza";
        assertEquals(expected, vm.use_product(1));
    }



}

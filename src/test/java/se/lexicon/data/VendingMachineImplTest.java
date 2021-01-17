package se.lexicon.data;



import org.junit.Before;
import org.junit.Test;
import se.lexicon.model.*;
import static org.junit.Assert.*;



public class VendingMachineImplTest {
    private final Sequencer sq = new Sequencer();


    @Before
    public void setup() {
        sq.resetId();
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
        String expected = " Name: Energy Drink, Number: 2";
        assertEquals(expected, vz.getProducts()[1]);
    }



    @Test
    public void test_use_product2() {
        Product[] productTest2 = new Product[2];
        productTest2[0] = new Drink("Coke", 50, "50cl");
        productTest2[1] = new Food("Pepperoni Pizza", 20, 250);
        VendingMachineImpl vy = new VendingMachineImpl(productTest2);
        String expected = " Name: Pepperoni Pizza, Number: 2";
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
        boughtProducts[0] = vm.request(2);
        int actualChange = vm.endSession();
        assertEquals(expectedChange, actualChange);
    }



    @Test
    public void test_request_multiple_products_and_get_change() {
        Product[] productTestMultiple = new Product[5];
        productTestMultiple[0] = new Drink("Product 1", 50, "50cl");
        productTestMultiple[1] = new Food("Product 2", 25, 250);
        productTestMultiple[2] = new Food("Product 3", 30, 250);
        productTestMultiple[3] = new Food("Product 4", 40, 250);
        productTestMultiple[4] = new Snack("Product 5", 20, 90);
        VendingMachineImpl vg = new VendingMachineImpl(productTestMultiple);
        Product[] boughtProducts = new Product[5];
        vg.addCurrency(1000);
        vg.addCurrency(500);

        int count = 0;
        for (int i = 5; i > 0; i--) {
            boughtProducts[count] = vg.request(i);
            count++;
        }

        int expectedChange = 1335;
        int actualChange = vg.endSession();
        assertEquals(expectedChange, actualChange);
    }



}

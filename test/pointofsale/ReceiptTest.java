/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale;

import model.Receipt;
import model.Product;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PMazur
 */
public class ReceiptTest {
    
    private Receipt instance = null;
    
    public ReceiptTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new Receipt();
        instance.addProduct(new Product("Pawelek", "8934832", 3.67));
        instance.addProduct(new Product("Mars", "7643532", 6.74));
        instance.addProduct(new Product("Mars", "7643532", 6.74));
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addProduct method, of class Receipt.
     */
    @Test
    public void testAddProduct() {
        System.out.println("addProduct");
        Product product = new Product("Milky Way", "6762342", 1.54);
        Product expResult = new Product("Milky Way", "6762342", 1.54);
        Product result = instance.addProduct(product);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Receipt.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Product name: Pawelek   Price: 3,67\n"
                         + "Product name: Mars   Price: 6,74\n"
                         + "Product name: Mars   Price: 6,74\n"
                         + "\n"
                         + "-----------------------------\n" 
                         + "Full price: 17,15";
        String result = instance.toString();
        assertEquals(expResult, result);
        
        instance.setLongReceipt(false);
        expResult = "Product name: Pawelek   Price: 3,67\n"
                  + "Product name: Mars   Price: 6,74 x2\n"
                  + "\n"
                  + "-----------------------------\n" 
                  + "Full price: 17,15";
        result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSummary method, of class Receipt.
     */
    @Test
    public void testGetSummary() {
        System.out.println("getSummary");
        String expResult = "Full price: 17,15";
        String result = instance.getSummary();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLongReceipt method, of class Receipt.
     */
    @Test
    public void testSetLongReceipt() {
        System.out.println("setLongReceipt");
        boolean longReceipt = false;
        instance.setLongReceipt(longReceipt);
    }
    
}

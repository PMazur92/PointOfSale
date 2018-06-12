/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale;

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
public class ProductTest {
    
    private Product instance = null;
    
    public ProductTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new Product("Pawelek", "8934832", 3.6749);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getProductName method, of class Product.
     */
    @Test
    public void testGetProductName() {
        System.out.println("getProductName");
        String expResult = "Pawelek";
        String result = instance.getProductName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPrice method, of class Product.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        double expResult = 3.67;
        double result = instance.getPrice();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getBarcode method, of class Product.
     */
    @Test
    public void testGetBarcode() {
        System.out.println("getBarcode");
        String expResult = "8934832";
        String result = instance.getBarcode();
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class Product.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        int expResult = "8934832".hashCode();
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Product.
     * #1 Test where objects are equals
     * #2 Test where objects are different
     * #3 Test where one object is null
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Product objTest1 = new Product("Pawelek", "8934832", 3.67);
        Product objTest2 = new Product("3bit", "12343676", 2.7598);
        
        //1
        boolean expResult = true;
        boolean result = instance.equals(objTest1);
        assertEquals(expResult, result);
        
        //2
        expResult = false;
        result = instance.equals(objTest2);
        assertEquals(expResult, result);
        
        //3
        expResult = false;
        result = instance.equals(null);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Product.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Product name: Pawelek   Price: 3,67";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}

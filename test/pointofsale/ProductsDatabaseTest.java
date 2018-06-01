/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale;

import java.util.Arrays;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
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
public class ProductsDatabaseTest {
    
    private ProductsDatabase instance = null;
    
    public ProductsDatabaseTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
                
        instance = new ProductsDatabase();
        
        instance.addProduct(new Product("3bit", "12343676", 2.7598))
                .addProduct(new Product("Mars", "7643532", 6.78))
                .addProduct(new Product("Snickers", "89234325", 2.78))
                .addProduct(new Product("Milky Way", "6762342", 1.54));
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getProductsByName method, of class ProductsDatabase.
     */
    @Test(expected = UnsupportedOperationException.class)
    public void testGetProductsByName() {
        System.out.println("getProductsByName");
        String name = "";
        Product expResult = null;
        Product result = instance.getProductsByName(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of getProductByBarcode method, of class ProductsDatabase.
     * #1 barcode exist in db
     * #2 barcode doesnt exist in db
     */
    @Test()
    public void testGetProductByBarcode() {
        System.out.println("getProductByBarcode");
        
        //#1
        String barcode = "12343676";
        Product expResult = new Product("3bit", "12343676", 2.7598);
        Product result = instance.getProductByBarcode(barcode);
        assertEquals(expResult, result);
        
        //#2
        try {
            barcode = "9838493";
            instance.getProductByBarcode(barcode);
        }catch(NoSuchElementException exc) {
            assertEquals("No value present", exc.getMessage());
        }
    }

    /**
     * Test of getProductsByPrice method, of class ProductsDatabase.
     */
    @Test(expected = UnsupportedOperationException.class)
    public void testGetProductsByPrice() {
        System.out.println("getProductsByPrice");
        float price = 0.0F;
        Product expResult = null;
        Product result = instance.getProductsByPrice(price);
        assertEquals(expResult, result);
    }

    /**
     * Test of addProduct method, of class ProductsDatabase.
     * 4 products always in db plus 1 added
     */
    @Test
    public void testAddProduct() {
        System.out.println("addProduct");
        Product product = new Product("Twix", "9987875", 2.30);
        int expResult = 5;
        int result = instance.addProduct(product).getDatabaseSize();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of addProducts method, of class ProductsDatabase.
     * 4 products always in db plus 3 added
     */
    @Test
    public void testAddProducts() {
        System.out.println("addProducts");
        Set<Product> products = new HashSet<>(Arrays.asList(
                new Product("Pawelek", "8934832", 3.67), 
                new Product("Princessa", "9831233", 1.20),
                new Product("Prince Polo", "8938912", 1.32)));
        int expResult = 7; //4 always in db + 3 added
        int result = instance.addProducts(products).getDatabaseSize();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getDatabaseSize method, of class ProductsDatabase.
     */
    @Test
    public void testGetDatabaseSize() {
        System.out.println("getDatabaseSize");
        int expResult = 4;
        int result = instance.getDatabaseSize();
        assertEquals(expResult, result);
    }
   
}

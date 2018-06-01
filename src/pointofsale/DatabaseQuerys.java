package pointofsale;

import java.util.NoSuchElementException;
import java.util.Set;

/**
 *
 * @author PMazur
 */
public interface DatabaseQuerys {
    Product getProductsByName(String name) throws NoSuchElementException;
    Product getProductByBarcode(String Barcode) throws NoSuchElementException;
    Product getProductsByPrice(float price) throws NoSuchElementException;
    ProductsDatabase addProduct(Product product);
    ProductsDatabase addProducts(Set<Product> products);
    int getDatabaseSize();
}

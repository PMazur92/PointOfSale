package pointofsale;
        
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 *
 * @author PMazur
 */
public class ProductsDatabase implements DatabaseQuerys{
    private Set<Product> database;

    public ProductsDatabase() {
        database = new HashSet<>();
    }
    
    public int getDatabaseSize() {
        return database.size();
    }
    /*
    * Function for near future, actually it isnt necessary
    */
    @Override
    public Product getProductsByName(String name) throws NoSuchElementException{
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Product getProductByBarcode(String barcode) throws NoSuchElementException{
        return database.stream()
                       .filter(p -> p.getBarcode().equals(barcode))
                       .findAny()
                       .get();
    }
    
    /*
    * Function for near future, actually it isnt necessary
    */
    @Override
    public Product getProductsByPrice(float price) throws NoSuchElementException{
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ProductsDatabase addProduct(Product product) {
        database.add(product);
        return this;
    }

    @Override
    public ProductsDatabase addProducts(Set<Product> products) {
        database.addAll(products);
        return this;
    }
        
}

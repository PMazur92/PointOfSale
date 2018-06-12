package database;

import model.Product;

/**
 *
 * @author PMazur
 */
public class DatabaseConnection {
    private static DatabaseConnection instance;
    private final ProductsDatabase database;

    private DatabaseConnection() {
        database = new ProductsDatabase();
        
        // Fill database with few Products
        
        database.addProduct(new Product("3bit", "12343676", 2.7598))
                .addProduct(new Product("Mars", "7643532", 6.74))
                .addProduct(new Product("Snickers", "89234325", 2.70))
                .addProduct(new Product("Milky Way", "6762342", 1.54));
        
    }

    public ProductsDatabase getDatabase() {
        return database;
    }

    public static DatabaseConnection getInstance() {
        if(instance == null) {
            instance = new DatabaseConnection();
        }
        
        return instance;
    }
    
    
    
    
}

package pointofsale;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author PMazur
 */
public class MainApplication {
    
    private final DatabaseConnection dbconn;
    private ProductsDatabase productDB;
    private final LCDDisplay lcd;
    private final Printer printer;
    private Receipt receipt;
    
    public MainApplication() {
        dbconn = DatabaseConnection.getInstance();
        productDB = dbconn.getDatabase();
        lcd = new LCDDisplay();
        printer = new Printer();
        receipt = new Receipt();
        
    }
    
    void run(){
        Scanner scan = new Scanner(System.in); //Java Util Class Scanner used for simulating barcode scanner
        String barcode;
        while(!(barcode = scan.nextLine().trim()).equals("exit")) {
            if(barcode.isEmpty()) {
                lcd.print("Invalide bar-code!");
            } else {
                try {
                    lcd.print(receipt.addProduct(productDB.getProductByBarcode(barcode)));
                } catch (NoSuchElementException exc) {
                    lcd.print("Product not found");
                }
            }
        }
        printer.print(receipt);
        lcd.print(receipt.getSummary());
    }
}

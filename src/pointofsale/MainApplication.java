package pointofsale;

import iodevices.Printer;
import iodevices.LCDDisplay;
import database.ProductsDatabase;
import database.DatabaseConnection;
import iodevices.BarcodeScanner;
import model.Receipt;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author PMazur
 */
public class MainApplication implements BarcodeListener{
    
    private static final String EXIT = "exit";
    private static final String INVALID = "Invalid bar-code!";
    private static final String NOT_FOUND = "Product not found";
    
    private final DatabaseConnection dbconn;
    private ProductsDatabase productDB;
    private final LCDDisplay lcd;
    private final Printer printer;
    private Receipt receipt;
    private BarcodeScanner scanner;
    
    public MainApplication() {
        dbconn = DatabaseConnection.getInstance();
        productDB = dbconn.getDatabase();
        lcd = new LCDDisplay();
        printer = new Printer();
        receipt = new Receipt();
        scanner = new BarcodeScanner(this);
    }
    
    void run(){
        while (true) {
            Scanner keyboard = new Scanner(System.in);
            do {
                //example barcodes
                scanner.readBarcode("12343676"); //in database
                scanner.readBarcode(""); // empty
                scanner.readBarcode("243324234"); //not in database
                scanner.readBarcode("89234325"); //in database
                scanner.readBarcode("6762342"); //in database
                scanner.readBarcode("98493230"); //not in database
                scanner.readBarcode("12343676"); //in database same as 1st
            } while (!keyboard.nextLine().trim().equals(EXIT));
            printer.print(receipt.toString());
            lcd.print(receipt.getSummary());
            receipt = new Receipt();
        }
    }

    @Override
    public void onBarcodeScan(String barcode) {
        if (isValid(barcode)) {
            try {
                lcd.print(receipt.addProduct(productDB.getProductByBarcode(barcode)).toString());
            } catch (NoSuchElementException exc) {
                lcd.print(NOT_FOUND);
            }
        } else {
            lcd.print(INVALID);
        }
    }
    
    private boolean isValid(String barcode) {
        return !barcode.isEmpty();
    }
}

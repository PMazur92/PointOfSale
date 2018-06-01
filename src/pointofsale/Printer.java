package pointofsale;

import java.io.PrintStream;

/**
 *
 * @author PMazur
 */
public class Printer implements OutputDevice{

    private final PrintStream printerStream;

    public Printer() {
        printerStream = new PrintStream(System.out); //for simplify I used System.out
    }

    @Override
    public void print(Product product) {
        printerStream.println(product);
    }

    @Override
    public void print(Receipt receipt) {
        printerStream.println(receipt);
    }

    @Override
    public void print(String text) {
        printerStream.println(text);
    }
    
}

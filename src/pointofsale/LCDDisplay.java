package pointofsale;

import java.io.PrintStream;

/**
 *
 * @author PMazur
 */
public class LCDDisplay implements OutputDevice{
    
    private final PrintStream lcdStream;

    public LCDDisplay() {
        lcdStream = new PrintStream(System.out);
    }
    
    @Override
    public void print(Product product) {
        lcdStream.println(product.toString());
    }

    @Override
    public void print(Receipt receipt) {
        lcdStream.println(receipt.toString());
    }

    @Override
    public void print(String text) {
        lcdStream.println(text);
    }

}

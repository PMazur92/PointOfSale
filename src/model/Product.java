package model;

import java.text.DecimalFormat;

/**
 *
 * @author PMazur
 */

public class Product {
    private String productName;
    private String barcode;
    private double price;

    public Product(String productName, String barcode, double price) {
        this.productName = productName;
        this.barcode = barcode;
        this.price = setPrice(price);
    }
    
    private double setPrice(double price) {
        return (double)Math.round(price * 100) / 100;
    }
    
    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }
    
    public String getBarcode() {
        return barcode;
    }
    
    @Override
    public int hashCode() {
        return barcode.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        } else if(obj instanceof Product) {
            return barcode.equals(((Product)obj).barcode);
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Product name: " + productName + "   Price: " + (new DecimalFormat("#,##0.00").format(price));
    }

    
}

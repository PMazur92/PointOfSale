package model;

import model.Product;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author PMazur
 */
public class Receipt {
    private final Map<Product, Integer> receipt;
    private boolean longReceipt;
    private BigDecimal fullPrice;
    
    public Receipt() {
        this(true);
    }
    
    public Receipt(boolean longReceipt) {
        this.longReceipt = longReceipt;
        receipt = new LinkedHashMap<>();
        fullPrice = new BigDecimal(0.0); 
    }
    
    /*
    * @return Summary of receipt in String
    */
    public String getSummary() {
        return "Full price: " + (new DecimalFormat("#,##0.00").format(fullPrice));
    }
    
    public void setLongReceipt(boolean longReceipt) {
        this.longReceipt = longReceipt;
    }
    
    private String getLongReceipt() {
        StringBuilder longerReceipt = new StringBuilder();
        for(Map.Entry<Product, Integer> entry : receipt.entrySet()) {
            if(entry.getValue() > 1) {
                for(int i=0; i < entry.getValue(); ++i) {
                    longerReceipt.append(entry.getKey().toString())
                                 .append("\n");
                }
            } else {
                longerReceipt.append(entry.getKey().toString())
                             .append("\n");
            }
        }
        return longerReceipt.toString();
    }
    
    private String getShortReceipt() {
        StringBuilder shortReceipt = new StringBuilder();
        for(Map.Entry<Product, Integer> entry : receipt.entrySet()) {
            shortReceipt.append(entry.getKey().toString());
            if(entry.getValue() > 1) {
                shortReceipt.append(" x")
                            .append(entry.getValue());
            }
            shortReceipt.append("\n");
        }
        return shortReceipt.toString();
    }
    
    public Product addProduct(Product product) {
        fullPrice = fullPrice.add(new BigDecimal(product.getPrice()));
        Integer count = receipt.get(product);
        if(count == null) {
            receipt.put(product, 1);
        } else {
            receipt.put(product, count+1);
        }
        return product;
    }

    @Override
    public String toString() {
        StringBuilder result;
        if(longReceipt == true) { 
            result = new StringBuilder(getLongReceipt());
        } else {
            result = new StringBuilder(getShortReceipt());
        }
        result.append("\n-----------------------------\n");
        result.append(getSummary());
        return result.toString();
    }
}

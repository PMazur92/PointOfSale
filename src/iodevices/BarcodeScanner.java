/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iodevices;

import pointofsale.BarcodeListener;

/**
 *
 * @author PMazur
 */
public class BarcodeScanner {
    private BarcodeListener barcodeListener;

    public BarcodeScanner(BarcodeListener barcodeListener) {
        this.barcodeListener = barcodeListener;
    }
    
    public void readBarcode(String barcode) {
        barcodeListener.onBarcodeScan(barcode);
    }
}

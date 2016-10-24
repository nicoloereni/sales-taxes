package store;

import models.Product;

import java.util.List;

public class ReceiptPrinter {

    private String receipt = "";

    public String printReceipt(List<Product> products) {

        products.stream().forEach(this::formatReceipt);

        System.out.println(receipt);



        return receipt;

    }

    private String formatReceipt(Product p) {
        String result = "1 " + p.getProductName().get() + " at " + p.getPriceWithTaxes().get() + "\n";

        receipt += result;

        return result;
    }
}

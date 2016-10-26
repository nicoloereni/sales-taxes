package receipt;

import tax.prices.RounderInterface;
import models.Product;

import java.math.BigDecimal;
import java.util.List;

public class ReceiptPrinter {

    private RounderInterface rounder;

    public ReceiptPrinter(RounderInterface rounder) {
        this.rounder = rounder;
    }

    public String printReceipt(List<Product> products) {

        String productsReceipt = products.stream().map(this::formatReceiptProduct).reduce("", (a,b) -> a + b);
        String totalTaxesReceipt = formatReceiptTotalTaxes(products.stream().mapToDouble(p -> p.getTaxPrice().get().doubleValue()).sum());
        String totalPriceWithTaxesReceipt = formatReceiptTotalPriceWithTaxes(products.stream().mapToDouble(p -> p.getPriceWithTaxes().get().doubleValue()).sum());

        String receipt = productsReceipt + totalTaxesReceipt + totalPriceWithTaxesReceipt;

        System.out.println(receipt);

        return receipt;

    }

    String formatReceiptTotalPriceWithTaxes(Double totalPricesWithTax) {

        return "Total: " + rounder.roundPrice(new BigDecimal(totalPricesWithTax));
    }

    String formatReceiptTotalTaxes(Double totalTaxes) {

        return "Sales taxes: " + rounder.roundPrice(new BigDecimal(totalTaxes)) + "\n";

    }

    String formatReceiptProduct(Product p) {

        return "1 " + p.getProductName().get() + " at " + p.getPriceWithTaxes().get() + "\n";
    }
}

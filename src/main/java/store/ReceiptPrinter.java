package store;

import calculators.RounderInterface;
import calculators.TaxPriceCalculatorInterface;
import models.Product;

import java.math.BigDecimal;
import java.util.List;

public class ReceiptPrinter {

    private String receipt = "";
    private RounderInterface rounder;
    private TaxPriceCalculatorInterface taxPriceCalculatorInterface;

    public ReceiptPrinter(RounderInterface rounder, TaxPriceCalculatorInterface taxPriceCalculatorInterface) {
        this.rounder = rounder;
        this.taxPriceCalculatorInterface = taxPriceCalculatorInterface;
    }

    public String printReceipt(List<Product> products) {

        products.forEach(taxPriceCalculatorInterface.populateProductPrices());

        products.stream().forEach(this::formatReceiptProduct);

        System.out.println(receipt);

        String totalTaxesReceipt = formatReceiptTotalTaxes(products.stream().mapToDouble(p -> p.getTaxPrice().get().doubleValue()).sum());

        System.out.println(totalTaxesReceipt);

        String totalPriceWithTaxesReceipt = formatReceiptTotalPriceWithTaxes(products.stream().mapToDouble(p -> p.getPriceWithTaxes().get().doubleValue()).sum());

        System.out.println(totalPriceWithTaxesReceipt);

        return receipt;

    }

    String formatReceiptTotalPriceWithTaxes(Double totalPricesWithTax) {

        String result = "Total: " + rounder.roundPrice(new BigDecimal(totalPricesWithTax));

        receipt += result;

        return result;
    }

    String formatReceiptTotalTaxes(Double totalTaxes) {

        String result = "Sales taxes: " + rounder.roundPrice(new BigDecimal(totalTaxes)) + "\n";

        receipt += result;

        return result;

    }

    private String formatReceiptProduct(Product p) {
        String result = "1 " + p.getProductName().get() + " at " + p.getPriceWithTaxes().get() + "\n";

        receipt += result;

        return result;
    }
}

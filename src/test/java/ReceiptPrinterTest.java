import calculators.Rounder;
import calculators.TaxPriceCalculator;
import models.*;
import org.junit.Before;
import org.junit.Test;
import store.ReceiptPrinter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static models.tax.type.enums.ImportTaxType.IMPORTED;
import static models.tax.type.enums.ImportTaxType.NOT_IMPORTED;

public class ReceiptPrinterTest {

    private ReceiptPrinter receiptPrinter;

    @Before
    public void setUp() throws Exception {

        Rounder rounder = new Rounder();
        receiptPrinter = new ReceiptPrinter(rounder, new TaxPriceCalculator(rounder));

    }

    /**
     * Input 1:
     * 1 book at 12.49
     * 1 music CD at 14.99
     * 1 chocolate bar at 0.85
     * <p>
     * Output 1:
     * 1 book : 12.49
     * 1 music CD: 16.49
     * 1 chocolate bar: 0.85
     * Sales Taxes: 1.50
     * Total: 29.83
     */
    @Test
    public void printReceiptInputOneReturnProperResponse() throws Exception {

        List<Product> products = new ArrayList<>();
        products.add(new Book("book", new BigDecimal(12.49), NOT_IMPORTED));
        products.add(new TaxedProduct("music CD", new BigDecimal(14.99), NOT_IMPORTED));
        products.add(new Food("chocolate bar", new BigDecimal(0.85), NOT_IMPORTED));

        String result = receiptPrinter.printReceipt(products);

        assertEquals(
                "1 book at 12.49\n" +
                        "1 music CD at 16.49\n" +
                        "1 chocolate bar at 0.85\n" +
                        "Sales taxes: 1.50\n" +
                        "Total: 29.83",
                result);

    }

    /**
     * Input 2:
     * 1 imported box of chocolates at 10.00
     * 1 imported bottle of perfume at 47.50
     * <p>
     * Output 2
     * 1 imported box of chocolates: 10.50
     * 1 imported bottle of perfume: 54.65
     * Sales Taxes: 7.65
     * Total: 65.15
     */
    @Test
    public void printReceiptInputTwoReturnProperResponse() throws Exception {

        List<Product> products = new ArrayList<>();
        products.add(new Food("chocolate bar", new BigDecimal(10.00), IMPORTED));
        products.add(new TaxedProduct("imported bottle of perfume", new BigDecimal(47.50), IMPORTED));

        String result = receiptPrinter.printReceipt(products);

        assertEquals(
                "1 chocolate bar at 10.50\n" +
                        "1 imported bottle of perfume at 54.65\n" +
                        "Sales taxes: 7.65\n" +
                        "Total: 65.15",
                result
        );

    }

    /**
     * Input 3:
     * 1 imported bottle of perfume at 27.99
     * 1 bottle of perfume at 18.99
     * 1 packet of headache pills at 9.75
     * 1 box of imported chocolates at 11.25
     * <p>
     * Output 3:
     * 1 imported bottle of perfume: 32.19
     * 1 bottle of perfume: 20.89
     * 1 packet of headache pills: 9.75
     * 1 imported box of chocolates: 11.85
     * Sales Taxes: 6.70
     * Total: 74.68
     */
    @Test
    public void printReceiptInputThreeReturnProperResponse() throws Exception {

        List<Product> products = new ArrayList<>();
        products.add(new TaxedProduct("imported bottle of perfume", new BigDecimal(27.99), IMPORTED));
        products.add(new TaxedProduct("bottle of perfume", new BigDecimal(18.99), NOT_IMPORTED));
        products.add(new MedicalProduct("packet of headache pills", new BigDecimal(9.75), NOT_IMPORTED));
        products.add(new Food("box of imported chocolates", new BigDecimal(11.25), IMPORTED));

        String result = receiptPrinter.printReceipt(products);

        assertEquals(
                "1 imported bottle of perfume at 32.19\n" +
                        "1 bottle of perfume at 20.89\n" +
                        "1 packet of headache pills at 9.75\n" +
                        "1 box of imported chocolates at 11.85\n" +
                        "Sales taxes: 6.70\n" +
                        "Total: 74.68",
                result
        );

    }
}

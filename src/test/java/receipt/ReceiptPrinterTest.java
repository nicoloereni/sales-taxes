package receipt;

import models.Book;
import models.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import tax.prices.RounderInterface;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import static java.util.Optional.of;
import static junit.framework.TestCase.assertEquals;
import static models.tax.type.ImportTaxType.IMPORTED;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ReceiptPrinterTest {

    @Mock
    RounderInterface rounder;

    ReceiptPrinter receiptPrinter;
    private double aRandomTotalPricesWithTax;

    @Before
    public void setUp() throws Exception {

        receiptPrinter = new ReceiptPrinter(rounder);
        aRandomTotalPricesWithTax = 0.1d;

        when(rounder.roundPrice(any())).thenAnswer(invocation -> BigDecimal.TEN.setScale(2, RoundingMode.HALF_UP));

    }

    @Test
    public void formatReceiptTotalPriceWithTaxesReturnProperResponse() throws Exception {

        assertEquals("Total: 10.00", receiptPrinter.formatReceiptTotalPriceWithTaxes(aRandomTotalPricesWithTax));

    }

    @Test
    public void formatReceiptTotalTaxesReturnProperResponse() throws Exception {

        assertEquals("Sales taxes: 10.00\n", receiptPrinter.formatReceiptTotalTaxes(aRandomTotalPricesWithTax));

    }

    @Test
    public void formatReceiptProductReturnProperResponse() throws Exception {

        Book product = new Book("a book", new BigDecimal(3.3), IMPORTED);
        product.setPriceWithTaxes(of(BigDecimal.ZERO));

        assertEquals("1 a book at 0\n", receiptPrinter.formatReceiptProduct(product));

    }

    @Test
    public void printReceiptEmptyProductListReturnProperResponse() throws Exception {

        assertEquals(
                "Sales taxes: 10.00\nTotal: 10.00",
                receiptPrinter.printReceipt(new ArrayList<>())
        );
    }

    @Test
    public void printReceiptProductListReturnProperResponse() throws Exception {

        ArrayList<Product> products = new ArrayList<>();
        products.add(new Book("book name", new BigDecimal(10), IMPORTED));

        assertEquals(
                "1 book name at 0\nSales taxes: 10.00\nTotal: 10.00",
                receiptPrinter.printReceipt(products)
        );
    }
}

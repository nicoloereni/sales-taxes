import models.Book;
import models.Food;
import models.Product;
import models.StandardProduct;
import org.junit.Before;
import org.junit.Test;
import store.ReceiptPrinter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static models.tax.type.enums.ImportTaxType.NOT_IMPORTED;

public class ReceiptPrinterTest {

    private ReceiptPrinter receiptPrinter;

    @Before
    public void setUp() throws Exception {

        receiptPrinter = new ReceiptPrinter();

    }

    /**
     * Input 1:
     * 1 book at 12.49
     * 1 music CD at 14.99
     * 1 chocolate bar at 0.85
     */
    @Test
    public void printReceiptReturnProperResponse() throws Exception {
        List<Product> products = new ArrayList<>();
        products.add(new Book("book", new BigDecimal(12.49), NOT_IMPORTED));
        products.add(new StandardProduct("music CD", new BigDecimal(14.99), NOT_IMPORTED));
        products.add(new Food("chocolate bar", new BigDecimal(0.85), NOT_IMPORTED));

        String result = receiptPrinter.printReceipt(products);

        assertEquals("1 book at 12.49\n1 music CD at 16.49\n1 chocolate bar at 0.85\n", result);

    }
}

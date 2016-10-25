package tax.prices;

import models.Book;
import models.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.math.RoundingMode.HALF_UP;
import static java.util.Optional.of;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static models.tax.type.ImportTaxType.IMPORTED;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductTaxPriceTest {

    @Mock
    private TaxPriceInterface taxPrice;
    private ProductTaxPrice productTaxPrice;
    private Optional<BigDecimal> valueExpected;

    @Before
    public void setUp() throws Exception {

        valueExpected = of(new BigDecimal(10).setScale(2, HALF_UP));

        when(taxPrice.calculatePriceWithTaxes(any(), any())).thenReturn(valueExpected);
        when(taxPrice.calculateTaxPrice(any(), any())).thenReturn(valueExpected);
        productTaxPrice = new ProductTaxPrice(taxPrice);

    }

    @Test
    public void populateEmptyProductsPriceAndTaxReturnProperResponse() throws Exception {

        List<Product> productsPopulated = productTaxPrice.populateProductsPriceAndTax(new ArrayList<>());

        assertNotNull(productsPopulated);
        assertTrue(productsPopulated.isEmpty());

    }

    @Test
    public void populateProductsPriceAndTaxReturnProperResponse() throws Exception {

        ArrayList<Product> products = new ArrayList<>();
        products.add(new Book("name", new BigDecimal(3), IMPORTED));

        List<Product> productsPopulated = productTaxPrice.populateProductsPriceAndTax(products);

        assertEquals(1, productsPopulated.size());
        assertEquals(valueExpected.get(), productsPopulated.get(0).getPriceWithTaxes().get());
        assertEquals(valueExpected.get(), productsPopulated.get(0).getTaxPrice().get());

    }
}

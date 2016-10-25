package calculators;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;

import static java.math.BigDecimal.*;
import static java.util.Optional.of;
import static junit.framework.TestCase.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TaxPriceCalculatorTest {

    private TaxPriceCalculator taxPriceCalculator;

    @Mock
    Rounder rounder;
    private double delta;

    @Before
    public void setUp() throws Exception {

        delta = 0.001;
        taxPriceCalculator = new TaxPriceCalculator(rounder);
        when(rounder.roundPrice(any())).thenAnswer(invocation -> invocation.getArguments()[0]);
        when(rounder.roundTax(any())).thenAnswer(invocation -> invocation.getArguments()[0]);

    }

    @Test
    public void calculatePriceWithTaxesReturnProperResponse() throws Exception {

        assertEquals(0d, taxPriceCalculator.calculatePriceWithTaxes(of(ZERO), new BigDecimal(10)).get().doubleValue(), delta);
        assertEquals(11d, taxPriceCalculator.calculatePriceWithTaxes(of(TEN), new BigDecimal(0.1)).get().doubleValue(), delta);
        assertEquals(10d, taxPriceCalculator.calculatePriceWithTaxes(of(TEN), ZERO).get().doubleValue(), delta);
        assertEquals(2d, taxPriceCalculator.calculatePriceWithTaxes(of(ONE), new BigDecimal(1)).get().doubleValue(), delta);

    }

    @Test
    public void calculateTaxPriceReturnProperResponse() throws Exception {

        assertEquals(0d, taxPriceCalculator.calculateTaxPrice(of(ZERO), new BigDecimal(10)).get().doubleValue(), delta);
        assertEquals(1d, taxPriceCalculator.calculateTaxPrice(of(TEN), new BigDecimal(0.1)).get().doubleValue(), delta);
        assertEquals(0d, taxPriceCalculator.calculateTaxPrice(of(TEN), ZERO).get().doubleValue(), delta);
        assertEquals(1d, taxPriceCalculator.calculateTaxPrice(of(ONE), new BigDecimal(1)).get().doubleValue(), delta);

    }
}

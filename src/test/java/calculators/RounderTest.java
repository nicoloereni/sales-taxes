package calculators;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static java.math.RoundingMode.HALF_UP;
import static junit.framework.TestCase.assertEquals;

public class RounderTest {

    private Rounder rounder;

    @Before
    public void setUp() throws Exception {
        rounder = new Rounder();

    }

    @Test
    public void roundTaxReturnProperResponse() throws Exception {

        assertEquals(new BigDecimal(0.10).setScale(2, HALF_UP), rounder.roundTax(new BigDecimal(0.10)));
        BigDecimal expected15 = new BigDecimal(0.15).setScale(2, HALF_UP);
        BigDecimal expected20 = new BigDecimal(0.20).setScale(2, HALF_UP);
        assertEquals(expected15, rounder.roundTax(new BigDecimal(0.11)));
        assertEquals(expected15, rounder.roundTax(new BigDecimal(0.12)));
        assertEquals(expected15, rounder.roundTax(new BigDecimal(0.13)));
        assertEquals(expected15, rounder.roundTax(new BigDecimal(0.14)));
        assertEquals(expected15, rounder.roundTax(new BigDecimal(0.15)));
        assertEquals(expected20, rounder.roundTax(new BigDecimal(0.16)));
        assertEquals(expected20, rounder.roundTax(new BigDecimal(0.18)));
        assertEquals(expected20, rounder.roundTax(new BigDecimal(0.19)));
        assertEquals(expected20, rounder.roundTax(new BigDecimal(0.17)));

    }

    @Test
    public void roundPriceReturnProperResponse() throws Exception {

        assertEquals(new BigDecimal(0.10).setScale(2, HALF_UP), rounder.roundPrice(new BigDecimal(0.10)));
        assertEquals(new BigDecimal(0.11).setScale(2, HALF_UP), rounder.roundPrice(new BigDecimal(0.11)));
        assertEquals(new BigDecimal(0.12).setScale(2, HALF_UP), rounder.roundPrice(new BigDecimal(0.12)));
        assertEquals(new BigDecimal(0.13).setScale(2, HALF_UP), rounder.roundPrice(new BigDecimal(0.13)));
        assertEquals(new BigDecimal(0.14).setScale(2, HALF_UP), rounder.roundPrice(new BigDecimal(0.14)));
        assertEquals(new BigDecimal(0.15).setScale(2, HALF_UP), rounder.roundPrice(new BigDecimal(0.15)));
        assertEquals(new BigDecimal(0.16).setScale(2, HALF_UP), rounder.roundPrice(new BigDecimal(0.16)));
        assertEquals(new BigDecimal(0.17).setScale(2, HALF_UP), rounder.roundPrice(new BigDecimal(0.17)));
        assertEquals(new BigDecimal(0.18).setScale(2, HALF_UP), rounder.roundPrice(new BigDecimal(0.18)));
        assertEquals(new BigDecimal(0.19).setScale(2, HALF_UP), rounder.roundPrice(new BigDecimal(0.19)));

    }
}

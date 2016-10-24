package calculators;

import java.math.BigDecimal;

import static java.math.RoundingMode.HALF_UP;

public class Rounder {

    public static BigDecimal roundTax(BigDecimal taxPrice) {
        return taxPrice.setScale(4, HALF_UP).multiply(new BigDecimal("20")).setScale(0, BigDecimal.ROUND_CEILING).divide(new BigDecimal("20")).setScale(2, HALF_UP);
    }

    public static BigDecimal roundPrice(BigDecimal price) {
        return price.setScale(2, HALF_UP);
    }
}
package calculators;

import java.math.BigDecimal;
import java.util.Optional;

import static java.math.RoundingMode.HALF_UP;

public class TaxPriceCalculator {

    public static final BigDecimal ROUNDING = BigDecimal.valueOf(0.05d);

    public static Optional<BigDecimal> calculatePriceWithTaxes(Optional<BigDecimal> price, BigDecimal taxPercentage) {

        return price.map(p -> (calculateTaxPrice(p, taxPercentage).add(p).setScale(2, HALF_UP)));

    }

    private static BigDecimal round(BigDecimal taxesPrice) {

        return (taxesPrice.divide(ROUNDING, 2, HALF_UP).multiply(ROUNDING));

    }

    private static BigDecimal calculateTaxPrice(BigDecimal price, BigDecimal taxPercentage) {
        return round(price.multiply(taxPercentage));
    }

    public static Optional<BigDecimal> calculateTaxPrice(Optional<BigDecimal> price, BigDecimal taxPercentage) {
        return Optional.of(calculateTaxPrice(price.get(), taxPercentage));
    }
}

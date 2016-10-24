package calculators;

import java.math.BigDecimal;
import java.util.Optional;

import static calculators.Rounder.roundPrice;
import static calculators.Rounder.roundTax;

public class TaxPriceCalculator {

    public static Optional<BigDecimal> calculatePriceWithTaxes(Optional<BigDecimal> price, BigDecimal taxPercentage) {

        return price.map(p -> roundPrice(calculateTaxPrice(p, taxPercentage).add(p)));

    }

    private static BigDecimal calculateTaxPrice(BigDecimal price, BigDecimal taxPercentage) {
        return roundTax(price.multiply(taxPercentage));
    }

    public static Optional<BigDecimal> calculateTaxPrice(Optional<BigDecimal> price, BigDecimal taxPercentage) {
        return Optional.of(calculateTaxPrice(price.get(), taxPercentage));
    }
}

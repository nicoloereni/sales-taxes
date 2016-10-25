package calculators;


import models.Product;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.function.Consumer;

public interface TaxPriceCalculatorInterface {
    Optional<BigDecimal> calculatePriceWithTaxes(Optional<BigDecimal> price, BigDecimal taxPercentage);

    Optional<BigDecimal> calculateTaxPrice(Optional<BigDecimal> price, BigDecimal taxPercentage);

    Consumer<Product> populateProductPrices();
}

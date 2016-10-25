package tax.prices;


import java.math.BigDecimal;
import java.util.Optional;

public interface TaxPriceInterface {
    Optional<BigDecimal> calculatePriceWithTaxes(Optional<BigDecimal> price, BigDecimal taxPercentage);

    Optional<BigDecimal> calculateTaxPrice(Optional<BigDecimal> price, BigDecimal taxPercentage);

}

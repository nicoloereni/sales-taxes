package tax.prices;

import java.math.BigDecimal;
import java.util.Optional;


public class TaxPrice implements TaxPriceInterface {

    private RounderInterface rounderInterface;

    public TaxPrice(RounderInterface rounderInterface) {
        this.rounderInterface = rounderInterface;
    }

    @Override
    public Optional<BigDecimal> calculatePriceWithTaxes(Optional<BigDecimal> price, BigDecimal taxPercentage) {

        return price.map(p -> rounderInterface.roundPrice(calculateTaxPrice(p, taxPercentage).add(p)));

    }

    private BigDecimal calculateTaxPrice(BigDecimal price, BigDecimal taxPercentage) {
        return rounderInterface.roundTax(price.multiply(taxPercentage));
    }

    @Override
    public Optional<BigDecimal> calculateTaxPrice(Optional<BigDecimal> price, BigDecimal taxPercentage) {
        return Optional.of(calculateTaxPrice(price.get(), taxPercentage));
    }

}

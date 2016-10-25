package calculators;

import models.Product;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.function.Consumer;


public class TaxPriceCalculator implements TaxPriceCalculatorInterface {

    private RounderInterface rounderInterface;

    public TaxPriceCalculator(RounderInterface rounderInterface) {
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

    @Override
    public Consumer<Product> populateProductPrices() {
        return p -> {
            BigDecimal taxPercentage = p.getTaxType().getValue().add(p.getImportTaxType().getValue());
            p.setPriceWithTaxes(calculatePriceWithTaxes(p.getPrice(), taxPercentage));
            p.setTaxPrice(calculateTaxPrice(p.getPrice(), taxPercentage));
        };
    }
}

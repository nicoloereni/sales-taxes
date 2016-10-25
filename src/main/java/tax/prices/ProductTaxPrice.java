package tax.prices;

import models.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Consumer;

public class ProductTaxPrice implements ProductTaxPriceInterface {

    private TaxPriceInterface taxPrice;

    public ProductTaxPrice(TaxPriceInterface taxPrice) {
        this.taxPrice = taxPrice;
    }

    private Consumer<Product> populateProductPriceAndTax() {
        return p -> {
            BigDecimal taxPercentage = p.getTaxType().getValue().add(p.getImportTaxType().getValue());
            p.setPriceWithTaxes(taxPrice.calculatePriceWithTaxes(p.getPrice(), taxPercentage));
            p.setTaxPrice(taxPrice.calculateTaxPrice(p.getPrice(), taxPercentage));
        };
    }

    @Override
    public List<Product> populateProductsPriceAndTax(List<Product> products){
        products.forEach(populateProductPriceAndTax());
        return products;
    }

}

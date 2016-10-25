package tax.prices;

import models.Product;

import java.util.List;

public interface ProductTaxPriceInterface {
    List<Product> populateProductsPriceAndTax(List<Product> products);
}

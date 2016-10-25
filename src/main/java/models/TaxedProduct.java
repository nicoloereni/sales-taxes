package models;

import models.tax.type.enums.ImportTaxType;

import java.math.BigDecimal;
import java.util.Optional;

import static java.util.Optional.*;
import static models.tax.type.enums.TaxType.STANDARD;

public class TaxedProduct extends Product{
    public TaxedProduct(String name, BigDecimal price, ImportTaxType importTaxType) {
        super(of(name), of(price), importTaxType, STANDARD);
    }
}

package models;

import models.tax.type.enums.ImportTaxType;

import java.math.BigDecimal;
import java.util.Optional;

import static java.util.Optional.*;
import static models.tax.type.enums.TaxType.STANDARD;

public class StandardProduct extends Product{
    public StandardProduct(String name, BigDecimal price, ImportTaxType importTaxType) {
        super(of(name), of(price), importTaxType, STANDARD);
    }
}

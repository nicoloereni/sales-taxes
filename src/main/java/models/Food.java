package models;

import models.tax.type.enums.ImportTaxType;

import java.math.BigDecimal;
import java.util.Optional;

import static java.util.Optional.*;
import static models.tax.type.enums.TaxType.EXEMPT;

public class Food extends Product{

    public Food(String name, BigDecimal price, ImportTaxType importTaxType) {
        super(of(name), of(price), importTaxType, EXEMPT);
    }
}

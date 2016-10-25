package models;

import models.tax.type.ImportTaxType;

import java.math.BigDecimal;

import static java.util.Optional.*;
import static models.tax.type.TaxType.EXEMPT;

public class Food extends Product{

    public Food(String name, BigDecimal price, ImportTaxType importTaxType) {
        super(of(name), of(price), importTaxType, EXEMPT);
    }
}

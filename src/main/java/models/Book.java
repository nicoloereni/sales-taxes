package models;

import models.tax.type.ImportTaxType;
import models.tax.type.TaxType;

import java.math.BigDecimal;

import static java.util.Optional.*;

public class Book extends Product {

    public Book(String name, BigDecimal price, ImportTaxType importTaxType) {
        super(of(name), of(price), importTaxType, TaxType.EXEMPT);
    }
}

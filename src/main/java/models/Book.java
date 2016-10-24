package models;

import models.tax.type.enums.ImportTaxType;
import models.tax.type.enums.TaxType;

import java.math.BigDecimal;
import java.util.Optional;

import static java.util.Optional.*;

public class Book extends Product {

    public Book(String name, BigDecimal price, ImportTaxType importTaxType) {
        super(of(name), of(price), importTaxType, TaxType.EXEMPT);
    }
}

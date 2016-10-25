package models;

import models.tax.type.ImportTaxType;

import java.math.BigDecimal;

import static java.util.Optional.of;
import static models.tax.type.TaxType.EXEMPT;

public class MedicalProduct extends Product {
    public MedicalProduct(String name, BigDecimal price, ImportTaxType importTaxType) {
        super(of(name), of(price), importTaxType, EXEMPT);
    }
}

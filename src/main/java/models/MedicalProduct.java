package models;

import models.tax.type.enums.ImportTaxType;

import java.math.BigDecimal;
import java.util.Optional;

import static java.util.Optional.of;
import static models.tax.type.enums.TaxType.EXEMPT;

public class MedicalProduct extends Product {
    public MedicalProduct(String name, BigDecimal price, ImportTaxType importTaxType) {
        super(of(name), of(price), importTaxType, EXEMPT);
    }
}

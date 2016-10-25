package models;

import models.tax.type.ImportTaxType;
import models.tax.type.TaxType;

import java.math.BigDecimal;
import java.util.Optional;

import static java.util.Optional.of;

public class Product {

    private TaxType taxType;
    private ImportTaxType importTaxType;
    private Optional<BigDecimal> priceWithTaxes;
    private Optional<String> productName;
    private Optional<BigDecimal> taxPrice;

    public Product(Optional<String> name, Optional<BigDecimal> price, ImportTaxType importTaxType, TaxType taxType) {
        this.productName = name;
        this.price = price;
        this.importTaxType = importTaxType;
        this.taxType = taxType;
        this.priceWithTaxes = of(BigDecimal.ZERO);
        this.taxPrice = of(BigDecimal.ZERO);
    }

    private Optional<BigDecimal> price;

    public Optional<BigDecimal> getPrice() {
        return price;
    }

    public void setPrice(Optional<BigDecimal> price) {
        this.price = price;
    }

    public TaxType getTaxType() {
        return taxType;
    }

    public void setTaxType(TaxType taxType) {
        this.taxType = taxType;
    }

    public ImportTaxType getImportTaxType() {
        return importTaxType;
    }

    public void setImportTaxType(ImportTaxType importTaxType) {
        this.importTaxType = importTaxType;
    }

    public Optional<BigDecimal> getPriceWithTaxes() {
        return priceWithTaxes;
    }

    public void setPriceWithTaxes(Optional<BigDecimal> priceWithTaxes) {
        this.priceWithTaxes = priceWithTaxes;
    }

    public Optional<String> getProductName() {
        return productName;
    }

    public void setProductName(Optional<String> productName) {
        this.productName = productName;
    }

    public Optional<BigDecimal> getTaxPrice() {
        return taxPrice;
    }

    public void setTaxPrice(Optional<BigDecimal> taxPrice) {
        this.taxPrice = taxPrice;
    }
}

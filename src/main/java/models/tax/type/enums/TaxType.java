package models.tax.type.enums;

import java.math.BigDecimal;

public enum TaxType {

    STANDARD(new BigDecimal(0.10)),
    EXEMPT(BigDecimal.ZERO);

    private final BigDecimal value;

    TaxType(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal geValue() {
        return this.value;
    }
}

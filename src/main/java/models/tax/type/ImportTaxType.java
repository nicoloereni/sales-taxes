package models.tax.type;

import java.math.BigDecimal;

public enum ImportTaxType {

    IMPORTED(new BigDecimal(0.05)),
    NOT_IMPORTED(BigDecimal.ZERO);

    private final BigDecimal value;

    ImportTaxType(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

}

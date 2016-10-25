package tax.prices;

import java.math.BigDecimal;

public interface RounderInterface {
    BigDecimal roundTax(BigDecimal taxPrice);

    BigDecimal roundPrice(BigDecimal price);
}

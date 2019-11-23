


package pl.jkan.pp5.creditcard.model;

import java.math.BigDecimal;

public class CreditCard {
    private BigDecimal limit;

    public void assignLimit(BigDecimal initialLimit) {
        limit = initialLimit;
    }

    public BigDecimal limit() {
        return limit;
    }
}

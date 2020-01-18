


package pl.jkan.pp5.creditcard.model;

import java.math.BigDecimal;

public class CreditCard {
    private BigDecimal limit;
    private BigDecimal balance;

    public void assignLimit(BigDecimal initialLimit) {

        if (BigDecimal.valueOf(1000).compareTo(initialLimit) == 1) {
            throw new CreditBelowLimitException();
        }

        limit = initialLimit;
        balance = initialLimit;
    }

    public BigDecimal limit() {
        return limit;
    }

    public void withdraw(BigDecimal amount) {
        this.balance = balance.subtract(amount);
    }

    public BigDecimal currentBalance() {
        return balance;
    }
}

package pl.jkan.pp5.creditcard.model;

import java.math.BigDecimal;

public class CardSummary {
    public BigDecimal balance;

    public CardSummary(BigDecimal balance) {
        this.balance = balance;
    }
}

package pl.jkan.pp5.creditcard.model;

import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.math.BigDecimal;

public class CreditCardFacadeTest {

    private InMemoryCreditCardStorage creditCardStorage;

    @Test
    public void allowWithdrawFromCards() {
        thereIsCreditCardIdentifiedWitNumber("1234-56789");

        CreditCardFacade api = thereIsCCApi();
        api.withdraw("1234-56789", BigDecimal.valueOf(200));

        CardSummary summary = api.getSummary("1234-56789");
        Assert.assertNotNull(summary);
        Assert.assertEquals(summary.balance, BigDecimal.valueOf(800));
    }

    private CreditCardFacade thereIsCCApi() {
        return new CreditCardFacade();
    }

    private void thereIsCreditCardIdentifiedWitNumber(String number) {
        CreditCard creditCard = new CreditCard(number);
        creditCard.assignLimit(BigDecimal.valueOf(1000));

        creditCardStorage.add(creditCard);
    }
}

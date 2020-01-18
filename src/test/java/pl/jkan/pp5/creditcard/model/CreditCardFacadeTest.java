package pl.jkan.pp5.creditcard.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class CreditCardFacadeTest {

    private CreditCardStorage creditCardStorage;

    @Before
    public void setup() {
        creditCardStorage = new InMemoryCreditCardStorage();
    }

    @Test
    public void allowWithdrawFromCards() {
        thereIsCreditCardIdentifiedWitNumber("1234-56789");

        CreditCardFacade api = thereIsCCApi();
        api.withdraw(new WithdrawCommand("1234-56789", BigDecimal.valueOf(200)));

        CardSummary summary = api.getSummary("1234-56789");
        Assert.assertNotNull(summary);
        Assert.assertEquals(summary.balance, BigDecimal.valueOf(800));
    }

    private CreditCardFacade thereIsCCApi() {
        return new CreditCardFacade(this.creditCardStorage);
    }

    private void thereIsCreditCardIdentifiedWitNumber(String number) {
        CreditCard creditCard = new CreditCard(number);
        creditCard.assignLimit(BigDecimal.valueOf(1000));

        creditCardStorage.add(creditCard);
    }
}

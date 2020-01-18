


package pl.jkan.pp5.creditcard.model;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.UUID;

public class CreditCardTest {

    public static final int INITIAL_LIMIT = 1000;

    @Test
    public void itAllowAssignLimitToCreditCard() {
        //Arrange // Given
        CreditCard creditCard = thereIsCreditCard();
        //Act     // When
        creditCard.assignLimit(BigDecimal.valueOf(INITIAL_LIMIT));
        //Assert  // Then // Expect
        Assert.assertEquals(BigDecimal.valueOf(INITIAL_LIMIT), creditCard.limit());
    }

    private CreditCard thereIsCreditCard() {
        return new CreditCard("123456789");
    }

    @Test
    public void denyAssignLimitBelowMinimum() {
        CreditCard creditCard = thereIsCreditCard();

        try {
            creditCard.assignLimit(BigDecimal.valueOf(500));
            Assert.fail("Exception should be thrown");
        } catch (CreditBelowLimitException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void withdrawFromCard() {
        //Arrange // Given
        CreditCard creditCard = thereIsCreditCard();
        creditCard.assignLimit(BigDecimal.valueOf(INITIAL_LIMIT));
        //ACt / When
        creditCard.withdraw(BigDecimal.valueOf(200));
        //Assert // Then
        Assert.assertEquals(creditCard.currentBalance(), BigDecimal.valueOf(800));
    }
}

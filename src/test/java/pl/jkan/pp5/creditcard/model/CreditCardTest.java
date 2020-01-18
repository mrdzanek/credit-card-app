


package pl.jkan.pp5.creditcard.model;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class CreditCardTest {

    public static final int INITIAL_LIMIT = 1000;

    @Test
    public void itAllowAssignLimitToCreditCard() {
        //Arrange // Given
        CreditCard creditCard = new CreditCard();
        //Act     // When
        creditCard.assignLimit(BigDecimal.valueOf(INITIAL_LIMIT));
        //Assert  // Then // Expect
        Assert.assertEquals(BigDecimal.valueOf(INITIAL_LIMIT), creditCard.limit());
    }

    @Test
    public void denyAssignLimitBelowMinimum() {
        CreditCard creditCard = new CreditCard();

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
        CreditCard creditCard = new CreditCard();
        creditCard.assignLimit(BigDecimal.valueOf(INITIAL_LIMIT));
        //ACt / When
        creditCard.withdraw(BigDecimal.valueOf(200));
        //Assert // Then
        Assert.assertEquals(creditCard.currentBalance(), BigDecimal.valueOf(800));
    }
}

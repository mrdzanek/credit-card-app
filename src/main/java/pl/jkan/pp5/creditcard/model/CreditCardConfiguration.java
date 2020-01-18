package pl.jkan.pp5.creditcard.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.UUID;

@Configuration
public class CreditCardConfiguration {
    @Bean
    CreditCardFacade creditCardFacade() {
        CreditCardStorage storage = getFixtures();
        return new CreditCardFacade(storage);
    }
    private CreditCardStorage getFixtures() {
        CreditCardStorage storage = new InMemoryCreditCardStorage();
        storage.add(testCard(1000));storage.add(testCard(2000));
        return storage;
    }

    private CreditCard testCard(Integer initial) {
        CreditCard creditCard = new CreditCard(UUID.randomUUID().toString());
        creditCard.assignLimit(BigDecimal.valueOf(initial));
        return creditCard;
    }
}

package pl.jkan.pp5.creditcard.model;

import javax.smartcardio.Card;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class InMemoryCreditCardStorage implements CreditCardStorage {
    Map<String, CreditCard> cards = new ConcurrentHashMap<String, CreditCard>();

    public void add(CreditCard creditCard) {
        cards.put(creditCard.getNumber(), creditCard);
    }

    public CreditCard load(String number) {
        return cards.get(number);
    }

    public List<CreditCard> all() {
        return cards.entrySet()
                .stream()
                .map(e -> e.getValue())
                .collect(Collectors.toList());
    }
}

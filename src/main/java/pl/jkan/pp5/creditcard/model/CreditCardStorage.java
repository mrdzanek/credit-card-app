package pl.jkan.pp5.creditcard.model;

import java.util.List;

public interface CreditCardStorage {
    void add(CreditCard creditCard);

    CreditCard load(String number);

    List<CreditCard> all();
}

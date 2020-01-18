package pl.jkan.pp5.creditcard.model;

public class CreditCardFacade {
    private CreditCardStorage creditCardStorage;

    public CreditCardFacade(CreditCardStorage creditCardStorage) {
        this.creditCardStorage = creditCardStorage;
    }

    public void withdraw(WithdrawCommand withdrawCommand) {
        CreditCard creditCard = creditCardStorage.load(withdrawCommand.getNumber());
        creditCard.withdraw(withdrawCommand.getAmount());
        creditCardStorage.add(creditCard);
    }

    public CardSummary getSummary(String number) {
        CreditCard creditCard = creditCardStorage.load(number);
        return creditCard.getSummary();
    }
}

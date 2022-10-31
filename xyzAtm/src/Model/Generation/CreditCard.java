package Model.Generation;


import java.time.LocalDate;

public class CreditCard extends Card {

    private long creditCardDue = 0;

    CreditCard(int cardNumber, int pin, int ccv, LocalDate expiryDate,String cardType) {
        super(cardNumber, pin, ccv,expiryDate,cardType);
    }

    public void setCreditCardDue(long creditCardDue) {
        this.creditCardDue = creditCardDue;
    }

    public long getCreditCardDue() {
        return creditCardDue;
    }
}

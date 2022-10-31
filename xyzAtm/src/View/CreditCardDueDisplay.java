package View;

import Model.Generation.CreditCard;

public class CreditCardDueDisplay {
    public void displayCreditCardDue(CreditCard creditCard)
    {
        System.out.println("Credit card due:"+creditCard.getCreditCardDue());
    }
}

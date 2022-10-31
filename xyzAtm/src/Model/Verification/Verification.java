package Model.Verification;

import Model.Generation.Card;
import Model.Generation.Customer;
import Model.Generation.Server;

public class Verification implements DataVerification {
    DataValidation validating=new Validation();
    Server server=Server.getServer();
    public long verification(Card.CardType cardType)
    {
        long cardNumber=validating.validation("Card Number");

        long pin=validating.validation("Pin");
        if(cardType== Card.CardType.DEBITCARD) {
            for (Customer list : server.getList1()) {
                if (list.getAccounts().getDebitCard().getCardNumber() == cardNumber && list.getAccounts().getDebitCard().getPin() == pin) {
                    return list.getAccounts().getAccountNumber();
                }
            }

        }
        else{
            for (Customer list : server.getList1()) {
                try {
                    if (list.getAccounts().getCreditCard().getCardNumber() == cardNumber && list.getAccounts().getCreditCard().getPin() == pin) {
                        return list.getAccounts().getCreditCard().getCardNumber();
                    }
                } catch (NullPointerException e) {
                    System.out.println("No credit card available for you");
                    return 0;
                }
            }
        }
        return 0;

    }
}

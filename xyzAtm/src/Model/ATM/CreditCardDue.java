package Model.ATM;

import Model.Generation.Card;
import Model.Generation.Customer;
import Model.Generation.Server;
import Model.Generation.CreditCard;
import Model.Verification.DataVerification;
import Model.Verification.Verification;

public class CreditCardDue implements CreditCardDueBalance {

    DataVerification verify = new Verification();
    Server server = Server.getServer();

    public CreditCard creditCardDueBalance()
    {
        long cardNumber = verify.verification(Card.CardType.CREDITCARD);
        if (cardNumber != 0)
        {
            for (Customer list : server.getList1())
            {
                if (list.getAccounts().getCreditCard().getCardNumber() == cardNumber)
                {
                    return list.getAccounts().getCreditCard();
                }
            }
        }
        else {
            System.out.println("Enter valid details");
        }
        return null;
    }
}

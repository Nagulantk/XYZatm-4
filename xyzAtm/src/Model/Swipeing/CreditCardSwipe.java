package Model.Swipeing;

import Model.Generation.Card;
import Model.Generation.Customer;
import Model.Generation.Server;
import Model.Verification.DataValidation;
import Model.Verification.DataVerification;
import Model.Verification.Validation;
import Model.Verification.Verification;

public class CreditCardSwipe {
    DataVerification verify=new Verification();
    DataValidation validating=new Validation();
    Server server= Server.getServer();

    public void creditCardSwiping()
    {
        long cardNumber= verify.verification(Card.CardType.CREDITCARD);
        if(cardNumber!=0) {
            System.out.println("Enter the purchase amount(limit -100000):");
            long amount = validating.validation("Amount");

            for(Customer list:server.getList1())
            {
                if(list.getAccounts().getCreditCard().getCardNumber()==cardNumber)
                {
                 list.getAccounts().getCreditCard().setCreditCardDue(list.getAccounts().getCreditCard().getCreditCardDue()+amount-(int)(amount*0.01));
                    System.out.println("purchase is successfully");
                    System.out.println("Cashback:"+amount*0.01);
                    System.out.println("Credit card Due:"+list.getAccounts().getCreditCard().getCreditCardDue());
                }
            }

        }
        else
        {
            System.out.println("Invalid details");
        }

    }
}

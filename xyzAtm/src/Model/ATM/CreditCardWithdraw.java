package Model.ATM;


import Model.Generation.Card;
import Model.Generation.Customer;
import Model.Generation.Server;
import Model.Verification.DataValidation;
import Model.Verification.DataVerification;
import Model.Verification.Validation;
import Model.Verification.Verification;

public class CreditCardWithdraw implements CreditCardAmountWithdraw {
 DataVerification verify=new Verification();
 DataValidation validating=new Validation();
 Server server= Server.getServer();
public void creditCardWithdraw()
    {
        long cardNumber= verify.verification(Card.CardType.CREDITCARD);
        if(cardNumber!=0) {
            System.out.println("Enter the withdraw amount(limit -100000):");

            long amount=validating.validation("Amount");
            if(amount<=100000) {
                for (Customer list: server.getList1()) {
                    if (list.getAccounts().getCreditCard().getCardNumber() == cardNumber) {
                        if(amount<=100) {
                           list.getAccounts().getCreditCard().setCreditCardDue(list.getAccounts().getCreditCard().getCreditCardDue() +amount + (int) (amount * 0.02));
                            System.out.println("Amount is withdrawn");
                            System.out.println("Tax:" + amount * 0.02);
                        }
                        else {
                            list.getAccounts().getCreditCard().setCreditCardDue(list.getAccounts().getCreditCard().getCreditCardDue() +amount + (int) (amount * 0.04));
                            System.out.println("Amount is withdrawn");
                            System.out.println("Amount is withdrawn");
                            System.out.println("Tax:" + amount * 0.04);
                        }
                        System.out.println("Credit card Due:" +list.getAccounts().getCreditCard().getCreditCardDue());
                    }
                }
            }

        }
        else
        {
            System.out.println("Invalid details");
        }
    }


}

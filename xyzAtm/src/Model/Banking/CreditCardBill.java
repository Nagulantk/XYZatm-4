package Model.Banking
        ;


import Model.Generation.Card;
import Model.Generation.Customer;
import Model.Generation.Server;
import Model.Verification.DataVerification;
import Model.Verification.Verification;

public class CreditCardBill {
    DataVerification verify=new Verification();
    Server server= Server.getServer();
    public void billPayment() {
        long cardNumber = verify.verification(Card.CardType.CREDITCARD);
        if (cardNumber != 0) {
            for (Customer list : server.getList1()) {
                if (list.getAccounts().getCreditCard().getCardNumber() == cardNumber) {
                    if (list.getAccounts().getCreditCard().getCreditCardDue() <= list.getAccounts().getBalance()) {
                        list.getAccounts().setBalance(list.getAccounts().getBalance() - list.getAccounts().getCreditCard().getCardNumber());
                        list.getAccounts().getCreditCard().setCreditCardDue(0);
                        System.out.println("Bill payment is SuccessFull");
                        System.out.println("Remaining balance in the account:" + list.getAccounts().getBalance());
                    } else {
                        System.out.println("Insufficient balance in the account");
                    }
                }
            }
        }
        else {
            System.out.println(" Invalid details is entered");
        }
    }
}

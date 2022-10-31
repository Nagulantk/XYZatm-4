package Model.Swipeing;


import Model.Generation.Accounts;
import Model.Generation.Card;
import Model.Generation.Customer;
import Model.Generation.Server;
import Model.Verification.DataValidation;
import Model.Verification.DataVerification;
import Model.Verification.Validation;
import Model.Verification.Verification;

public class DebitCardSwipe {
    DataVerification verify = new Verification();
   DataValidation validating = new Validation();

    Accounts account;
    Server server=Server.getServer();

    public void swipe() {
        long accountNumber = verify.verification(Card.CardType.DEBITCARD);
        if (accountNumber != 0) {

            long amount = validating.validation("Purchase Amount");
            for(Customer list:server.getList1()) {
                if (list.getAccounts().getAccountNumber() == accountNumber) {
                    account = list.getAccounts();
                }
            }
            if (amount <= account.getBalance()) {
                account.setBalance(account.getBalance()-amount+(long)(amount*0.01));
                System.out.println("purchase is successfully");
                System.out.println("Cashback:" + amount * 0.01);
                System.out.println("Balance:" + account.getBalance());
            } else {
                System.out.println("Insufficient balance");
            }
        } else {
            System.out.println("Invalid details");
        }
    }
}

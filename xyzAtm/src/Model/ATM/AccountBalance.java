package Model.ATM;

import Model.Generation.Accounts;
import Model.Generation.Card;
import Model.Generation.Customer;
import Model.Generation.Server;
import Model.Verification.DataVerification;
import Model.Verification.Verification;

public class AccountBalance implements Balance {
    DataVerification verify = new Verification();
    Accounts account;
    Server server = Server.getServer();

    public Accounts getBalance() {
        long accountNumber = verify.verification(Card.CardType.DEBITCARD);
        if (accountNumber != 0) {
            for (Customer list : server.getList1()) {
                if (list.getAccounts().getAccountNumber() == accountNumber) {
                    account = list.getAccounts();
                }
            }

        }
        return account;
    }
}

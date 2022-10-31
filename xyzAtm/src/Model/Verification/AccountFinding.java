package Model.Verification;


import Model.Generation.Accounts;
import Model.Generation.Customer;
import Model.Generation.Server;

public class AccountFinding {

    DataValidation validating=new Validation();
    Server server=Server.getServer();
    public Accounts findingAccount() {

        long accountNumber = validating.validation("Account number");
        if (accountNumber != 0) {
            for (Customer list : server.getList1()) {
                if (list.getAccounts().getAccountNumber() == accountNumber) {
                    return list.getAccounts();
                }
            }
        }
        System.out.println("No account found");

        return null;
    }
}

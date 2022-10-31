package Model.ATM;


import Model.Generation.Accounts;
import Model.Generation.Card;
import Model.Generation.Customer;
import Model.Generation.Server;
import Model.Verification.DataValidation;
import Model.Verification.DataVerification;
import Model.Verification.Validation;
import Model.Verification.Verification;

public class Deposit implements AmountDeposit {

    DataVerification verify=new Verification();
    DataValidation validating=new Validation();
Accounts account;
Server server=Server.getServer();
    public void deposit()
    {long accountNumber=  verify.verification(Card.CardType.DEBITCARD);
        if(accountNumber!=0)
        {
            for(Customer list:server.getList1()) {
            if (list.getAccounts().getAccountNumber() == accountNumber) {
                account = list.getAccounts();
            }
          }
            long amount=validating.validation("Amount");
          account.setBalance(account.getBalance()+amount);
            System.out.println("Amount is deposited successfully");
            System.out.println("Balance:"+ account.getBalance());
        }
        else
        {
            System.out.println("Invalid details");
        }
    }

}

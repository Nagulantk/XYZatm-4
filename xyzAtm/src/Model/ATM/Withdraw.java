package Model.ATM;

import Model.Generation.Accounts;
import Model.Generation.Card;
import Model.Generation.Customer;
import Model.Generation.Server;
import Model.Verification.DataValidation;
import Model.Verification.DataVerification;
import Model.Verification.Validation;
import Model.Verification.Verification;

public class Withdraw implements AmountWithdraw {

    DataVerification verify=new Verification();
    DataValidation validating =new Validation();
    Accounts account;
    Server server=Server.getServer();
    public void withdraw()
    {
        float tax;
        long accountNumber= verify.verification(Card.CardType.DEBITCARD );
        if(accountNumber!=0)
        {

            long amount=validating.validation("Amount");
            for(Customer list:server.getList1()) {
                if (list.getAccounts().getAccountNumber() == accountNumber) {
                    account = list.getAccounts();
                }
            }
            if(amount%5==0&&amount<= account.getBalance())
            {
                if(amount<=100)
                {
                    tax=0.02f;
                }
                else {
                    tax=0.04f;
                }
               account.setBalance(account.getBalance()-amount-(long)(amount*tax));
                System.out.println("Amount is withdrawn successfully");
                System.out.println("Balance:" +  account.getBalance());
                System.out.println("Tax:"+amount*tax);

            }
            else
            {
                System.out.println("Insufficient balance or Enter amount divisible by 5");
            }
        }
        else
        {
            System.out.println("Invalid details");
        }
    }
}

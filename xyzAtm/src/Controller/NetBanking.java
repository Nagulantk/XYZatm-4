package Controller;
import Model.Generation.Accounts;
import Model.Generation.Customer;
import Model.Banking.CustomerDetails;
import Model.Generation.CreditCard;

import Model.Banking.CreditCardBill;
import Model.Verification.AccountFinding;
import Model.Generation.AccountGeneration;
import View.*;
public class NetBanking {
    enum BankAction
    {
        ACCOUNTGENERATION,
        CREDITCARDGENERATION,
        CREDITCARDPAYMENT,
        GETCUSTOMERDETAILS,


    }
    AccountGeneration accountGeneration=new AccountGeneration();
    private NetBanking(){}
    private static NetBanking bank=new NetBanking();


    public void bankWorking()
    {
      BankAction bankAction;
        Process process=new Process();

        DisplayMenu displayMenu=new BankDisplayMenu();
        displayMenu.displayMenu();
        bankAction= (BankAction) process.getProcess("BankMenu");
        switch (bankAction) {
            case ACCOUNTGENERATION:
                Accounts accounts=accountGeneration.accountGeneration(accountGeneration);
                AccountDetails accountDetails=new AccountDetails();
                accountDetails.printDetails(accounts);
                break;
            case CREDITCARDGENERATION:
                AccountFinding finding = new AccountFinding();
                Accounts account = finding.findingAccount();
                if(account!=null) {
                    CreditCard creditCard = account.setCreditCard(account, accountGeneration);
                    CreditCardDetailsDisplay creditCardDetailsDisplay = new CreditCardDetailsDisplay();
                    creditCardDetailsDisplay.displayDetails(creditCard);
                }

                break;
            case CREDITCARDPAYMENT:
                CreditCardBill bill = new CreditCardBill();
                bill.billPayment();
                break;
            case GETCUSTOMERDETAILS:
                CustomerDetails customerDetails=new CustomerDetails();
                Customer customer=customerDetails.getDetails();
                CustomerDetailsDisplay customerDetailsDisplay=new CustomerDetailsDisplay();
                customerDetailsDisplay.displayDetails(customer);


        }
    }
    public static NetBanking getBank()
    {
        return bank;
    }

}

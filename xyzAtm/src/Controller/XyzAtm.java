package Controller;

import Model.ATM.*;
import Model.Generation.Accounts;
import Model.Generation.Card;
import Model.Generation.CreditCard;
import View.*;

public class XyzAtm {
    enum AtmActions
    {
        DEPOSIT,
        WITHDRAW,
        GETBALANCE,
        CREDITCARDDUE
    }

   AmountWithdraw withdraw=new Withdraw();
   AmountDeposit deposit=new Deposit();
    CreditCardDueBalance due=new CreditCardDue();
   Balance balance=new AccountBalance();
   CreditCardAmountWithdraw creditCardWithdraw=new CreditCardWithdraw();
   Process process=new Process();
   public void AtmWorking()
   {

       AtmActions action;
       DisplayMenu displayMenu=new ATMDisplayMenu();
       displayMenu.displayMenu();
       action= (AtmActions) process.getProcess("ATMMenu");

       switch(action)
       {
           case DEPOSIT:
               deposit.deposit();
               break;
           case WITHDRAW:
               System.out.println("Withdraw using Debit card or Credit card:");
              Card.CardType cardType;
               cardType= (Card.CardType) process.getProcess("CardType");
               switch (cardType) {
                   case DEBITCARD:
                     withdraw.withdraw();
                       break;
                   case CREDITCARD:
                     creditCardWithdraw.creditCardWithdraw();
                       break;
               }
               break;
           case GETBALANCE:
               Accounts account= balance.getBalance();
               DisplayBalance displayBalance=new DisplayBalance();
               displayBalance.balanceDisplay(account);

               break;
           case CREDITCARDDUE:
             CreditCard creditCard=due.creditCardDueBalance();
             if(creditCard!=null)
             {
                 CreditCardDueDisplay creditCardDueDisplay=new CreditCardDueDisplay();
                 creditCardDueDisplay.displayCreditCardDue(creditCard);
             }
               break;
       }

   }


}

package Controller;


import Model.Generation.Card;
import Model.Swipeing.CreditCardSwipe;
import Model.Swipeing.DebitCardSwipe;


public class SwipeMachine {
    DebitCardSwipe debitCardSwipe=new DebitCardSwipe();
   CreditCardSwipe creditCardSwipe=new CreditCardSwipe();
   Process process=new Process();
   public void swipeMachineWork()
   {
       Card.CardType cardType;
       System.out.println("Swipe using Debit card or Credit card:");
       cardType= (Card.CardType) process.getProcess("CardType");
       switch (cardType) {
           case DEBITCARD:
              debitCardSwipe.swipe();
               break;
           case CREDITCARD:
              creditCardSwipe.creditCardSwiping();
               break;
       }
   }
}

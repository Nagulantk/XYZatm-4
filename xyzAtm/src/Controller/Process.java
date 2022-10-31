package Controller;
import Model.Generation.Card;
import View.ATMDisplayMenu;
import View.DisplayMenu;
import View.BankDisplayMenu;

import java.util.Scanner;
public class Process {

    public  Enum getProcess(String process) {
        Scanner input = new Scanner(System.in);
        XyzAtm.AtmActions atmAction;

        Card.CardType cardType;
        NetBanking.BankAction bankAction;
        String work = input.nextLine();
        work = work.toUpperCase();

        if (process.equals("ATMMenu")) {
            DisplayMenu displayMenu=new ATMDisplayMenu();

            try {
                atmAction = XyzAtm.AtmActions.valueOf(work);
                return atmAction;
            } catch (Exception e) {

                System.out.println("Please enter valid process");
                displayMenu.displayMenu();
                return getProcess("ATMMenu");
            }
        }
        if (process.equals("CardType")) {
            try {
                cardType = Card.CardType.valueOf(work);

                return cardType;
            } catch (Exception e) {

                System.out.println("Please enter valid process");

                return getProcess("CardType");
            }
        }
        if (process.equals("BankMenu")) {
            DisplayMenu displayMenu=new BankDisplayMenu();

            try {
                bankAction = NetBanking.BankAction.valueOf(work);
                return bankAction;
            }
            catch (Exception e) {

                System.out.println("Please enter valid process");
                displayMenu.displayMenu();
                return getProcess("BankMenu");
            }
        }
      return null;
    }
}

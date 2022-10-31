
import Controller.NetBanking;
import Controller.SwipeMachine;
import Controller.XyzAtm;
import java.util.Scanner;

public class Main {

    public  enum Action {
       BANKING,
        ATM,
        SWIPE,
        EXIT
     }

    public static void main(String[] args) {
        boolean condition=true;
        SwipeMachine machine=new SwipeMachine();
        Action action;
        while (condition) {

            action= getProcess();

            switch (action) {

                case ATM:
                    XyzAtm atm=new XyzAtm();
                    atm.AtmWorking();
                    break;
                case BANKING:
                 NetBanking bank=NetBanking.getBank();
                 bank.bankWorking();
                    break;
                    case SWIPE:
                  machine.swipeMachineWork();
                      break;
                    case EXIT:condition=false;
                    System.out.println("Thank you");
                    break;
                default:System.out.println("Enter a valid request");
                break;
            }
        }
    }
    public static void displayMenu()
    {
        System.out.println("Enter the action to be performed:");
        System.out.println("Banking");
        System.out.println("ATM");
        System.out.println("Swipe");
        System.out.println("Exit");
    }
public static Action getProcess()
{Action action;
       displayMenu();
       Scanner input=new Scanner(System.in);
       String work=input.nextLine();
    work = work.toUpperCase();
        try {
            action = Action.valueOf(work);
            return action;
        } catch (Exception e) {

            System.out.println("Please enter valid process");
           return getProcess();

        }


}
}

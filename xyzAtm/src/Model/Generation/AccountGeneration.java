package Model.Generation;
import Model.Verification.DataValidation;
import Model.Verification.DateVerification;
import Model.Verification.Validation;
import Model.Verification.VerifyDate;
import java.time.*;
import java.util.*;public class AccountGeneration {
    Scanner input=new Scanner(System.in);
    DataValidation validating=new Validation();
    DateVerification dateVerification=new VerifyDate();
    int generatingAccountNumber=1000000;
     int generatingDebitCardNumber=10000;
     int generatingCreditCardNumber=22334455;
     int generatingCcv=300;
     int generatingPin=1000;
    Accounts accounts;
    Customer customer;
    Server server= Server.getServer();
    public Accounts accountGeneration(AccountGeneration generation)
    {   System.out.println("Enter Name:");
        String name=input.nextLine();
        long phoneNumber=validating.validation("Phone number");
        LocalDate dateOfBirth=dateVerification.verifyDate();

        System.out.println(dateOfBirth);

        long panNumber=validating.validation("Pan card Number");
        long balance=validating.validation("Balance");

       String newPassword;
       String password;
        do {
            System.out.println("Enter password");
            password = input.nextLine();
            System.out.println("ReEnter password");
           newPassword = input.nextLine();
            if(!password.equals(newPassword))
            {
                System.out.println("Reentered password is not same as password");
            }
        }while(!password.equals(newPassword));


        accounts=new Accounts(balance,generation.generatingAccountNumber,generation);
       customer=new Customer(name,panNumber,dateOfBirth,phoneNumber,password,accounts);
       server.setList1(customer);
       generation.generatingDebitCardNumber++;
      generation.generatingPin++;
      generation.generatingCcv++;
       generation.generatingAccountNumber++;
       return  accounts;
    }
}



package Model.Banking;
import Model.Generation.Customer;
import Model.Generation.Server;
import Model.Verification.DataValidation;
import Model.Verification.Validation;

import java.util.Scanner;
public class CustomerDetails {
    DataValidation validating=new Validation();
    public Customer getDetails()
    {Scanner input=new Scanner(System.in);
        Server server=Server.getServer();
        System.out.println("Enter customer Name");
        String name=input.nextLine();
        long phoneNumber=validating.validation("Phone number");
        System.out.println("Enter password");
        String password=input.nextLine();
        for(Customer customer:server.getList1())
        {
            if(customer.getName().equals(name)&&customer.getPhoneNumber()==phoneNumber&&customer.getPassword().equals(password))
            {
                return customer;
            }
        }
        return null;
    }
}

package View;

import Model.Generation.Accounts;

public class DisplayBalance {
public void balanceDisplay(Accounts account)
{
    if(account!=null)
    {
        System.out.println("Balance:"+account.getBalance());
        }
    else
    {
        System.out.println("Enter valid details");
    }
}
}

package Model.Generation;



import Model.Generation.Accounts;

import java.time.LocalDate;

public class Customer {
    private String name;
    private long panNumber;
    private LocalDate dateOfBirth;
    private String password;

    public String getName() {
        return name;
    }

    public long getPanNumber() {
        return panNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPassword() {
        return password;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    private long phoneNumber;
    private Accounts accounts;
     Customer(String name,long panNumber,LocalDate dateOfBirth,long phoneNumber,String password,Accounts accounts)
    {
        this.name=name;
        this.panNumber=panNumber;
        this.dateOfBirth=dateOfBirth;
        this.phoneNumber=phoneNumber;
        this.accounts=accounts;
        this.password=password;
    }
    public Accounts getAccounts() {
        return accounts;
    }


}

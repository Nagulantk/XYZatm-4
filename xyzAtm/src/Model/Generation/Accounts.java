package Model.Generation;

public class Accounts {
    private final long accountNumber;
    private long balance;
    private Card debitCard;
    private CreditCard creditCard;

   public Accounts(long balance, long accountNumber, AccountGeneration generation)
    {

        this.balance=balance;
        this.accountNumber=accountNumber;
        DebitCardGeneration cardGeneration=new DebitCardGeneration();
       this.debitCard= cardGeneration.generation(balance,generation);


    }
    public long getAccountNumber()
    {
        return accountNumber;
    }
    public long getBalance()
    {
        return balance;
    }
    public void setBalance(long balance)
    {
   this.balance=balance;
    }
    public Card getDebitCard() {
        return debitCard;
    }
    public CreditCard getCreditCard() {
        return creditCard;
    }

    public CreditCard setCreditCard(Accounts accounts,AccountGeneration generation)
    {
        CreditCardGeneration cardGeneration=new CreditCardGeneration();
        this.creditCard=cardGeneration.creditCardGeneration(accounts,generation);
        return creditCard;
    }



}





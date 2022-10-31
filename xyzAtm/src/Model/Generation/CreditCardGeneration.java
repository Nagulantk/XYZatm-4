package Model.Generation;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class CreditCardGeneration {
    public CreditCard creditCardGeneration(Accounts accounts,AccountGeneration generation) {

            Date date1=new Date();
            SimpleDateFormat dateForm=new SimpleDateFormat("yyyy-MM-dd");
            String d=dateForm.format(date1);
            LocalDate dateOf=LocalDate.parse(d);
            LocalDate expiryDate=dateOf.plusYears(5);
            String cardType;
            cardType = accounts.getDebitCard().getCardType();
            CreditCard card = new CreditCard(generation.generatingCreditCardNumber++, generation.generatingPin++, generation.generatingCcv++, expiryDate,cardType);

            return  card;

    }
}

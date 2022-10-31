package Model.Generation;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class DebitCardGeneration {

    public Card generation(long balance, AccountGeneration generation)
    { Date date1=new Date();
        SimpleDateFormat dateForm=new SimpleDateFormat("yyyy-MM-dd");
        String d=dateForm.format(date1);
        LocalDate dateOf=LocalDate.parse(d);
        LocalDate expiryDate=dateOf.plusYears(5);
        String cardType;
        if(balance<100000)
        {
            cardType="Visa Classic";
        }
        else if(balance>=100000&&balance<1000000)
        {
            cardType="visa Gold";
        }
        else {
            cardType="Visa Platinum";
        }
        Card card=new DebitCard(generation.generatingDebitCardNumber,generation.generatingPin,generation.generatingCcv,expiryDate,cardType);

        return card;
    }
}

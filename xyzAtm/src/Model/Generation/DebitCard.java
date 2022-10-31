package Model.Generation;
import java.time.LocalDate;
public class DebitCard extends Card {
     DebitCard(int cardNumber, int pin, int ccv,LocalDate expiryDate,String cardType)
    {
        super( cardNumber, pin, ccv,expiryDate,cardType);
    }
}

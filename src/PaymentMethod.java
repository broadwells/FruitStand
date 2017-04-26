/**
 * Created by broadwells on 4/26/17.
 */
public class PaymentMethod {
    double cash;
    int checkNum;
    long creditCard;
    int cvv;
    String expDate;


    public PaymentMethod(double cash, int checkNum, long creditCard, int cvv) {
        this.cash = cash;
        this.checkNum = checkNum;
        this.creditCard = creditCard;
        this.cvv = cvv;
        //this.expDate = expDate;
    }
}

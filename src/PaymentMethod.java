import java.util.Scanner;

/**
 * Created by broadwells on 4/26/17.
 */
public class PaymentMethod {
    double cash;
    long checkNum;
    String creditCard;
    String cvv;
    int month;
    int year;


    public PaymentMethod(double cash) { //FIXME maybe?
        this.cash = cash;
    }

    public PaymentMethod(long checkNum) {
        this.checkNum = checkNum;
    }

    public PaymentMethod(String creditCard) {
        this.creditCard = creditCard;
    }

    public PaymentMethod() {
    }

    public PaymentMethod(String cvv, int month, int year) {
        this.cvv = cvv;
        this.month = month;
        this.year = year;
    }

    public double getCash() {
        return cash;
    }

    public long getCheckNum() {
        return checkNum;
    }

    public boolean validCheck(long checkNum){
        String check = String.valueOf(checkNum);
        boolean valid;
        if (check.length() == 12){
            valid = true;
        }
        else {
            System.out.println("Invalid check number. Please try again or select another payment method.");
            valid = false;
        }
        return valid;
    }

    public String checkCreditNum(String creditCardNum) {
        String cardCompany = "";
        if (creditCardNum.startsWith("4")) {
            cardCompany = "Visa";
        }
        else if (creditCardNum.startsWith("5")) {
            cardCompany = "MasterCard";
        }
        else if (creditCardNum.startsWith("6")) {
            cardCompany = "Discover";
        }
        else if (creditCardNum.startsWith("34") || creditCardNum.startsWith("37")) {
            cardCompany = "Amex";
        }
        return cardCompany;
    }

    public boolean validCCNum(String creditCardNum) {
        boolean valid;
        if (creditCardNum.startsWith("4")) {
            valid = false;
        }
        else if (creditCardNum.startsWith("5")) {
            valid = false;
        }
        else if (creditCardNum.startsWith("6")) {
            valid = false;
        }
        else if (creditCardNum.startsWith("34") || creditCardNum.startsWith("37")) {
            valid = false;
        } else {
            System.out.println("Invalid Number");
            valid = true;
        }
        return valid;
    }

    public String checkCvvNum(Scanner s, String cardComp) {
        String cvvNumInt = "";
        boolean valid = false;
        while (!valid) {
            System.out.println("Please enter CVV: ");
            String cvvNum = s.nextLine();
            if (cvvNum.length() == 3 && cardComp.equalsIgnoreCase("Visa") || cardComp.equalsIgnoreCase
                    ("MasterCard") || cardComp.equalsIgnoreCase("Discover")) {
                valid = true;
                cvvNumInt = cvvNum;
            } else if (cvvNum.length() == 4 && cardComp.equalsIgnoreCase("Amex")) {
                valid = true;
                cvvNumInt = cvvNum;
            } else {
                System.out.println("Invalid number, please enter valid number.");
                valid = false;
            }
        }
        return cvvNumInt;
    }

    public static String formatDate(int month, int year) {
        String monthDate = String.valueOf(month);
        String yearDate = String.valueOf(year);
        String date = monthDate + "/" + yearDate;
        return date;
    }

    public boolean validDate (int month, int year){
        boolean valid = true;
        if (month <= 4 && year <= 2017){
            System.out.println("Invalid exp date. Please user a valid credit card or select another method of payment");
            valid = true;
        }
        else if (month >= 1 || month <= 12){
            valid = false;
        }
        else if (month >= 5 && year == 2017){
            valid = false;
        }
        else if (year >= 2018){
            valid = false;
        }
        return valid;
    }

    public static String maskNumber(String number, String mask){
        int index = 0;
        StringBuilder maskedNum = new StringBuilder();
        for (int i = 0; i < mask.length(); i++){
            char c = mask.charAt(i);
            if (c == '#'){
                maskedNum.append(number.charAt(index));
                index++;
            }
            else if (c == 'x') {
                maskedNum.append(c);
                index++;
            }
            else {
                maskedNum.append(c);
            }
        }
        return maskedNum.toString();
    }
}

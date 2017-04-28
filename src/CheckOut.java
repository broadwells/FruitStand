//author: Stephanie Broadwell

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Created by broadwells on 4/26/17.
 */
public class CheckOut {
    BigDecimal totalAmount = new BigDecimal(0.00);
    BigDecimal changeDue = new BigDecimal(0.00);
    BigDecimal userChange = new BigDecimal(0.00);
    PaymentMethod cash, mask, check, cardInfo;
    String payType;
    String cardType, cardNum, cvvThree, cvvFour;
    int monthDate, yearDate;

    public BigDecimal calculateGrandTotal(double itemPrice) {
        BigDecimal grandTotal = new BigDecimal(0.00);
        grandTotal = grandTotal.add(BigDecimal.valueOf(itemPrice));
        return grandTotal;
    }

    public BigDecimal calculateChange(double cash, BigDecimal totalBill) {
        BigDecimal cashAmount = BigDecimal.valueOf(cash);

        if (cashAmount.compareTo(totalBill) == 1 || cashAmount.compareTo(totalBill) == 0) {
            changeDue = cashAmount.subtract(totalBill);
        }
        return changeDue;
    }

    public boolean validCashForChange(double cash, BigDecimal totalBill) {
        BigDecimal cashAmount = BigDecimal.valueOf(cash);
        boolean valid;

        if (cashAmount.compareTo(totalBill) == 1 || cashAmount.compareTo(totalBill) == 0) {
            valid = false;
        }
        else {
            System.out.println("That is not enough cash, please add more money or try different pay method.");
            valid = true;
        }
        return valid;
    }

    public void promptPayment(Scanner scan, ArrayList<CartItem> shoppingCart) {
        CheckOut grandTotal = new CheckOut();
        CheckOut changeBack = new CheckOut();
        double totalPrice = 0.00;

        for (int i = 0; i < shoppingCart.size(); i++) {
            totalPrice += shoppingCart.get(i).getPrice();
        }
        totalAmount = grandTotal.calculateGrandTotal(totalPrice);
        System.out.println("Grand Total is: $" + totalAmount);

        boolean validInput = true;
        while (validInput) {
            System.out.println("Cash, check, or credit card?");
            payType = scan.nextLine();

            if (payType.equalsIgnoreCase("cash")) {
                System.out.println("Please enter amount you will be paying with: ");
                double cashMethod = scan.nextDouble();
                cash = new PaymentMethod(cashMethod);
                validInput = changeBack.validCashForChange(cash.getCash(), totalAmount);
                userChange = changeBack.calculateChange(cash.getCash(), totalAmount);
                scan.nextLine();
            }
            else if (payType.equalsIgnoreCase("check")) {
                System.out.println("Please enter the check number: ");
                long checkMethod = scan.nextLong();
                check = new PaymentMethod(checkMethod);
                validInput = check.validCheck(checkMethod);
                scan.nextLine();
            }
            else if (payType.equalsIgnoreCase("credit card")) {
                System.out.println("Enter credit card num: ");
                cardNum = scan.nextLine();
                PaymentMethod creditCard = new PaymentMethod(cardNum);
                PaymentMethod cvvNum = new PaymentMethod();
                cardType = creditCard.checkCreditNum(cardNum);
                switch (cardType) {
                    case "Visa":
                    case "Mastercard":
                    case "Discover":
                        cvvThree = cvvNum.checkCvvNum(scan, cardType);
                        System.out.println("Please enter month of expiration date of credit card: (mm) ");
                        monthDate = scan.nextInt();
                        System.out.println("Please enter year of expiration date of credit card: (yyyy) ");
                        yearDate = scan.nextInt();
                        cardInfo = new PaymentMethod(cvvThree, monthDate, yearDate);
                        validInput = cardInfo.validDate(monthDate, yearDate);
                        scan.nextLine();
                        break;
                    case "Amex":
                        cvvFour = cvvNum.checkCvvNum(scan, cardType);
                        System.out.println("Please enter month of expiration date of credit card: (mm) ");
                        monthDate = scan.nextInt();
                        System.out.println("Please enter year of expiration date of credit card: (yyyy) ");
                        yearDate = scan.nextInt();
                        cardInfo = new PaymentMethod(cvvFour, monthDate, yearDate);
                        validInput = cardInfo.validDate(monthDate, yearDate);
                        scan.nextLine();
                        break;
                }
            }
        }

    }

    public void printReceipt(ArrayList<CartItem> shoppingCart) {
        System.out.println("Your receipt: \nItems purchased:");
        for (CartItem i : shoppingCart) {
            System.out.println("\t" + i);
        }
        System.out.println("Grand Total: " + totalAmount);
        System.out.println(payType);
        if (payType.equalsIgnoreCase("cash")) {
            System.out.println("Amount paid: $" + cash.getCash() + "\nChange due: $" + userChange);
        } else if (payType.equalsIgnoreCase("check")) {
            System.out.println(mask.maskNumber(String.valueOf(check.getCheckNum()), "xxxxxxxx####"));
        } else if (payType.equalsIgnoreCase("credit card")) {
            switch (cardType) {
                case "Visa":
                case "Mastercard":
                case "Discover":
                    System.out.println(cardType + " " + mask.maskNumber(cardNum, "xxxx-xxxx-xxxx-####") + " CVV: " +
                            mask.maskNumber(cvvThree, "xxx") + " Exp Date: " + cardInfo.formatDate(monthDate, yearDate));
                    break;
                case "Amex":
                    System.out.println(cardType + " " + mask.maskNumber(cardNum, "xxxx-xxxxxx-x####") + " CVV: " +
                            mask.maskNumber(cvvFour, "xxxx") + " Exp Date: " + cardInfo.formatDate(monthDate, yearDate));
                    break;
            }
        }
        System.out.println("Thank you for shopping at Detroit Rock Fruit Stand!\n");
    }

}

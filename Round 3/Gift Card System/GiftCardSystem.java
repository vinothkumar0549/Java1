import java.util.LinkedHashMap;

public class GiftCardSystem {

    LinkedHashMap<Integer, Customer> customerdetail = new LinkedHashMap<>();
    LinkedHashMap<Integer, GiftCard> giftcardDetails = new LinkedHashMap<>();

    static GiftCardSystem giftcardinstance = null;

    public static GiftCardSystem getInstance() {
        if (giftcardinstance == null) {
            giftcardinstance = new GiftCardSystem();
        }
        return giftcardinstance;
    }

    public void addToCustomer(int customerid, int accountno, String name, int balance, String password) {
        String encryptedpassword = encryptPassword(password);
        Customer customer = new Customer(customerid, accountno, name, balance, encryptedpassword);
        customerdetail.put(customerid, customer);
    }

    public String encryptPassword(String password) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < password.length(); i++) {
            if ((password.charAt(i) >= 65 && password.charAt(i) <= 90)
                    || (password.charAt(i) >= 97 && password.charAt(i) <= 122)
                    || (password.charAt(i) >= 48 && password.charAt(i) <= 57)) {
                if (password.charAt(i) == 'Z') {
                    builder.append('A');
                } else if (password.charAt(i) == 'z') {
                    builder.append('a');
                } else if (password.charAt(i) == '9') {
                    builder.append('0');
                } else {
                    builder.append((char) (password.charAt(i) + 1));
                }
            } else {
                System.out.println("Password must contains a-z A-Z 0-9");
                return "";
            }
        }
        return builder.toString();
    }

    public void printDetails() {
        System.out.printf(" | %-15s | %-15s | %-15s | %-10s | %-20s |\n", "Customer Id", "Account No", "Name",
                "Balance",
                "Encrypt Password");
        for (Customer customer : customerdetail.values()) {
            customer.display();
        }
    }

    public boolean loginUser(int id, String password) {
        if (customerdetail.get(id) == null) {
            return false;
        } else if (customerdetail.get(id).getEncryptedPassword().equals(encryptPassword(password))) {
            return true;
        }
        return false;
    }

    public Customer getCustomer(int customerid) {
        return customerdetail.get(customerid);
    }

    public int createNewCard(int pin, Customer customer) {
        GiftCard giftcard = new GiftCard(pin, 0, customer.getAccountNo());
        int cardno = giftcard.getCardNo();
        customer.setGiftCards(cardno, giftcard);
        giftcardDetails.put(cardno, giftcard);
        return cardno;
    }

    public void addTopUp(int cardno, int pin, int amount, Customer customer) {
        GiftCard giftcard = customer.getGiftCards().get(cardno);
        if (giftcard != null) {
            if (giftcard.getCardPin() == pin) {
                if (customer.getBalance() - amount >= 0) {
                    giftcard.setCardBalance(giftcard.getCardBalance() + amount);
                    customer.setBalance(customer.getBalance() - amount);
                    System.out
                            .println("The Amount " + amount + " added to the GiftCard " + giftcard);
                    giftcard.setTransactionHistory("Debit: " + amount);
                } else {
                    System.out.println("Not Sufficient Balance");
                }
            } else {
                System.out.println("InCorrect Pin");
            }
        } else {
            System.out.println("Gift Card not Exist");
        }
    }

    public boolean showCardDetials(Customer customer) {
        if (customer.getGiftCards().size() == 0) {
            return false;
        }
        for (GiftCard giftCard : customer.getGiftCards().values()) {
            System.out.println(giftCard.toString());
        }
        return true;
    }

    public void showCardTransactionDetails(int cardno, Customer customer) {
        GiftCard giftcard = customer.getGiftCards().get(cardno);
        if (giftcard != null) {
            System.out.println("The Transaction History: " + giftcard.getCardNo());
            for (String transaction : giftcard.getTransactionHistory()) {
                System.out.println(transaction);
            }
        } else {
            System.out.println("Invalid Card Number");
        }
    }

    public void blockCard(int cardno, int pin, Customer customer) {
        GiftCard giftcard = customer.getGiftCards().get(cardno);
        if (giftcard != null) {
            if (giftcard.getCardPin() == pin) {
                customer.setBalance(customer.getBalance() + giftcard.getCardBalance());
                customer.getGiftCards().remove(cardno);
                giftcardDetails.remove(cardno);
                System.out.println("The Card No " + cardno + " is Blocked");
            } else {
                System.out.println("Pin is Not Match");
            }
        } else {
            System.out.println("Card No is not Valid");
        }
    }

    public void purchase(int bill, int cardno, int pin) {
        GiftCard giftcard = giftcardDetails.get(cardno);
        if (giftcard != null) {
            if (giftcard.getCardPin() == (pin)) {
                if (giftcard.getCardBalance() - bill > 0) {
                    giftcard.setCardBalance(giftcard.getCardBalance() - bill);
                    giftcard.getTransactionHistory().add("Credit " + bill);
                    System.out.println("Successfully Purchase");
                    System.out.println("Available Balance: " + giftcard.getCardBalance());
                } else {
                    System.out.println("Insufficient Balance");
                }
            } else {
                System.out.println("Pin is Not Match");
            }
        } else {
            System.out.println("Gift Card Not Found");
        }
    }

}

import java.util.Map;
import java.util.LinkedHashMap;

public class Customer {

    private int customerid;
    private int accountno;
    private String name;
    private int balance;
    private String encryptedpassword;
    private Map<Integer, GiftCard> giftcards = new LinkedHashMap<>();

    Customer(int customerid, int accountno, String name, int balance, String encryptedpassword) {
        this.customerid = customerid;
        this.accountno = accountno;
        this.name = name;
        this.balance = balance;
        this.encryptedpassword = encryptedpassword;
    }

    public int getCustomerId() {
        return customerid;
    }

    public int getAccountNo() {
        return accountno;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public String getEncryptedPassword() {
        return encryptedpassword;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setGiftCards(int cardno, GiftCard giftcard) {
        giftcards.put(cardno, giftcard);
    }

    public Map<Integer, GiftCard> getGiftCards() {
        return giftcards;
    }

    public void display() {
        System.out.printf(" | %-15d | %-15d | %-15s | %-10d | %-20s |\n", customerid, accountno, name, balance,
                encryptedpassword);
    }

}

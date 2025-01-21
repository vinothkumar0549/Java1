import java.util.ArrayList;

public class GiftCard {

    private static int cardnogenerator = 10001;
    private int cardaccountno;
    private int cardno;
    private int cardpin;
    private int cardbalance;
    ArrayList<String> transactionhistory;

    GiftCard(int cardpin, int cardbalance, int cardaccountno) {
        this.cardno = GiftCard.cardnogenerator++;
        this.cardaccountno = cardaccountno;
        this.cardpin = cardpin;
        this.cardbalance = cardbalance;
        this.transactionhistory = new ArrayList<>();
    }

    public int getCardNo() {
        return cardno;
    }

    public int getCardPin() {
        return cardpin;
    }

    public int getCardBalance() {
        return cardbalance;
    }

    public int getCardAccountNo() {
        return cardaccountno;
    }

    public void setCardBalance(int cardbalance) {
        this.cardbalance = cardbalance;
    }

    public void setTransactionHistory(String transaction) {
        transactionhistory.add(transaction);
    }

    public ArrayList<String> getTransactionHistory() {
        return transactionhistory;
    }

    public String toString() {
        return "Account No: " + cardaccountno + " Card No: " + cardno + " Card Pin: " + cardpin + " Card Balance: "
                + cardbalance;
    }
}

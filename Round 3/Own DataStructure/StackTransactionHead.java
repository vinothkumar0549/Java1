public class StackTransactionHead {

    static int size = 0;

    Node transactionhead;
    StackTransactionHead next = null;

    StackTransactionHead(Node transactionhead) {
        this.transactionhead = transactionhead;
        this.next = null;
        size++;
    }
}

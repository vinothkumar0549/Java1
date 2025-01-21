public class OwnDataStructure {

    Node head;
    Node Transactionhead;
    StackTransactionHead stacktransaction = null;

    OwnDataStructure() {
        this.head = null;
    }

    boolean set(char key, int value) {
        Node temp = head;
        while (temp != null) {
            if (temp.key == key) {
                if (Transactionhead != null) {
                    Node newTransactionNode = new Node(key, temp.value);
                    newTransactionNode.next = Transactionhead;
                    Transactionhead = newTransactionNode;
                }
                temp.value = value;
                return true;
            }
            temp = temp.next;
        }
        if (Transactionhead != null) {
            Node newTransactionNode = new Node(key, null);
            newTransactionNode.next = Transactionhead;
            Transactionhead = newTransactionNode;
        }
        Node newNode = new Node(key, value);
        newNode.next = head;
        head = newNode;
        return true;
    }

    Integer get(char key) {
        Node temp = head;
        if (temp == null) {
            return null;
        }
        while (temp != null) {
            if (temp.key == key) {
                return temp.value;
            }
            temp = temp.next;
        }
        return null;
    }

    boolean unSet(char key) {
        Node temp = head;
        if (temp == null) {
            return false;
        }
        while (temp != null) {
            if (temp.key == key) {
                if (Transactionhead != null) {
                    Node newTransactionNode = new Node(key, temp.value);
                    newTransactionNode.next = Transactionhead;
                    Transactionhead = newTransactionNode;
                }
                temp.value = null;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    int count(Integer value) {
        Node temp = head;
        int count = 0;
        if (temp == null) {
            return 0;
        }
        while (temp != null) {
            if (temp.value == value) {
                count++;
            }
            temp = temp.next;
        }
        return count;
    }

    void beginTransaction() {
        if (Transactionhead != null) {
            StackTransactionHead prevtransactionhead = new StackTransactionHead(Transactionhead);
            prevtransactionhead.next = stacktransaction;
            stacktransaction = prevtransactionhead;
        }
        Node newNode = new Node();
        Transactionhead = newNode;
    }

    boolean rollBack() {
        if (Transactionhead == null) {
            return false;
        }
        while (Transactionhead != null) {
            System.out.println(Transactionhead.key + " check " + Transactionhead.value);
            TransactionSet(Transactionhead.key, Transactionhead.value);
            Transactionhead = Transactionhead.next;
        }
        if (Transactionhead == null && StackTransactionHead.size > 0) {
            Transactionhead = stacktransaction.transactionhead;
            stacktransaction = stacktransaction.next;
            StackTransactionHead.size--;
        }
        return true;
    }

    void TransactionSet(char key, Integer value) {
        Node temp = head;
        while (temp != null) {
            if (temp.key == key) {
                temp.value = value;
                return;
            }
            temp = temp.next;
        }
        // Node newNode = new Node(key, value);
        // newNode.next = head;
        // head = newNode;
        // return;
    }

    boolean commit() {
        if (Transactionhead == null) {
            return false;
        }
        Transactionhead = null;
        if (Transactionhead == null && StackTransactionHead.size > 0) {
            Transactionhead = stacktransaction.transactionhead;
            stacktransaction = stacktransaction.next;
            StackTransactionHead.size--;
        }
        return true;
    }

}

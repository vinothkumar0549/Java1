public class Node {

    char key;
    Integer value;
    Node next;

    Node(char key, Integer value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }

    Node() { // initialize transaction node
        this.key = '\0';
        this.value = null;
        this.next = null;
    }

}

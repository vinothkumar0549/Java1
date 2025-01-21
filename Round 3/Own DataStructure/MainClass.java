import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        OwnDataStructure dataStructure = new OwnDataStructure();
        try (Scanner scanner = new Scanner(System.in)) {
            int n;
            Integer value;
            char key;
            while (true) {
                System.out.println("-----Main Menu-----");
                System.out.println("1. Set\n2. Get\n3. UnSet\n4. Count\n5. Begin\n6. RollBack\n7. Commit\n8. Exit");
                System.out.println("Enter Your Choice: ");
                n = scanner.nextInt();
                switch (n) {
                    case 1:
                        System.out.println("Enter the Key: ");
                        key = scanner.next().charAt(0);
                        System.out.println("Enter the Value: ");
                        value = scanner.nextInt();
                        if (dataStructure.set(key, value)) {
                            System.out.println("Set Value " + value + " at Key " + key);
                        }
                        break;
                    case 2:
                        System.out.println("Enter the Key");
                        key = scanner.next().charAt(0);
                        value = dataStructure.get(key);
                        System.out.println("The Value at Key " + key + ": " + value);
                        break;
                    case 3:
                        System.out.println("Enter the Key: ");
                        key = scanner.next().charAt(0);
                        if (dataStructure.unSet(key)) {
                            System.out.println("The Value has Changed to Null at Key " + key);
                        } else {
                            System.out.println("Key Not Found");
                        }
                        break;
                    case 4:
                        System.out.println("Enter the Value: ");
                        value = scanner.nextInt();
                        int count = dataStructure.count(value);
                        System.out.println("Count of the Value " + value + ": " + count);
                        break;
                    case 5:
                        System.out.println("Begin New Transaction...");
                        dataStructure.beginTransaction();
                        break;
                    case 6:
                        if (dataStructure.rollBack()) {
                            System.out.println("RollBack all Transaction");
                        } else {
                            System.out.println("No Transaction Begin...");
                        }
                        break;
                    case 7:
                        if (dataStructure.commit()) {
                            System.out.println("All Transactions are Commit");
                        } else {
                            System.out.println("No Transaction Begin...");
                        }
                        break;
                    case 8:
                        System.exit(0);
                    default:
                        System.out.println("Invalid Choice... ");
                }
            }
        }
    }
}
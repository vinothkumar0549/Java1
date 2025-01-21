import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n, id, pin;
            String password;
            System.out.println("Enter the No. of Customers: ");
            n = scanner.nextInt();
            GiftCardSystem giftcardsystem = GiftCardSystem.getInstance();
            int i = 0;
            while (i < n) {
                System.out.println("Enter the Customer Id: ");
                int cusid = scanner.nextInt();
                System.out.println("Enter the Account No: ");
                int account = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter the Name: ");
                String name = scanner.nextLine();
                System.out.println("Enter the Balance: ");
                int balance = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter the Password: ");
                String userpassword = scanner.nextLine();
                if (!giftcardsystem.encryptPassword(userpassword).equals("")) {
                    giftcardsystem.addToCustomer(cusid, account, name, balance, userpassword);
                    i++;
                }
            }
            while (true) {
                System.out.println("-----Main Menu-----");
                System.out.println("1. Login\n2. Purchase\n3. Print Details\n4. Exit");
                System.out.println("Enter your Choice: ");
                n = scanner.nextInt();
                switch (n) {
                    case 1:
                        System.out.println("Enter the Customer Id: ");
                        id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Enter the Password: ");
                        password = scanner.nextLine();
                        if (giftcardsystem.loginUser(id, password)) {
                            System.out.println("Customer " + id + " Logged In");
                            Customer customer = giftcardsystem.getCustomer(id);
                            boolean logout = false;
                            while (true) {
                                System.out.println("-----Customer Detials-----");
                                customer.display();
                                System.out.println(
                                        "1. Create a New Gift Card\n2. Top-Up the Existing Card\n3. Show Gift Card Transaction History\n4. Block the Existing Card\n5. Logout");
                                System.out.println("Enter Your Choice: ");
                                n = scanner.nextInt();
                                switch (n) {
                                    case 1:
                                        System.out.println("Enter the PIN for your New Card: ");
                                        pin = scanner.nextInt();
                                        System.out.println(
                                                "The New Gift Card" + giftcardsystem.createNewCard(pin, customer)
                                                        + " Created for Customer Id " + customer.getCustomerId());
                                        break;
                                    case 2:
                                        System.out.println("Enter the CardNo: ");
                                        int cardno = scanner.nextInt();
                                        System.out.println("Enter the Card Pin: ");
                                        pin = scanner.nextInt();
                                        System.out.println("Enter the Amount to Add: ");
                                        int amount = scanner.nextInt();
                                        giftcardsystem.addTopUp(cardno, pin, amount, customer);
                                        break;
                                    case 3:
                                        if (giftcardsystem.showCardDetials(customer)) {
                                            System.out.println("Enter the Card No: ");
                                            cardno = scanner.nextInt();
                                            giftcardsystem.showCardTransactionDetails(cardno, customer);
                                        } else {
                                            System.out.println("No Gift Cards Available");
                                        }
                                        break;
                                    case 4:
                                        System.out.println("Enter the Card No: ");
                                        cardno = scanner.nextInt();
                                        System.out.println("Enter the Pin: ");
                                        pin = scanner.nextInt();
                                        giftcardsystem.blockCard(cardno, pin, customer);
                                        break;
                                    case 5:
                                        logout = true;
                                        break;
                                    default:
                                        System.out.println("Invalid Option...");
                                }
                                if (logout) {
                                    System.out.println("Customer " + id + " is Logged Out");
                                    break;
                                }
                            }
                        } else {
                            System.out.println("Username or Password is Wrong or Not Exist...");
                        }
                        break;
                    case 2:
                        System.out.println("Enter the Bill Amount: ");
                        int bill = scanner.nextInt();
                        System.out.println("Enter the Card No: ");
                        int cardno = scanner.nextInt();
                        System.out.println("Enter the Pin: ");
                        pin = scanner.nextInt();
                        giftcardsystem.purchase(bill, cardno, pin);
                        break;
                    case 3:
                        GiftCardSystem.getInstance().printDetails();
                        break;
                    case 4:
                        System.exit(0);
                    default:
                        System.out.println("Invalid Option...");
                }
            }
        }
    }
}
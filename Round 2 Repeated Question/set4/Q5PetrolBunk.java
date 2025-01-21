package set4;

import java.util.Scanner;;

public class Q5PetrolBunk {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Petrol in Car: ");
        int p = scanner.nextInt();
        System.out.println("Enter the Petrol Bunks Space Separeted: ");
        scanner.nextLine();
        String Line = scanner.nextLine();

        int n = 0;
        try (Scanner strscan = new Scanner(Line)) {
            while (strscan.hasNext()) {
                n++;
                strscan.next();
            }
            int[] distance = new int[n];
            int[] petrol = new int[n];

            System.out.println("Enter the Distance and the Petrol of the Bunk: ");
            for (int i = 0; i < n; i++) {
                distance[i] = scanner.nextInt();
                petrol[i] = scanner.nextInt();
            }

            for (int i = 0; i < n; i++) {
                if (p >= distance[i]) {
                    p = p - distance[i] + petrol[i];
                } else {
                    System.out.println("Not Enough Petrol");
                    return;
                }
            }

            System.out.printf("The Remaining Petrol in the Car: %d", p);
        }
        scanner.close();
    }
}

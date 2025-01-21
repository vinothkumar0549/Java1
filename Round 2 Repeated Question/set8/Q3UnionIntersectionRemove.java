package set8;

import java.util.Scanner;
import java.util.Set;
//import java.util.TreeSet; //use TreeSet for the Ascending Order
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ArrayList;

public class Q3UnionIntersectionRemove {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> union = new LinkedHashSet<>(); // use TreeSet for Ascending Order
        Set<Integer> intersection = new LinkedHashSet<>(); // use TreeSet for Ascending Order
        List<Integer> remove = new ArrayList<>();
        System.out.println("Enter the Size of the Array 1: ");
        int n1 = scanner.nextInt();
        int[] arr1 = new int[n1];
        System.out.println("Enter the Elements of the Array 1: ");
        for (int i = 0; i < n1; i++) {
            arr1[i] = scanner.nextInt();
            union.add(arr1[i]);
            if (arr1[i] % 2 != 0) {
                remove.add(arr1[i]);
            }
        }
        System.out.println("Enter the Size of the Array 2: ");
        int n2 = scanner.nextInt();
        int[] arr2 = new int[n2];
        System.out.println("Enter the Elements of the Array 2: ");
        for (int i = 0; i < n2; i++) {
            arr2[i] = scanner.nextInt();
            if (union.contains(arr2[i])) {
                intersection.add(arr2[i]);
            }
            union.add(arr2[i]);
            if (arr2[i] % 2 == 0) {
                remove.add(arr2[i]);
            }
        }
        System.out.println("Union: ");
        for (int i : union) {
            System.out.print(i + " ");
        }
        System.out.println("Intersection: ");
        for (int i : intersection) {
            System.out.print(i + " ");
        }
        System.out.println("Except: ");
        for (int i : remove) {
            System.out.print(i + " ");
        }
        scanner.close();
    }
}
